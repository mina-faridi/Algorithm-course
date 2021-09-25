import java.util.Vector;

/**
 * Created by ASUS UX360CA on 6/10/2018.
 */
public class Node implements Runnable {

    boolean isMax; // has max random number among it's neighbours
    int color;
    int random;
    int degree;
    Graph graph;
    int min;
    //random number which is given to each node
    //this thread is used to check neighbours
    // of each node to know if has the largest
    // number and if so, it gets colored
    Vector<Integer> neighbours;

    public Node() {
        isMax = true;
        neighbours = new Vector<>();
        color = 0;
        min = 0;
    }

    void setDegree() {
        degree = neighbours.size();
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void run() {

        isMax = true;
        if (color == 0) {
            for (int i = 0; i < degree; i++) {
                Node node = graph.nodes.get(neighbours.get(i));
                if (node.color == 0 && node.random > random)
                    isMax = false;
            }
            if (isMax){
//                System.out.println(random + "is max");
                int min = 0; //min number which != color of neighbours
                boolean minFound = true;
                while (minFound){
                    min++;
                    minFound = false;
//                    System.out.println(random + " is degree " + degree);
                    for (int i = 0; i < degree; i++) {
                        Node node = graph.nodes.get(neighbours.get(i));
//                        System.out.println("checkkin" + random + "with" + node.random);
                        if (node.color == min) {
//                            System.out.println("hi"+ random + "with" + node.random);
                            minFound = true;
                        }
//                        System.out.println(random + " minfound :" + minFound + "min: "+ min);
                    }
                }
//                System.out.println(random + " min is "+ min);
                this.min = min;
                graph.incNumOfCol();
            }

        }
//        System.out.println("random " + random + " is gonno inc");
        graph.incNumOfThr();
    }
}
