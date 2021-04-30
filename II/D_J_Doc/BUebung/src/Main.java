
import java.util.LinkedList;
/**
 * @author jerem
 * @version 1.0
 */
public class Main {
    public static void main(String[] args){
        Graph g = new Graph();
        Node s = new Node("Start");
        Node n2 = new Node("Node2");
        Node n3 = new Node("Node3");
        Node n4 = new Node("Node4");
        
        g.add(s);
        g.add(n2);
        g.add(n3);
        g.add(n4);
        g.addEdge(s, n2, 100);
        g.addEdge(s, n3, 50);
        g.addEdge(s, n4, 500);
        g.addEdge(n2, n4, 100);
        g.addEdge(n3, n4, 20);
        g.addEdge(n2, n3, 10);
        
        g.disjkstra(s);
        LinkedList<Node> temp = g.getPath(n2);
        
        for(Node n : temp){
            System.out.println("" + n);
        }
    }
}
