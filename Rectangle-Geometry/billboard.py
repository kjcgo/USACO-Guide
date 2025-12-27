#https://usaco.org/index.php?page=viewproblem2&cpid=759
def main():
    with open("billboard.in") as f:
        a = f.readline().split()
        xa1, ya1, xa2, ya2 = int(a[0]), int(a[1]), int(a[2]), int(a[3])

        b = f.readline().split()
        xb1, yb1, xb2, yb2 = int(b[0]), int(b[1]), int(b[2]), int(b[3])

        c = f.readline().split()
        xc1, yc1, xc2, yc2 = int(c[0]), int(c[1]), int(c[2]), int(c[3])

    a_area = abs(xa1-xa2) * abs(ya1-ya2)
    b_area = abs(xb1-xb2) * abs(yb1-yb2)

    ac_int = max(0, (min(xc2, xa2) - max(xc1, xa1))) * max(0, (min(yc2, ya2) - max(yc1, ya1)))
    bc_int = max(0, (min(xc2, xb2) - max(xc1, xb1))) * max(0, (min(yc2, yb2) - max(yc1, yb1)))

    ans = a_area + b_area - ac_int - bc_int
    with open("billboard.out", "w") as f:
        f.write(str(ans))

if __name__ == "__main__":
    main()
