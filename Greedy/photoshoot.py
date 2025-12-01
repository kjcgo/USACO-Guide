from operator import truediv

#https://usaco.org/index.php?page=viewproblem2&cpid=1227

def main():
    n = int(input())
    cows = input()
    start = False
    is_odd = True
    ans = "."
    count = 0

    for x in range(0, n, 2):
        #print(cows[x], cows[x+1])
        if cows[x] == 'G' and cows[x+1] == 'H' and ans[-1] != "F":
            ans += "F"
            count += 1
        if cows[x] == 'H' and cows[x+1] == 'G' and ans[-1] != "T":
            ans += "T"
            count += 1
    if ans[-1] == "T":
        print(count -1)
    else:
        print(count)


if __name__ == '__main__':
    main()
