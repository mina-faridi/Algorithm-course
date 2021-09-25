import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ASUS UX360CA on 7/5/2018.
 */
public class GraphMaker
{
    int numOfNode;

    Graph graph;

    public GraphMaker(int numOfNode) {
        this.numOfNode = numOfNode;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("graph"+numOfNode));
            for (int i = 1; i <= numOfNode; i++) {
                for (int j = 1; j < i; j+=4) {
                    bw.append(i + " " + j+'\n');
                    bw.flush();
                }
                for (int j = i + 1; j <= numOfNode; j+=4) {
                    bw.append(i  + " " + j +'\n');
                    bw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GraphMaker(10);
        System.out.println("10");
        new GraphMaker(100);
        System.out.println("10");

        new GraphMaker(1000);
        System.out.println("10");
    }
}
