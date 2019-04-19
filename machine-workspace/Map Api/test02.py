from websocket import WebSocketApp
from threading import Thread
import time
import json
import cv2
import requests

def on_message(ws,message) :
    print(message)
    
def on_error(ws, error) :
    print(error)

def on_close(ws) :
    print(" closed ")

def on_open(ws) :
    cap = cv2.VideoCapture('C:/Users/student/Desktop/videos/a.mp4')
    def run(*args) :
        while(cap.isOpened()) :
            # stream.write(jpgImage.tobytes())
            # stream.seek(0)
            ret , frame = cap.read()
            ret , jpgImage = cv2.imencode('.jpg', frame)
            ws.send(bytearray(jpgImage))

        print("thread running...")
    Thread(target = run).start()

ws = WebSocketApp("ws://localhost:8080/naverApi/camera",
on_open = on_open,
on_message = on_message,
on_error = on_error,
on_close = on_close
)
ws.run_forever()

