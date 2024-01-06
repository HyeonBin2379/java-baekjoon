package programmers;

class Babbling1Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("aya")) {
                babbling[i] = babbling[i].replaceFirst("aya", " ");
            }
            if (babbling[i].contains("ye")) {
                babbling[i] = babbling[i].replaceFirst("ye", " ");
            }
            if (babbling[i].contains("woo")) {
                babbling[i] = babbling[i].replaceFirst("woo", " ");
            }
            if (babbling[i].contains("ma")) {
                babbling[i] = babbling[i].replaceFirst("ma", " ");
            }

            babbling[i] = babbling[i].trim();
            if (babbling[i].equals("")) {
                answer++;
            }
        }
        return answer;
    }
}
public class Babbling1 {
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
        Babbling1Solution result = new Babbling1Solution();
        System.out.println(result.solution(babbling));
    }
}
