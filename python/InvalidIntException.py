class InvalidIntException(Exception):
    def __init__(self,arg):
        super().__init__("정수가 아닙니다 {}".format(arg))

def convert_to_integer(text):
    if text.isdight() :
        return int(text)
    else:
        raise InvalidIntException(text)

if __name__ == "__main__":
    try:
        text = input()
        number = convert_to_integer(text)
    except InvalidIntException as err:
        print(err)
    else:
        print("정수변환")