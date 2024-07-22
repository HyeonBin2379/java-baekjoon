package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Exercise15720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Integer[][] menu = new Integer[3][];
        int notDiscounted = 0;
        for (int i = 0; i < 3; i++) {
            menu[i] = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted(Comparator.reverseOrder())
                    .toArray(Integer[]::new);
            notDiscounted += Arrays.stream(menu[i]).reduce(0, Integer::sum);
        }

        int min = Math.min(Math.min(b, c), d);
        int discounted = notDiscounted;
        for (int i = 0; i < min; i++) {
            discounted -= (menu[0][i]+menu[1][i]+menu[2][i])*0.1;
        }
        System.out.println(notDiscounted);
        System.out.println(discounted);
    }
}
