package codekata.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class PhoneList {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparing(String::length));
        TreeSet<String> phoneNums = new TreeSet<>(Arrays.asList(phone_book));

        for (String phone : phone_book) {
            if (phoneNums.stream()
                    .filter(s -> !s.equals(phone) && s.length() > phone.length())
                    .anyMatch(s -> s.startsWith(phone))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = {"123", "13", "134"};
        boolean result = new PhoneList().solution(phone_book);
        System.out.println(result);
    }
}
