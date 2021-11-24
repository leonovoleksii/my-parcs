import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static boolean isPrime(int x) {
        if (x == 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("../out/input"));
        int l = sc.nextInt();
        System.out.println(l);
        int r = sc.nextInt();
        System.out.println(r);
        Node n = new Node(l, r, 0);
        System.out.println("[" + n.l + " " + n.r + "] Build started.");

        long sum = 0L;
        long time = System.currentTimeMillis();
        for (int i = n.l; i <= n.r; i++) {
            if (isPrime(i)) sum+=i;
        }
        System.out.println("[" + sum + "] Build finished. Execution time: " + (System.currentTimeMillis() - time)/1000.0 + "s");
    }
}