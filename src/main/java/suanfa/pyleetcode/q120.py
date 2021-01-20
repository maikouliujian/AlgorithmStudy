"""
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:

    def minimumTotal(self, triangle) -> float:
        self.res = float("inf")
        row = len(triangle)
        def helper(level, i, j, tmp):
            print("{level}-{i}-{j}-{tmp}".format(level=str(level),
                                                 i=str(i),
                                                 j=str(j),
                                                 tmp=str(tmp)))

            if level == row:
                self.res = min(self.res, tmp)
                return
            if 0 <= i < len(triangle[level]):
                helper(level + 1, i, i+1, tmp + triangle[level][i])
            if 0 <= j < len(triangle[level]):
                helper(level + 1, j, j+1, tmp + triangle[level][j])
        # 层level, 访问下一层两个节点位置i,j , 目前总和tmp
        helper(0, -1, 0, 0)
        return self.res




if __name__ == '__main__':
    triangle = [
        [2],
        [3,4],
        [6,5,7],
        [4,1,8,3]
    ]

    s = Solution()
    re = s.minimumTotal(triangle)
    print(re)
