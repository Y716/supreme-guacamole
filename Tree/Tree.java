package Tree;

import java.util.List;
import java.util.LinkedList;

class Node<T> {
    T data;
    List<Node> children;

    Node(T data) {
        this.data = data;
        children = new LinkedList<>();
    }
}

public class Tree<T> {
    Node<T> root;

    Tree(Node<T> root){
        this.root = root;
    }
    
    Tree(T data){
        root = new Node<T>(data);
    }
}
