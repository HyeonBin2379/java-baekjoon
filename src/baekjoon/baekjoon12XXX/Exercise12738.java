package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise12738 {

    private static final List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int len = 0;
        numList.add(seq[0]);
        for (int i = 1; i < n; i++) {
            if (seq[i] > numList.get(numList.size()-1)) {
                len = numList.size();
                numList.add(seq[i]);
            } else {
                int pos = binarySearch(len, seq[i]);
                numList.set(pos, seq[i]);
            }
        }
        System.out.println(len+1);
    }

    private static int binarySearch(int end, int target) {
        int left = 0;
        int right = end;

        while (left < right) {
            int mid = (left + right)/2;
            if (target > numList.get(mid)) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}