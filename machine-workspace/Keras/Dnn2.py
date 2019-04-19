from keras.models import Model
from keras.layers import Input, Dense, Activation

import pandas as pd 
import numpy as np 

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

class DNN2(Model) :
    def __init__(self, num_input, num_hidden, num_output) :

        hidden = Dense(num_hidden)
        relu = Activation('relu')
        output = Dense(num_output)
        softmax = Activation('softmax')

        x = Input(shape=(num_input,))
        h = relu(hidden(x))
        y = softmax(output(h))

        super().__init__(x,y)

        self.compile(loss = 'categorical_crossentropy', optimizer ='adam'
                            , metrics = ['accuracy'])


model = DNN2(4,10,3)

model.fit(x_data, y_data, epochs=10000, verbose=1) 



loss, accuracy = model.evaluate(rx_data, ry_data, batch_size=100) 
print(loss, accuracy)