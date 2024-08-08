import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, map[][], distMap[][];
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    static class Node implements Comparable<Node>{

        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;
        while (true) {
            cnt++;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            distMap = new int[N][N];
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distMap[i][j] = INF;
                }
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra(new Node(0, 0, map[0][0]));
            sb.append("Problem " + cnt + ": " + distMap[N-1][N-1] + "\n");
        }
        System.out.println(sb.toString());
    }

    static void dijkstra(Node start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(start);
        distMap[0][0] = start.distance;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int dist = now.distance;
            int x = now.x;
            int y = now.y;

            if(distMap[x][y] < dist) continue; // 이미 최소값이면 방문한것

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                int cost = dist + map[nx][ny];
                if(distMap[nx][ny] > cost) {
                    distMap[nx][ny] = cost;
                    pq.offer(new Node(nx, ny, cost));
                }
            }
        }
    }
}