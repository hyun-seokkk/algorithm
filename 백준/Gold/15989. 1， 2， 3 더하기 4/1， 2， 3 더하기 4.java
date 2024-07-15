import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[] dp = new int[n+1];
            dp[0] = 1;

            for (int i = 1; i <= 3; i++) {
                for (int j = i; j <= n; j++) {
                    dp[j] += dp[j - i];
                }
            }
            System.out.println(dp[n]);

        }

    }

}