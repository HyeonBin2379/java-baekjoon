package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LottoRankSolution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {6, 6};
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        List<Integer> win_numbers = Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toList());

        int sameCount = 0;
        int zeroCount = 0;
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            if (win_numbers.contains(num)) {
                sameCount++;
            }
        }

        answer[0] = Math.min(answer[0], 7-sameCount-zeroCount);
        answer[1] = Math.min(answer[1], 7-sameCount);
        return answer;
    }
}

public class LottoRank {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        LottoRankSolution result = new LottoRankSolution();
        System.out.println(Arrays.toString(result.solution(lottos, win_nums)));
    }
}
