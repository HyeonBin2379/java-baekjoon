package programmers;

import java.util.Arrays;

class CountingDiffBitSolution {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < numbers.length; i++) {
            answer[i]++;
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        return answer;
    }
}
public class CountingDiffBit {
    public static void main(String[] args) {
        long[] numbers = {2,7};
        System.out.println(Arrays.toString(new CountingDiffBitSolution().solution(numbers)));
    }
}
