import cv2
import sys
from face import recrop


image = cv2.imread("C:/Users/student/Desktop/sanas/twice.jpg")
image_gs = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)

cascade_file = "C:/Users/student/Desktop/haarcascade_frontalface_alt.xml"
cascade = cv2.CascadeClassifier(cascade_file)

face_list = cascade.detectMultiScale(image_gs, scaleFactor=1.1, minNeighbors=3 ,minSize=(10,10))
if len(face_list) == 0: 
    print("no face") 
    quit() 

print(face_list) 
color = (0, 0, 255) 
mosaic_rate = 30 
for (x,y,w,h) in face_list: 
    # 얼굴 부분 자르기 
    face_img = image[y:y+h, x:x+w] 
    # 자른 이미지를 지정한 배율로 축소하기 
    face_img = cv2.resize(face_img, (w//mosaic_rate, h//mosaic_rate)) 
    # 축소한 그림을 원래 크기로 확대하기 
    face_img = cv2.resize(face_img, (w, h), interpolation=cv2.INTER_AREA) 
    # 원래 이미지에 붙이기 
    image[y:y+h, x:x+w] = face_img 
    # 렌더링 결과를 파일에 출력 
    cv2.imwrite('mosaic.jpg', image)

    data = [y,x,w,h]
    face_image = recrop(image,data)
    name = str(x)
    cv2.imshow(name,face_image)

cv2.waitKey()
cv2.destroyAllWindows() 
