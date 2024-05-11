x=1
y=4
ans=x^y
c=0
while(ans!=0):
    ans=ans&(ans-1)
    c+=1
print(c)

