package week_10;

public class PGS_연속된부분수열의합 {
    //기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
    //부분 수열의 합은 k입니다.
    //합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
    //길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
    class Solution {
        public int[] solution(int[] sequence, int k) {
            // 가장 짧은 구간의 [start, end] 인덱스를 저장할 곳
            // 초기값은 가능한 가장 긴 구간으로 설정해 놓음
            // 정답 범위의 초기값을 (0, 1,000,000)으로 설정
            int[] answer = {0, 1_000_000};

            int sum = 0; // 구간 합
            int start = 0; // 시작 인덱스

            for (int end = 0; end < sequence.length; end++) {
                // 끝 인덱스 값을 더해서 현재 구간 합 구하기
                sum += sequence[end];

                // sum이 k보다 크면, 시작 인덱스 이동
                while (sum > k) {
                    sum -= sequence[start];
                    start++; // 시작 인덱스 증가
                }

                // 만약 sum과 k가 일치하면
                if (sum == k) {
                    // 현재 윈도우 길이가 answer에 저장된 것보다 짧으면 갱신
                    if ((end - start) < answer[1] - answer[0]) {
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
            }
            return answer;
        }
    }
}
