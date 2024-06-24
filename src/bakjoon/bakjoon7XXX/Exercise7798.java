package bakjoon.bakjoon7XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Exercise7798 {

    private enum BedSizeType { // 침대 크기별 타입
        A("A", 20, 35),
        B("B", 36, 48),
        C("C", 49, 62),
        D("D", 0, 0);

        private final String type;
        private final int min, max;

        BedSizeType(String type, int min, int max) {
            this.type = type;
            this.min = min;
            this.max = max;
        }
        public static String getType(int bedSize) {
            return Arrays.stream(BedSizeType.values())
                    .filter(bedSizeType -> bedSizeType.isInRange(bedSize))
                    .findFirst()
                    .orElse(D)
                    .type;
        }
        private boolean isInRange(int bedSize) {
            return min <= bedSize && bedSize <= max;
        }
    }

    private static class Hotel { // 호텔 정보
        String bedSizeType;
        int bedSize, roomCapacity, availableRoom, pricePerRoom;

        public Hotel(int bedSize, int roomCapacity, int availableRoom, int pricePerRoom) {
            this.bedSizeType = BedSizeType.getType(bedSize);
            this.bedSize = bedSize;
            this.roomCapacity = roomCapacity;
            this.availableRoom = availableRoom;
            this.pricePerRoom = pricePerRoom;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 호텔 개수
            int m = Integer.parseInt(st.nextToken()); // 참가팀 수

            /* 2. 이용 가능한 호텔 정보 입력 */
            Map<String, Hotel> hotelList = new LinkedHashMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int bedSize = Integer.parseInt(st.nextToken()); // 침대 크기
                int capacity = Integer.parseInt(st.nextToken()); // 객실당 최대 수용 가능 인원
                int availableRoom = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                hotelList.put(name, new Hotel(bedSize, capacity, availableRoom, price));
            }

            sb.append(String.format("Case #%d:\n", i));
            for (int j = 0; j < m; j++) {
                /* 3. 참가 팀별 선호 호텔 정보 입력 */
                st = new StringTokenizer(br.readLine());
                String bedSizeType = st.nextToken();    // 침대 타입
                int numOfPeople = Integer.parseInt(st.nextToken()); // 전체 인원수
                int maxCapPerRoom = Integer.parseInt(st.nextToken()); // 방 1개당 최대 인원수(객실 수용 인원보다 적을 수 있음)

                /* 4. 이용 가능 호텔 중 조건에 맞는 호텔 목록 찾기 */
                Map<String, Integer> matched = new LinkedHashMap<>();
                for (Map.Entry<String, Hotel> hotel : hotelList.entrySet()) {
                    if (hotel.getValue().bedSizeType.equals(bedSizeType)) {
                        int maxCap = Math.min(maxCapPerRoom, hotel.getValue().roomCapacity);
                        int roomNeeded = (numOfPeople + maxCap-1) / maxCap;
                        if (hotel.getValue().availableRoom >= roomNeeded) {
                            matched.put(hotel.getKey(), roomNeeded * hotel.getValue().pricePerRoom);
                        }
                    }
                }

                /* 5-1 조건 충족 호텔 없는 경우 no-hotel 출력 */
                if (matched.isEmpty()) {
                    sb.append("no-hotel\n");
                    continue;
                }
                /* 5-2 가장 저렴한 호텔 찾기(최솟값이 여러 개이면 침대 크기 큰 순으로 정렬) */
                Map.Entry<String, Integer> answer = matched.entrySet().stream().min(
                        (o1, o2) -> {
                            if (!Objects.equals(o1.getValue(), o2.getValue())) {
                                return o1.getValue()-o2.getValue();
                            } else {
                                return hotelList.get(o2.getKey()).bedSize - hotelList.get(o1.getKey()).bedSize;
                            }
                        }).get();
                sb.append(String.format("%d %s\n", answer.getValue(), answer.getKey()));
            }
        }
        System.out.print(sb);
    }
}
