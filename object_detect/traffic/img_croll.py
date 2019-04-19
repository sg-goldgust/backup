import requests
import json
import os
import urllib.request
import urllib.parse as parse
import time
import shutil
#네이버 검색 클라이언트 ID, Secret ID 헤더 설정
header = {
    "X-Naver-Client-Id" : "CsN1Mz4nK6JMwf7j13Bq",
    "X-Naver-Client-Secret" : "pNJth4_7BC"
}

#검색 url
url = "https://openapi.naver.com/v1/search/image"

params = {
    "query" : "신호등",
    "start" : 1,
    "display" : 100
}

res = requests.get(url, headers=header, params=params, stream=True)
list = json.loads(res.text) #json을 사전으로 바꿔준다.. 반대는 dump
dir = "C:/Users/student/Desktop/videos/car/photo/"
imgCnt = 1

for i in range(10) :
    for ix, item in enumerate(list["items"]) :
        url = item["link"]
        #url info 객체로 전환하고 파일 이름을 추출하여 end를 검사
        o = parse.urlparse(url) 
        fileName = os.path.split(o.path)[1]
        if not fileName.endswith(("jpg", "JPG", "PNG", "png")) :
            continue

        savepath =  dir + str(imgCnt) + ".jpg"
        if res.status_code == 200 :
            with open(savepath,'wb') as f:
                try :
                    urllib.request.urlretrieve(url, savepath)
                    imgCnt += 1
                except :
                    continue
        
        #request param 'start' 증가
    params["start"] = (i+1)*100
    print("100장 croll 완료..")
    time.sleep(1)

    
    