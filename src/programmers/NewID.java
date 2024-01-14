package programmers;

class NewIDSolution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^-_.a-zA-Z0-9]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        if (answer.equals("")) {
            answer += "a";
        }
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length()-1);
        }
        return answer;
    }
}
public class NewID {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(new NewIDSolution().solution(new_id));
    }
}
