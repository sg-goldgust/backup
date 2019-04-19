def some_function():
    print("1~10사이의 수를 입력하세요 :")
    num = int(input())
    if num<1 or num>10:
        raise Exception("유효하지 않은 숫자입니다")
    else:
        print("입력한 수는 {}입니다".format(num))

def some_function_caller():
    try:
        some_function()
    except Exception as err:
        print(err)
        print("1")
        raise
        

try:
    some_function_caller()
except Exception as err:
    print(err)
    print("2")
