import cv2
import numpy as np 
import random

def image_generator(file_path,num=10) :
    img = cv2.imread(file_path)
    r,c = img.shape[0:2]
    arr = np.linspace(-20,20,num)
    for i in arr :
        M_r = cv2.getRotationMatrix2D((c/2, r/2), i, 1)
        new_r_img = cv2.warpAffine(img,M_r,(c,r))
        #생성된 회전 이미지를 저장한다.
        save_name = "C:/Users/student/Desktop/sanas/" + str(i) +".jpg"
        cv2.imwrite(save_name,new_r_img)


image_generator("C:/Users/student/Desktop/b680dc6f48d5bd12e614f9db1ce121db.jpg")

img = cv2.imread("C:/Users/student/Desktop/b680dc6f48d5bd12e614f9db1ce121db.jpg")
r,c = img.shape[0:2]
M = np.float32([[1,0,100],[0,1,100]])

new_img =cv2.warpAffine(img,M,(c,r))
cv2.imshow("move_image", new_img)


number = random.randint(1,20)
M_r = cv2.getRotationMatrix2D((c/2, r/2), 90, 1)
new_r_img = cv2.warpAffine(img,M_r,(c,r))

cv2.imshow("rot_image",new_r_img)

print(number)

cv2.waitKey()
cv2.destroyAllWindows()


