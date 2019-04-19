from mnist_dnn_data import load_data
from dnn import DNN

(train_X, train_y), (test_X, test_y) = load_data()

num_input = train_X.shape[1]
num_hiddens = [100,50]
num_output = train_y.shape[1]

model = DNN(num_input, num_hiddens, num_output)
history = model.fit(train_X, train_y, epochs=5, batch_size=100)

model.save_weights('mnist.h5')
print("model 학습 저장 완료!!")