from keras.models import Sequential
from keras.layers import Input, Dense, Activation
import Ex04

class DNN1(Sequential) :
    def __init__(self, num_input, num_hidden, num_output) :
        super().__init__()

        self.add(Dense(num_hidden, activation = 'relu', input_shape=(num_input,)))

        self.add(Dense(num_output, activation = 'softmax'))

        self.compile(loss = 'categorical_crossentropy', 
                        optimizer='adam',
                        metrics = ['accuracy'])

x_data, y_data = Ex04.load_data()

model = DNN1(2,10,3)

model.fit(x_data, y_data, epochs=1000, verbose=1) 
loss, accuracy = model.evaluate(x_data, y_data, batch_size=100) 
print(loss, accuracy)