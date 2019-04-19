import cv2
import matplotlib as plt

#얼굴을 찾는데 사용한다. crop하고 32로 resize해준다.
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
    #return_img = cv2.resize(return_img, (28,28), interpolation=cv2.INTER_AREA)
    return return_img


#rgb색상의 사진을 출력하는데사용한다.
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