from PIL import Image
import numpy as np 
from mnist_cnn_data import load_data
from cnn import CNN

im = Image.open('C:/Users/student/Desktop/20190328_170704.jpg').convert("L")
im = im.resize((28,28))
im.show()
im2arr = np.array(im)




input_data = im2arr.reshape(1, 28,28, 1).astype('float32') / 255.
print(input_data)
model = CNN((28,28,1), 10)

model.load_weights('cnn.h5')


result = model.predict(input_data).argmax()
print(result)
