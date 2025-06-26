package week_12;
import java.util.*;
public class BOJ_2xn타일링 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 가로 길이 n 입력

        int[] ways = new int[1001];  // 타일링 방법 수 저장 배열

        // 기본값 설정
        ways[1] = 1; // 2×1
        ways[2] = 2; // 2×2

        // 3 이상부터 점화식 적용
        for (int i = 3; i <= n; i++) {
            ways[i] = (ways[i - 1] + ways[i - 2]) % 10007;
        }

        // 결과 출력
        System.out.println(ways[n]);
    }
}
