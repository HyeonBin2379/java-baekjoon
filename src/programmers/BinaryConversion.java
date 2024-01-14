package programmers;

import java.util.Arrays;

class BinaryConversionSolution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        while (s.length() > 1) {
            int before = s.length();
            s = s.replace("0", "");
            answer[0]++;
            answer[1] += before - s.length();
            s = Integer.toBinaryString(s.length());
        }
        return answer;
    }
}
public class BinaryConversion {
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(new BinaryConversionSolution().solution(s)));
    }
}
