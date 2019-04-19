class ContactInfo:
    def __init__(self,name,email):
        self.name=name
        self.email=email

    def print_info(self):
        print("{} : {}".format(self.name, self.email))

if __name__ == "__main__":
    sanghyun = ContactInfo("상현","sg@naver.com")
    hanbit = ContactInfo("한빗", "hb@naver.com")

    sanghyun.print_info()
    hanbit.print_info()