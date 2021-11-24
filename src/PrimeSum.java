import parcs.*;

public class PrimeSum implements AM {
    private static final int NODES = 4;

    private boolean isPrime(int x) {
        if (x == 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public void run(AMInfo info) {
        Node n = (Node) info.parent.readObject();
        System.out.println("[" + n.l + " " + n.r + "] Build started.");

        long sum = 0L;
        int start = n.l;
        while (start % NODES != n.div) start++;
        for (int i = start; i <= n.r; i += NODES) {
            if (isPrime(i)) sum += i;
        }
        System.out.println("[" + n.l + " " + n.r + "] Build finished.");
        info.parent.write(sum);
    }
}