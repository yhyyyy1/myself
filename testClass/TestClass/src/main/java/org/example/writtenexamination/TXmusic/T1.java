package org.example.writtenexamination.TXmusic;

/**
 * AC
 * 20 mins
 */
public class T1 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode temp = node;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        System.out.println(merge(node));
    }

    public static int merge(ListNode a) {
        // write code here

        // 意思就是如果ai为0，则前面一定是0；如果ai不是0，则前面一定是0

        // 合并就是 Math.max
        if (a == null || a.next == null) {
            return 0;
        }

        int count = 0;
        ListNode temp = a;
        while (temp.next != null) {
            if (temp.val == 0 && temp.next.val == 0) {
                temp.next = temp.next.next;
                temp.val = 0;
                count++;
            } else if (temp.val != 0 && temp.next.val != 0) {
                // 需要合并
                int tempVal = Math.max(temp.val, temp.next.val);
                temp.next = temp.next.next;
                temp.val = tempVal;
                count++;
            } else {
                temp = temp.next;
            }
        }
        return count;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
