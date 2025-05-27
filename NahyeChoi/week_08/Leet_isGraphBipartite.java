package week_08;

import java.util.LinkedList;
import java.util.Queue;

public class Leet_isGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] set = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                visited[i] = true;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int cur = queue.remove();

                    for (int next : graph[cur]) {
                        if (!visited[next]) {
                            set[next] = !set[cur];
                            visited[next] = true;
                            queue.add(next);
                        } else {
                            if (set[cur] == set[next]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
