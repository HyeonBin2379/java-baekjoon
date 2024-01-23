package programmers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class DiscountingSolution {
    private final Map<String, Integer> shopping = new LinkedHashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < want.length; i++) {
            shopping.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            String[] temp = Arrays.copyOfRange(discount, i, i+10);
            if (canDiscount(temp)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean canDiscount(String[] temp) {
        Map<String, Integer> discounting = new LinkedHashMap<>();
        for (String s : temp) {
            if (!shopping.containsKey(s)) {
                return false;
            }
            discounting.put(s, discounting.getOrDefault(s, 0) + 1);
        }
        return discounting.entrySet().stream()
                .allMatch(entry -> shopping.get(entry.getKey()).equals(discounting.get(entry.getKey())));
    }
}
public class Discounting {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(new DiscountingSolution().solution(want, number, discount));
    }
}
