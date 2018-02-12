package baekjoon;

import java.util.Scanner;

/**
 n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. (각각의 동전은 몇 개라도 사용할 수 있다.)

 입력
 첫째줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다.

 출력
 첫째 줄에 경우의 수를 출력한다. 경우의 수는 2^31보다 작다.

 https://www.acmicpc.net/problem/2293
 */
public class CoinCount {

    public static void main(String...args) {
        new CoinCount().solution();
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int amount = sc.nextInt();

        int[] coin = new int[n];
        int[] dp = new int[amount+1];

        for(int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        dp[0] = 1;

        for(int i = 0; i < coin.length; i++) {
            for(int j = coin[i]; j <= amount; j++) {
                dp[j] += dp[j-coin[i]];
            }
        }

        System.out.println(dp[amount]);
    }
}