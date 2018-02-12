package codility.lesson06_Sorting;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

 A[P] + A[Q] > A[R],
 A[Q] + A[R] > A[P],
 A[R] + A[P] > A[Q].
 For example, consider array A such that:

 A[0] = 10    A[1] = 2    A[2] = 5
 A[3] = 1     A[4] = 8    A[5] = 20
 Triplet (0, 2, 4) is triangular.

 Write a function:

 class Solution { public int solution(int[] A); }
 that, given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

 For example, given array A such that:

 A[0] = 10    A[1] = 2    A[2] = 5
 A[3] = 1     A[4] = 8    A[5] = 20
 the function should return 1, as explained above. Given array A such that:

 A[0] = 10    A[1] = 50    A[2] = 5
 A[3] = 1
 the function should return 0.

 Assume that:

 N is an integer within the range [0..100,000];
 each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 Complexity:

 expected worst-case time complexity is O(N*log(N));
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 배열이 triangle 조건에 부합하는 경우 1, 아니면 0
 */
public class Triangle {

    public static void main(String... args) {
        int arr[] = {10, 2, 5 , 1, 8, 20};
        assertEquals(1, solution(arr));
    }

    public static int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            int P = A[i];
            int Q = A[i + 1];
            int R = A[i + 2];

            if (((double)P + (double)Q) > R
                    && ((double)Q + (double)R)  > P
                    && ((double)R + (double)P)  > Q) {
                return 1;
            }
        }

        return 0;
    }
}
