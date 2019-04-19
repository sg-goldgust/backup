from keras.models import Sequential
from keras.layers import Dense
import numpy as np 

x = np.array([0,1,2,3,4])
y = x*2 + 1

model = Sequential()
model.add(Dense(1, input_shape=(1,)))

model.compile('SGD','mse')
model.fit(x[:2],y[:2],epochs=1000,verbose=0 )

weights, bias = model.layers[0].get_weights()
print(weights, bias)

print('Targets:' , y[2:])
print('Predictions:' , model.predict(x[2:]).flatten())