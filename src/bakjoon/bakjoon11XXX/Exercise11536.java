package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise11536 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> increase = new ArrayList<>();
        List<String> decrease = new ArrayList<>();
        List<String> input = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            input.add(name);
            increase.add(name);
            decrease.add(name);
        }
        increase.sort(null);
        decrease.sort(Comparator.reverseOrder());

        if (!input.equals(increase) && !input.equals(decrease)) {
            System.out.println("NEITHER");
        } else {
            System.out.println(input.equals(increase) ? "INCREASING" : "DECREASING");
        }
    }
}
