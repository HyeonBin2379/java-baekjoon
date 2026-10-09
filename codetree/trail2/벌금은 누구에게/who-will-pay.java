import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 학생 수
        int m = sc.nextInt();   // 벌칙 시행횟수
        int k = sc.nextInt();   // 벌칙 횟수 제한
        
        int[] penalizedPerson = new int[m];
        for (int i = 0; i < m; i++) {
            penalizedPerson[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] penaltyCnt = new int[n];
        Arrays.fill(penaltyCnt, k);
        int answer = -1;
        for (int i = 0; i < m; i++) {
            int index = penalizedPerson[i]-1;
            penaltyCnt[index]--;
            
            if (penaltyCnt[index] == 0) {
                answer = index+1;
                break;
            }
        }
        System.out.println(answer);
    }
}