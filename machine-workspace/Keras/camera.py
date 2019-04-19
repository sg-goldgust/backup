import cv2
import requests

url = 'http://localhost:8080/monitor/camera/1'

#메모리에다가 잡혀있는 파일이다.
#stream = io.BytesIO()
cap = cv2.VideoCapture('C:/Users/student/Desktop/videos/a.mp4')

while(cap.isOpened()) :
    # stream.write(jpgImage.tobytes())
    # stream.seek(0)
    ret , frame = cap.read()
    ret , jpgImage = cv2.imencode('.jpg', frame)
    print(ret)
    print(jpgImage.size)
    
    file = {'image' : jpgImage}
    res = requests.post(url, files=file)

    cv2.imshow('img',frame)

    if cv2.waitKey(10) & 0xFF == ord('q'):
        break
cap.release()
cv2.destroyAllWindows()

"""
while(True) :
    cap = cv2.VideoCapture('video2.avi')
    try:
        while(cap.isOpened()) :
            ret , frame = cap.read()
            ret , jpgImage = cv2.imencode('.jpg', frame)

            file = {'image' : jpgImage}
            res = requests.post(url, files=file)

   
            if cv2.waitKey(10) & 0xFF == ord('q'):
                break
        except:
            cap.release()
            """