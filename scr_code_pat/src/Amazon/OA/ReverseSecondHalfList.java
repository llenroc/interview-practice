package Amazon.OA;

/**
 * Created by yizhaoyang on 7/23/17.
 */
// ListNode class definition
class ListNode {
    int itemValue;
    ListNode next;

    public ListNode(int val) {
        itemValue = val;
        next = null;
    }
}

public class ReverseSecondHalfList {

    /**
     * Call the private method to solve the problem
     * @param head The head node of the given linked list
     * @return     The head node of the reversed linked list
     */
    public ListNode solution(ListNode head) {
        return reverseSecondHalfList(head);
    }

    /**
     * Private method for encapsulation
     * Reverse the second half of the given linked list
     * @param head The head node of the given linked list
     * @return     The head node of the reversed linked list
     */
    private ListNode reverseSecondHalfList(ListNode head) {
        // If the linked list is null (head node is null) or contains only
        // one node (head.next is null), return the head node of the linked list directly
        if (head == null || head.next == null) {
            return head;
        }

        // Define the node previous to the first node of the second half linked list
        // and two search nodes to find the it
        ListNode preHalfFirstNode = head;
        ListNode slowSearchNode = head;
        ListNode fastSearchNode = head;

        // Find the first node of the second half of the linked list
        while (fastSearchNode.next != null) {
            fastSearchNode = fastSearchNode.next;
            slowSearchNode = slowSearchNode.next;
            if (fastSearchNode.next != null) {
                fastSearchNode = fastSearchNode.next;
            }
        }

        // Find the node previous to the first node of the second half linked list
        while (preHalfFirstNode.next != slowSearchNode) {
            preHalfFirstNode = preHalfFirstNode.next;
        }

        // Define previous node, current node, and next node for the reversing operation
        ListNode prevNode = null;
        ListNode currNode = preHalfFirstNode.next;
        ListNode nextNode = null;

        // Reverse all the nodes starting from the first node of the second half linked list
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        // Connect the first node of the reversed second half
        // linked list to the original first half linked list
        preHalfFirstNode.next = prevNode;

        return head;
    }

    // Main method for testing
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
//        node7.next = null;

        ListNode printer = head;
        while (printer != null) {
            System.out.print(printer.itemValue);
            System.out.print("->");
            printer = printer.next;
        }
        System.out.println("null");

        ReverseSecondHalfList testInstance = new ReverseSecondHalfList();
        ListNode newHead = testInstance.solution_2(head);

        printer = newHead;
        while(printer != null) {
            System.out.print(printer.itemValue);
            System.out.print("->");
            printer = printer.next;
        }
        System.out.println("null");
    }
    /**
     * Call the private method to solve the problem
     * @param head The head node of the given linked list
     * @return     The head node of the reversed linked list
     */
    public ListNode solution_2(ListNode head) {
        return reverseSecondHalfList_2(head);
    }

    /**
     * Private method for encapsulation
     * Reverse the second half of the given linked list
     * @param head The head node of the given linked list
     * @return     The head node of the reversed linked list
     */
    private ListNode reverseSecondHalfList_2(ListNode head) {
        // If the linked list is null (head node is null) or contains only
        // one node (head.next is null), return the head node of the linked list directly
        if (head == null || head.next == null) {
            return head;
        }

        // Find the node previous to the first node of the second
        // half linked list using two search nodes
        ListNode slowSearchNode = head;
        ListNode fastSearchNode = head.next;

        while(fastSearchNode.next != null && fastSearchNode.next.next != null) {
            slowSearchNode = slowSearchNode.next;
            fastSearchNode = fastSearchNode.next.next;
        }

        // Define previous node, current node, and next node for the reversing operation
        ListNode prevNode = null;
        ListNode curNode = slowSearchNode.next;
        ListNode nextNode = null;

        while(curNode != null) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }

        // Connect the first node of the reversed second half
        // linked list to the original first half linked list
        slowSearchNode.next = prevNode;

        return head;
    }
}
