package programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P12978 {
    public int solution(int N, int[][] road, int K) {
        class Node implements Comparable<Node> {
            int idx;
            int cost;
            public Node(final int idx, final int cost) {
                this.idx = idx;
                this.cost = cost;
            }

            @Override
            public int compareTo(final Node o) {
                return Integer.compare(this.cost, o.cost);
            }
        }

        final int start = 1;
        int answer = 0;
        int[] dist = new int[N+1];
        for (int i=0; i<= N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        final ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i=0; i<= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i=0; i<road.length; i++) {
            int s = road[i][0];
            int e = road[i][1];
            int cost = road[i][2];

            graph.get(s).add(new Node(e, cost));
            graph.get(e).add(new Node(s, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        final boolean[] visit = new boolean[N + 1];
        visit[start] = true;

        while(!pq.isEmpty()) {
            final Node curNode = pq.poll();
            final ArrayList<Node> nextNodes = graph.get(curNode.idx);
            for (Node nextNode : nextNodes) {
                if (dist[nextNode.idx] > dist[curNode.idx] + nextNode.cost && (dist[curNode.idx] + nextNode.cost <= K)) {
                    // System.out.println(nextNode.idx);
                    dist[nextNode.idx] = dist[curNode.idx] + nextNode.cost;
                    visit[nextNode.idx] = true;
                    pq.offer(nextNode);
                }
            }
        }

        for (int i=0; i<visit.length; i++){
            if (visit[i]) {
                // System.out.println(i);
                answer++;
            }
        }

        return answer;
    }

    public int solution1(int N, int[][] road, int K) {
        int answer = 0;
        int[][] minimumMaps = new int[N+1][N+1];

        for (int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];

            if (minimumMaps[a][b] == 0 || minimumMaps[a][b] > road[i][2] ) {
                minimumMaps[a][b] = road[i][2];
                minimumMaps[b][a] = road[i][2];
            }
        }

        Set<Integer> sets = new HashSet<Integer>();
        bfs(1, 0, K, new boolean[road.length], sets, road, 0, N, minimumMaps);

        return sets.size();
    }

    private void bfs(int curNode, int curK, int k, boolean[] visited, Set<Integer> sets, int[][] road, int steps, int N, int[][] minimumMaps) {
        if (curK <= k) {
            sets.add(curNode);
        }

        if (curK > k) {
            return;
        }

        if (steps >= N) {
            return;
        }

        boolean isDone = false;

        for (int i=0; i<road.length; i++) {
            if (!visited[i]) {
                if (road[i][0] == curNode && minimumMaps[road[i][0]][road[i][1]] == road[i][2]) {
                    visited[i] = true;
                    bfs(road[i][1], curK+road[i][2], k, visited, sets, road, steps+1, N, minimumMaps);
                    visited[i] = false;
                }

                if (road[i][1] == curNode && minimumMaps[road[i][0]][road[i][1]] == road[i][2]) {
                    visited[i] = true;
                    bfs(road[i][0], curK+road[i][2], k, visited, sets, road, steps+1, N, minimumMaps);
                    visited[i] = false;
                }
            }
        }

    }
}
