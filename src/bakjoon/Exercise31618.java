package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise31618 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new TreeSet<>();
        int len = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            set.add(num[i]);
        }

        for (int i = 0; i < len; i++) {
            if (set.contains(num[i]-3) && set.contains(num[i]+3)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
