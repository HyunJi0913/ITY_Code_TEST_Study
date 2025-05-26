package week_08;

// PGS 네트워크
// 컴퓨터 A와 B가 직접 연결되어 있고, B와 C가 직접 연결되어 있을 때
// A와 C도 간접적으로 연결되어 있기에 정보 교환 가능
// 따라서 A, B, C는 모두 같은 네트워크 상에 존재

import java.util.LinkedList;
import java.util.Queue;

// 컴퓨터의 개수 n
// 연결에 대한 정보가 담긴 2차원 배열 computers
// 네트워크의 개수 return
public class PGS_Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        // 컴퓨터는 0부터 n-1 정수로 표현
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    } // end of solution()

    public static void bfs(int[][] computers, boolean[] visited, int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[index] = true;
        queue.add(index);

        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int i = 0; i < computers.length; i++){
                if (computers[curNode][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    } // end of bfs
}
