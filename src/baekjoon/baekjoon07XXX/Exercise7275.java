package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise7275 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] group = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            group[i] = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                group[i].add(Integer.parseInt(st.nextToken()));
            }
        }


        int[] clothes = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
        int[] sumByGroup = new int[k];
        for (int i = 1; i <= clothes.length; i++) {
            for (int j = 0; j < k; j++) {
                if (group[j].contains(i)) {
                    sumByGroup[j] += clothes[i-1];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer += (int) Math.ceil((double)sumByGroup[i]/m);
        }
        System.out.println(answer);
    }
}
