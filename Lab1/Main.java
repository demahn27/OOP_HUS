package Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File(args[0]));
            PrintWriter out = new PrintWriter(args[1]);

            while (sc.hasNext()) {
                int n = Integer.parseInt(sc.nextLine());
                int cnt = 0;
                String result = "[";
                for (int i = 1; i <= n; i++) {
                    if (isPerfect(i)) {
                        cnt++;
                        result = result + i + " ";
                    }
                }
                result.trim();
                result += "]";
                result = cnt + ", " + result;
                out.println(result);
            }

            sc.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPerfect(int n) {
        if (n < 1) return false;
        long sum = 1;

        for (long i = 2; i*i <= n; i++) {
            if (i * i == n) sum += i;
            else if (n % i == 0) {
                sum += i + n / i;
            }
        }

        return sum == n && sum != 1;
    }
}
