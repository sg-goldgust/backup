import cv2
import numpy as np 
img = cv2.imread("C:/Users/student/Desktop/b680dc6f48d5bd12e614f9db1ce121db.jpg")
ker = np.ones((5,5),np.uint8)
new_image = cv2.erode(img,ker,iterations = 1)
cv2.imshow("image", new_image)
cv2.waitKey()
cv2.destroyAllWindows()