import requests
import urllib.parse as parse
import json
import os
import urllib.request
#네이버 검색 클라이언트 ID, Secret ID 헤더 설정
header = {
    "X-Naver-Client-Id" : "CsN1Mz4nK6JMwf7j13Bq",
    "X-Naver-Client-Secret" : "pNJth4_7BC"
}

#검색 url
url = "https://openapi.naver.com/v1/search/image"

params = {
    "query" : "사나",
    "start" : 1
}

res = requests.get(url, headers=header, params=params)
print(res.status_code)

list = json.loads(res.text) #json을 사전으로 바꿔준다.. 반대는 dump

for ix, item in enumerate(list["items"]) :
    title = item["title"]
    link = item["link"]
    info = parse.urlparse(link)
    fileName = os.path.split(info.path)[1]
    print(ix, title, fileName)
    url = link
    savename = fileName

    urllib.request.urlretrieve(url, savename)


