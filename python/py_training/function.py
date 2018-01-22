def f():
    print 'call f() ...'
    def g():
        print 'call g() ...'
    return g
x=f()
print x
print x()

def calc_sum(lst):
    def lazy_sum():
        return sum(lst)
    return lazy_sum
aaa = calc_sum([1,2,3,4,5])
print aaa
print aaa()
