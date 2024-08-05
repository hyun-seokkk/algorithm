import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, res, cnt;
    static int dx[] = {0,0,-1,1,}, dy[] = {1,-1,0,0}, map[][];
    static char colorMap[][];

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        colorMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            String now = br.readLine();
            for (int j = 0; j < N; j++) {
                colorMap[i][j] = now.charAt(j);
            }
        }
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] > 0) continue;
                cnt++;
                bfs(i, j, colorMap[i][j]);
            }
        }
        System.out.print(cnt+" ");
        cnt = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] > 0) continue;
                cnt++;
                bfs2(i, j, colorMap[i][j]);
            }
        }
        System.out.println(cnt);


    }

    private static void bfs2(int x, int y, char nowColor) {
        ArrayDeque<Point> q = new ArrayDeque();
        q.offer(new Point(x, y));
        map[x][y] = cnt;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || nx>=N || ny<0|| ny>=N) continue;
                char nColor = colorMap[nx][ny];
                if(map[nx][ny] > 0) continue;
                if(nowColor == 'R' || nowColor == 'G') {
                    if(nColor == 'B') continue;
                } else {
                    if(nowColor != nColor) continue;
                }
                map[nx][ny] = cnt;
                q.offer(new Point(nx, ny));
            }

        }
    }

    private static void bfs(int x, int y, char nowColor) {
        ArrayDeque<Point> q = new ArrayDeque();
        q.offer(new Point(x, y));
        map[x][y] = cnt;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || nx>=N || ny<0|| ny>=N) continue;
                if(colorMap[nx][ny] != nowColor || map[nx][ny] > 0) continue;
                map[nx][ny] = cnt;
                q.offer(new Point(nx, ny));
            }

        }

    }
}