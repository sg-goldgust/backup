import tensorflow as tf 
import numpy as np 
import dataload as dataload

data = dataload.load_data('C:/python/data')

X = tf.placeholder(tf.float32)
Y = tf.placeholder(tf.float32)
test_x_data = data.test.images
test_y_data = data.test.lables

W1 = tf.Variable(tf.random_normal([1024, 256], stddev=0.01)) 
L1 = tf.nn.relu(tf.matmul(X, W1)) 
W2 = tf.Variable(tf.random_normal([256, 256], stddev=0.01)) 
L2 = tf.nn.relu(tf.matmul(L1, W2)) 
W3 = tf.Variable(tf.random_normal([256, 43], stddev=0.01)) 
model = tf.matmul(L2, W3)

global_step = tf.Variable(0, trainable=False, name="global_step")

cost = tf.nn.softmax_cross_entropy_with_logits_v2(labels=Y, logits=model)
optimizer = tf.train.AdamOptimizer(learning_rate = 0.01)
train_op = optimizer.minimize(cost,global_step=global_step)
saver = tf.train.Saver(tf.global_variables())

with tf.Session() as sess:
    # 체크포인트가 존재하는지 검사
    ckpt = tf.train.get_checkpoint_state('./model8')
    if ckpt and tf.train.checkpoint_exists(ckpt.model_checkpoint_path):
        print(tf.train.checkpoint_exists(ckpt.model_checkpoint_path))
    # 체크포인트가 존재하는 경우, 복원
    # global_step 값도 복원됨
        saver.restore(sess, ckpt.model_checkpoint_path)
    else :
    # 체크포인트가 존재하지 않는 경우, 젂역 변수 초기화
        sess.run(tf.global_variables_initializer())

    batch_size = 100 
    total_batch = int(data.train.num_examples/batch_size) 
    for epoch in range(15): 
        sess.run(tf.global_variables_initializer())
        total_cost = 0 
        for i in range(total_batch): 
            x_data, y_data = data.train.next_batch(batch_size)
            print(y_data)
            _, cost_val = sess.run([optimizer, cost], feed_dict={X: x_data,Y: y_data}) 
            total_cost += cost_val 
        print('Epoch:', '%04d' % (epoch + 1), 'Avg. cost =', '{:.3f}'.format(total_cost / total_batch)) 
        data.train.reset_batch()
    print('최적화 완료!')
    #feed_dict = {X:x_data, Y:y_data}
    #for step in range(2) :
     #   sess.run(train_op,feed_dict=feed_dict)
      #  print(
       #         "Step : {}, Cost : {}".format(sess.run(global_step),
        #                                        sess.run(cost, feed_dict=feed_dict))
         #   )

    saver.save(sess, './model8/dnn.ckpt', global_step = global_step)

    prediction = tf.argmax(model,axis=1)
    target = tf.argmax(Y, axis=1)
    print(sess.run(prediction, feed_dict={X : test_x_data}))
    print(sess.run(target, feed_dict={Y : test_y_data}))

    is_correct = tf.equal(prediction, target)
    accuracy = tf.reduce_mean(tf.cast(is_correct, tf.float32))
    print('정확도 : {:.2f}'.format(
    sess.run(accuracy* 100, feed_dict={X: test_x_data,Y: test_y_data})) )