package programmers;

class MakingJadenCaseSolution {
    public String solution(String s) {
        char[] str = s.toLowerCase().toCharArray();
        int strlen = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                strlen = 0;
                continue;
            }

            if (strlen++ == 0) {
                str[i] = Character.toUpperCase(str[i]);
            }
        }
        return String.valueOf(str);
    }
}
public class MakingJadenCase {
    public static void main(String[] args) {
        String s = "  for the what 1what  ";
        System.out.println(new MakingJadenCaseSolution().solution(s));
    }
}
