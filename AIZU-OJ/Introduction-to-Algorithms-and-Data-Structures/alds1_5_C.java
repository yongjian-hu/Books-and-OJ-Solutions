import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static final int BIG_NUM = 2000000000;
	public static final int MOD = 1000000007;
	public static final long HUGE_NUM = 99999999999999999L;
	public static final double EPS = 0.000000001;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -----------------------------------
        int n = sc.nextInt();

        out.printf("%.8f %.8f\n", 0.0, 0.0);
        Koch(n, 0.0, 0.0, 100.0, 0.0);
        out.printf("%.8f %.8f\n", 100.0, 0.0);
        /*
         * int n = sc.nextInt(); // read input as integer
         * long k = sc.nextLong(); // read input as long
         * double d = sc.nextDouble(); // read input as double
         * String str = sc.next(); // read input as String
         * String s = sc.nextLine(); // read whole line as String
         * 
         * int result = 3*n;
         * out.println(result); // print via PrintWriter
         */

        // Stop writing your solution here. ------------------------------------
        out.close();
    }

    public static void Koch(int d, double p1x, double p1y, double p2x, double p2y) {
        if (d == 0) return;

        double sx, sy, ux, uy, tx, ty;
        sx = p1x + (p2x - p1x) / 3.0;
        sy = p1y + (p2y - p1y) / 3.0;
        tx = p2x - (p2x - p1x) / 3.0;
        ty = p2y - (p2y - p1y) / 3.0;
        ux = (tx - sx) * 0.5 - Math.sqrt(3) / 2.0 * (ty - sy) + sx;
        uy = Math.sqrt(3) / 2.0 * (tx - sx) + (ty - sy) * 0.5 + sy;

        Koch(d - 1, p1x, p1y, sx, sy);
        out.printf("%.8f %.8f\n", sx, sy);
        Koch(d - 1, sx, sy, ux, uy);
        out.printf("%.8f %.8f\n", ux, uy);
        Koch(d - 1, ux, uy, tx, ty);
        out.printf("%.8f %.8f\n", tx, ty);
        Koch(d - 1, tx, ty, p2x, p2y);
    }

    // -----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    // -----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    // --------------------------------------------------------
}
