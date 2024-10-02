package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise13771 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Double> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            list.add(Double.parseDouble(br.readLine()));
        }
        Collections.sort(list);
        System.out.printf("%.2f\n", list.get(1));
    }
}
