import java.io.*;
import java.util.*;

/* Use fast reading input class provided by Flatfoot on Codeforces 
 * - https://codeforces.com/blog/entry/7018
 */
class Main {
    public static int n;
    public static int[] A;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        n = sc.nextInt();
        A = new int[n + 1];
        for (int i = 0; i < n; i++) A[i+1] = sc.nextInt();
        buildMaxHeap();
        print();
        out.close();
    }

    public static int parent(int i) {
        return i / 2;
    }

    public static int leftChild(int i) {
        return i * 2;
    }

    public static int rightChild(int i) {
        return i * 2 + 1;
    }

    public static void swap(int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void maxHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if (left <= n && A[left] > A[i]) largest = left;
        if (right <= n && A[right] > A[largest]) largest = right;

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public static void buildMaxHeap() {
        // bottom-up approach
        for (int i = n/2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    public static void print() {
        for (int i = 1; i <= n; i++) {
            out.print(" " + A[i]);
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
