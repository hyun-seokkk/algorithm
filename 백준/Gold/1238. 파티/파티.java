import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int index;
        int distance;
        Node next;

        public Node(int index, int distance, Node next) {
            this.index = index;
            this.distance = distance;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    static ArrayList<Integer[]> distList = new ArrayList<>();
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Node[] graph = new Node[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, distance, graph[from]);
        }

        for (int i = 1; i <= N; i++) {
            Integer[] arr = new Integer[N + 1];
            Arrays.fill(arr, Integer.MAX_VALUE);
            distList.add(arr);
            dijkstra(i, graph);
        }

        int result = 0;

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, distList.get(i - 1)[X] + dijkstraToX(i, graph));
        }

        System.out.println(result);
    }

    public static void dijkstra(int start, Node[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, null));

        Integer[] dist = distList.get(start - 1);
        dist[start] = 0;

        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIndex = current.index;

            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;

            for (Node tmp = graph[currentIndex]; tmp != null; tmp = tmp.next) {
                int nextIndex = tmp.index;
                int newDist = dist[currentIndex] + tmp.distance;

                if (!visited[nextIndex] && dist[nextIndex] > newDist) {
                    dist[nextIndex] = newDist;
                    pq.offer(new Node(nextIndex, newDist, null));
                }
            }
        }
    }

    public static int dijkstraToX(int start, Node[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0, null));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIndex = current.index;

            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;

            for (Node tmp = graph[currentIndex]; tmp != null; tmp = tmp.next) {
                int nextIndex = tmp.index;
                int newDist = dist[currentIndex] + tmp.distance;

                if (!visited[nextIndex] && dist[nextIndex] > newDist) {
                    dist[nextIndex] = newDist;
                    pq.offer(new Node(nextIndex, newDist, null));
                }
            }
        }

        return dist[start];
    }
}