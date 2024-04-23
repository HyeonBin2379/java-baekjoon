package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise2628 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        List<Integer> colNumList = new ArrayList<>(List.of(0, w));
        List<Integer> rowNumList = new ArrayList<>(List.of(0, h));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (type == 0) {
                rowNumList.add(num);
            } else {
                colNumList.add(num);
            }
        }
        Collections.sort(colNumList);
        Collections.sort(rowNumList);
        System.out.println(getMaxLength(colNumList) * getMaxLength(rowNumList));
    }

    private static int getMaxLength(List<Integer> numList) {
        int max = 0;
        for (int i = 1; i < numList.size(); i++) {
            int len = numList.get(i) - numList.get(i-1);
            max = Math.max(len, max);
        }
        return max;
    }
}
