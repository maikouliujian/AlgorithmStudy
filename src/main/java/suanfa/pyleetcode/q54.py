# 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元
__author__ = 'ice'


def select_coin(coin_value, total_value):
    min_coin_num = [0]

    for i in range(1, total_value + 1):
        min_coin_num.append(float('inf'))
        for value in coin_value:
            if value <= i and min_coin_num[i - value] + 1 < min_coin_num[i]:
                min_coin_num[i] = min_coin_num[i - value] + 1

    return min_coin_num

result = select_coin([1, 3, 5], 11)
print(result)
print("coin number:" + str(result[-1]))



def f(n):
    if n == 1:      #把所有的边界问题找到
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 1
    if n == 4:
        return 2
    if n == 5:
        return 1

    h = [1,3,5]
    minx = n
    for i in range(3):
        coun = f(n-h[i])+1    # 采用了递归的思想 这里是从上到下，
        if minx > coun:       # 复杂度比较高
            minx = coun
    return minx

print(f(11))

if __name__ == '__main__':
    # print(float('inf'))
    pass
