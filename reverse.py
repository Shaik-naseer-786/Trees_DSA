#n=100
rev=0
a=0
ans=""
#n1=str(n)
n1=input()
for i in range(len(n1)-1,-1,-1):
    ans=ans+n1[i]
print(ans)