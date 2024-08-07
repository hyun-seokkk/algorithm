import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, J;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        J = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = M;
        int ans = 0;

        for (int i = 0; i < J; i++) {
            st = new StringTokenizer(br.readLine());
            int apple = Integer.parseInt(st.nextToken());

            if(apple < start) {
                int move = start - apple;
                ans += move;
                start = apple;
                end -= move;
            } else if(apple > end) {
                int move = apple - end;
                ans += move;
                start += move;
                end = apple;
            }
        }
        System.out.println(ans);
    }
}