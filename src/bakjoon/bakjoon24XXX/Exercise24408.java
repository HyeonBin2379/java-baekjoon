package bakjoon.bakjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise24408 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (!numList.isEmpty() && num % numList.get(0) == 0) {
                System.out.println(num);
                numList.clear();
                continue;
            }
            numList.add(num);
        }
    }
}
