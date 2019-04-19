class Base:
    def base_method(self):
        print("Hello Base")

class Derived(Base):
    pass

if __name__ == "__main__":
    base = Base()
    base.base_method()
    derived = Derived()
    derived.base_method()