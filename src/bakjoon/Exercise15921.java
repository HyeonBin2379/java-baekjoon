package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise15921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> count = new TreeMap<>();
        int len = Integer.parseInt(br.readLine());
        if (len == 0) {
            System.out.println("divide by zero");
            return;
        }
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        double exp = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            exp += entry.getKey()*entry.getValue();
        }

        if (exp == 0) {
            System.out.println("divide by zero");
        } else {
            System.out.printf("%.2f\n", (double)sum/exp);
        }
    }
}
