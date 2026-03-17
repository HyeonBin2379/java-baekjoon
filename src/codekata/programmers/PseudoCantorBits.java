package codekata.programmers;

public class PseudoCantorBits {

	public int solution(int n, long l, long r) {
		// n번째 유사 칸토어 비트열의 [l, r] 구간에서의 1의 개수 구하기
		// [l, r] = [1, r]에서 [1, l-1]에 해당하는 구간을 뺀 나머지 구간
		return (int) (countOnes(n, r)- countOnes(n, l-1));
	}

	// n번째 유사 칸토어 비트열의 [1, k] 구간에서의 1의 개수 구하기
	private long countOnes(int n, long k) {
		// 0번째 유사 칸토어 비트열
		if (n == 0) {
			return k == 1 ? 1 : 0;
		}

		// n번째 유사 칸토어 비트열을 5개의 n-1번째 유사 칸토어 비트열로 분할
		long part = (long)Math.pow(5, n-1);
		long idx = k / part;	// [1, k]에 5등분한 온전한 블록이 몇 개 포함되는지
		long rem = k % part;	// [1, k]에서 온전한 블록 이후의 남은 칸 수(0 <= rem < part)

		if (idx == 2) {
			// k가 가운데(인덱스상으로는 2) 구간에 걸리는 경우
			return (long)Math.pow(4, n-1)*idx;
		} else {
			// [1, k]에서 idx > 2인 경우 -> 가운데 구간(idx = 2)은 항상 0만 포함되므로 고려하지 않음 -> -1
			long blockCnt = (idx > 2) ? idx-1 : idx;
			// 온전한 블록에서의 1의 개수 + 나머지 구간에서의 1의 개수(재귀)
			return (long)Math.pow(4, n-1)*blockCnt + countOnes(n-1, rem);
		}
	}

	public static void main(String[] args) {
		int result = new PseudoCantorBits().solution(2, 4, 17);
		System.out.println(result);
	}
}
