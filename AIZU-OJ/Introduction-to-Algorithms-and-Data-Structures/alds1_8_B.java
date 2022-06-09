import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static final int NIL = -1; 
    public static Node root;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -----------------------------------
        int n = sc.nextInt();
        root = null;
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "insert":
                    insert(new Node(Integer.parseInt(input[1])));
                    break;
                case "find":
                    if (find(Integer.parseInt(input[1]))) out.println("yes");
                    else out.println("no");
                    break;
                case "print":
                    print(root);
                    break;
            }
        }

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

    public static boolean find (int target) {
        Node node = root;
        while (node != null) {
            if (node.id == target) return true;
            else if (node.id > target) node = node.left;
            else node = node.right;
        }
        return false;
    }


    public static void print(Node node) {
        sb.setLength(0);
        inorder(node);
        // sb.deleteCharAt(0);
        out.println(sb.toString());
        sb.setLength(0);
        preorder(node);
        // sb.deleteCharAt(0);
        out.println(sb.toString());
    }

    public static void preorder(Node node) {
        sb.append(" " + node.id);
        if (node.left != null)
            preorder(node.left);
        if (node.right != null)
            preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node.left != null)
            inorder(node.left);
        sb.append(" " + node.id);
        if (node.right != null)
            inorder(node.right);
    }

    public static void insert(Node node) {
        Node y = null, x = root;
        while (x != null) {
            y = x;
            if (x.id > node.id) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == null) root = node;
        else if (node.id < y.id) {
            y.left = node;
        } else {
            y.right = node;
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
