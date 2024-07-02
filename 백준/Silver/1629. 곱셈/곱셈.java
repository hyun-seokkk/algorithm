import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long A,B,C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long res = 1;

        while(B > 0) {
            if(B%2 == 1) {
                res = (res * A) % C;
            }
            A = ((A%C) * (A%C)) % C;
            B /= 2;

        }
        System.out.println(res);

    }

}