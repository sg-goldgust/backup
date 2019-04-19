import cv2
import matplotlib as plt

def recrop(img,data) :
    gray_img = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    return_img = None
    w_start = data[0]
    h_start = data[1] 
    w_length = data[2]
    h_length = data[3]

    w_end = w_start + w_length
    h_end = h_start + h_length

    if(w_length > h_length) :
        add_size = (w_length-h_length)/2
        #세로 길이를 늘려준다.
        h_start = int(h_start - add_size)
        h_end = int(h_start + add_size)
        return_img = gray_img[w_start:w_end, h_start:h_end]
    else: 
        add_size = (h_length-w_length)/2
        #가로 길이를 늘려준다.
        w_start = int(w_start - add_size)
        w_end = int(w_end + add_size)
        print(w_start, w_end)
        return_img = gray_img[w_start:w_end, h_start:h_end]
    return_img = cv2.resize(return_img, (28,28), interpolation=cv2.INTER_AREA)
    return return_img

def rgb(file) :
    for epochs in range(3) :
        size_img = None
        img = cv2.imread(file)
        name = "image" + str(epochs) 
        for i in range(img.shape[0]) :
            for j in range(img.shape[1]) :
                img[i][j][epochs] = 0
                
        size_img = cv2.resize(img, (28,28), interpolation=cv2.INTER_AREA)
        cv2.imshow(name,size_img)
 
rgb("C:/Users/student/Desktop/b680dc6f48d5bd12e614f9db1ce121db.jpg")

img = cv2.imread("C:/Users/student/Desktop/b680dc6f48d5bd12e614f9db1ce121db.jpg")
#crop 이미지 출력
crop_img = recrop(img,[200,600,100,120])
cv2.imshow("cropimage",crop_img)

#흑백 이미지 출력
gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
cv2.imwrite("gray_image.jpg",gray)
cv2.imshow("image",gray)

#cv2.cvtColor(img,cv2.BGR2RGB)
#plt.imshow(img)
#plt.show()

cv2.waitKey()
cv2.destroyAllWindows()


