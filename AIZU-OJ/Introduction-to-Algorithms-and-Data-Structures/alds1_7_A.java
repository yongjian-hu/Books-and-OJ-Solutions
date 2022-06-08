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
    public static final int N_MAX = 100001;
    public static final int NIL = -1;
    public static Node[] Nodes;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -----------------------------------
        int n = sc.nextInt();
        Nodes = new Node[n];
        Node root = null;

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int degree = sc.nextInt();

            if (Nodes[id] == null) {
                Nodes[id] = new Node(id);
            }

            int child_id;
            int left_id = NIL;
            for (int j = 0; j < degree; j++) {
                child_id = sc.nextInt();
                if (Nodes[child_id] == null) {
                    Nodes[child_id] = new Node(child_id);
                }
                if (j == 0) Nodes[id].left = Nodes[child_id];
                else Nodes[left_id].right = Nodes[child_id];
                left_id = child_id;
                Nodes[child_id].parent = Nodes[id];
            }
        }
        for (int i = 0; i < n; i++) if (Nodes[i].parent == null) root = Nodes[i];
        setDepth(root, 0);
        for (int i = 0; i < n; i++) printTree(Nodes[i]);
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

    public static void printTree(Node node) {
        int parentId = NIL;
        if (node.parent != null) parentId = node.parent.id;
        
        out.printf("node %d: parent = %d, depth = %d, ", node.id, parentId, node.depth);
        if (parentId == NIL) out.printf("root, ");
        else if (node.left == null) out.printf("leaf, ");
        else out.printf("internal node, ");

        out.print("[");
        int i = 0;
        Node child = node.left;
        while(child != null) {
            if (i > 0) out.print(", ");
            out.print(child.id);
            child = child.right;
            i++;
        }
        out.println("]");
    }

    public static void setDepth(Node root, int depth) {
        root.depth = depth;
        Node node = root.right;
        while (node != null) {
            node.depth = depth;
            if (node.left != null) setDepth(node.left, depth + 1);
            node = node.right;
        }
        if (root.left != null) setDepth(root.left, depth + 1);
    }

    public static class Node {
        Node parent;
        Node left;
        Node right;
        int id;
        int depth;
        public Node() {
            left = right = parent = null;
            id = NIL;
            depth = NIL;
        }
        public Node(int id) {
            this.id = id;
            depth = NIL;
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
