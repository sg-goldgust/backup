import cv2
import numpy as np 
img = cv2.imread("C:/Users/student/Desktop/b680dc6f48d5bd12e614f9db1ce121db.jpg")

new_img = cv2.GaussianBlur(img,(5,5),0)

cv2.imshow("image",new_img)
cv2.waitKey()
cv2.destroyAllWindows()