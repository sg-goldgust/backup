class A:
    def method(self):
        print("A")

class B(A):
    def method(self,arg):
        super().method()
        print("B",arg)

class C(A):
    def method(self):
        print("C")
        super().method()

if __name__ == "__main__":
    A().method()
    B().method("test")
    C().method()
