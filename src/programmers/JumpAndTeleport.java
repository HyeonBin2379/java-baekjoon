package programmers;

class JumpAndTeleportSolution {
    public int solution(int n) {
        int ans = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            n--;
            ans++;
        }
        return ans;
    }
}

public class JumpAndTeleport {
    public static void main(String[] args) {
        System.out.println(new JumpAndTeleportSolution().solution(5000));
    }
}
