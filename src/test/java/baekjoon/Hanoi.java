package baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로  옮기려 한다.

 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.(중간 과정 역시 그래야함)
 이 작업을 수행하는데 필요한 이동순서를 출력하는 프로그램을 작성하라

 첫째 줄에 옮긴 횟수 K를 출력한다.

 두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.

 https://www.acmicpc.net/problem/11729
 */
public class Hanoi {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        new Hanoi().solution2(n);
    }

    public void solution(int n) {
        int count = (int) Math.pow(2, n) - 1;

        System.out.println(count);
        move(n, '1', '2', '3');
    }

    private void move(int n, char from, char by, char to) {
        if (n == 1) {
            System.out.println(from + " " + to);
        } else {
            move(n - 1, from, to, by);
            System.out.println(from + " " + to);
            move(n - 1, by, from, to);
        }
    }

    public void solution2(int n) {
        int count = (int) Math.pow(2, n) - 1;

        System.out.println(count);
        move2(n, 1, 2, 3);
    }

    public void move2(int n, int from, int by, int to) {
        Stack<Integer> stack = new Stack<>();

        while(true) {
            while(n > 1) {
                stack.push(to);
                stack.push(by);
                stack.push(from);
                stack.push(n);

                int temp = to;
                to = by;
                by = temp;

                n--;
            }

            System.out.println(from + " " + to);

            if(!stack.empty()) {
                n = stack.pop();
                from = stack.pop();
                by = stack.pop();
                to = stack.pop();

                System.out.println(from + " " + to);

                int temp = from;
                from = by;
                by = temp;

                n--;
            } else {
                break;
            }
        }
    }

}