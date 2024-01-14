package programmers;

import java.util.Arrays;

class PhoneListSolution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            int len1 = phone_book[i-1].length();
            int len2 = phone_book[i].length();
            if (phone_book[i-1].equals(phone_book[i].substring(0, Math.min(len1, len2)))) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
public class PhoneList {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(new PhoneListSolution().solution(phone_book));
    }
}
