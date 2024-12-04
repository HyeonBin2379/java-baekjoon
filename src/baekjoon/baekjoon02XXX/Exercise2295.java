package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise2295 {

    private static List<Long> sumList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Long> numList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numList.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(numList);

        sumList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sumList.add(numList.get(i) + numList.get(j));
            }
        }
        Collections.sort(sumList);

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                long sum = numList.get(i) - numList.get(j);
                if (binarySearch(sum)) {
                    System.out.println(numList.get(i));
                    return;
                }
            }
        }
    }

    private static boolean binarySearch(long target) {
        int left = 0;
        int right = sumList.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (sumList.get(mid) == target) {
                return true;
            } else if (sumList.get(mid) < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
