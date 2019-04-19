import cv2
import numpy as np 
img = cv2.imread("C:/Users/student/Desktop/b680dc6f48d5bd12e614f9db1ce121db.jpg")

ker = np.ones((3,3))
ker = np.random.rand(3,3)

new_img = cv2.filter2D(img,-1,ker)

cv2.imshow("image",new_img)
cv2.waitKey()
cv2.destroyAllWindows()