import math

#https://usaco.org/index.php?page=viewproblem2&cpid=615

def main():
    with open("pails.in") as f:
        pails = f.readline().split(" ")
    x = int(pails[0])
    y = int(pails[1])
    m = float(pails[2])
    a_max = math.floor(m / x)
    b_max = math.floor(m / y)
    #print(a_max, b_max)
    ans = 0

    for i in range(a_max+1):
        for j in range(b_max+1):
            if i * x + j * y <= m:
                ans = max(ans,  i * x + j * y)
    with open("pails.out", "w") as f:
        f.write(str(ans))

if __name__ == "__main__":
    main()
