package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1991 {

    private static int[] left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        left = new int[n+1];
        right = new int[n+1];
        for (int i = 0; i < n; i++) {
            char[] tokens = br.readLine().toCharArray();
            char c = tokens[0];
            char l = tokens[2];
            char r = tokens[4];

            if (l != '.') {
                left[c-'A'+1] = l-'A'+1;
            }
            if (r != '.') {
                right[c-'A'+1] = r-'A'+1;
            }
        }
        preorder(1);
        System.out.println();
        inorder(1);
        System.out.println();
        postorder(1);
        System.out.println();
    }

    private static void preorder(int cur) {
        System.out.print((char)(cur+'A'-1));
        if (left[cur] != 0) {
            preorder(left[cur]);
        }
        if (right[cur] != 0) {
            preorder(right[cur]);
        }
    }

    private static void inorder(int cur) {
        if (left[cur] != 0) {
            inorder(left[cur]);
        }
        System.out.print((char)(cur+'A'-1));
        if (right[cur] != 0) {
            inorder(right[cur]);
        }
    }

    private static void postorder(int cur) {
        if (left[cur] != 0) {
            postorder(left[cur]);
        }
        if (right[cur] != 0) {
            postorder(right[cur]);
        }
        System.out.print((char)(cur+'A'-1));
    }
}
