package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise17122 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = getNum(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken())-1;

            if ((num1/8 + num1 % 8) % 2 == (num2/8 + num2 % 8) % 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int getNum(String pos) {
        int row = pos.charAt(1)-'0'-1;
        int col = pos.charAt(0)-'A';
        return row*8 + col;
    }
}
