import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Set<String> subStringSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                subStringSet.add(input.substring(i, j+1));
            }
        }

        System.out.println(subStringSet.size());
        sc.close();
    }
}
