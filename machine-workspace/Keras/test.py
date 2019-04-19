from keras.models import Sequential
from keras.layers import Dense
import numpy as np
# x = np.array([0,1,2,3,4])
# y = x * 2 + 1

# model = Sequential()
# model.add(Dense(1,input_shape=(1,)))

# model.compile('SGD','mse')
# model.fit(x[:2], y[:2], epochs = 1000, verbose=0)
num_points = 1000
x_data = np.random.normal(0.0,0.55,(num_points))
y_data = x_data*0.1 + 0.3 + np.random.normal(0.0,0.03,(num_points))

x_data = np.random.randn(2000,3)
w_real = [0.3,0.5,0.1]
b_real = -0.2

noise = np.random.randn(1,2000)*0.1
y_data = np.matmul(w_real,x_data.T) + b_real + noise
y_data = y_data.reshape(2000,1)

print(x_data)