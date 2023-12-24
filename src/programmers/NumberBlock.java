package programmers;

import java.util.Arrays;

class NumberBlockSolution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin)+1];
        for (int i = 0; i < answer.length; i++) {
            long num = begin + i;
            int max_div = 1;
            for (long j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    max_div = (int) Math.max(j, num / j);
                    if (num / j <= 10000000) {
                        max_div = (int) Math.max(max_div, j);
                    }
                }
            }
            answer[i] = max_div;
        }
        if (begin == 1) {
            answer[0] = 0;
        }
        return answer;
    }
}
public class NumberBlock {
    public static void main(String[] args) {
        NumberBlockSolution result = new NumberBlockSolution();
        long begin = 1L;
        long end = 10L;
        System.out.println(Arrays.toString(result.solution(begin, end)));
    }
}
