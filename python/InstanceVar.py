class InstanceVar:
    def __init__(self):
        self.text_list = []

    def add(self,text):
        self.text_list.append(text)

    def sort(self, reverse=False):
        self.text_list.sort(reverse=reverse)

    def print_list(self):
        print(self.text_list)
    
if __name__ == '__main__':
    a=InstanceVar()
    a.add('a')
    a.add('b')
    a.add('d')
    a.add('c')

    a.sort()
    a.print_list()
