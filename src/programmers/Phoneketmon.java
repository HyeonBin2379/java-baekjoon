package programmers;

import java.util.Set;
import java.util.TreeSet;

class PhoneketmonSolution {
    public int solution(int[] nums) {
        int choose = nums.length / 2;
        Set<Integer> kinds = new TreeSet<>();
        for (int num : nums) {
            kinds.add(num);
        }
        return Math.min(kinds.size(), choose);
    }
}
public class Phoneketmon {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        PhoneketmonSolution result = new PhoneketmonSolution();
        System.out.println(result.solution(nums));
    }
}
