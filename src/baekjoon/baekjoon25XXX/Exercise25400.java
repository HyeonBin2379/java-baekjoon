package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Exercise25400 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> numList = Arrays.stream(br.readLine().split(" ", n))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
        int cardNum = 1;
        int removed = 0;
        while (!numList.isEmpty()) {
            if (numList.peek() == cardNum) {
                numList.poll();
                cardNum++;
            } else {
                numList.poll();
                removed++;
            }
        }
        System.out.println(removed);
    }
}
