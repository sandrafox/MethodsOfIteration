
def findx0(r, x):
    left = 0.5 + 1/(2 * r)
    right = 0.5 - 1 / (2 * r)
    leftabs = abs(left - x)
    rightabs = abs(right - x)
    x0 = 0
    if leftabs < rightabs:
        x0 = leftabs
    else:
        x0 = rightabs
    return (x0 + x) - 0.00001

def findq(r, x, x0):
    delta = x0 + 0.00001 - x
    return r * (1 - 2 * (x - delta))

def findsolve1(r):
    x0 = findx0(r, 0)
    x1 = r * x0 * (1 - x0)
    q = findq(r, 0, x0)
    delta = abs(x1)
    while abs(x1 - x0) > 0.000001 * (1 - q) / q:
        x0 = x1
        x1 = r * x0 * (1 - x0)
        if delta < abs(x1):
            return -1
        delta = abs(x1)
    return x1


def findsolve2(r):
    x0 = findx0(r, 1 - 1/r)
    x1 = r * x0 * (1 - x0)
    q = findq(r, 1 - 1/r, x0)
    delta = abs(x1 - 1 + 1/r)
    while abs(x1 - x0) > 0.000001 * (1 - q) / q:
        x0 = x1
        x1 = r * x0 * (1 - x0)
        if delta < abs(x1 - 1 + 1/r):
            return -1
        delta = abs(x1 - 1 + 1/r)
    return x1

def findsolve(r):
    x0 = 0.5
    x1 = r * x0 * (1 - x0)
    while abs(x1 - x0) > 0.00000000001:
        x0 = x1
        x1 = r * x0 * (1 - x0)
    return x1

f = open('text.txt', 'w')
for x in [x / 100000.0 for x in range(0, 300000)]:
    #if x == 0:
     #   continue
    f.write("%f %.5f\n" %(x, findsolve(x)))
    #print("solve2 for %f = %f" %(x, findsolve2(x)))
    #print("\n")