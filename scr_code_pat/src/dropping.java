import java.util.Stack;

class dropping{

    static Node pre = null;
    static Stack<Node> s = new Stack<>();

    public static void addNumber(int num){
        Node node = new Node(num);

        if(s.isEmpty()){
            pre = node;
            s.push(node);
        }
        else{
            pre = s.peek();
            link(pre,node);
            s.push(node);
        }

        for (int i = 0; i < s.size(); i++) {


            System.out.println("pre val " + pre.val);
            System.out.println("pre pre " + pre.pre);
            System.out.println("pre next " + pre.next);

            System.out.println("node val" + node.val);
            System.out.println("node pre" + node.pre);
            System.out.println("node next" + node.next);
        }
    }

    public static void link(Node n1, Node n2){
        n1.next = n2;
        n2.pre = n1;
    }


    public static void main(String[] args) {
        addNumber(1);
        addNumber(2);
        addNumber(3);

    }


    private static class Node{
        Node pre;
        Node next;
        int val;

        public Node(int val){
            this.val = val;
        }


        public String toString(){
            return "" + this.val + " " + this.pre + " " + this.next;
        }
    }



}
