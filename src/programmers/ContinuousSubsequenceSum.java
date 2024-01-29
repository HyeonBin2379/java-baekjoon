package programmers;

import java.util.Arrays;

class ContinuousSubsequenceSumSolution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, sequence.length-1};
        int start = 0, end = 1;
        int sum = sequence[0];

        while (start < end) {
            if (sum == k) {
                if (end - 1 - start < answer[1] - answer[0]) {
                    answer[0] = start;
                    answer[1] = end-1;
                }
                sum -= sequence[start++];
            } else if (sum > k) {
                sum -= sequence[start++];
            } else if (end < sequence.length) {
                sum += sequence[end++];
            } else {
                break;
            }
        }
        return answer;
    }
}
public class ContinuousSubsequenceSum {
    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        System.out.println(Arrays.toString(new ContinuousSubsequenceSumSolution().solution(sequence, k)));
    }
}
