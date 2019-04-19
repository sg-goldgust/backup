from keras import datasets
from keras.utils import np_utils


def load_data():
    (X_train, y_train), (X_test, y_test) = datasets.mnist.load_data()

    y_train = np_utils.to_categorical(y_train)
    y_test = np_utils.to_categorical(y_test)

    L, W, H = X_train.shape
    X_train = X_train.reshape(-1, W*H) / 255.0
    X_test = X_test.reshape(-1, W*H) / 255.0

    return (X_train, y_train), (X_test, y_test)