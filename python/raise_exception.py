print("text를 입력하세요:",end="")
text=input()
if text.isdigit() == False:
    raise Exception("text가 숫자를 포함하고 있지 않습니다.")