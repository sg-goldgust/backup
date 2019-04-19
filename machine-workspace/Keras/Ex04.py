import numpy as np  
from keras.models import Sequential
from keras.layers import Dense, Activation

def load_data() :
    x_data = np.array(
        [[0,0],
        [1,0],
        [1,1],
        [0,0],
        [0,0],
        [0,1]]
    )

    y_data = np.array(
        [[1,0,0],
        [0,1,0],
        [0,0,1],
        [1,0,0],
        [1,0,0],
        [0,0,1]]
    )

    return x_data, y_data

x_data, y_data = load_data()

model = Sequential()
model.add(Dense(3,input_shape = (2,), activation = 'softmax'))
model.compile(loss = 'categorical_crossentropy',optimizer='adam',metrics=['accuracy'])
model.summary()

# 훈련 
history= model.fit(x_data, y_data, epochs=100, verbose=0) 
loss, accuracy = model.evaluate(x_data, y_data, batch_size=100) 
print(loss, accuracy)