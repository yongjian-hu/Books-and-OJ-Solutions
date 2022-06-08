import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static final int N_MAX = 30;
    public static final int NIL = -1;
    public static Node[] nodes;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -----------------------------------
        int n = sc.nextInt();
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            int curId = sc.nextInt();
            int curLeft = sc.nextInt();
            int curRight = sc.nextInt();
            if (nodes[curId] == null) {
                nodes[curId] = new Node(curId);
            }
            if (curLeft != NIL) {
                if (nodes[curLeft] == null)
                    nodes[curLeft] = new Node(curLeft);
                nodes[curId].left = nodes[curLeft];
                nodes[curLeft].parent = nodes[curId];
            }
            if (curRight != NIL) {
                if (nodes[curRight] == null)
                    nodes[curRight] = new Node(curRight);
                nodes[curId].right = nodes[curRight];
                nodes[curRight].parent = nodes[curId];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nodes[i].parent == null) {
                setDepth(nodes[i], 0);
                setHeight(nodes[i]);
            }
        }

        for (int i = 0; i < n; i++) print(nodes[i]);
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

    public static void print(Node node) {
        int parentId = NIL, sibling = NIL, degree = 0;
        if (node.parent != null) {
            parentId = node.parent.id;
            if (node.parent.left == node && node.parent.right != null) {
                sibling = node.parent.right.id;
            } else if (node.parent.right == node && node.parent.left != null) {
                sibling = node.parent.left.id;
            }
        }
        if (node.left != null) degree++;
        if (node.right != null) degree++;
        out.printf("node %d: parent = %d, sibling = %d, degree = %d, depth = %d, height = %d, ", node.id, parentId, sibling, degree, node.depth, node.height);
        if (parentId == NIL) out.println("root");
        else if (degree == 0) out.println("leaf");
        else out.println("internal node");
    }

    public static void setDepth(Node root, int depth) {
        root.depth = depth;
        if (root.left != null) setDepth(root.left, depth + 1);
        if (root.right != null) setDepth(root.right, depth + 1);
    }

    public static int setHeight(Node node) {
        int h1 = 0,  h2 = 0;
        if (node.right != null)
            h1 = setHeight(node.right) + 1;
        if (node.left != null)
            h2 = setHeight(node.left) + 1;
        node.height = Math.max(h1, h2);
        return Math.max(h1, h2);
    }

    public static class Node {
        Node parent;
        Node left;
        Node right;
        int id;
        int depth;
        int height;
        public Node() {
            left = right = parent = null;
            id = NIL;
            depth = NIL;
            height = NIL;
        }
        public Node(int id) {
            this.id = id;
            depth = NIL;
            height = NIL;
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

