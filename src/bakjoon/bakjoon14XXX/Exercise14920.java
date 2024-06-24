package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise14920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> seq = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());
        seq.add(num);

        while (seq.get(seq.size()-1) != 1) {
            int prev = seq.get(seq.size()-1);
            int next = (prev % 2 == 0) ? prev/2 : 3*prev+1;
            seq.add(next);
        }
        System.out.println(seq.indexOf(1) + 1);
    }
}
