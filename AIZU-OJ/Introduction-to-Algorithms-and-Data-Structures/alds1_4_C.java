import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        MyDict dict = new MyDict();
        for (int i = 0; i < n; i++) {
            String[] in = sc.nextLine().split(" ");
            switch(in[0]) {
                case "insert":
                    dict.insert(in[1]);
                    break;
                case "find":
                    if (dict.find(in[1]) == 1) out.println("yes");
                    else out.println("no");
                    break;
            }
        }
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

    public static int getChar (char c) {
        switch(c) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
        }
        return -1;
    }

    public static int getKey(String s) {
        int sum = 0;
        int p = 2;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            sum += p * getChar(s.charAt(i));
            p *= 2;
        }
        return sum;
    }

    public static class MyDict {
        int M = 100000000;
        int h1 (int key) { return key % M; }
        int h2 (int key) { return 1 + (key % (M - 1)); }
        String[] H;
        public MyDict() {
            H = new String[M];
            Arrays.fill(H, null);
        }

        public void insert(String s) {
            int key, i, h;
            key = getKey(s);
            i = 0;
            while (true) {
                h = h1(key) + i * h2(key);
                if (H[h] == null) {
                    H[h] = s;
                    break;
                } else {
                    i++;
                }
            }
        }

        public int find(String s) {
            int key, i, h;
            key = getKey(s);
            i = 0;
            while (true) {
                h = h1(key) + i * h2(key);
                if (H[h] == null) return 0;
                else if (H[h].equals(s)) return 1;
                i++;
            }
        }
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
