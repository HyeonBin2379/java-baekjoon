package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise31669 {

    private static char[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        checked = new char[n][m];

        for (int i = 0; i < n; i++) {
            checked[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < m; i++) {
            if (!hasChecked(n, i)) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println("ESCAPE FAILED");
    }

    public static boolean hasChecked(int n, int m) {
        for (int j = 0; j < n; j++) {
            if (checked[j][m] == 'O') {
                return true;
            }
        }
        return false;
    }
}
