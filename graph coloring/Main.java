/**
 * Created by ASUS UX360CA on 6/11/2018.
 */
public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        final long startTime = System.nanoTime();
        g.color();
        final long duration = System.nanoTime() - startTime;
        (new GPrinter()).print(g);
        System.out.println(duration);
    }
}
