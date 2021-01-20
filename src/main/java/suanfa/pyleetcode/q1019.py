

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None




class Solution:
    """
    思路：TODO 采用回溯法
          TODO 先把链表转为列表
    """
    def nextLargerNodes(self, head: ListNode) -> list[int]:
        # 1、链表转列表
        tmp = head
        nums = []
        while tmp:
            nums.append(tmp.val)
            tmp = tmp.next
        # 2、使用栈=记录位置=进行回溯
        stack = []
        result = [0] * len(nums)
        for i, n in enumerate(nums):
            # 回溯
            while stack and nums[stack[-1]] < n:
                # 更新对应位置的值，并进行弹栈
                result[stack.pop()] = n
            stack.append(i)

        return result


if __name__ == '__main__':
   pass