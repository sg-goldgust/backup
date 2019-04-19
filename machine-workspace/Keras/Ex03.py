import numpy as np  
from keras.models import Sequential
from keras.layers import Dense
import matplotlib.pyplot as plt

num_points = 2000

w_real = [0.3,0.5,0.1]
b_real = -0.2

x_data = np.random.randn(num_points , 3)
noise = np.random.randn(1, num_points) * 0.1
y_data = np.matmul(w_real,x_data.T) + b_real + noise
y_data = y_data.reshape(2000,1)

model = Sequential()
model.add(Dense(1,input_shape=(3,)))
model.compile(loss = 'mse', optimizer = 'sgd')
model.summary()

history = model.fit(x_data,y_data,epochs=1000,verbose=0)

weights, bias = model.layers[0].get_weights()
print(weights, bias)

plt.plot(history.history['loss'])
plt.legend(['train'],loc = 'upper left')
plt.show()