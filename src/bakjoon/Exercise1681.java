package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise1681 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String l = st.nextToken();

        List<Integer> numList = new ArrayList<>();
        int i = 1;
        while (numList.size() < n) {
            String num = Integer.toString(i);
            if (!num.contains(l)) {
                numList.add(Integer.parseInt(num));
            }
            i++;
        }
        System.out.println(numList.get(n-1));
    }
}
