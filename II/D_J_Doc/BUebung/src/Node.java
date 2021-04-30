
/**
 * @author jerem
 */
public class Node implements Comparable<Node> {
    private String name;
    private Node vorgaenger;
    private int abstand;

    
    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getVorgaenger() {
        return vorgaenger;
    }

    public void setVorgaenger(Node vorgaenger) {
        this.vorgaenger = vorgaenger;
    }

    public int getAbstand() {
        return abstand;
    }

    public void setAbstand(int abstand) {
        this.abstand = abstand;
    }
    /**
     * 
     * @return Returns the name of this node
     */
    @Override
    public String toString() {
        return "" + name;
    }
    /**
     * @param o Node that is being compared to
     * @return Returns a value, that helps in the node sorting process later on
     */
    @Override
    public int compareTo(Node o) {
       if(this.getAbstand() > o.getAbstand()){
           return 1;
       }else if(this.getAbstand() < o.getAbstand()){
           return -1;
       }else{
           return 0;
       }
    }
    
    
}
