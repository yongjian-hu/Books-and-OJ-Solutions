import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static final int N_MAX = 45;
    public static final int NIL = -1;
    public static Node[] nodes;
    public static int[] preorder;
    public static int[] inorder;
    public static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -----------------------------------
        int n = sc.nextInt();
        preorder = new int[n];
        inorder = new int[n];
        for (int i = 0; i < n; i++) preorder[i] = sc.nextInt();
        for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
        Node root = reconstruct(0, n, 0, n);
        postorder(root);
        sb.deleteCharAt(0);
        out.println(sb.toString());
        /*
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

    public static Node reconstruct(int preorder_i, int preorder_j, int inorder_i, int inorder_j) {
        Node root;
        if (preorder_i >= preorder_j) return null;
        root = new Node(preorder[preorder_i]);
        if (preorder_i + 1 == preorder_j) return root;
        int inorderRootPos = NIL;
        for (int i = inorder_i; i < inorder_j; i++) {
            if (inorder[i] == root.id) {
                inorderRootPos = i;
            }
        }
        int leftLength = inorderRootPos - inorder_i;
        root.left = reconstruct(preorder_i + 1, preorder_i + 1 + leftLength, inorder_i, inorderRootPos);
        root.right = reconstruct(preorder_i + 1 + leftLength, preorder_j, inorderRootPos + 1, inorder_j);
        return root;
    }

    public static void postorder(Node node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        sb.append(" " + node.id);
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
