
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:

    def reversList(self,head):
        """
        反转单链
        :param head:
        :return:
        """
        pre,cur = None,head
        while cur:
            cur.next,pre,cur = pre,cur,cur.next
        return pre






if __name__ == '__main__':
    n1 = ListNode(4)
    n2 = ListNode(5)
    n3 = ListNode(7)
    n4 = ListNode(8)

    n1.next = n2
    n2.next = n3
    n3.next = n4



    so = Solution()
    re = so.reversList(n1)
    print(re.val)