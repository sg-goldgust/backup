from keras.models import load_model ,Model
from keras.layers import Input, Dense, Activation

import pandas as pd 
import numpy as np 
from Dnn2 import DNN2
Iris_map = {'setosa':0, 'versicolor':1, 'virginica':2}

data = pd.read_csv('C:/Users/student/Downloads/iris.csv').values
np.random.shuffle(data)
test_data = data[100:]

rx_data = test_data[1:,:4]
ry_data = test_data[1:,4]

for counter, value in enumerate(ry_data):
    temp = value.split("-")
    ry_data[counter] = Iris_map[temp[1]]  

model = DNN2(4,10,3)
model.load_weights('mnist_mlp_model.h5')

loss, accuracy = model.evaluate(rx_data, ry_data, batch_size=100) 
print(loss, accuracy)