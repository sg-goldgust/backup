from selenium import webdriver
USER = "kyle779"
PASS = "Cookies100@"

browser = webdriver.Chrome('C:/Users/student/Downloads/chromedriver_win32/chromedriver.exe')
browser.implicitly_wait(3)

url_login = "https://nid.naver.com/nidlogin.login"
browser.get(url_login)
print("네이버 로그인 시작")

e = browser.find_element_by_id("id")
e.clear()
e.send_keys(USER)
e = browser.find_element_by_id("pw")
e.clear()
e.send_keys(PASS)

form = browser.find_element_by_css_selector("input.btn_global[type=submit]")
form.submit()
print("로그인 버튼 클릭합니다.")
