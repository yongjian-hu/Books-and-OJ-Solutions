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
        int q = sc.nextInt();
        int elaps = 0;
        MyQueue queue = new MyQueue();
        for (int i = 0; i < n; i++) {
            String[] l = sc.nextLine().split(" ");
            queue.enque(new MyProcess(l[0], Integer.parseInt(l[1])));
        }

        while (!queue.isEmpty()) {
            MyProcess p = queue.deque();
            int t = Math.min(p.time, q);
            p.time = p.time - t;
            elaps += t;
            if (p.time > 0) queue.enque(p);
            else {
                out.println(p.name + " " + elaps);
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

    public static class MyProcess {
        public String name;
        public int time;
        
        public MyProcess(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    public static class MyQueue {
        int head, tail;
        int max = 100005;
        MyProcess[] Q;
        public MyQueue() {
            Q = new MyProcess[max];
            head = 0;
            tail = 0;
        }

        public void enque(MyProcess p) {
            int tmp = (tail + 1) % max;
            if (isFull()) System.exit(1);
            Q[tail] = p;
            tail = tmp;
        }

        public MyProcess deque () {
            if (isEmpty()) System.exit(1);
            MyProcess p = Q[head];
            head = (head + 1) % max;
            return p;
        }

        public boolean isEmpty() {return head == tail;}
        public boolean isFull() {return head == (tail + 1) % max;}
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
