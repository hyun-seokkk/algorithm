import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, nums[], sel[];
    static boolean v[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        sel = new int[M];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        solution(0, 0);
        System.out.println(sb);
    }

    private static void solution(int idx, int k) {
        if(k == M) {
            for(int ele : sel) {
                sb.append(ele + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            if(!v[i]){
                sel[k] = nums[i];
                v[i] = true;
                solution(i, k+1);
                v[i] = false;
            }
        }

    }
}