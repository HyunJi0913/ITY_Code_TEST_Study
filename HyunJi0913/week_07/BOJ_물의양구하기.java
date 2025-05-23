package week_07;

import java.util.*;

public class BOJ_물의양구하기 {
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] now;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        now = new int[3]; // A, B, C 물의 양을 저장하는 배열

        now[0] = scan.nextInt();
        now[1] = scan.nextInt();
        now[2] = scan.nextInt();

        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) System.out.print(i + " ");
        }
    }

    public static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B; // 전체 물 양에서 A와 B를 뺀 것이 C

            for (int k = 0; k < 6; k++) { // A→B, A→C, B→A, B→C, C→A, C→B
                int[] next = {A, B, C};

                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;

                if (next[Receiver[k]] > now[Receiver[k]]) {
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
                    next[Receiver[k]] = now[Receiver[k]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}

class AB {
    int A;
    int B;

    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}
