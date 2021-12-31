package tree;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = {0,1,2,3,4,5,6,7,8,9,10};
        Node tree = Node.getTreeHead(data, 1, null);
        Node.LDR(tree);
        Node remove = tree;
        while (remove.getLeftNode() !=null) {
            
            remove = remove.getLeftNode();
        }
        tree = Node.removeNode(remove);
        System.out.println();
        Node.LDR(tree);
    }

}
