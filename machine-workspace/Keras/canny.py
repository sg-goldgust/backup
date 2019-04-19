import cv2
img =cv2.imread("C:/Users/student/Desktop/b680dc6f48d5bd12e614f9db1ce121db.jpg")
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
edges = cv2.Canny(gray,100,200,3)

cv2.imshow("1",edges)
cv2.waitKey()
cv2.destroyAllWindows()