from mnist_cnn_data import load_data
from cnn import CNN

batch_size = 128
epochs = 10

data = load_data()
model = CNN(data.input_shape, data.num_classes)
print(data.x_train.shape)
print(data.y_train.shape)

history = model.fit(data.x_train, data.y_train, batch_size= batch_size, epochs=epochs, validation_split=0.2)
model.save_weights('cnn.h5')

score = model.evaluate(data.x_test, data.y_test)
print('Test loss:', score[0])
print('Test accuracy' , score[1])
