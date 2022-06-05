import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static int n; // num of packages
    public static int k; // num of trucks
    public static int[] arr; // package's weights
    
    public static void main(String[] args) {    
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        n = sc.nextInt();
        k = sc.nextInt();
        long sum = 0;
        arr = new int[n];
        for (int i = 0; i < n; i++) { arr[i] = sc.nextInt(); sum += arr[i]; }

        long left = 0, right = sum, mid = (left + right) / 2;
        long ans = right;
        while (left < right) {
            if (check(mid)) {
                right = mid;       
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        ans = right;
        out.println(ans);
        // Start writing your solution here. -----------------------------------

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

    public static boolean check (long p) {
        int i = 0;
        for (int j = 0; j < k; j++) {
            long s = 0;
            while (s + arr[i] <= p) {
                s += arr[i];
                i++;
                if (i == n) return true;
            }
        }
        if (i == n) return true;
        else return false;
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
