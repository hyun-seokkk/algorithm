import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        ArrayDeque<String> stack = new ArrayDeque<>();
        int gwalhoCnt = 0;

        for (String s : arr) {

            if(s.equals("(")) {
                stack.push(s);
            } else if(s.equals(")")) {
                gwalhoCnt--;
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    System.out.print(stack.pop());
                }
                stack.pop();
            } else if (isAddOrSub(s) || isMulOrDiv(s)) {
                while (!stack.isEmpty() && priority(s) <= priority(stack.peek())) {
                    System.out.print(stack.pop());
                }
                stack.push(s);
            } else {
                System.out.print(s);
            }

        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static int priority(String s) {
        if (isAddOrSub(s)) {
            return 1;
        } else if (isMulOrDiv(s)) {
            return 2;
        }
        return 0;
    }

    public static boolean isAddOrSub(String s) {
        return "+".equals(s) || "-".equals(s);
    }

    public static boolean isMulOrDiv(String s) {
        return "*".equals(s) || "/".equals(s);
    }
}