import numpy as np 
import cv2

cap = cv2.VideoCapture('C:/Users/student/Desktop/videos/vtest.avi')
print(cap)
fps = cap.get(cv2.CAP_PROP_FPS)
delay = int(1000/fps)

cascade_file = "C:/Users/student/Desktop/videos/cars.xml"
cascade = cv2.CascadeClassifier(cascade_file)

p_cascade_file = "C:/Users/student/Desktop/videos/haarcascade_upperbody.xml"
p_cascade = cv2.CascadeClassifier(p_cascade_file)


while(cap.isOpened()) :
    ret, frame = cap.read()



    car_list = cascade.detectMultiScale(frame, scaleFactor=1.1, minNeighbors=3, minSize=(30,30))
    color = (0, 0, 255) # 빨간색
    color2 = (0,255,0)
    people_list = p_cascade.detectMultiScale(frame, scaleFactor=1.1, minNeighbors=1, minSize=(10,10))
    for car in car_list:
        x,y,w,h = car
        cv2.rectangle(frame, (x,y), (x+w, y+h), color, thickness=8)

    for p in people_list :
        x,y,w,h = p
        cv2.rectangle(frame, (x,y), (x+w, y+h), color2, thickness=8)

    cv2.imshow('frame',frame)
    if cv2.waitKey(delay) & 0xFF == ord('q') :
        break
cap.release()
cv2.destroyAllWindows()