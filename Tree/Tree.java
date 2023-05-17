package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class Tree {

    Node root = null;

    Node createTree() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value:");
        int d = sc.nextInt();
        if( d == -1 ) {
            return null;
        }
        Node head = root;
        head = new Node(d);
        System.out.println("Enter the left of " + d);
        head.leftNode = createTree();
        System.out.println("Enter the right of " + d);
        head.rightNode = createTree();
        return head;
    }

    void preOrder(Node head){
        if (head == null)
        return; 
        System.out.println(head.data);
        preOrder(head.leftNode);
        preOrder(head.rightNode);
    }
    
    void inOrder(Node head) {
        if (head == null)
            return;
        inOrder(head.leftNode);
        System.out.println(head.data);
        inOrder(head.rightNode);
    }

    void postOrder(Node head) {
        if (head == null)
            return;
        postOrder(head.leftNode);
        postOrder(head.rightNode);
        System.out.println(head.data);
    }
    int search(int cur,int[] in,int s, int e){
        int i=s;
        while(cur!=in[i]&&i<=e)
            i++;
        return i;
    }
    static int indpre = 0;
    Node buildTreePre(int[] in,int[] pre, int s, int e){
        if(s<0||e>=in.length||s>e)
            return null; 
        int cur = pre[indpre++];
        int g = search(cur,in,s,e);
        Node head = new Node(cur);
        if(s==e)
            return head;
        head.leftNode = buildTreePre(in, pre, s, g-1);
        head.rightNode = buildTreePre(in, pre, g+1, e);
        return head; 
    }

    static int indpost = 0;

    Node buildPostTree(int[] in, int[] pre, int s, int e){
        indpost = in.length-1;
        return buildTreePost(in, pre, s, e);
    }

    Node buildTreePost(int[] in, int[] post, int s, int e) {
        if (s < 0 || e >= in.length || s > e)
            return null;
        int cur = post[indpost--];
        int g = search(cur, in, s, e);
        Node head = new Node(cur);
        if (s == e)
            return head;
        head.rightNode = buildTreePost(in, post, g + 1, e);
        head.leftNode = buildTreePost(in, post, s, g - 1);
        return head;
    }

    void levelOrder(Node head){
        if(head == null){
            System.out.println(head);
            return;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(head);
        que.add(null);
        while(!que.isEmpty()){
            Node newNode = que.poll();
            if(newNode!=null){
                System.out.println(newNode.data);
                if(newNode.leftNode!=null)
                    que.add(newNode.leftNode);
                if (newNode.rightNode != null)
                    que.add(newNode.rightNode);
            }else if (!que.isEmpty()){
                que.add(null);
            }
        }
    }

    int sumAtKLevel(Node head,int k){
        if (head == null) {
            System.out.println(head);
            return 0;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(head);
        que.add(null);
        int sum = 0;
        while (!que.isEmpty()) {
            Node newNode = que.poll();
            if (newNode != null) {
                if(k==1) sum+=newNode.data;
                if (newNode.leftNode != null)
                    que.add(newNode.leftNode);
                if (newNode.rightNode != null)
                    que.add(newNode.rightNode);
            } else if (!que.isEmpty()) {
                que.add(null);
            }
            if(k==0) return sum;
            if(newNode==null)
                k--;
        }
        return sum;
    }

    int countNode(Node head){
        if(head == null)
            return 0;
        return countNode(head.leftNode) + countNode(head.rightNode) + 1;
    }

    int sumOfAll(Node head){
        if(head == null)
            return 0;
        return sumOfAll(head.leftNode) + sumOfAll(head.rightNode) + head.data;
    }

    int sumReplace(Node head){
        if(head == null)
            return 0;
        int l = sumReplace(head.leftNode);
        int r = sumReplace(head.rightNode);
        head.data += l + r;
        return head.data;  
    }

    int heightTree(Node head){
        if(head == null)
            return 0;
        return Math.max(heightTree(head.leftNode),heightTree(head.rightNode)) + 1; 
    }

    int farLeft(Node head, int count){
        if(head == null)
            return count+1;
        int l = farLeft(head.leftNode,count-1);
        int r = farLeft(head.rightNode,count+1);
        count = Math.min(l,r);
        return count;
    }

    boolean checkBalancedHeight(Node head){
        if(head == null)
            return true;
        int l = heightTree(head.leftNode);
        int r = heightTree(head.rightNode);
        boolean b = Math.abs(l-r)<=1;
        return b&&checkBalancedHeight(head.leftNode)&&checkBalancedHeight(head.rightNode);
    }

    int farRight(Node head, int count) {
        if (head == null)
            return count-1;
        int l = farRight(head.leftNode, count - 1);
        int r = farRight(head.rightNode, count + 1);
        count = Math.max(l, r);
        return count;
    }

    int diameterTree(Node head){
        if(head == null)
            return 0;
        int cur = heightTree(head.leftNode) + heightTree(head.rightNode) + 1;
        int dur = Math.max(diameterTree(head.leftNode),diameterTree(head.rightNode));
        return Math.max(cur,dur);
    }

    int widthTree(Node head){
        if(head == null)
            return 0;
        int l = farLeft(head, 0);
        int r = farRight(head, 0);
        return r-l;
    }

    Set<Integer> set = new HashSet<>();
    void rightView(Node head,int count){
        if(head == null)
            return;
        if(!set.contains(count)){
            set.add(count);
            System.out.println(head.data);
        }
        rightView(head.rightNode, count+1);
        rightView(head.leftNode, count+1);
    }

    void leftView(Node head, int count) {
        if (head == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr!=null){
                if(q.peek()==null)
                    System.out.println(curr.data);
                if(curr.rightNode!=null)
                    q.add(curr.rightNode);
                if(curr.leftNode!=null)
                    q.add(curr.leftNode);
            }else if(!q.isEmpty()){
                q.add(null);
            }
        }
    }

    Node lCA(Node head, int n1, int n2){
        if(head == null)
            return null;
        if(head.data == n1||head.data == n2)
            return head;
        Node l = lCA(head.leftNode, n1, n2);
        Node r = lCA(head.rightNode, n1, n2);
        if(l!=null&&r!=null)
            return head;
        if(l == null && r == null)
            return null;
        if(l!=null)
            return l;
        return r;         
    }

    int findDst(Node head,int n, int count){
        if(head == null)
            return -1;
        if(head.data == n)
            return count;
        int l = findDst(head.leftNode, n, count+1);
        if(l!=-1)
            return l; 
        return findDst(head.rightNode, n, count+1);
    }

    int distBtwNodes(Node head, int n1, int n2){
        if(head == null)
            return 0;
        Node lca = lCA(head, n1, n2);
        System.out.println(lca.data);
        return findDst(lca, n1, 0) + findDst(lca, n2, 0) +1;
    }

    void printRight(Node head){
        if(head == null)
            return;
        System.out.println(head.data);
        printRight(head.rightNode);
    }

    Node flattenTree(Node head){
        if(head == null)
            return null;
        
        flattenTree(head.leftNode);
        flattenTree(head.rightNode);

        Node temp = head.rightNode;
        Node tem = head.leftNode;
        if(tem==null)
            return head;
        head.rightNode = tem;
        if(temp==null)
            return head;
        while(tem.rightNode!=null)
            tem = tem.rightNode;
        tem.rightNode = temp;
        return head;
    }

    void subtreeNodesAtK(int k, Node head){
        if(k<0||head == null)
            return;
        if(k == 0)
            System.out.println(head.data);
        subtreeNodesAtK(k, head.leftNode);
        subtreeNodesAtK(k, head.rightNode);
    }

    int printNodeatK(int k,Node head, int target){
        if(head == null)
            return -1;
        if(head.data == target){
            subtreeNodesAtK(k, head);
            return 0;
        }
        int l = printNodeatK(k, head.leftNode, target);
        if(l!=-1){
            if(l+1==k)
            System.out.println(head.leftNode.data);
            else
                subtreeNodesAtK(k-l-2, head.rightNode);
                return 1+l;
        }

        int r = printNodeatK(k, head.rightNode, target);
        if (r != -1) {
            if (r + 1 == k)
                System.out.println(head.rightNode.data);
            else
                subtreeNodesAtK(k - r - 2, head.leftNode);
            return 1 + r;
        }

        return -1;
    }

    Node findNode(Node head,int val){
        if(head == null)
            return null;
        if(head.data==val)
            return head;
        Node l = findNode(head.leftNode, val);
        if(l!=null)
            return l;
        return findNode(head.rightNode, val);
    }

    List<Node> getPath(Node head,int val, List<Node> list){
        if(head == null)
            return list;
        list.add(head);
        if(head.data == val)
            return list;
        List<Node> lis = new ArrayList<>();
        getPath(head.leftNode, val, lis);
        if(!lis.isEmpty()&&lis.get(lis.size()-1).data==val){
            list.addAll(lis);
            return list;
        }
        return getPath(head.rightNode, val, list);
    }

    Node LCA(Node head,int n1, int n2){
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();
        path1 = getPath(head, n1, path1);
        path2 = getPath(head, n2, path2);
        int pc = 0;
        while(path1.get(pc)==path2.get(pc))
            pc++;
        return path1.get(pc-1);
    }

    int maxPathSum(Node head){
        if(head == null)
            return 0;
        int l = maxPathSum(head.leftNode);
        int r = maxPathSum(head.rightNode);
        int max = Math.max(l+head.data,r+head.data);
        max = Math.max(l+r+head.data,max);
        return Math.max(max,head.data);
    }

    Map<Integer,Integer> map = new HashMap<>(); 

    Map<Integer,Integer> topView(Node head, int n){
        if(head == null)
            return map;
        map.putIfAbsent(n, head.data);
        topView(head.leftNode, n-1);
        topView(head.rightNode, n+1);
        return map;
    }

    void printTopView(Node head){
        Map<Integer,Integer> m1 = topView(head, 0);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int key: m1.keySet()){
            pq.add(key);
        }
        for(int x:pq){
            System.out.println(m1.get(x));
        }
    }

    static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        public Node(int data) {
            this.data = data;
            leftNode = null;
            rightNode = null;
        }

    }

    //Binary Search Tree

    Node insertBST(Node head, int val){
        if(head == null){
            head = new Node(val);
            return head;
        }

        if(head.data > val)
            head.leftNode = insertBST(head.leftNode, val);
        else
            head.rightNode = insertBST(head.rightNode, val);
        return head;
    }

    Node createBinarySearchTree(int[] arr){
        Node head = new Node(arr[0]);
        for(int x=1;x<arr.length;x++){
            insertBST(head, arr[x]);
        }
        return head;
    }

    Node searchBSTNode(Node head, int val){
        if(head == null)
            return null;
        if(head.data == val)
            return head;
        if(head.data > val)
            return searchBSTNode(head.leftNode, val);
        return searchBSTNode(head.rightNode, val);
    }

    void free(Node head, Node r){
        if(head == null)
            return;
        if(head.leftNode == r)
            head.leftNode = null;
        else if(head.rightNode == r)
            head.rightNode = null;
        else{
            free(head.leftNode, r);
            free(head.rightNode, r);
        }
    }

    Node inorderSuc(Node head){
        Node curr = head;
        while( curr!=null &&curr.leftNode!= null ){
            curr = curr.leftNode;
        }
        return curr;
    }

    Node deleteInBST(Node j, Node head, int key){
        if(head == null)
            return null;
        if(head.data > key){
            head.leftNode = deleteInBST(j,head.leftNode, key);
        }else if(head.data < key){
            head.rightNode = deleteInBST(j,head.rightNode, key);
        }else{
            if(head.leftNode == null){
                Node temp = head.rightNode;
                free(j,head);
                return temp;
            }else if(head.rightNode == null){
                Node temp = head.leftNode;
                free(j, head);
                return temp;
            }else if(head.rightNode == null && head.leftNode == null){
                free(j,head);
                return null;
            }
            Node temp = inorderSuc(head.rightNode);
            int swap = head.data;
            head.data = temp.data;
            temp.data = swap;
            head.rightNode = deleteInBST(j, head.rightNode, temp.data);
        }
        return head;
    }

    void constructBST(Node head, Node min, Node max, int val){
        if(head == null){
            head  = new Node(val);
            return;
        }
        if(head.leftNode==null&&head.data>val){
            head.leftNode = new Node(val);
            return;
        }
        if (head.rightNode == null && head.data < val) {
            head.rightNode = new Node(val);
            return;
        }
        if(head.data > val){
            if (max != null && max.data > val){
                constructBST(head.leftNode, min, head, val);
            }else if( max == null){
                constructBST(head.leftNode, min, head, val);
            }
        }
        
        constructBST(head.rightNode,head,max,val);
    } 

    Node constructBSTpre(int[] arr){
        Node head = new Node(arr[0]);
        for(int i=1;i<arr.length;i++){
            constructBST(head, null, null, arr[i]);
        }
        return head;
    }

    static int preind = 0;
    Node buildPreBST(int[] pre, int val, int min ,int max){
        Node head = null;
        if(val>min&&val<max){
            head = new Node(val);
            preind++;
            if(preind<pre.length){
                head.leftNode = buildPreBST(pre, pre[preind], min, head.data);
            }
            if(preind < pre.length) {
                head.rightNode = buildPreBST(pre, pre[preind], head.data, max);
            }
            if(preind>=pre.length)
                return head;
        }
        return head;
    }

    boolean isValidBST(Node head, Node min, Node max){
        if(head == null)
            return true;
        if(min!=null&&head.data<min.data||max!=null&&head.data>max.data)
            return false;
        return isValidBST(head.leftNode, min, head)&&isValidBST(head.rightNode, head, max);
    }

    Node constructBSTFRomSortedArray(int[] arr, int s, int f){
        if(s>f)
            return null;
        int mid = s + (f-s)/2;
        Node head = new Node(arr[mid]);
        head.leftNode = constructBSTFRomSortedArray(arr, s, mid-1);
        head.rightNode = constructBSTFRomSortedArray(arr, mid+1, f);
        return head;
    }


    Stack<Node> curr = new Stack<>();
    Stack<Node> next = new Stack<>();
    void zigzagTraversal(Node head, boolean b){
        if (head == null)
            return;
        next.push(head);
        
        while(!curr.isEmpty()||!next.isEmpty()){
            /*if(curr.isEmpty()||next.isEmpty()){
                Stack<Node> stk = curr;
                curr = next;
                next = stk;
                b = !b;
                System.out.println("kxkkgd");
            }*/
            if(curr.isEmpty()&&!next.isEmpty()){
                Stack<Node> stk = curr;
                curr = next;
                next = stk;
                b = !b;
            }
            Node node = curr.pop();
            System.out.println(node.data);
            if(b){
                if (node.leftNode != null)
                    next.push(node.leftNode);
                if (node.rightNode != null)
                    next.push(node.rightNode);
            }else{
                if (node.rightNode != null)
                    next.push(node.rightNode);
                if (node.leftNode != null)
                    next.push(node.leftNode);
            }
        }
    }

    int sizeofLargestBSTinBT(Node head){
        if(head == null)
            return 0;
        if(isValidBST(head, null, null))
            return countNode(head);
        return Math.max(sizeofLargestBSTinBT(head.leftNode),sizeofLargestBSTinBT(head.rightNode));
    }

    //Heap

    
}
