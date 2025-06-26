package week_12;
import java.util.*;
public class BOJ_RGB거리 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int houseCount = scanner.nextInt(); // 집의 개수

        int[][] cost = new int[houseCount][3]; // 각 집의 색별 칠하는 비용
        for (int i = 0; i < houseCount; i++) {
            cost[i][0] = scanner.nextInt(); // 빨강
            cost[i][1] = scanner.nextInt(); // 초록
            cost[i][2] = scanner.nextInt(); // 파랑
        }

        int[][] dp = new int[houseCount][3]; // dp[i][j] = i번째 집을 j색으로 칠할 때 최소 비용

        // 첫 번째 집은 비용 그대로
        dp[0][0] = cost[0][0]; // 빨강
        dp[0][1] = cost[0][1]; // 초록
        dp[0][2] = cost[0][2]; // 파랑

        // 두 번째 집부터 계산
        for (int i = 1; i < houseCount; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); // 현재 빨강 → 이전 초록, 파랑 중 작은 값
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); // 현재 초록 → 이전 빨강, 파랑 중 작은 값
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]); // 현재 파랑 → 이전 빨강, 초록 중 작은 값
        }

        // 마지막 집에서 가장 작은 값을 출력
        int last = houseCount - 1;
        int answer = Math.min(dp[last][0], Math.min(dp[last][1], dp[last][2]));
        System.out.println(answer);
    }
}
