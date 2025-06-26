package week_12;
import java.util.*;
public class BOJ_정수삼각형 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt(); // 삼각형의 줄 수
        int[][] triangle = new int[count][count]; // 삼각형을 저장할 배열
        int[][] maxSum = new int[count][count]; // 최대 합을 저장할 배열

        // 삼각형 값 입력 받기
        for (int i = 0; i < count; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        // 첫 번째 값은 그대로 복사
        maxSum[0][0] = triangle[0][0];

        // 두 번째 줄부터 마지막 줄까지 최대 합 계산
        for (int i = 1; i < count; i++) {
            for (int j = 0; j <= i; j++) {
                // 왼쪽 위에서 내려온 경우
                if (j > 0) {
                    maxSum[i][j] = Math.max(maxSum[i][j], maxSum[i - 1][j - 1] + triangle[i][j]);
                }
                // 오른쪽 위에서 내려온 경우
                if (j < i) {
                    maxSum[i][j] = Math.max(maxSum[i][j], maxSum[i - 1][j] + triangle[i][j]);
                }
            }
        }

        // 마지막 줄에서 가장 큰 값을 찾기
        int answer = 0;
        for (int i = 0; i < count; i++) {
            if (maxSum[count - 1][i] > answer) {
                answer = maxSum[count - 1][i];
            }
        }

        // 결과 출력
        System.out.println(answer);
    }

}
