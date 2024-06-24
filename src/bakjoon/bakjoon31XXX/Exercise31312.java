package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise31312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            num.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(num);

        if (!num.contains(a) && num.contains(b)) {
            System.out.println(a);
        } else if (num.contains(a) && !num.contains(b)) {
            System.out.println(b);
        } else if (num.contains(a) && num.contains(b)) {
            for (int i = a; i <= b; i++) {
                System.out.println(i);
            }
        } else {
            System.out.println(-1);
        }
    }
}
