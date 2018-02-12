package codility.lesson08_Leader;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * A non-empty zero-indexed array A consisting of N integers is given.

 The leader of this array is the value that occurs in more than half of the elements of A.

 An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

 For example, given array A such that:

 A[0] = 4
 A[1] = 3
 A[2] = 4
 A[3] = 4
 A[4] = 4
 A[5] = 2
 we can find two equi leaders:

 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 The goal is to count the number of equi leaders.

 Write a function:

 class Solution { public int solution(int[] A); }
 that, given a non-empty zero-indexed array A consisting of N integers, returns the number of equi leaders.

 For example, given:

 A[0] = 4
 A[1] = 3
 A[2] = 4
 A[3] = 4
 A[4] = 4
 A[5] = 2
 the function should return 2, as explained above.

 Assume that:

 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 두 개의 배열로 나뉘었을 때 같은 수로 각 출현 빈도수가 과반수 이상인 경우의 수
 */
public class EquiLeader {

    public static void main(String...args) {
        assertEquals(2, solution(new int[] {4, 3, 4, 4, 4, 2}));
        assertEquals(0, solution(new int[] {1, 2}));
    }

    public static int solution(int[] A) {
        int N = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int leader = A[0];

        for (int n : A)
        {
            if (!map.containsKey(n))
            {
                map.put(n, 1);
            }
            else
            {
                map.put(n, map.get(n) + 1);

                if (leader != n && map.get(leader) < map.get(n))
                {
                    leader = n;
                }
            }
        }

        if (map.get(leader) <= N / 2)
        {
            return 0;
        }

        int leftLeaders = 0;
        int rightLeader = map.get(leader);
        int leftCount = 0;
        int rightCount = N;
        int leaders = 0;

        for (int i = 0; i < N - 1; i++)
        {
            if (A[i] == leader)
            {
                leftLeaders++;
                rightLeader--;
            }

            leftCount++;
            rightCount--;

            if (leftLeaders > leftCount / 2 && rightLeader > rightCount / 2)
            {
                leaders++;
            }
        }

        return leaders;
    }

}