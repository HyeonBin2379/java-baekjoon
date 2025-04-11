package algorithm.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> closet = new HashMap<>();
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                closet.merge(category, 1, Integer::sum);
            }

            int totalCases = 1;
            for (int count : closet.values()) {
                totalCases *= count+1;
            }
            System.out.println(totalCases-1);
        }
    }
}
