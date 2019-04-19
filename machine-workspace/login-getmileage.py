import requests
from bs4 import BeautifulSoup
from urllib.parse import urljoin

USER = "kyle779"
PASS = "Cookies100@"

session = requests.session()
login_info = {
    "id" : USER,
    "pw" : PASS
}

url_login = "https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com"
res = session.post(url_login, data = login_info)
res.raise_for_status()
print(res.text)


#url_mypage = "http://localhost:8080/tour/member/view"
#res = session.get(url_mypage)
#res.raise_for_status()

#print(res.text)
