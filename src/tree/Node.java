package tree;

public class Node {

    private int value;
    private Node rightNode;
    private Node leftNode;
    private Node parentNode;
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
    
    public static Node getTreeHead(int[] data,int position,Node parentNode) {
        
        Node node= new Node();
        node.setValue(data[position]);
        node.setParentNode(parentNode);
        
        position = position == 0?1:position;
        
        if (data.length > position*2) {
            
            node.setLeftNode(getTreeHead(data,position*2,node));
        }
        if (data.length > position*2 +1) {
            
            node.setRightNode(getTreeHead(data,position*2 +1,node));
        }
        return node;
    }
    
    // the result of LDR is as same as the result before doing this fucntion.
    public static Node removeNode(Node removeNode) {
        
        Node parentNode = removeNode.getParentNode();
        
        if (removeNode.leftNode==null && removeNode.rightNode == null) {
            
            if (parentNode == null) {
                
                return null;
            }
            else if (parentNode.leftNode == removeNode) {
                
                parentNode.leftNode = null;
            }
            else if (parentNode.rightNode == removeNode) {
                
                parentNode.rightNode = null;
            }
            
        }
        
        if (removeNode.leftNode == null && removeNode.rightNode != null) {
            
            if (parentNode == null) {
                
                return removeNode.rightNode;
            }
            else if (parentNode.leftNode == removeNode) {
                
                parentNode.leftNode = removeNode.rightNode;
            }
            else if (parentNode.rightNode == removeNode) {
                
                parentNode.rightNode = removeNode.rightNode;
            }
        }
        
        if (removeNode.leftNode != null && removeNode.rightNode == null) {
            
            if (parentNode == null) {
                
                return removeNode.leftNode;
            }
            else if (parentNode.leftNode == removeNode) {
                
                parentNode.leftNode = removeNode.leftNode;
            }
            else if (parentNode.rightNode == removeNode) {
                
                parentNode.rightNode = removeNode.leftNode;
            }
        }
        
        if (removeNode.leftNode != null && removeNode.rightNode != null) {
            
            Node temp = removeNode.rightNode;
            while (temp.leftNode != null) {
                
                temp = temp.leftNode;
            }
            temp.leftNode = removeNode.leftNode;
            if (parentNode == null) {
                
                removeNode.leftNode.parentNode = temp;
                return removeNode.rightNode;
            }
            else if (parentNode.leftNode == removeNode) {
                
                parentNode.leftNode = removeNode.rightNode;
            }
            else if (parentNode.rightNode == removeNode) {
                
                parentNode.rightNode = removeNode.rightNode;
            }
        }
        
        Node root =removeNode;
        while (root.parentNode != null) {
            
            root = root.parentNode;
        }
        removeNode.parentNode = null;
        return root;
    }
    
    public static Node LDR(Node root) {
        
        if (root.getLeftNode() != null) LDR(root.getLeftNode());
        System.out.print(root.getValue() + ",");
        if (root.getRightNode() != null) LDR(root.getRightNode());
        return root;
    }
}
