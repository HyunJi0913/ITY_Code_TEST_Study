package week_09;
import java.util.*;

public class PG_블록이동하기 {
    static class Node {
        int x, y, time;
        boolean usedShoes; // 신발 사용 여부

        Node(int x, int y, int time, boolean usedShoes) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.usedShoes = usedShoes;
        }
    }

    public int solution(int n, int m, int[][] hole) {
        boolean[][] trap = new boolean[n + 1][m + 1]; // 함정 표시
        for (int[] h : hole) {
            trap[h[0]][h[1]] = true;
        }

        boolean[][][] visited = new boolean[n + 1][m + 1][2]; // [x][y][0 or 1] → 신발 사용 여부

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1, 0, false));
        visited[1][1][0] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == n && cur.y == m) return cur.time;

            // 1. 일반 이동 (1칸)
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if (!trap[nx][ny] && !visited[nx][ny][cur.usedShoes ? 1 : 0]) {
                        visited[nx][ny][cur.usedShoes ? 1 : 0] = true;
                        queue.add(new Node(nx, ny, cur.time + 1, cur.usedShoes));
                    }
                }
            }

            // 2. 신비로운 신발로 2칸 이동 (한 번만 가능)
            if (!cur.usedShoes) {
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d] * 2;
                    int ny = cur.y + dy[d] * 2;

                    if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                        if (!visited[nx][ny][1]) {
                            // 중간 칸이 함정이든 말든 넘을 수 있음
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, cur.time + 1, true));
                        }
                    }
                }
            }
        }

        return -1; // 도달 불가
    }
}
