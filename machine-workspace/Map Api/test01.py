from websocket import WebSocketApp
from threading import Thread
import time
import json

carMsg = {
    "msgType" : "POSITION",
    "target" : 1,
    "lat" : 37.0,
    "lng" : 127.0,
    }

def on_message(ws,message) :
    print('control 데이터 : ' + message)
    cMsg = json.loads(message)
    if(cMsg['direction'] == "UP") :
        carMsg['lng'] += 0.01 
        car_str = json.dumps(carMsg)
        ws.send(car_str)
        print("edit point by up...")
    
def on_error(ws, error) :
    print(error)

def on_close(ws) :
    print(" closed ")

def on_open(ws) :
    car_str = json.dumps(carMsg)
    def run(*args) :
        ws.send(car_str) 
        print("thread running...")
    Thread(target = run).start()


if __name__ == "__main__" :
   
    ws = WebSocketApp("ws://localhost:8080/naverApi/echo",
    on_open = on_open,
    on_message = on_message,
    on_error = on_error,
    on_close = on_close
    )
    ws.run_forever()

   



