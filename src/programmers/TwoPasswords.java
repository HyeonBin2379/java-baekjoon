package programmers;

class TwoPasswordsSolution {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (String token : skip.split("")) {
            alphabet = alphabet.replace(token, "");
        }
        for (String token : s.split("")) {
            int idx = alphabet.indexOf(token) + index;
            answer.append(alphabet.charAt(idx % alphabet.length()));
        }

        return answer.toString();
    }
}
public class TwoPasswords {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(new TwoPasswordsSolution().solution(s, skip, index));
    }
}
