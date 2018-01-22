import math

def add(x,y,f):
    return f(x)+f(y)

print add(4,8,math.sqrt)
