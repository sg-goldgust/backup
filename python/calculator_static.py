class Calculator:
    PI = 3.14

    @staticmethod
    def plus(a,b):
        return a+b
    
    @staticmethod
    def minus(a,b):
        return a-b

    @staticmethod
    def multiply(a,b):
        return a*b

    @staticmethod
    def divide(a,b):
        return a/b
    
    @classmethod
    def area(cls,r):
        return r*r*cls.PI

if __name__ == '__main__':
    print(Calculator.plus(3,4))