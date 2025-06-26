package week_12;
import java.util.*;
public class BOJ_계단오르기게임 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt(); // 계단 개수

        int[] score = new int[count + 1];      // 계단 점수 저장 (1부터 시작)
        int[] maxScore = new int[count + 1];   // 최대 점수 저장

        for (int i = 1; i <= count; i++) {
            score[i] = scanner.nextInt();
        }

        // 기본값 설정
        maxScore[1] = score[1];

        if (count >= 2) {
            maxScore[2] = score[1] + score[2];
        }

        // DP로 최대 점수 구하기
        for (int i = 3; i <= count; i++) {
            maxScore[i] = Math.max(
                    maxScore[i - 2] + score[i],
                    maxScore[i - 3] + score[i - 1] + score[i]
            );
        }

        System.out.println(maxScore[count]);
    }
}
