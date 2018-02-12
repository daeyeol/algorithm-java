package baekjoon;

import java.util.Scanner;

/**
 n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.

 0	1	0	0
 0	1	1	1
 1	1	1	0
 0	0	1	0
 위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다.

 입력
 첫째 줄에 n, m(1 ≤ n, m ≤ 1,000)이 주어진다. 다음 n개의 줄에는 m개의 숫자로 배열이 주어진다.

 출력
 첫째 줄에 가장 큰 정사각형의 넓이를 출력한다.

 https://www.acmicpc.net/problem/1915
 */
public class LargeRectangle {

    public static void main(String... args) {
        new LargeRectangle().solution();
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = 0;
        int min = 0;

        int[][] array = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String temp = sc.next();

            for (int j = 1; j <= m; j++) {
                array[i][j] = temp.charAt(j - 1) - '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (array[i][j] == 1) {
                    min = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
                    dp[i][j] = min + 1;

                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.print(max * max);
    }

}