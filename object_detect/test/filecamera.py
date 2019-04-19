import cv2
import requests
from detecter import Detecter
import numpy as np
from threading import Thread
detecter = Detecter()
detecter.setup('./frozen_inference_graph.pb', './mscoco_label_map.pbtxt') 
delay = int(1000/25)

class FileCamera :
    def __init__(self, video) :
        self.cap = cv2.VideoCapture(video)
        self.THRESHOLD = 0.5
        self.fancyFrame = None
        self.fancyDetectFrame = None

    def fancy(self) :
        while(self.cap.isOpened()) :
            ret, frame = self.cap.read() 
            self.fancyFrame = frame
            cv2.waitKey(delay)
            
    def detect(self) :
        frame = self.fancyFrame
        image_ex = np.expand_dims(frame,axis=0)
        (boxes, scores, classes, num) = detecter.detect(image_ex) 
        detecter.viaulize(frame,boxes,classes,scores,self.THRESHOLD)
        return frame
    
    def play(self) :
        print("동영상 play 시작 준비 완료 ...")
        
        while(True) :
            #print("fancyFrame" , self.fancyFrame , "fancyDetectFrame" , self.fancyDetectFrame)
            if (self.fancyFrame is not None) :
                self.fancyDetectFrame = self.detect()
            if (self.fancyDetectFrame is not None) :
                
                cv2.imshow('Video',self.fancyDetectFrame)
                cv2.waitKey(1)

if __name__ == "__main__" :
    test = FileCamera('C:/Users/student/Desktop/videos/video2.avi')
    Thread(target = test.play).start()
    test.fancy()
    
    


