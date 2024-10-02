package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise12645 {

    private static char[] digits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            String N = br.readLine();
            bw.append(String.format("Case #%d: %s\n", i, findNextNumber(N)));
        }
        br.close();
        bw.close();
    }

    private static String findNextNumber(String N) {
        // 숫자를 문자열로 변환
        digits = N.toCharArray();

        // 자리수의 조합을 생성하기 위해 정렬
        Arrays.sort(digits);

        // 다음 숫자를 찾기
        // 더 이상 조합이 없다면 종료
        String answer;
        do {
            // 조합을 생성
            answer = new String(digits);
            // 현재 조합이 N보다 크면 반환
            if (answer.compareTo(N) > 0) {
                break;
            }
            // 다음 조합으로 이동
        } while (nextPermutation());

        // 만약 다음 숫자가 없다면, 가장 작은 자리수를 추가한 숫자 반환
        StringBuilder sb = new StringBuilder();
        int index = 0;
        if (answer.equals(N)) {
            Arrays.sort(digits);
            sb.append(new String(digits));
            index = upperBound();
            sb.insert(index+1,"0".repeat(index+1)); // 0을 추가하여 새로운 숫자 형성
        } else {
            sb.append(new String(digits));
        }
        return sb.substring(index);
    }

    private static int upperBound() {
        int left = 0;
        int right = digits.length;
        while (left < right) {
            int mid = (left+right)/2;
            if (digits[mid] <= '0') {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }
    private static boolean nextPermutation() {
        int i = digits.length - 1;
        // 오른쪽에서부터 비내림차순으로 찾기
        while (i > 0 && digits[i - 1] >= digits[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        // 교환할 인덱스를 찾기
        int j = digits.length - 1;
        while (digits[j] <= digits[i - 1]) {
            j--;
        }
        swap(i-1, j);

        // i부터 끝까지 뒤집기
        j = digits.length - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}
