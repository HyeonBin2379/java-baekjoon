package bakjoon.bakjoon07XXX;

import java.io.*;
import java.util.*;

public class Exercise7281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> time = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int onOff = Integer.parseInt(st.nextToken());
            if (onOff == 1) {
                time.add(t);
            }
        }

        int maxTime = 0;
        for (int i = 1; i < time.size(); i++) {
            int diff = time.get(i) - time.get(i-1);
            maxTime = Math.max(maxTime, diff);
        }
        System.out.println(maxTime);
    }
}
