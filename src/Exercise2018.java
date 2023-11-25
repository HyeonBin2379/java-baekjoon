import java.util.Scanner;

public class Exercise2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int count = 1, sum = 1;
        int start = 1, end = 1;
        while (end < num) {
            if (sum == num) {
                count++;
                end++;
                sum += end;
            }
            else if (sum > num) {
                sum -= start;   // 기존의 start_index의 값을 뺀 다음
                start++;        // start_index의 값을 증가시켜야 함에 유의(순서 바뀌면 안 됨)
            }
            else {
                end++;
                sum += end;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
