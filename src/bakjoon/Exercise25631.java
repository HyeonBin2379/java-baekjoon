package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] mat = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        boolean[] visited = new boolean[n];
        Arrays.sort(mat);
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (mat[i] < mat[j] && !visited[j]) {
                    visited[j] = true;
                    mat[i] = 0;
                    break;
                }
            }
        }
        System.out.println(Arrays.stream(mat).filter(val -> val > 0).count());
    }
}
