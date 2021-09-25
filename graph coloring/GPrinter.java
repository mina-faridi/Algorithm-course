import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by ASUS UX360CA on 6/11/2018.
 */
public class GPrinter {

    void print(Graph g) {
        try {
            Vector<Node> nodes = g.nodes;
            int n = nodes.size();
            int max = 0;
            int temp;
//            System.out.println(n);
            BufferedWriter bw = new BufferedWriter(new FileWriter("colored"));
            for (int i = 0; i < n; i++) {
                int size = nodes.get(i).neighbours.size();
                temp = nodes.get(i).color;
                if (temp > max)
                    max = temp;
                for (int j = 0; j < size; j++) {
                    boolean b = nodes.get(i).color == nodes.get(nodes.get(i).neighbours.get(j)).color;
                    if (b == true)
                        System.out.println(i +1 + " " + nodes.get(i).neighbours.get(j)+1+ "hello");
                }
                bw.append(i + 1 + " " + String.valueOf(nodes.get(i).color)+'\n');
                bw.flush();
            }
            System.out.println("number of color is "+ max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
