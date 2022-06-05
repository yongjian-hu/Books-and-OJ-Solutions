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
        MyList list = new MyList();
        for (int i = 0; i < n; i++) {
            String[] l = sc.nextLine().split(" ");
            switch (l[0]) {
                case "insert":
                    list.insert(Integer.parseInt(l[1]));
                    break;
                case "delete":
                    list.delete(Integer.parseInt(l[1]));
                    break;
                case "deleteFirst":
                    list.deleteFirst();
                    break;
                case "deleteLast":
                    list.deleteLast();
                    break;
            }
        }
        list.printList();
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

    public static class Node {
        int val;
        Node prev, next;
        public Node(int n) {
            this.val = n;
            this.prev = null;
            this.next = null;
        }
    }

    public static class MyList {
        Node head = null, tail = null;

        public MyList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public void insert(int x) {
            Node tmp = new Node(x);
            tmp.next = head.next;
            head.next.prev = tmp;
            head.next = tmp;
            tmp.prev = head;   
        }

        public Node search(int x) {
            Node tmp = head.next;
            while (tmp != tail && tmp.val != x) tmp = tmp.next;
            return tmp;
        }

        public void delete(int x) {
            Node node = search(x);
            if (node == tail) return;
            node.prev.next = node.next;    
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        public void deleteFirst() {
            if (head.next == tail) return;
            Node del = head.next;
            head.next = del.next;
            del.next.prev = head;
            del.next = null;
            del.prev = null;
        }

        public void deleteLast() {
            Node del = tail.prev;
            if (del == head) return;
            tail.prev = del.prev;
            del.prev.next = tail;
            del.next = null;
            del.prev = null;
        }

        public void printList() {
            Node tmp = head.next;
            if (tmp == tail) out.println();
            StringBuilder sb = new StringBuilder();
            while (tmp != tail && tmp.next != tail) {
                sb.append(tmp.val).append(" ");
                tmp = tmp.next;
            }
            sb.append(tmp.val);
            out.println(sb.toString());
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
