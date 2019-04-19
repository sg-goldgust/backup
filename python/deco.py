class Callable:
    def __call__(self):
        print("I am called.")

if __name__ == "__main__":
    obj = Callable()
    obj()