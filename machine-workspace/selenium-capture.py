from selenium import webdriver

url = "https://www.naver.com/"
#browser = webdriver.PhantomJS("C:/Users/student/Downloads/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe")
options = webdriver.ChromeOptions()
options.add_argument('headless')

browser = webdriver.Chrome('C:/Users/student/Downloads/chromedriver_win32/chromedriver.exe'
    ,chrome_options=options)

browser.implicitly_wait(3)

browser.get(url)

browser.save_screenshot('Website.png')
browser.quit()