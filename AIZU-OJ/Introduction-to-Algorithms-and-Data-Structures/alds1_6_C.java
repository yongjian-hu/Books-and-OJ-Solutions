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
    public static final int Infinity = Integer.MAX_VALUE;
    public static Card[] A;
    public static Card[] B;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -----------------------------------
        int n = sc.nextInt();
        A = new Card[n];
        B = new Card[n];
        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            int j = sc.nextInt();
            A[i] = new Card(c, j);
            B[i] = new Card(c, j);
        }
        quickSort(A, 0, n - 1);
        mergeSort(B, 0, n);
        int stable = 1;
        for (int i = 0; i < n; i++) {
            if (A[i].c != B[i].c || A[i].n != B[i].n) {
                stable = 0;
                break;
            }
        }
        if (stable == 1) out.println("Stable");
        else out.println("Not stable");
        for (int i = 0; i < n; i++) {
            out.print(A[i].c + " " + A[i].n);
            out.println();
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

    public static class Card {
        public char c;
        public int n;
        public Card(char c, int n) {
            this.c = c;
            this.n = n;
        }
    }

    public static int partition(Card[] A, int p, int r) {
        int x = A[r].n;
        int i = p - 1, j;
        for (j = p; j < r; j++) {
            if (A[j].n <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i+1, j);
        return i+1;
    }

    public static void quickSort(Card[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static void swap(Card[] A, int i, int j) {
        Card tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void merge(Card[] B, int left, int mid, int right) {
        int n1 = mid - left;
        int n2 = right - mid;
        Card[] L = new Card[n1 + 1];
        Card[] R = new Card[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = B[left + i];
        }
        L[n1] = new Card('A', Infinity);
        for (int i = 0; i < n2; i++) {
            R[i] = B[mid + i];
        }
        R[n2] = new Card('A', Infinity);

        int i = 0, j = 0;
        for (int k = left; k < right; k++) {
            if (L[i].n <= R[j].n) B[k] = L[i++];
            else B[k] = R[j++];
        }
    }

    public static void mergeSort(Card[] B, int left, int right) {
        if (left + 1 < right) {
            int mid = (left + right) / 2;
            mergeSort(B, left, mid);
            mergeSort(B, mid, right);
            merge(B, left, mid, right);
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
