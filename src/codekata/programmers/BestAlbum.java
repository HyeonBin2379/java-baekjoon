package codekata.programmers;

import java.util.*;
import java.util.stream.*;

class BestAlbum {

	private static class Album implements Comparable<Album> {
		int idx;
		int plays;

		Album(int idx, int plays) {
			this.idx = idx;
			this.plays = plays;
		}

		@Override
		public int compareTo(Album n) {
			int comparison = Integer.compare(n.plays, this.plays);
			return comparison != 0 ? comparison : Integer.compare(this.idx, n.idx);
		}
	}

	private final Map<String, Integer> rankByPlays = new LinkedHashMap<>();
	private final Map<String, List<Album>> albumList = new LinkedHashMap<>();


	public int[] solution(String[] genres, int[] plays) {
		// 1. 장르별 노래 재생횟수 총합
		// 2. 장르 내 노래 재생횟수 기준 내림차순, 고유번호 기준 오름차순
		for (int i = 0; i < plays.length; i++) {
			albumList.putIfAbsent(genres[i], new ArrayList<>());
			albumList.get(genres[i]).add(new Album(i, plays[i]));
			rankByPlays.merge(genres[i], plays[i], Integer::sum);
		}
		List<String> sorted = new ArrayList<>(rankByPlays.keySet());
		sorted.sort((o1, o2) -> rankByPlays.get(o2).compareTo(rankByPlays.get(o1)));

		// 3. 한 장르의 곡은 최대 2개까지만 선택 / 1개뿐이면 1개 곡만 선택
		List<Integer> answer = new ArrayList<>();
		for (String genre : sorted) {
			albumList.get(genre).sort(Comparator.comparing(album -> album));
			int size = Math.min(albumList.get(genre).size(), 2);

			List<Integer> albumNum = new ArrayList<>();
			albumList.get(genre).subList(0, size).forEach(album -> albumNum.add(album.idx));
			answer.addAll(albumNum);
		}

		return answer.stream()
				.mapToInt(v -> v)
				.toArray();
	}

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] solution = new BestAlbum().solution(genres, plays);
		System.out.println(Arrays.toString(solution));
	}
}