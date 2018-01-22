import math

def format_name(s):
    return s[0].upper()+s[1:].lower()
    #return s.title()
    #reutrn s.capitalize()
print map(format_name,['adam','ALOS','aSDFD'])

