#https://usaco.org/index.php?page=viewproblem2&cpid=567

def main():
    with open("paint.in") as f:
        ab = f.readline().split(" ")
        a = int(ab[0])
        b = int(ab[1])

        cd = f.readline().split(" ")
        c = int(cd[0])
        d = int(cd[1])

    ans = (b-a) + (d-c)

    sub = min(b, d) - max(a, c)
    if sub > 0:
        ans -= sub

    with open("paint.out", "w") as f:
        f.write(str(ans))




if __name__ == "__main__":
    main()
