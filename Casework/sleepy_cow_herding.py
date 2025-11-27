import math

# for finding min
# if the distance between any two consecutive cows is 2, return 1
# else, return 2

# for finding max
# one less than the max distance between any two consecutive cows

# edge case, cows are already together, return 0 for both

#https://usaco.org/index.php?page=viewproblem2&cpid=915

def main():
    with open("herding.in", "r") as f:
        a, b, c = map(int, f.readline().split())

    f.close()
    ab = (int)(math.fabs(a-b))
    bc =(int)(math.fabs(b-c))

    most = max(ab, bc)
    mx = (int)(most - 1)


    if ab  == 2 or bc == 2:
        min = 1
    elif ab == 1 and bc == 1:
        min = 0
    else:
        min = 2

    #print(min)
    #print(mx)
    with open('herding.out', 'w') as f:
        f.write(str(min))
        f.write("\n")
        f.write(str(mx))

if __name__ == "__main__":
    main()
