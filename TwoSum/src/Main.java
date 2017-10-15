public class Main {

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{5, 76, 11, 15}, 87);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);
        ListNode r = addTwoNumbers(l1, l2);
        ListNode flag = r;
        while (flag != null) {
            System.out.print(flag.val);
            flag=flag.next;
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        int res1 = 0, res2 = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res1 = i;
                    res2 = j;
                }
            }
        }
        int[] arr = {res1, res2};
        return arr;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     * eg:
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode res = new ListNode(0);
        ListNode r=res;
        int flag = 0;
        while (p != null || q != null) {
            int x = 0, y = 0;
            if (p != null) {
                x = p.val;
            }
            if (q != null) {
                y = q.val;
            }
            int sum = x + y + flag;
            r.next=new ListNode(sum%10);
            r=r.next;
            flag = sum / 10;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if(flag>0){
            r.next=new ListNode(flag);
        }
        return res.next;
    }
}
