import cv2
img = cv2.imread("C:/Users/student/Desktop/b680dc6f48d5bd12e614f9db1ce121db.jpg")

gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)

x_edges = cv2.Sobel(gray,-1,1,0,ksize=5)
y_edges = cv2.Sobel(gray,-1,0,1,ksize=5)

cv2.imshow("1",x_edges)
cv2.imshow("2",y_edges)
cv2.waitKey()
cv2.destroyAllWindows()