package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise2002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> in = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String carId = br.readLine();
            in.put(carId, i);
        }
        List<String> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String carId = br.readLine();
            out.add(carId);
        }

        int count = 0;
        for (int i = 0; i < out.size()-1; i++) {
            for (int j = i+1; j < out.size(); j++) {
                if (in.get(out.get(j)) < in.get(out.get(i))) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
