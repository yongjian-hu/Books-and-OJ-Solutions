import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static int n;
    public static int[] A;
    public static final int MAX_SIZE = 2000000;
    public static final int Inf = Integer.MAX_VALUE;
    public static final int minusInf = Integer.MIN_VALUE;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -----------------------------------
        n = 0;
        A = new int[MAX_SIZE];
        boolean flag = true;
        while(flag) {
            String[] input = sc.nextLine().split(" ");
            switch(input[0]) {
                case "insert":
                    insert(Integer.parseInt(input[1]));
                    break;
                case "extract":
                    out.println(extract());
                    break;
                case "end":
                    flag = false;
                    break;
            }
        }
        
        // Stop writing your solution here. ------------------------------------
        out.close();
    }

    public static int left(int i) { return i * 2; }
    public static int right(int i) { return i * 2 + 1; }
    public static int parent(int i) { return i / 2; }

    public static void insert(int key) {
        n++;
        A[n] = minusInf;
        heapIncreaseKey(n, key);
    }

    public static void heapIncreaseKey(int i, int key) {
        if (key < A[i]) { out.println("error"); System.exit(1); }
        A[i] = key;
        while (i > 1 && A[parent(i)] < A[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public static int extract() {
        // for (int i = 1 ; i <= n; i++) out.print(A[i] + " ");
        int max = A[1];
        A[1] = A[n--];
        maxHeapify(1);
        return max;
    }

    public static void maxHeapify(int i) {
        int l, r, largest;
        l = left(i);
        r = right(i);
        largest = i;
        if (l <= n && A[i] < A[l]) largest = l;
        if (r <= n && A[r] > A[largest]) largest = r;
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }
    public static void swap(int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
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
