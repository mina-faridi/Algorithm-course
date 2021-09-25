import java.util.Vector;

/**
 * Created by ASUS UX360CA on 6/10/2018.
 */
public class Graph {
    Vector<Node> nodes;
    private int numOfCol; //number of colored nodes.
    private int n; //number of nodes
    private int numOfCurThr; //this shows number of threads which have finished their job

    public Graph() {
        nodes = (new InputReader()).getGraph();
        n = nodes.size();
        numOfCol = 0;
        for (int i = 0; i < n; i++) {
            nodes.get(i).setGraph(this);
        }
    }
    void incNumOfCol(){
        numOfCol++;
    }
    public void color() {
//        Thread.currentThread().setPriority(5);

        setRndm();
        while (numOfCol < n){
//            System.out.println("nom of col is " + numOfCol);
            numOfCurThr = 0;
            for (int i = 0; i < n; i++) {
                    new Thread(nodes.get(i)).start();

            }
                while (numOfCurThr < n) {
//                    System.out.println(numOfCurThr + "is num 0f curt");
            }
            for (int i = 0; i < n; i++) {
                nodes.get(i).color = nodes.get(i).min;
            }
        }
    }
    public void incNumOfThr(){
        synchronized (this) {
            numOfCurThr++;
        }
    }

    private void setRndm() { //this function set random numbers for each node
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            int rnd = (int) (Math.random() * n);
            while (b[rnd] == true) {
                rnd = (int) (Math.random() * n);
            }
            nodes.get(i).random = rnd;
            b[rnd] = true;
        }
    }
}
