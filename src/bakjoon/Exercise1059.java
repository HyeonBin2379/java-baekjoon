package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise1059 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> num = new ArrayList<>(List.of(0));
        for (int i = 1; i <= l; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(num);

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        if (num.contains(n)) {
            System.out.println(answer);
            return;
        }

        for (int i = 1; i <= l; i++) {
            if (num.get(i-1) < n && n < num.get(i)) {
                answer = (n-num.get(i-1))*(num.get(i)-n)-1;
                break;
            }
        }
        System.out.println(answer);
    }
}
