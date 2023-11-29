package Tree;


public class MainBT {
    public static void main(String[] args) {
        
    }
}

class NodeBT{
    int data;
    NodeBT left;
    NodeBT right;

    public NodeBT(int data){
        this.data = data;
        left = right = null;
    }
}

class BT{
    NodeBT root;

    public void add(int data){
        if(root == null){
            root = new NodeBT(data);
            return;
        }
        NodeBT temp = root;
        NodeBT parent = root;
        int penanda = 0;
        while(temp != null){
            parent = temp;
            if(temp.left == null){
                penanda = 0;
                break;
            }
            if (temp.right == null){
                penanda = 1;
                break;
            }
        }
        if(penanda == 0){
            parent.left = new NodeBT(data);
        }else if(penanda == 1){
            parent.right = new NodeBT(data);
        }
    }
}

