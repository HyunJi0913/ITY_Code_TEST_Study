package week_12;
import java.util.*;
public class BOJ_평범한배낭 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int itemCount = scanner.nextInt();         // 물건 개수
        int maxWeight = scanner.nextInt();         // 배낭이 들 수 있는 최대 무게

        int[] maxValueAtWeight = new int[maxWeight + 1];
        // maxValueAtWeight[무게] = 해당 무게일 때 얻을 수 있는 최대 가치

        // 각 물건을 하나씩 처리
        for (int itemIndex = 0; itemIndex < itemCount; itemIndex++) {
            int itemWeight = scanner.nextInt();    // 이번 물건의 무게
            int itemValue = scanner.nextInt();     // 이번 물건의 가치

            // 무게를 큰 쪽부터 작은 쪽으로 순회 → 중복 선택 방지
            for (int currentWeight = maxWeight; currentWeight >= itemWeight; currentWeight--) {
                maxValueAtWeight[currentWeight] = Math.max(
                        maxValueAtWeight[currentWeight],
                        maxValueAtWeight[currentWeight - itemWeight] + itemValue
                );
            }
        }

        // 최대 무게일 때의 최대 가치 출력
        System.out.println(maxValueAtWeight[maxWeight]);
    }

}
