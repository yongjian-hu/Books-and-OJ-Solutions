import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        String[] list = sc.nextLine().split(" ");
        MyStack stk = new MyStack();

        for (String s : list) {
            int a, b;
            char c = s.charAt(0);
            if (c == '+') {
                a = stk.pop();
                b = stk.pop();
                stk.push(a+b);
            } else if (c == '-') {
                a = stk.pop();
                b = stk.pop();
                stk.push(b - a);
            } else if (c == '*') {
                a = stk.pop();
                b = stk.pop();
                stk.push(a * b);
            } else {
                stk.push(Integer.parseInt(s));
            }
        }
        
        out.println(stk.pop());

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

    public static class MyStack {
        int max;
        int top;
        int[] a;
        public MyStack() {
            max = 1000;
            top = 0;
            a = new int[max];
        }

        boolean isFull() {return top >= (max - 1);}
        boolean isEmpty() {return top == 0;};

        void push(int x) {
            if (isFull()) {
                out.println("Stack is full.");
                System.exit(1);
            }
            top++;
            a[top] = x;
        }

        int top() {return a[top];}

        int pop() {
            if (isEmpty()) {
                out.println("Stack is empty.");
                System.exit(1);   
            }
            top--;
            return a[top+1];
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
