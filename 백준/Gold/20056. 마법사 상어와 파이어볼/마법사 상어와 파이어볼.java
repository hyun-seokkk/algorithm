import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    static List<FireBall>[][] map;

    static class FireBall {
        int r, c, m, s, d; // (r,c)위치, m질량, d방향, s속력

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "FireBall{" +
                    "r=" + r +
                    ", c=" + c +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        //파이어볼 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            FireBall now = new FireBall(r, c, m, s, d);
            map[r][c].add(now);
        }

        for (int cmd = 0; cmd < K; cmd++) {
            move();
            merge();
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].isEmpty()) continue;
                for (FireBall ele : map[i][j]) {
                    res += ele.m;
                }
            }
        }
        System.out.println(res);
    }

    private static void merge() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].size() >= 2) {
                    List<Integer> dList = new ArrayList<>();
                    int sumM = 0;
                    int sumS = 0;

                    for (FireBall ele : map[i][j]) {
                        sumM += ele.m;
                        sumS += ele.s;
                        dList.add(ele.d);
                    }

                    int newM = sumM / 5;
                    int newS = sumS / map[i][j].size();
                    map[i][j] = new ArrayList<>();
                    if (newM == 0) {
                        continue;
                    }
                    boolean isOdd = false;
                    boolean isEven = false;
                    for (int ele : dList) {
                        if (ele % 2 == 0) {
                            isEven = true;
                        } else {
                            isOdd = true;
                        }
                    }
                    if (isOdd && isEven) {
                        for (int k = 1; k <= 7; k += 2) {
                            map[i][j].add(new FireBall(i, j, newM, newS, k));
                        }
                    } else {
                        for (int k = 0; k <= 6; k += 2) {
                            map[i][j].add(new FireBall(i, j, newM, newS, k));
                        }
                    }
                }
            }
        }
    }

    private static void move() {
        List<FireBall>[][] newMap = new ArrayList[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                newMap[i][j] = new ArrayList<>();
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].isEmpty()) continue;
                for (FireBall fb : map[i][j]) {
                    int nr = (fb.r + dr[fb.d] * fb.s % N + N - 1) % N + 1;
                    int nc = (fb.c + dc[fb.d] * fb.s % N + N - 1) % N + 1;
                    newMap[nr][nc].add(new FireBall(nr, nc, fb.m, fb.s, fb.d));
                }
            }
        }
        map = newMap;
    }
}