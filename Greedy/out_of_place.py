//https://usaco.org/index.php?page=viewproblem2&cpid=785

def main():
    with open("outofplace.in", 'r') as f:
        n = int(f.readline())
        nums1 = []
        nums2 = []
        for x in range(n):
            num = int(f.readline())
            nums1.append(num)
            nums2.append(num)

        nums1.sort()
        counter = 0
        for x in range(n):
            if nums1[x] != nums2[x]:
                counter += 1
        f.close()

    with open("outofplace.out", 'w') as f:
        f.write(str(counter-1))
        f.close()
if __name__ == "__main__":
    main()
