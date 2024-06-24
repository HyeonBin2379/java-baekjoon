package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] kayak = new int[n];
        Arrays.fill(kayak, 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int teamNum = Integer.parseInt(st.nextToken())-1;
            kayak[teamNum]--;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int teamNum = Integer.parseInt(st.nextToken())-1;
            kayak[teamNum]++;
        }

        for (int i = 0; i < n-1; i++) {
            if (kayak[i] == 0 && kayak[i+1] == 2) {
                kayak[i]++;
                kayak[i+1]++;
            } else if (kayak[i+1] == 0 && kayak[i] == 2) {
                kayak[i+1]++;
                kayak[i]--;
            }
        }
        System.out.println(Arrays.stream(kayak).filter(value -> value == 0).count());
    }
}
