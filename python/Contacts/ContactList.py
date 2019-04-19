from ContactInfo import ContactInfo

class ContactList:
    def __init__(self):
        self.list = []

    def add(self,ci):
        self.list.append(ci)

    def find(self,name):
        temp = ContactInfo(None,None)
        for ci in self.list:
            if(ci.name == name):
                temp = ci
        return temp

    def getList(self,start=0,end=None):
        print(self.list[start:end])

    def __iter__(self):
        self.current = 0
        return self

    def __next__(self):
        if(self.current < len(self.list)):
            current = self.current
            self.current += 1
            return self.list[current]
        raise StopIteration()

if __name__ == "__main__":
    temp_list = ContactList()
    temp_list.add(ContactInfo("상현","sg@naver.com"))
    temp_list.add(ContactInfo("한빗", "hb@naver.com"))

    temp_list.getList()
