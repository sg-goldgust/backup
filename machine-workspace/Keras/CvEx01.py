import cv2
img = cv2.imread("C:/Users/student/Desktop/526319_192178_44.jpg")
print(img.shape) #bgr 순으로 채널이 구성되어있다. mathplot 사용시 주의하여야 한다.
cv2.imshow("image",img)

cv2.waitKey()
cv2.destroyAllWindows()