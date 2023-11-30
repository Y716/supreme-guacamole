package Tree;

class Node {
    int data;
    Node lc;
    Node rc;

    public Node(int data){
        this.data = data;
    }
}

public class BST {
    Node root;
    public void add(Node nodeBaru){
        if(root == null){
            root = nodeBaru;
        }
        else{
            Node temp = root;
            Node parent = root;
            int penanda = 0;
            while(temp != null){
                parent = temp;
                if(nodeBaru.data <= temp.data){
                    temp = temp.lc;
                    penanda = 0;
                }
                else if(nodeBaru.data > temp.data){
                    temp = temp.rc;
                    penanda = 1;
                }
            }
            if(penanda == 0){
                parent.lc = nodeBaru;
            }else if(penanda == 1){
                parent.rc = nodeBaru;
            }
        }
    }

    public void inorder(Node root){
        if(root != null){
            inorder(root.lc);
            System.out.print(root.data + " ");
            inorder(root.rc);
        }
    }

    public void search(Node root, int key){
        int lvl = 0;
        Node temp = root;
        while(temp != null){
            lvl ++;
            if(key == temp.data){
                System.out.println("angka " + key + " ketemu di level " + lvl);
                break;
            }else if(key < temp.data){
                temp = temp.lc;
            }else if(key > temp.data){
                temp = temp.rc;
            }
            if(temp == null){
                System.out.println("tidak ditemukan");
            }
        }

    }
}
