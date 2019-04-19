class A:
    def __init__(self,msg):
        print("A.__init__()")
        self.message = msg

class B(A):
    def __init__(self,msg):
        print("B.__init__()")

        super().__init__(msg)
        print("self.message is "+self.message)

if __name__ == "__main__":
    b = B("hello world")