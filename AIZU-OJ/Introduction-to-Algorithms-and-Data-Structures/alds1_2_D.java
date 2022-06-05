import java.io.*;
import java.util.*;

class Main {
    public static int cnt = 0;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> G = new ArrayList<>();
        for (int i = 1; ;) {
            if (i > n) break;
            G.add(i);
            i = i*3 + 1;            
        }
        out.println(G.size());
        for (int i = G.size() - 1;i >= 0; i--) {
            out.print(G.get(i));
            if (i > 0) out.print(" ");
        }
        out.println();
        for ( int i = G.size() - 1; i >= 0; i--) {
            insertion(arr, n, G.get(i));
        }
        out.println(cnt);
        for (int i = 0; i < n; i++) out.println(arr[i]);
        // Start writing your solution here. -------------------------------------

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

        // Stop writing your solution here. -------------------------------------
        out.close();
    }

    static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int k;
        for (k = 0; k < arr.length - 1; k++) {
            sb.append(arr[k] + " ");
        }
        sb.append(arr[k]);
        out.println(sb.toString());
    }

    static void insertion(int[] arr, int n, int g) {
        for (int i = g; i < n; i++) {
            int key = arr[i];
            int j;
            for (j = i - g; j >= 0 && arr[j] > key; j -= g) {
                arr[j + g] = arr[j];
                cnt++;
            }
            arr[j + g] = key;
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
