import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer> > rooms) {
        int i, p, rn, n = rooms.size();
        boolean[] visited = new boolean[n];
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            p = q.poll();
            rn = rooms.get(p).size();
            for (i = 0; i < rn; i++) {
                if (!visited[rooms.get(p).get(i)]) {
                    q.offer(rooms.get(p).get(i));
                    visited[rooms.get(p).get(i)] = true;
                }
            }
        }
        boolean res = true;
        for (i = 0; i < n; i++) {
            res = res && visited[i];
        }
        return res;
    }
}