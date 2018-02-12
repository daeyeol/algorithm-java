package codility.lesson06_Sorting;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

 We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

 The figure below shows discs drawn for N = 6 and A as follows:

 A[0] = 1
 A[1] = 5
 A[2] = 2
 A[3] = 1
 A[4] = 4
 A[5] = 0


 There are eleven (unordered) pairs of discs that intersect, namely:

 discs 1 and 4 intersect, and both intersect with all the other discs;
 disc 2 also intersects with discs 0 and 3.
 Write a function:

 class Solution { public int solution(int[] A); }
 that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

 Given array A shown above, the function should return 11, as explained above.

 Assume that:

 N is an integer within the range [0..100,000];
 each element of array A is an integer within the range [0..2,147,483,647].
 Complexity:

 expected worst-case time complexity is O(N*log(N));
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 그림 설명
 https://codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/

 각 원판의 끼리 겹치는 경우의 수
 */
public class NumberOfDiscIntersections {

    public static void main(String... args) {
        assertEquals(11, solution(new int[] {1, 5, 2, 1, 4, 0}));
    }

    public static int solution(int[] A) {
        class Disc
        {
            public int index;
            public long right;
            public long left;
            public long width;
        }

        int N = A.length;
        Disc[] discs = new Disc[N];

        for(int i = 0; i < N; i++) {
            Disc disc = new Disc();
            disc.index = i;
            disc.left = i - A[i];
            disc.right = i + A[i];
            disc.width = A[i] * 2;
            discs[i] = disc;
        }

        Arrays.sort(discs, new Comparator<Disc>() {
            @Override
            public int compare(Disc o1, Disc o2) {
                return o1.width > o2.width ? 1 : -1;
            }
        });

        int count = 0;

        for(int i = 0; i < N; i++) {
            Disc d1 = discs[i];

            for(int j = i + 1; j < N; j++) {
                Disc d2 = discs[j];

                if((d1.right <= d2.right && d1.right >= d2.left) ||
                        (d1.left >= d2.left && d1.left <= d2.right)) {
                    count++;
                }
            }
        }

        return count;
    }
}