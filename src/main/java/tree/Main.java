package tree;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = {0,1,2,3,4,5,6,7,8,9,10};
        main.java.tree.Node tree = main.java.tree.Node.getTreeHead(data, 1, null);
        main.java.tree.Node.LDR(tree);
        main.java.tree.Node remove = tree;
        while (remove.getLeftNode() !=null) {
            
            remove = remove.getLeftNode();
        }
        tree = main.java.tree.Node.removeNode(remove);
        System.out.println();
        main.java.tree.Node.LDR(tree);
    }

}
