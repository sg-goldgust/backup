import numpy as np 
from PIL import Image 
from detecter_image import get_detect_image
from detecter import Detecter
import cv2 as cv2

TEST_IMAGE_PATHS = ['./image1.jpg','./image2.jpg']
THRESHOLD = 0.3
detecter = Detecter()
detecter.setup('./frozen_inference_graph.pb', './mscoco_label_map.pbtxt') 

for image_path in TEST_IMAGE_PATHS: 
    image, image_ex = get_detect_image(image_path) 

    (boxes, scores, classes, num) = detecter.detect(image_ex) 
    print(num) #100개의 장소를 조사한다.
    print('boxes', boxes)
    print('scores', scores) 
    print('classes', classes)

    detecter.viaulize(image, boxes, classes, scores, THRESHOLD)
    image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
    cv2.imshow(image_path, image)

    # object_list = []
    # for output in zip(boxes,scores,classes) :
    #     if(output[1] > THRESHOLD) :
    #         object_list.append(output)
    #         print(output)
    
    # object_list = filter(lambda item : item[1] > THRESHOLD, zip(boxes,scores, classes))
    # for box, scores, clazz in object_list:
    #     print(box,score,clazz)



cv2.waitKey()
cv2.destroyAllWindows()

