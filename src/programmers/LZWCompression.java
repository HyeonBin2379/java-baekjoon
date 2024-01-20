package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LZWCompressionSolution {
    private final List<String> dictionary = new ArrayList<>();

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            dictionary.add(String.valueOf(i));
        }

        int size = msg.length();
        for (int i = 0; i < size; i++) {
            int wordLen = 1;
            while (i+wordLen <= size && dictionary.contains(msg.substring(i, i+wordLen))) {
                wordLen++;
            }
            if (i+wordLen > size) {
                answer.add(dictionary.indexOf(msg.substring(i)));
                break;
            }
            answer.add(dictionary.indexOf(msg.substring(i, i+wordLen-1)));
            dictionary.add(msg.substring(i, i+wordLen));
            if (wordLen > 1) {
                i += wordLen-2;
            }
        }

        return answer.stream()
                .mapToInt(value -> value+1)
                .toArray();
    }
}
public class LZWCompression {
    public static void main(String[] args) {
        String msg = "KAKAO";
        System.out.println(Arrays.toString(new LZWCompressionSolution().solution(msg)));
    }
}
