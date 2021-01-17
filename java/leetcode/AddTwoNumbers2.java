package leetcode;

/**
 * @author mean
 * @date 20200114
 */
public class AddTwoNumbers2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode cur = null;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int val = temp + n1 + n2;
            if (cur == null) {
                cur = new ListNode(val % 10);
                head = cur;
            } else {
                cur.next = new ListNode(val % 10);
                cur = cur.next;
            }
            temp = val / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (temp > 0) {
            cur.next = new ListNode(temp);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1, l2, l3, l4, l5, l6;
        l1 = new ListNode(2);
        l3 = new ListNode(4);
        l5 = new ListNode(3);
        l1.next = l3;
        l3.next = l5;

        l2 = new ListNode(5);
        l4 = new ListNode(6);
        l6 = new ListNode(4);
        l2.next = l4;
        l4.next = l6;

        addTwoNumbers(l1, l2);
    }

}
