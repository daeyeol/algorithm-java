package codility.lesson04_Counting_Elements;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * A non-empty zero-indexed array A consisting of N integers is given.

 A permutation is a sequence containing each element from 1 to N once, and only once.

 For example, array A such that:

 A[0] = 4
 A[1] = 1
 A[2] = 3
 A[3] = 2
 is a permutation, but array A such that:

 A[0] = 4
 A[1] = 1
 A[2] = 3
 is not a permutation, because value 2 is missing.

 The goal is to check whether array A is a permutation.

 Write a function:

 class Solution { public int solution(int[] A); }
 that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.

 For example, given array A such that:

 A[0] = 4
 A[1] = 1
 A[2] = 3
 A[3] = 2
 the function should return 1.

 Given array A such that:

 A[0] = 4
 A[1] = 1
 A[2] = 3
 the function should return 0.

 Assume that:

 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [1..1,000,000,000].
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 배열의 값이 순열인지 확인. 맞으면 1 아니면 0
 */
public class PermCheck {

    public static void main(String...args) {
        assertEquals(0, solution(new int[] {4, 1, 3}));
        assertEquals(1, solution(new int[] {4, 1, 3, 2}));
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int a : A) {
            if(a > A.length) {
                return 0;
            }

            if(map.containsKey(a)) {
                return 0;
            } else {
                map.put(a, 0);
            }
        }

        return 1;
    }

}