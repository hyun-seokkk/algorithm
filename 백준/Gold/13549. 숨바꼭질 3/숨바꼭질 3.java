import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, K, arr[], distance[];
    static final int INF = Integer.MAX_VALUE;
    static int[] steps = {-1, 1, 2};

    static class Node implements Comparable<Node> {

        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[200001];
        distance = new int[200001];
        Arrays.fill(distance, INF);

        dijkstra(new Node(N, 0));
        System.out.println(distance[K]);
    }

    private static void dijkstra(Node start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(start);
        distance[N] = start.cost;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int cost = now.cost;
            int idx = now.index;

            if(distance[idx] < cost) continue;

            for (int i = 0; i < 3; i++) {
                int nIdx = 0;
                if(i == 2) {
                    nIdx = idx * steps[i];
                } else {
                    nIdx = idx + steps[i];
                }

                if (nIdx < 0 || nIdx > 200000) continue;
                int nCost = i == 2 ? cost : cost + 1;
                if(distance[nIdx] > nCost) {
                    pq.offer(new Node(nIdx, nCost));
                    distance[nIdx] = nCost;
                }
            }

        }
    }
}