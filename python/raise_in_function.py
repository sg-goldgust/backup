def some_function():
    print("1~10사이의 수를 입력하세요:")
    num = int(input())
    if num<1 or num>10:
        raise Exception("유효하지 않은 숫자입니다/")
    else:
        print(num)
try:
    some_function()
except Exception as err:
    print(err)
