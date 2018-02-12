package codility.lesson10_Prime_and_composite_numbers;

import static org.junit.Assert.assertEquals;

/**
 * An integer N is given, representing the area of some rectangle.

 The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

 The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

 For example, given integer N = 30, rectangles of area 30 are:

 (1, 30), with a perimeter of 62,
 (2, 15), with a perimeter of 34,
 (3, 10), with a perimeter of 26,
 (5, 6), with a perimeter of 22.
 Write a function:

 class Solution { public int solution(int N); }

 that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

 For example, given an integer N = 30, the function should return 22, as explained above.

 Assume that:

 N is an integer within the range [1..1,000,000,000].
 Complexity:

 expected worst-case time complexity is O(sqrt(N));
 expected worst-case space complexity is O(1).

 직사각형의 최소 둘레 찾기

 */
public class MinPerimeterRectangle {

    public static void main(String... args) {
        assertEquals(22, solution(30));
    }

    public static int solution(int N) {
        int min = 2 * (1 + N);

        for (int A = 2; A <= Math.sqrt(N); A++)
        {
            if (N % A == 0)
            {
                int B = N / A;

                int perimeter = 2 * (A + B);
                min = Math.min(min, perimeter);
            }
        }

        return min;
    }

}