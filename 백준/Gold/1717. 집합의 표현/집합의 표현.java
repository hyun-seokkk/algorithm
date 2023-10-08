import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m, parents[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        parents = new int[n+1];

        for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
        
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int type = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(type == 0) {
        		union(a, b);
        	} else if(type == 1) {
        		System.out.println((isSameParent(a, b)) ? "YES" : "NO");;
        	}
        	
		}
        
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		int rx = find(parents[x]);
		return parents[x] = rx;
		
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) {
			parents[y]=x;
		}
		else {
			parents[x] =y;
		}
	}
	
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x == y) {
            return true;
        }
 
        return false;
    }

}