package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise15739 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = n*(n*n+1)/2;

        int[][] arr = new int[n][n];
        int[] sumByRow = new int[n];
        Set<Integer> numbers = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            numbers.addAll(Arrays.stream(arr[i]).boxed().toList());
            sumByRow[i] = Arrays.stream(arr[i]).sum();
            if (sumByRow[i] != sum) {
                System.out.println("FALSE");
                return;
            }
        }
        if (numbers.size() != n*n) {
            System.out.println("FALSE");
            return;
        }

        int[] sumByCol = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumByCol[i] += arr[j][i];
            }
            if (sumByCol[i] != sum) {
                System.out.println("FALSE");
                return;
            }
        }

        int[] sumByDiag = new int[2];
        for (int i = 0; i < n; i++) {
            sumByDiag[0] += arr[i][i];
            sumByDiag[1] += arr[i][n-1-i];
        }
        if (sumByDiag[0] != sum || sumByDiag[1] != sum) {
            System.out.println("FALSE");
            return;
        }
        System.out.println("TRUE");
    }
}
