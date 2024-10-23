package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Exercise32400 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> dartScore = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
        int index = dartScore.indexOf(20);
        int alice = 20
                + dartScore.get((index+19) % dartScore.size())
                + dartScore.get((index+1) % dartScore.size());
        int bob = dartScore.stream().reduce(0, Integer::sum);
        switch (Double.compare(alice / 3.0, (double) bob / 20)) {
            case 1 -> System.out.println("Alice");
            case 0 -> System.out.println("Tie");
            case -1 -> System.out.println("Bob");
        }
    }
}
