class HasPrivate:
    def __init__(self):
        self.public = "public"
        self.__private = "private"

    def print_from_internal(self):
        print(self.public)
        print(self.__private)

if (__name__ == "__main__"):
    obj = HasPrivate()
    obj.print_from_internal()

    print(obj.__dict__)
    