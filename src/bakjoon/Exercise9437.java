package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise9437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n/4; i++) {
                List<Integer> pages = List.of(2*i+1, 2*i+2, n-2*i-1, n-2*i);
                if (pages.contains(p)) {
                    pages.stream()
                            .filter(num -> num != p)
                            .forEach(val -> System.out.print(val + " "));
                    System.out.println();
                    break;
                }
            }
        }
    }
}
