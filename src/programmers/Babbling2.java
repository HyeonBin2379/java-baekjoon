package programmers;

class Babbling2Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("aya") && !babbling[i].contains("ayaaya")) {
                babbling[i] = babbling[i].replaceFirst("aya", "");
            }
            if (babbling[i].contains("ye") && !babbling[i].contains("yeye")) {
                babbling[i] = babbling[i].replaceFirst("ye", "");
            }
            if (babbling[i].contains("woo") && !babbling[i].contains("woowoo")) {
                babbling[i] = babbling[i].replaceFirst("woo", "");
            }
            if (babbling[i].contains("ma") && !babbling[i].contains("mama")) {
                babbling[i] = babbling[i].replaceFirst("ma", "");
            }

            if (babbling[i].equals("")) {
                answer++;
            }
        }
        return answer;
    }
}

public class Babbling2 {
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        Babbling2Solution result = new Babbling2Solution();
        System.out.println(result.solution(babbling));
    }
}
