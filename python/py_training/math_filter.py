import math

def myfilter(x):
    return x%2==1
print filter(myfilter,[1,2,56,7,8,99,65])
def is_filter_none(s):
    return s and len(s.strip())>0
print filter(is_filter_none,['  asd','bfgoib\n','','  ','eee'])
def is_sqrt(x):
    return math.sqrt(x)%1==0
   
print filter(is_sqrt,range(1,101))
print 'ass\n'.strip()
