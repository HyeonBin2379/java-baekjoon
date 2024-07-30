package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise16466 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> soldTicket = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        int answer = 1;
        while (true) {
            if (!soldTicket.contains(answer)) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }
}
