package Tree;

import Tree.Tree.Node;

public class Main {
    
    public static void main(String[] args) {

        Tree tree = new Tree();

        Node root = tree.createTree();

        //int[] in = {4,2,1,6,3,5};
        //int[] pre = {1,2,4,3,6,5};
        //int[] post = {4,2,6,5,3,1};
        //Node root = tree.buildPostTree(in,post,0,in.length-1);

        //System.out.println(tree.sumAtKLevel(root, 4));
        //System.out.println("count: " + tree.countNode(root)+"\nsum: " + tree.sumOfAll(root)+"\nheight: " + tree.heightTree(root) + "\nwidth: " + tree.widthTree(root) + "\ndiameter: " + tree.diameterTree(root));
        //tree.sumReplace(root);
        //tree.preOrder(root);

        //System.out.println(tree.checkBalancedHeight(root));
        //System.out.println();
        //tree.rightView(root, 0);
        
        //tree.leftView(root, 0);
        //System.out.println(tree.distBtwNodes(root, 4, 9));
        //System.out.println(tree.findNode(root,8).data);
        //List<Node> list = new ArrayList<>();
        //list = tree.getPath(root, 12, list);
        //for(Node rf:list){
            //System.out.println(rf.data);
        //}
        //System.out.println(tree.maxPathSum(root));
        //System.out.println(tree.LCA(root, 7, 8).data);
        System.out.println();
        //tree.printTopView(root);

        //int[] nums = {7,5,4,6,8,9};
        //Node root = tree.buildPreBST(nums,nums[0],Integer.MIN_VALUE,Integer.MAX_VALUE);
        
        System.out.println(tree.sizeofLargestBSTinBT(root));
    }

}
