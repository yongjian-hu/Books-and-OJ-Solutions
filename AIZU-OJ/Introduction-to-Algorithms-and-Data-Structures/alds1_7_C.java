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
            int left = sc.nextInt();
            int right = sc.nextInt();
            if (nodes[curId] == null) nodes[curId] = new Node(curId);
            if (left != NIL) {
                if (nodes[left] == null) nodes[left] = new Node(left);
                nodes[curId].left = nodes[left];
                nodes[left].parent = nodes[curId];
            }
            if (right != NIL) {
                if (nodes[right] == null) nodes[right] = new Node(right);
                nodes[curId].right = nodes[right];
                nodes[right].parent = nodes[curId];
            }
        }
        Node root = null;
        for (int i = 0; i < n; i++) if (nodes[i].parent == null) root = nodes[i];
        out.println("Preorder");
        preorder(root);
        out.println();
        out.println("Inorder");
        inorder(root);
        out.println();
        out.println("Postorder");
        postorder(root);
        out.println();


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

    public static void preorder(Node node) {
        out.print(" " + node.id);
        if (node.left != null)
            preorder(node.left);
        if (node.right != null)
            preorder(node.right);
    }
    public static void inorder(Node node) {
        if (node.left != null) inorder(node.left);
        out.print(" " + node.id);
        if (node.right != null) inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        out.print(" " + node.id);
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
