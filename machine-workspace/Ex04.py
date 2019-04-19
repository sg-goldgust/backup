import tensorflow as tf 
import numpy as np 
import pandas as pd 
from enum import Enum

Iris_map = {'setosa':0, 'versicolor':1, 'virginica':2}



data = pd.read_csv('C:/Users/student/Downloads/iris.csv').values
np.random.shuffle(data)
train_data = data[:100]
test_data = data[100:]

x_data = train_data[1:,:4]
y_data = train_data[1:,4]

rx_data = test_data[1:,:4]
ry_data = test_data[1:,4]

for counter, value in enumerate(y_data):
    temp = value.split("-")
    y_data[counter] = Iris_map[temp[1]]

for counter, value in enumerate(ry_data):
    temp = value.split("-")
    ry_data[counter] = Iris_map[temp[1]]    

def one_hot(y_data):
    #index = y_data.astype('uint8').flatten()
    y_temp = np.zeros((y_data.size , int(max(y_data))+1))

    for counter, value in enumerate(y_data):
        y_temp[counter][int(value)] = 1

    return y_temp

y_data = one_hot(y_data)
ry_data = one_hot(ry_data)

num_input = x_data.shape[1]
num_output = y_data.shape[1]
num_hidden = 10

X = tf.placeholder(tf.float32)
Y = tf.placeholder(tf.float32)

num_hidden2 = 20

W1 = tf.Variable(tf.random_uniform([num_input,num_hidden],-1,1))
L1 = tf.nn.relu(tf.matmul(X,W1)) 

W2 = tf.Variable(tf.random_uniform([num_hidden,num_hidden2],-1,1))
L2 = tf.nn.relu(tf.matmul(L1,W2))

#편향을 대체하는 가중치 추가
W3 = tf.Variable(tf.random_uniform([num_hidden2, num_output],-1,1))
model = tf.matmul(L2,W3)

global_step = tf.Variable(0, trainable=False, name="global_step")

cost = tf.nn.softmax_cross_entropy_with_logits_v2(labels=Y, logits=model)
optimizer = tf.train.AdamOptimizer(learning_rate = 0.01)
train_op = optimizer.minimize(cost,global_step=global_step)
saver = tf.train.Saver(tf.global_variables())

with tf.Session() as sess:
    # 체크포인트가 존재하는지 검사
    ckpt = tf.train.get_checkpoint_state('./irismodel')
    if ckpt and tf.train.checkpoint_exists(ckpt.model_checkpoint_path):
    # 체크포인트가 존재하는 경우, 복원
    # global_step 값도 복원됨
        saver.restore(sess, ckpt.model_checkpoint_path)
    else :
    # 체크포인트가 존재하지 않는 경우, 젂역 변수 초기화
        sess.run(tf.global_variables_initializer())

    feed_dict = {X:x_data, Y:y_data}
    for step in range(2) :
        sess.run(train_op,feed_dict=feed_dict)
        print(
                "Step : {}, Cost : {}".format(sess.run(global_step),
                                                sess.run(cost, feed_dict=feed_dict))
            )
    saver.save(sess, './irismodel/dnn.ckpt', global_step = global_step)

    prediction = tf.argmax(model,axis=1)
    target = tf.argmax(Y, axis=1)
    print(sess.run(prediction, feed_dict={X : rx_data}))
    print(sess.run(target, feed_dict={Y : ry_data}))

    is_correct = tf.equal(prediction, target)
    accuracy = tf.reduce_mean(tf.cast(is_correct, tf.float32))
    print('정확도 : {:.2f}'.format(
    sess.run(accuracy* 100, feed_dict=feed_dict)) )