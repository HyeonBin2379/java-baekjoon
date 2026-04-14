package codekata.programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CrackingSecretCode {

	private List<Set<Integer>> possibleCases;

	public int solution(int n, int[][] q, int[] ans) {
		// 1. 첫번째 힌트 기반 초기 정답군 생성
		List<Integer> currentQ = Arrays.stream(q[0]).boxed().collect(Collectors.toList());
		List<Set<Integer>> initialCandidates = initialCandidates(n, currentQ, ans[0]);

		// 2. 두번째 ~ m번째 힌트 -> 초기 정답군에서 가능한 조합만 남기고 나머지는 소거
		List<Set<Integer>> answers = recursive(1, q, ans, initialCandidates);
		return answers.size();
	}

	private List<Set<Integer>> recursive(int i, int[][] q, int[] ans, List<Set<Integer>> currentCandidates) {
		if (i == q.length) {
			return currentCandidates;
		}

		int currentAns = ans[i];
		List<Integer> currentQ = Arrays.stream(q[i]).boxed().collect(Collectors.toList());

		List<Set<Integer>> filtered = currentCandidates.stream()
					.filter(cand -> {
						Set<Integer> intersect = new HashSet<>(cand);
						intersect.retainAll(currentQ);
						return intersect.size() == currentAns;
					})
					.collect(Collectors.toList());

		return recursive(i+1, q, ans, filtered);
	}

	// 초기 정답군 생성
	private List<Set<Integer>> initialCandidates(int n, List<Integer> q, int ans) {
		// 1. q[0]에 포함되는, 정답에 해당하는 정수 조합
		List<Set<Integer>> seed1 = firstInput(q, ans);
		
		// 2. q[0]에는 없지만 정답에 포함되는 정수 조합
		List<Integer> remainder = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
		remainder.removeAll(q);
		List<Set<Integer>> seed2 = firstInput(remainder, 5-ans);

		// 3. 1과 2를 조합하여 만들 수 있는 모든 정답들
		List<Set<Integer>> candidates = new ArrayList<>();
		for (Set<Integer> set1 : seed1) {
			for (Set<Integer> set2 : seed2) {
				Set<Integer> cand = new HashSet<>(set1);
				cand.addAll(set2);
				candidates.add(cand);
			}
		}
		return candidates;
 	}

	private List<Set<Integer>> firstInput(List<Integer> q, int ans) {
		possibleCases = new ArrayList<>();
		Set<Integer> selected = new HashSet<>();
		combination(q, ans, 0, 0, selected);
		return possibleCases;
	}
	// 숫자 조합 탐색
	private void combination(List<Integer> q, int ans, int step, int idx, Set<Integer> selected) {
		if (step == ans) {
			possibleCases.add(new HashSet<>(selected));
			return;
		}
		for (int i = idx; i < q.size(); i++) {
			selected.add(q.get(i));
			combination(q, ans, step+1, i+1, selected);
			selected.remove(q.get(i));
		}
	}

	public static void main(String[] args) {
		int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
		int[] answer = {2, 3, 4, 3, 3};
		int result = new CrackingSecretCode().solution(10, q, answer);
		System.out.println(result);
	}
}
