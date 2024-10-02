package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise13423 {

    private static List<Integer> num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            num = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            Set<String> result = new HashSet<>();
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    int left = num.get(i);
                    int right = num.get(j);
                    int mid = (left + right) / 2;
                    if (mid - left == right - mid && binarySearch(mid)) {
                        result.add(left + " " + mid + " " + right);
                    }
                }
            }
            bw.write(result.size() + "\n");
        }
        br.close();
        bw.close();
    }

    private static boolean binarySearch(int target) {
        int left = 0;
        int right = num.size()-1;

        while (left <= right) {
            int mid = (left+right)/2;
            if (num.get(mid) == target) {
                return true;
            } else if (num.get(mid) < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
