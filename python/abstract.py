from abc import ABCMeta
from abc import abstractmethod

class AbstractDuck(metaclass=ABCMeta):
    @abstractmethod
    def Quack(self):
        pass

class Duck(AbstractDuck):
    #pass
    def Quack(self):
        print("[duck] quack")

def quack(obf):
    if isinstance(obj,AbstractDuck):
        obj.Quack()
    else:
        print("꿱꿱거리지 못합니다")

duck = Duck()
duck.Quack()