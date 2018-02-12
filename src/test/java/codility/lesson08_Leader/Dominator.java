package codility.lesson08_Leader;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * A zero-indexed array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

 For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
 The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

 Write a function

 class Solution { public int solution(int[] A); }
 that, given a zero-indexed array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

 Assume that:

 N is an integer within the range [0..100,000];
 each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
 the function may return 0, 2, 4, 6 or 7, as explained above.

 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).

 배열에 출현하는 값의 개수가 배열의 절반 이상인 값의 인덱스
 */
public class Dominator {

    public static void main(String...args) {
        int[] arr = new int[] {3, 4, 3, 2, 3, -1, 3, 3};
        assertEquals(0, solution(arr));
    }

    public static int solution(int[] A) {
        int N = A.length;

        if (N > 100000) {
            return -1;
        }

        if(A.length == 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int dominator = -1;
        int halfCount = N / 2;

        for(int i = 0; i < N; i++) {
            int a = A[i];

            if(!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                int count = map.get(a) + 1;
                map.put(a, count);

                if(count > halfCount) {
                    dominator = i;
                    break;
                }
            }
        }

        return dominator;
    }
}
