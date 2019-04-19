import numpy as np 
import tensorflow as tf 

class advancedNeural :
    def __init__(self,x_data,y_data,learningrate) :
        self.x_data = x_data
        self.y_data = y_data
        self.learningrate = learningrate

        self.variablesCnt = x_data.shape[1]
        self.steps = x_data.shape[0] 
        self.dtype = x_data.dtype

    def train(self) :

        x = tf.placeholder(tf.float32, shape=[self.steps,self.variablesCnt])
        y_true = tf.placeholder(self.dtype, shape = self.steps)

        w = tf.Variable(np.random.rand(1,self.variablesCnt), dtype = self.dtype)
        b = tf.Variable(0, dtype = self.dtype)
        y_pred = tf.matmul(w,tf.transpose(x)) + b

        loss = tf.reduce_mean(tf.square(self.y_data - y_pred))

        optimizer = tf.train.GradientDescentOptimizer(self.learningrate)

        train = optimizer.minimize(loss)

        init = tf.global_variables_initializer()
        with tf.Session() as sess:
            sess.run(init)
            for step in range(self.steps) :
                sess.run(train, {x:self.x_data, y_true:self.y_data})
                print(step, sess.run([w,b]))

if __name__ == "__main__":
    x_data = np.random.randn(10,3)
    w_real = [0.3,0.5,0.1]
    b_real = -0.2
    noise = np.random.randn(1,10) * 0.1
    y_data = np.matmul(w_real,x_data.T) + b_real + noise
    learningrate = 0.5
    advancedNeural.train(advancedNeural(x_data,y_data,learningrate))
