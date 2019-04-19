import cv2
import requests
from detecter import Detecter
import numpy as np
from threading import Thread

def detect() :
    global fancyFrame
    frame = fancyFrame
    if(fancyFrame is not None) :
        image_ex = np.expand_dims(frame, axis=0)
        (boxes,scores,classes,num) = detecter.detect(image_ex)
        detecter.viaulize(frame,boxes,classes,scores,threshold)
        return frame

def play() :
    global fancyDetectFrame
    print("detect된 동영상 시작 준비 완료...")
  
    if(fancyDetectFrame is not None) :
        cv2.imshow('Video',fancyDetectFrame)
        cv2.waitKey(1)
    

def run(*args) :
    global fancyDetectFrame
    while(True) :
        fancyDetectFrame = detect()
        print(fancyDetectFrame)
        play()
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

fancyFrame = None #detect할 최신 이미지를 담는다.
fancyDetectFrame = None #영상으로 내보내는 최신 이미지

#detecter생성
detecter = Detecter()
detecter.setup('./frozen_inference_graph.pb', './mscoco_label_map.pbtxt')

cap = cv2.VideoCapture('C:/Users/student/Desktop/videos/car/video/video3.mp4')
fps = cap.get(cv2.CAP_PROP_FPS)
delay = int(1000/fps)
threshold = 0.3

Thread(target = run).start()
while(cap.isOpened()):
    ret, frame = cap.read()
    fancyFrame = frame
    cv2.waitKey(delay)
