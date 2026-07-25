class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int sz = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (sz == n) {
            head = head.next;
            return head;
        }

        ListNode prev = head;
        for (int i = 0; i < sz - n - 1; i++) {
            prev = prev.next;
        }

        
        prev.next = prev.next.next;
        return head;
    }
}
