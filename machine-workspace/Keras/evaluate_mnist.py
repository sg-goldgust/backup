from mnist_dnn_data import load_data
from dnn import DNN
import numpy as np  
import time

(train_X, train_y), (test_X, test_y) = load_data()

num_input = train_X.shape[1]
num_hiddens = [100,50]
num_output = train_y.shape[1]

model = DNN(num_input, num_hiddens, num_output)
model.load_weights('mnist.h5')

ix = np.random.randint(10000)



t1 = time.time()
print(t1)
predict = model.predict(test_X[ix:ix+1]).argmax()
t2 = time.time()
print(t2) # 0.22s 소모된다.
print('predict :' , predict)
print(t2-t1)