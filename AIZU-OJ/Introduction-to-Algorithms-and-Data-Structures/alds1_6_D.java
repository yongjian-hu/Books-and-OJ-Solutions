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
    public static final int N_MAX= 1000;
    public static final int W_MAX = 10000;
    public static int[] A;
    public static int[] B;
    public static int min;
    public static boolean[] Visited;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -----------------------------------
        int n = sc.nextInt();
        A = new int[n];
        B = new int[n];
        int[] pos = new int[W_MAX + 1];
        Visited = new boolean[n];
        Arrays.fill(Visited, false);
        for (int i = 0; i < n; i++) B[i] = A[i] = sc.nextInt();
        Arrays.sort(B);
        min = B[0];
        for (int i = 0; i < n; i++) {
            pos[B[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (Visited[i] == true) continue;
            int cur = i;
            int sum = 0;
            int curMin = W_MAX;
            int num = 0;
            while (true) {
                Visited[cur] = true;
                num++;
                int weight = A[cur];
                curMin = Math.min(weight, curMin);
                sum += weight;
                cur = pos[weight];
                if (Visited[cur]) break;
            }
            ans += Math.min((sum + (num - 2) * curMin), (sum + curMin + (num + 1) * min));
        }
        out.println(ans);
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
