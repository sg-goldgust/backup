import numpy as np 
import cv2

cap = cv2.VideoCapture('http://70.12.241.130:4747/video')
fps = cap.get(cv2.CAP_PROP_FPS)
delay = int(1000/fps)

while(cap.isOpened()):
    ret, frame = cap.read()
    ret, buffer = cv2.imencode('.jpg',frame)

    with open('c:/temp/output.jpg','wb') as f:
        f.write(buffer)
    
    cv2.imshow('frame',buffer)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()