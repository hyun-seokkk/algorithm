import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String[] minNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        // 미리 계산해둘 최소값
        minNumber = new String[101];
        calculateMinNumbers();

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            // 최소값
            String minNum = minNumber[n];

            // 최대값
            StringBuilder maxNum = new StringBuilder();
            if (n % 2 == 1) { // 성냥개비 홀수일때 최초 7 한번 추가
                maxNum.append("7");
                n -= 3;
            }
            while (n > 0) {
                maxNum.append("1");
                n -= 2;
            }

            sb.append(minNum).append(" ").append(maxNum.toString()).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void calculateMinNumbers() {
        // 최소값 초기화
        minNumber[2] = "1";
        minNumber[3] = "7";
        minNumber[4] = "4";
        minNumber[5] = "2";
        minNumber[6] = "6";
        minNumber[7] = "8";
        minNumber[8] = "10";

        for (int i = 9; i <= 100; i++) {
            minNumber[i] = getMinCombination(i);
        }
    }

    private static String getMinCombination(int n) {
        String minValue = null;
        for (int i = 2; i <= 7; i++) { // 숫자 만들기 위해 필요한 성냥개비 개수
            if (n - i >= 2) { // 성냥 최소 2개 남아야함
                String current = minNumber[n - i] + getDigit(i);
                if (minValue == null || isSmaller(current, minValue)) {
                    minValue = current;
                }
            }
        }
        return minValue;
    }

    private static String getDigit(int matchsticks) {
        switch (matchsticks) {
            case 2: return "1";
            case 3: return "7";
            case 4: return "4";
            case 5: return "2";
            case 6: return "0"; // 두 자리 수 이상의 최소값을 위해 0 사용
            case 7: return "8";
            default: return "";
        }
    }

    private static boolean isSmaller(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() < b.length();
        }
        return a.compareTo(b) < 0;
    }
}