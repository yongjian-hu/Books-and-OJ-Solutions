import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        Card[] arr = new Card[n];
        Card[] selection;

        for (int i = 0; i < n; i++) {
            arr[i] = new Card();
            String s = sc.next();
            arr[i].suit = s.charAt(0);
            arr[i].value = s.charAt(1) - '0'; 
            // out.println(arr[i].suit);
            // out.println(arr[i].value);
        }
        selection = arr.clone();

        // Start writing your solution here. -----------------------------------

        // bubble
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i + 1; j--) {
                if (arr[j].value < arr[j-1].value) swap(arr, j , j -1);
            }
        }
        print(arr);
        out.println("Stable");

        // selection
        for (int i = 0; i < n; i++) {
            int minj = i;
            int j;
            for (j = i; j < n; j++) {
                if (selection[j].value < selection[minj].value) {
                    minj = j;
                }
            }
            swap(selection, minj, i);
        }
        print(selection);

        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].value != selection[i].value || arr[i].suit != selection[i].suit) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) out.println("Not stable");
        else out.println("Stable");
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

    public static class Card {
        public int value;
        public char suit;
    }

    static void swap(Card[] arr, int i, int j) {
        Card tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void print(Card[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            out.print(arr[i].suit);
            out.print(arr[i].value);
            if (i < n - 1) out.print(" ");
        }
        out.println();
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
