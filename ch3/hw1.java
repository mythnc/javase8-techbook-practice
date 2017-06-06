public class hw1 {

    public static int gcd(int a, int b) {
        if (a < b) {
            int temp = b;
            b = a;
            a = temp;
        }
        while (a % b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return b;
    }

    public static void main (String[] args) {
        int m = 1000;
        int n = 495;

        System.out.println(gcd(m, n));
    }
}
