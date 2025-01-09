import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int N, M;

    static class Point{
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];
        boolean visited[][] = new boolean[N][M];
        int resMap[][] = new int[N][M];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if(now == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startX, startY, 0));
        resMap[startX][startY] = 0;
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int cnt = now.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                resMap[nx][ny] = cnt+1;

                queue.offer(new Point(nx, ny, cnt + 1));
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print((!visited[i][j] & map[i][j] == 1) ? -1 + " " : resMap[i][j] + " ");
            }
            System.out.println();
        }
    }

}