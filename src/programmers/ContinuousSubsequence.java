package programmers;

import java.util.HashSet;
import java.util.Set;

class ContinuousSubsequenceSolution {
    public int solution(int[] elements) {
        Set<Integer> result = new HashSet<>();
        int[] prefixSum = new int[elements.length*2+1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + elements[(i-1) % elements.length];
        }

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                result.add(prefixSum[j+i]-prefixSum[j]);
            }
        }
        return result.size();
    }
}
public class ContinuousSubsequence {
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        System.out.println(new ContinuousSubsequenceSolution().solution(elements));
    }
}
