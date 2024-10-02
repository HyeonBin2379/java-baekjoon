package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise27913 {

    private static int[] queried;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String input = "SciComLove".repeat(n/10) + "SciComLove".substring(0, n%10);
        int upper = (int) input.chars().filter(ch -> Character.isUpperCase((char)ch)).count();
        queried = new int[n];
        while (q-- > 0) {
            int i = Integer.parseInt(br.readLine())-1;
            upper += isUpper(input, i) ? 1 : -1;
            queried[i]++;
            bw.write(upper + "\n");
        }
        br.close();
        bw.close();
    }

    private static boolean isUpper(String input, int index) {
        return (Character.isUpperCase(input.charAt(index)) && queried[index] % 2 == 1)
                || (Character.isLowerCase(input.charAt(index)) && queried[index] % 2 == 0);
    }
}
