import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by ASUS UX360CA on 6/10/2018.
 */
public class InputReader {

    String fileName;

    public InputReader() {
        Scanner sc = new Scanner(System.in);
        fileName = new String();

        System.out.println("enter file name");
        fileName = sc.next();
    }

    Vector<Node> getGraph() {
        Vector<Node> nodes = new Vector<Node>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int pv1, v1, v2;
            line = br.readLine();
            String[] l = line.split(" ");
            v1 = Integer.parseInt(l[0]) - 1;
            v2 = Integer.parseInt(l[1]) - 1;
            nodes.add(new Node());
            nodes.lastElement().neighbours.add(v2);
            pv1 = v1;
            while ((line = br.readLine()) != null) {
                l = line.split(" ");
                v1 = Integer.parseInt(l[0]) - 1;
                v2 = Integer.parseInt(l[1]) - 1;
                if (v1>=nodes.size()){
//                    System.out.println("new nodeeeee!");
                    nodes.add(new Node());
                }
                nodes.get(v1).neighbours.add(v2);
            }
            for (int i = 0; i < nodes.size(); i++) {
                nodes.get(i).setDegree();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return nodes;
    }
}
