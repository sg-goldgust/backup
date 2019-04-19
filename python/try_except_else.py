my_list = [1,2,3]

def method():
    try:
        print("첨자를 입력하세요")
        index = int(input())
        print(my_list[index])
        return
    except Exception as err:
        print(err)
    else:
        print("success")
    finally:
        print("어떤경우에도 출력됩니다")

method()