package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class TupleSolution {

    public int[] solution(String s) {
        String[] tokens = s.substring(2, s.length()-2).replace("},{", "-").split("-");
        List<List<Integer>> tuples = new ArrayList<>();
        for (String token : tokens) {
            tuples.add(new ArrayList<>(
                    Arrays.stream(token.split(","))
                            .filter(s1 -> !s1.isEmpty())
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
            ));
        }
        tuples.sort(Comparator.comparingInt(List::size));

        int[] answer = new int[tuples.size()];
        for (int i = answer.length-1; i > 0; i--) {
            tuples.get(i).removeAll(tuples.get(i-1));
            answer[i] = tuples.get(i).get(0);
        }
        answer[0] = tuples.get(0).get(0);
        return answer;
    }
}
public class Tuple {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(new TupleSolution().solution(s)));
    }
}
