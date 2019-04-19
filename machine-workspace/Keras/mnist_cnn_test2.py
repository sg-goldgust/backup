from mnist_cnn_data import load_data
from cnn import CNN
import time
import numpy as np 

batch_size = 128
epochs = 10

data = load_data()
model = CNN(data.input_shape, data.num_classes)

model.load_weights('cnn.h5')

ix = np.random.randint(data.x_test.shape[0])

start_time = time.time()
result = model.predict(data.x_test[ix:ix+1]).argmax()
print(data.x_test[ix:ix+1].shape)
print("==========================")
end_time = time.time()
print(result, end_time-start_time)

ix = np.random.randint(data.x_test.shape[0])
start_time2 = time.time()
result = model.predict(data.x_test[ix:ix+1]).argmax()
end_time2 = time.time()
print(result, end_time2-start_time2)