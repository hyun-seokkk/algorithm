import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = N-1;

        long minVal = Long.MAX_VALUE;
        long solS = 0;
        long solE = 0;

        while(start < end) {
            long sum = arr[start] + arr[end];
            if(Math.abs(sum) < minVal) {
                minVal = Math.abs(sum);
                solS = arr[start];
                solE = arr[end];
            }
            if(sum >= 0) end--;
            else start++;
        }
        System.out.printf("%d %d", solS, solE);
    }
}