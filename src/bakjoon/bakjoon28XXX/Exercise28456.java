package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise28456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            switch (type) {
                case 1 -> {
                    int[] temp = new int[n];
                    int row = Integer.parseInt(st.nextToken()) - 1;
                    for (int i = 0; i < n; i++) {
                        temp[i] = arr[row][(n-1+i) % n];
                    }
                    arr[row] = temp.clone();
                }
                case 2 -> {
                    int[][] newArr = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            newArr[j][(n-1-i) % n] = arr[i][j];
                        }
                    }
                    arr = newArr;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.stream(arr[i]).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
    }
}
