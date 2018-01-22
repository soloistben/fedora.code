import math

def f(x,y):
    return x+y
def c(x,y):
    return x*y

print reduce(f,[1,2,3,4,5],90)
print reduce(c,[2,4,5,7,12])
