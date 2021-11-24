import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import parcs.*;

public class Bluck {
    private final static int NODES = 4;

    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("PrimeSum.jar");
        ArrayList<Node> nodes = fromFile(curtask.findFile("input"));
        long x = 0;
        AMInfo info = new AMInfo(curtask, null);
        LinkedList<channel> channels = new LinkedList<>();
        for(Node n: nodes) {
            point p = info.createPoint();
            channel c = p.createChannel();
            p.execute("PrimeSum");
            c.write(n);
            channels.add(c);
        }
        System.out.println("Waiting for result...");
        for (var c : channels) {
            x += c.readLong();
        }
        System.out.println("Result: " + x);
        curtask.end();
    }

    private static ArrayList<Node> fromFile(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));
        System.out.println("created scanner");
        int l = sc.nextInt();
        System.out.println(l);
        int r = sc.nextInt();
        System.out.println(r);
        ArrayList<Node> res = new ArrayList<>();
        for (int i = 0; i < NODES; i++) {
            res.add(new Node(l, r, 2 * i + 1));
        }
        return res;
    }
}