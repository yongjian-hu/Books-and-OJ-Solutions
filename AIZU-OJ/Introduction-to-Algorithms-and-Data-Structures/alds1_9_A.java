import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static Node[] nodes;
    public static int n;
    public static final int NIL = -1;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -----------------------------------
        n = sc.nextInt();
        nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(sc.nextInt());
        
        for (int i = 0; i < n; i++) {
            if ((i+1)*2 - 1 < n) {
                nodes[i].left = nodes[(i+1)*2 - 1];
                nodes[(i+1)*2-1].parent = nodes[i];
            }
            if ((i+1)*2 < n) {
                nodes[i].right = nodes[(i+1)*2];
                nodes[(i+1)*2].parent = nodes[i];
            }
        }

        print();
        
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

    public static void print() {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                out.printf("node %d: key = %d, ", i+1, nodes[i].id);
                if (nodes[i].left != null) out.printf("left key = %d, ", nodes[i].left.id);
                if (nodes[i].right != null) out.printf("right key = %d, ", nodes[i].right.id);
                out.println();
            } else {
                out.printf("node %d: key = %d, ", i+1, nodes[i].id);
                if (nodes[i].parent != null) {
                    out.printf("parent key = %d, ", nodes[i].parent.id);
                }
                if (nodes[i].left != null) {
                    out.printf("left key = %d, ", nodes[i].left.id);
                }
                if (nodes[i].right != null) {
                    out.printf("right key = %d, ", nodes[i].right.id);
                }
                out.println();
            }
        }
    }

    public static class Node {
        Node parent;
        Node left;
        Node right;
        int id;
        public Node() {
            left = right = parent = null;
            id = NIL;
        }
        public Node(int id) {
            this.id = id;
            left = right = parent = null;
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
