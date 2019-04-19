import cv2
import sys
from face import recrop


image = cv2.imread("C:/Users/student/Desktop/sanas/twice.jpg")
image_gs = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)

cascade_file = "C:/Users/student/Desktop/haarcascade_frontalface_alt.xml"
cascade = cv2.CascadeClassifier(cascade_file)

face_list = cascade.detectMultiScale(image_gs, scaleFactor=1.1, minNeighbors=3, minSize=(10,10))

if len(face_list) > 0 :
    print(face_list)

    color = (0,0,255)
    for face in face_list :
        x,y,w,h = face
        data = [y,x,w,h]
        face_image = recrop(image,data)
        name = str(face)
        cv2.imshow(name,face_image)

    cv2.waitKey()
    cv2.destroyAllWindows() 



