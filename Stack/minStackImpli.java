package Stack;

public class minStackImpli {

    public class myStack{

        Node head;
        int minNumber;

        void push_back(int data) {

            Node addTo = new Node(data,data);
            if (head == null) {
                head = addTo;
                return;
            }
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }

            temp.next = addTo;

        }

        void pop(){
            Node temp = head;
            if(temp.next==null)
                head = null;
            else{
                while(temp.next.next!=null){
                    temp=temp.next;
                }
                temp.next = null;
            }
        }

        int top() {
            Node temp = head;
            if (temp.next == null)
                return head.val;
            else {
                while (temp.next != null) {
                    temp = temp.next;
                }
                return temp.val;
            }
        }


        public class Node{
            int val;
            int min;
            Node next;
            public Node(int val,int min){
                val = this.val;
                min = this.min;
                next = null;
            }
        } 
    }
    public static void main(String[] args){

    }
    
}
