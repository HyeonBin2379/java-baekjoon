package programmers;

class NQueenSolution {
    private int count = 0;
    private int[] column;

    public int solution(int n) {
        column = new int[n];
        queens(n, 0);
        return count;
    }

    public boolean promising(int level) {
        for (int i = 0; i < level; i++) {
            if (column[i] == column[level] || level-i == Math.abs(column[level] - column[i])) {
                return false;
            }
        }
        return true;
    }
    public void queens(int length, int level) {
        if (level == length) {
            count++;
            return;
        }

        for (int i = 0; i < length; i++) {
            column[level] = i;
            if (promising(level)) {
                queens(length, level+1);
            }
        }
    }
}
public class NQueen {
    public static void main(String[] args) {
        System.out.println(new NQueenSolution().solution(4));
    }
}
