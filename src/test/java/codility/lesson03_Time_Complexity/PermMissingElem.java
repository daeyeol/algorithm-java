package codility.lesson03_Time_Complexity;

import static org.junit.Assert.assertEquals;

/**
 * A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

 Your goal is to find that missing element.

 Write a function:

 class Solution { public int solution(int[] A); }
 that, given a zero-indexed array A, returns the value of the missing element.

 For example, given array A such that:

 A[0] = 2
 A[1] = 3
 A[2] = 1
 A[3] = 5
 the function should return 4, as it is the missing element.

 Assume that:

 N is an integer within the range [0..100,000];
 the elements of A are all distinct;
 each element of array A is an integer within the range [1..(N + 1)].
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).

 연속적으로 입력된 배열의 수 중에 누락된 수 찾기
 */
public class PermMissingElem {

    public static void main(String...args) {
        assertEquals(4, solution(new int[] { 2, 3, 1, 5 }));
        assertEquals(6, solution(new int[] { 2, 3, 1, 5, 4, 7 }));
        assertEquals(3, solution(new int[] { 1, 2, 4, 5, 6, 7 }));

        int length = 100000;
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }

        arr[1] = 100001;
        assertEquals(2, solution(arr));
    }

    public static int solution(int[] A) {
        long N = A.length + 1;
        long sum = N * (N + 1) / 2;
        long temp = 0;

        for(int a : A) {
            temp += a;
        }

        return (int)(sum - temp);
    }

}