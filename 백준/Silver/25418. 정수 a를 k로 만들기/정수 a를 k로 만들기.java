import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int memo[] = new int[K+1];
        memo[A+1] = 1;

        for (int i = A+2; i <= K; i++) {
            memo[i] = memo[i-1] + 1;
            if(i%2==0 && i/2>=A) {
                memo[i] = Math.min(memo[i/2] + 1, memo[i]);
            }
        }
        System.out.println(memo[K]);

    }
}