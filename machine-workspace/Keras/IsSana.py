#sana 얼굴인지 아닌지 찾아주는 모듈이다 
import cv2 
import numpy as np
import requests
import urllib.request
import urllib.parse as parse
import json
import os
import time

from keras.models import Sequential
from keras.layers import Dense, Conv2D, MaxPooling2D, Dropout, Flatten

class BCNN(Sequential) :
    def __init__(self, input_shape) :
        super().__init__()
        self.add(Conv2D(32,kernel_size=(3,3),
                 activation = 'relu',
                 input_shape = input_shape))
        self.add(MaxPooling2D(pool_size=(2,2)))
        self.add(Conv2D(64,(3,3), activation='relu'))
        self.add(MaxPooling2D(pool_size=(2,2)))
        self.add(Dropout(0.25))
        self.add(Flatten())

        self.add(Dense(128, activation = 'relu'))
        self.add(Dropout(0.5))
        self.add(Dense(1,activation = 'sigmoid'))
        self.compile(loss = 'binary_crossentropy' , optimizer='adam', metrics=['accuracy'])

def recrop(img,data) :
    gray_img = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    return_img = None
    w_start = data[0]
    h_start = data[1] 
    w_length = data[2]
    h_length = data[3]

    w_end = w_start + w_length
    h_end = h_start + h_length

    if(w_length > h_length) :
        add_size = (w_length-h_length)/2
        #세로 길이를 늘려준다.
        h_start = int(h_start - add_size)
        h_end = int(h_start + add_size)
        return_img = gray_img[w_start:w_end, h_start:h_end]
    else: 
        add_size = (h_length-w_length)/2
        #가로 길이를 늘려준다.
        w_start = int(w_start - add_size)
        w_end = int(w_end + add_size)

        return_img = gray_img[w_start:w_end, h_start:h_end]
    return_img = cv2.resize(return_img, (128,128), interpolation=cv2.INTER_AREA)
    return return_img

def image_generator(file_path,num=10) :
    img = cv2.imread(file_path)
    r,c = img.shape[0:2]
    arr = np.linspace(-20,20,num)
    for i in arr :
        M_r = cv2.getRotationMatrix2D((c/2, r/2), i, 1)
        new_r_img = cv2.warpAffine(img,M_r,(c,r))
        #생성된 회전 이미지를 저장한다.
        save_name = "C:/Users/student/Desktop/sanas/" + str(i) +file_path[-6:]
        cv2.imwrite(save_name,new_r_img)


#naver api를 통해서 이미지 검색
twice = ['사나','미나','모모','쯔위','정연','나연','다현','채영']
header = {
    "X-Naver-Client-Id" : "CsN1Mz4nK6JMwf7j13Bq",
    "X-Naver-Client-Secret" : "pNJth4_7BC"
}
    ##검색 url
url = "https://openapi.naver.com/v1/search/image"
    ##검색 파라미터
params = {
        "query" : "사나",
        "start" : 1,
        "display" : 100
    }
for i in range(2) :   
    params["start"] = i*100+1
        ##response 객체
    res = requests.get(url, headers=header, params=params)
    if(i == 1) :
        print(res)
    list = json.loads(res.text)
    
    for ix,item in enumerate(list["items"]) :
        url = item["link"]
        savepath = "C:/Users/student/Desktop/sanas/"+str(ix+i)+".jpg"
        urllib.request.urlretrieve(url, savepath)

    time.sleep(2)
#생성한 이미지에서 얼굴이 포함되어 있지 않으면 제거시킨다.

"""
#원본 이미지를 회전시켜서 각 이미지당 10개의 훈련데이터를 만든다
path_dir = "C:/Users/student/Desktop/sanas/original"
dir_list = os.listdir(path_dir)
print(dir_list)
for file_path in dir_list :
    file_path = "C:/Users/student/Desktop/sanas/original/" + file_path
    image_generator(file_path)
"""
"""
#준비한 이미지의 crop 작업
path_dir = "C:/Users/student/Desktop/sanas/train_image"
dir_list = os.listdir(path_dir)
for file_path in dir_list:
    file_path = "C:/Users/student/Desktop/sanas/train_image/" + file_path
    image = cv2.imread(file_path)
    image_gs = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)

    cascade_file = "C:/Users/student/Desktop/haarcascade_frontalface_alt.xml"
    cascade = cv2.CascadeClassifier(cascade_file)

    face_list = cascade.detectMultiScale(image_gs, scaleFactor=1.1, minNeighbors=3, minSize=(10,10))

    if len(face_list) > 0 :
        for face in face_list :
            x,y,w,h = face
            data = [y,x,w,h]
            face_img = recrop(image,data)
            
            save_name = "C:/Users/student/Desktop/sanas/face/"+str(face)+".jpg"
            print(save_name)
            
            cv2.imwrite(save_name,face_img)


print("crop 완료")

"""
"""
#bcnn 신경망으로 훈련하기 

input_shape = (128, 128, 1)

model = BCNN(input_shape)
    ##train data
face_dir = "C:/Users/student/Desktop/sanas/face"
face_list = os.listdir(face_dir)
train_X = []


for file in face_list :
    path = "C:/Users/student/Desktop/sanas/face/"+str(file)
    img = cv2.imread(path)
    img = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    train_X.append(img)
    

train_X = np.array(train_X).reshape((len(train_X),128,128,1))
print(train_X.shape)

train_y = np.ones((train_X.shape[0],1))
print(train_y)

model.fit(train_X, train_y, epochs=5, batch_size=100, validation_split=0.2)

performance_test = model.evaluate(train_X, train_y, batch_size=100)
print('Test Loss and Accuracy :' , performance_test)

"""