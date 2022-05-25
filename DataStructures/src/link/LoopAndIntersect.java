package link;

/**
 * 单链表成环与相交问题
 */
public class LoopAndIntersect {

    static class Node{
        Integer val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        Node b = new Node(4);
        a.next.next.next = b;
        a.next.next.next.next = new Node(5);
        a.next.next.next.next.next = b;

        Node c = new Node(1);
        c.next = new Node(2);
        c.next.next = new Node(3);
        Node d = new Node(4);
        c.next.next.next = b;
        // c.next.next.next.next = new Node(5);
        // c.next.next.next.next.next = b;

        Node intersect = isIntersect(a, c);

        System.out.println(intersect != null ? intersect.val : null);
    }

    /**
     * 判断两链表（成环/不成环）是否相交
     * @param headA
     * @param headB
     * @return 相交返回相交节点，不相交返回null
     */
    public static Node isIntersect(Node headA, Node headB){
        Node loopA = isLoop(headA);
        Node loopB = isLoop(headB);
        if(loopA == null && loopB == null){
            return noLoopIsIntersect(headA, headB);

        }else if(loopA != null && loopB != null){
            return LoopIsIntersect(headA, loopA, headB, loopB);
        }
        // 一成环，一不成环链表必不相交
        return null;
    }

    /**
     * 判断链表是否成环
     * @return 成环返回第一个入环节点，不成环返回null
     */
    public static Node isLoop(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return fast;
            }
        }
        return null;
    }

    /**
     * 判断两不成环链表是否相交
     * @param headA
     * @param headB
     * @return 相交返回相交节点，不相交返回null
     */
    public static Node noLoopIsIntersect(Node headA, Node headB){
        Node a = headA;
        Node b = headB;
        int len = 1;
        while(a.next != null){
            a = a.next;
            len++;
        }
        while(b.next != null){
            b = b.next;
            len--;
        }
        // 最后一个节点相同，则两链表必相交
        if(a == b){
            a = len >= 0 ? headA : headB;
            b = a == headA ? headB : headA;
            len = Math.abs(len);
            while(len != 0){
                a = a.next;
                len--;
            }
            while(a != b){
                a = a.next;
                b = b.next;
            }
            return a;
        }else{
            return null;
        }
    }

    /**
     * 判断两成环链表是否相交
     * @param headA
     * @param loopA 链表1入环节点
     * @param headB
     * @param loopB 链表2入环节点
     * @return 相交返回相交节点，不相交返回null
     */
    public static Node LoopIsIntersect(Node headA, Node loopA, Node headB, Node loopB){
        // 若入环节点为同一个，则两链表相交
        if(loopA == loopB){
            Node a = headA;
            Node b = headB;
            int len = 0;
            while(a != loopA){
                a = a.next;
                len++;
            }
            while(b != loopB){
                b = b.next;
                len--;
            }
            a = len >= 0 ? headA : headB;
            b = a == headA ? headB : headA;
            len = Math.abs(len);
            while(len != 0){
                a = a.next;
                len--;
            }
            while(a != b){
                a = a.next;
                b = b.next;
            }
            return a;
        }else{
            Node a = loopA.next;
            while (a != loopA) {
                if (a == loopB) {
                    return a;
                }
                a = a.next;
            }
            return null;
        }
    }
}