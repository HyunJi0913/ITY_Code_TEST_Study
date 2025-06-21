package week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 수
        int[][] arr = new int[N][2]; // 회의 시작시간, 종료시간 저장할 배열
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        // 회의 종료 시간 기준으로 오름차순 (종료시간이 빠른 것부터)
        Arrays.sort(arr, (o1, o2) -> {
            // 만약 종료시간이 동일하면 시작시간 기준으로 오름차순 정렬
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        // 첫 번째 회의의 종료시간을 end에 저장
        int end = arr[0][1];
        int count = 1; // 첫 회의 포함하여 count

        for (int i = 1; i < N; i++) {
            // end에 저장된 시간보다 이후인 회의만 선택 가능
            if (end <= arr[i][0]) {
                count++; // count 증가
                end = arr[i][1]; // 현재 회의의 종료시간으로 변경
            }
        }

        System.out.println(count);
    }
}
