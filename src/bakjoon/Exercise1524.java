package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise1524 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Long> sejun = Arrays.stream(br.readLine().split(" "))
                    .map(Long::parseLong)
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
            List<Long> sebi = Arrays.stream(br.readLine().split(" "))
                    .map(Long::parseLong)
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());

            while (!sejun.isEmpty() && !sebi.isEmpty()) {
                if (sejun.get(sejun.size()-1) >= sebi.get(sebi.size()-1)) {
                    sebi.remove(sebi.size()-1);
                } else {
                    sejun.remove(sejun.size()-1);
                }
            }

            if (!sejun.isEmpty()) {
                System.out.println("S");
            } else if (!sebi.isEmpty()) {
                System.out.println("B");
            } else {
                System.out.println("C");
            }
        }
    }
}
