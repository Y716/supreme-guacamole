package HackerrankSolution;

import java.util.*;

class Graph {
    ArrayList<Integer>[] nodes;
    int length;
    Queue<Integer>[] requests;

    Graph(int length) {
        this.length = length;
        nodes = new ArrayList[length];
        requests = new LinkedList[length]; 
        for(int i = 0; i < length;i++) {
            requests[i] = new LinkedList<>();
            nodes[i] = new ArrayList<>();
        }
        
    }

    void requestFollow(int follower, int followed) {
        requests[followed].add(follower);
    }

    void seeRequests(int userId) {
        if(requests[userId].isEmpty()) {
            
            return;
        }
        String s = requests[userId].toString();
        System.out.println(s.substring(1,s.length()-1).replace(", ", " "));
    }

    void acceptFollow(int userId) {
        if(requests[userId].isEmpty()) {
            System.out.println("No requests");
            return;
        }
        int followerId = requests[userId].remove();
        nodes[userId].add(followerId);
    }

    void checkFollowers(int userId) {
        ArrayList<Integer> followers = nodes[userId];
		
        if (followers.size() == 0) {
            System.out.println("No followers");
            return;
        }
        String s = followers.toString();
        System.out.println(s.substring(1,s.length()-1).replace(", ", " "));
    }
}

public class Twitward {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int graphLength = in.nextInt();
        Graph graph = new Graph(graphLength);
        int actions = in.nextInt();
        in.nextLine();
        for (int i = 0; i < actions; i++) {
            String action = in.nextLine();
            String[] actionList = action.split(" ");
            switch (actionList[0]) {
                case "FOLLOW":
                    graph.requestFollow(Integer.parseInt(actionList[1]), Integer.parseInt(actionList[2]));
                    break;
                case "SEEREQUESTS":
                    graph.seeRequests(Integer.parseInt(actionList[1]));
                    break;
                case "ACCEPT":
                    graph.acceptFollow(Integer.parseInt(actionList[1]));
                    break;
                case "FOLLOWERS":
                    graph.checkFollowers(Integer.parseInt(actionList[1]));
                    break;
            }
        }
    }
}