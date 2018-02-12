package codility.lesson04_Counting_Elements;

import static org.junit.Assert.assertEquals;

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:

 increase(X) − counter X is increased by 1,
 max counter − all counters are set to the maximum value of any counter.
 A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:

 if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 if A[K] = N + 1 then operation K is max counter.
 For example, given integer N = 5 and array A such that:

 A[0] = 3
 A[1] = 4
 A[2] = 4
 A[3] = 6
 A[4] = 1
 A[5] = 4
 A[6] = 4
 the values of the counters after each consecutive operation will be:

 (0, 0, 1, 0, 0)
 (0, 0, 1, 1, 0)
 (0, 0, 1, 2, 0)
 (2, 2, 2, 2, 2)
 (3, 2, 2, 2, 2)
 (3, 2, 2, 3, 2)
 (3, 2, 2, 4, 2)
 The goal is to calculate the value of every counter after all operations.

 Write a function:

 class Solution { public int[] solution(int N, int[] A); }
 that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.

 The sequence should be returned as:

 a structure Results (in C), or
 a vector of integers (in C++), or
 a record Results (in Pascal), or
 an array of integers (in any other programming language).
 For example, given:

 A[0] = 3
 A[1] = 4
 A[2] = 4
 A[3] = 6
 A[4] = 1
 A[5] = 4
 A[6] = 4
 the function should return [3, 2, 2, 4, 2], as explained above.

 Assume that:

 N and M are integers within the range [1..100,000];
 each element of array A is an integer within the range [1..N + 1].
 Complexity:

 expected worst-case time complexity is O(N+M);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 주어진 배열중에 N + 1 값이 counter 이며
 배열의 각 값에 해당하는 순서의 값을 1씩 증가시키다 counter 값을 만나면
 모든 행의 값을 max 값으로 설정하고 다시 1씩 증가시켜간다.
 */
public class MaxCounters {

    public static void main(String...args) {
        int[] result = solution(5, new int[] {3, 4, 4, 6, 1, 4, 4});

        for(int n : result) {
            System.out.print(n + " ");
        }

        // 3 2 2 4 2
    }

    public static int[] solution(int N, int[] A) {
        int[] arr = new int[N];
        int counter = 0;
        int max = 0;

        for(int K = 0; K < A.length; K++) {
            int X = A[K];

            if(X == N + 1) {
                counter = max;
            } else {
                int i = X - 1;

                if(counter > arr[i]) {
                    arr[i] = counter + 1;
                } else {
                    arr[i]++;
                }

                if(max < arr[i]) {
                    max = arr[i];
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(arr[i] < counter) {
                arr[i] = counter;
            }
        }

        return arr;
    }

}