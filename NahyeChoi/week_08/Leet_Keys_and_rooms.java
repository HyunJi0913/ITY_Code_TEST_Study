package week_08;

import java.util.*;

public class Leet_Keys_and_rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.put(0, true);
        for (int key : rooms.get(0)) {
            queue.offer(key);
        }

        while (!queue.isEmpty()) {
            int key = queue.poll();

            if (!visited.containsKey(key)) {
                visited.put(key, true);
                for (int next : rooms.get(key)){
                    queue.offer(next);
                }
            }
        }

        if (visited.size() < rooms.size()) return false;
        else return true;
    }
}
