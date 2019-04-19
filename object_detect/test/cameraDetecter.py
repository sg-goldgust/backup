
THRESHOLD = 0.2

def detect(frame) :
    frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    image_ex = np.expand_dims(frame,axis=0)
    (boxes, scores , classes, num) = detecter.detect(image_ex)
    detecter.viaulize(frame,boxes,classes,scores,THRESHOLD)
    cv2.imshow('Video',frame)