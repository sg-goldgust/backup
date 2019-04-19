#class PrimeSequence:
 #   def __init__(self,rng):
  #      self.rng = rng
   #     self.primelist = []
    #    for prime in range(2,self.rng):
     #       for i in range(2,prime):
      #          if prime%i == 0: break
       #     else:
        #        self.primelist.append(prime)

        
'''def __iter__(self):
        return self
    def __next__(self):
        if self.primelist is not None:
            return self.primelist.pop(0)
        else:
            raise StopIteration()'''



def PrimeRange(rng):
    primelist = []
    for prime in range(2,rng):
        for i in range(2,prime):
            if prime%i == 0: break
        else:
            primelist.append(prime)
            
    for p in primelist:
        yield p
    else:
        raise StopIteration()
    return

for pn in PrimeRange(50):
    print(pn) 

'''iter = PrimeRange(50)
print(iter.__next__())
print(iter.__next__())'''
