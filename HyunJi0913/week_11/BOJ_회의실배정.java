package week_11;

import java.util.*;

public class BOJ_회의실배정 {

    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 회의 개수
        List<Meeting> schedule = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            schedule.add(new Meeting(start, end));
        }

        // 끝나는 시간을 기준으로 정렬, 같다면 시작시간 기준
        schedule.sort((a, b) -> {
            if (a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        });

        int count = 0;
        int lastEndTime = 0;

        for (Meeting m : schedule) {
            if (m.start >= lastEndTime) {
                count++;
                lastEndTime = m.end;
            }
        }

        System.out.println(count);
    }
}
