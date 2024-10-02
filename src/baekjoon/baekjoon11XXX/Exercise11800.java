package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11800 {
    private static final String[] nickname = {"Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh"};
    private static final String[] nickIfSame = {"Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(String.format("Case %d: ", i));
            if (a == b) {
                sb.append(nickIfSame[a-1]).append("\n");
            } else if ((a == 6 && b == 5) || (a == 5 && b == 6)) {
                sb.append(String.format("%s %s\n", nickname[5], "Beesh"));
            } else {
                sb.append(String.format("%s %s\n", nickname[Math.max(a-1, b-1)], nickname[Math.min(a-1, b-1)]));
            }
        }
        System.out.print(sb);
    }
}
