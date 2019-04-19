import numpy as np  
from keras.models import Sequential
from keras.layers import Dense

num_points = 1000
x_data = np.random.normal(0.0,0.55,(num_points))
y_data = x_data * 0.1 + 0.3 + np.random.normal(0.0,0.03,(num_points))

model = Sequential()
model.add(Dense(1,input_shape=(1,)))
model.compile('SGD','mse')

history = model.fit(x_data,y_data,epochs=1000,verbose=0)

weights , bias = model.layers[0].get_weights()
print(weights,bias)

test_indexs = np.random.choice(num_points,10)
test_x = x_data[test_indexs]
test_y = y_data[test_indexs]
print('Targets   :', test_y)
print('Predictions:', model.predict(test_x).flatten())