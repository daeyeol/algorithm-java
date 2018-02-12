package codility.lesson04_Counting_Elements;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * This is a demo task.

 Write a function:

 class Solution { public int solution(int[] A); }
 that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

 For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

 Given A = [1, 2, 3], the function should return 4.

 Given A = [−1, −3], the function should return 1.

 Assume that:

 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [−1,000,000..1,000,000].
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 1보다 큰 연속된 정수 중에 누락된 수 찾기
 */
public class MissingInteger {

    public static void main(String...args) {
        int arr[] = {-1 , -3};
        assertEquals(1, solution(arr));
    }

    public static int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for(int n : A) {
            set.add(n);
        }

        for(int i = 1; i <= A.length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }

        return A.length + 1;
    }

}
