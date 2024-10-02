package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise30805 {

    private static int max1, max2, idx1, idx2;
    private static List<Integer> seq1, seq2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        seq1 = Arrays.stream(br.readLine().split(" ", n))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int m = Integer.parseInt(br.readLine());
        seq2 = Arrays.stream(br.readLine().split(" ", m))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        while (canFindCommonMax()) {
            answer.add(max1);
            seq1 = seq1.subList(idx1 + 1, seq1.size());
            seq2 = seq2.subList(idx2 + 1, seq2.size());
        }

        System.out.println(answer.size());
        if (!answer.isEmpty()) {
            System.out.println(answer.stream().map(value -> Integer.toString(value)).collect(Collectors.joining(" ")));
        }
    }

    private static boolean canFindCommonMax() {
        while (true) {
            if (seq1.isEmpty() || seq2.isEmpty()) {
                return false;
            }
            max1 = seq1.stream().reduce(0, Integer::max);
            max2 = seq2.stream().reduce(0, Integer::max);

            idx1 = seq1.indexOf(max1);
            idx2 = seq2.indexOf(max2);

            if (max1 == max2) {
                break;
            } else if (max1 > max2) {
                seq1.remove(idx1);
            } else {
                seq2.remove(idx2);
            }
        }
        return true;
    }
}
