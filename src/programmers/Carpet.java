package programmers;

import java.util.Arrays;

class CarpetSolution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int area = brown + yellow;
        for (int i = 3; i*i <= area; i++) {
            if (area % i == 0) {
                if (yellow % (i-2) == 0 && yellow / (i-2) == (area/i)-2) {
                    answer[0] = area/i;
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }
}
public class Carpet {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(new CarpetSolution().solution(brown, yellow)));
    }
}
