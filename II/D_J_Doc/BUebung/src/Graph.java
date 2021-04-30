
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author jerem
 */
public class Graph {
    private LinkedList<Node> nodes;
    private HashMap<String, Integer> kanten;

    public Graph() {
        nodes = new LinkedList<>();
        kanten = new HashMap<>();
    }

    /**
     * 
     * @param x Node which is added from outside and should be added to the list
     */
    public void add(Node x) {
        nodes.add(x);

    }
    /**
     * 
     * @param x One of the Two nodes between which is a connection
     * @param y One of the Two nodes between which is a connection
     * @param z the length of the connection
     */
    public void addEdge(Node x, Node y, int z) {
        kanten.put("" + x + "/" + y, z);
        kanten.put("" + y + "/" + x, z);
    }
    /**
     * This method alters all nodes and prepares them, when a different node is set to be the new starting pint
     * @param x this parameter describes the node which is set as the starting point
     */
    public void initDijkstra(Node x) {
        for (Node n : nodes) {
            if (x.equals(n)) {
                n.setAbstand(0);
                n.setVorgaenger(null);
            } else {
                n.setAbstand(Integer.MAX_VALUE);
                n.setVorgaenger(null);
            }
        }

    }
    /**
     * This method sorts out the shortest ways between the nodes and sets the nodes predecesspr and gap values
     * @param x the parameter describes the starting point node
     */
    public void disjkstra(Node x) {
        initDijkstra(x);
        LinkedList<Node> temp = new LinkedList<>(nodes);
        if (!nodes.isEmpty()) {
            while (temp.size() > 0) {
                Collections.sort(temp);
                Node n = temp.get(0);
                temp.remove(n);
                relaxation(n);
            }
        }
    }
    /**
     * Figures out the shortest way between the nodes and sets its predecessors after the outcome
     * @param x Describes the starting point, which is given to this method form the disjkstra method
     */
    private void relaxation(Node x) {
        for (Node k : nodes) {
            if (!k.equals(x)) {
                if (kanten.get("" + x + "/" + k) + x.getAbstand() < k.getAbstand()) {
                    k.setAbstand(x.getAbstand() + kanten.get("" + x + "/" + k));
                    k.setVorgaenger(x);
                }
            }
        }
    }
    /**
     * This method figures out the shortest path to a targeted node
     * @param x This parameter represents the targeted node
     * @return Returns the shortest way to the targeted node
     */
    public LinkedList<Node> getPath(Node x) {
        LinkedList<Node> puh = new LinkedList<>();
        Node current = x;
        puh.add(x);
        while (current.getVorgaenger() != null) {
            current = current.getVorgaenger();
            puh.add(current);
        }
        return puh;
    }
}
