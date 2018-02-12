package etc;

import static org.junit.Assert.assertEquals;

/**
 * Charlemagne, the King Of Frankia, is considering building some castles on the border with Servia.
   The border is divided into N segments.The King knows the height of the terrain in each segment of the border.
   The height of each segment of terrain is stored in array A, with A[P] denoting the height of the P-th segment of the border.
   The King has decided to build a castle on top of every hill and in the bottom of every valley.
   Let [P..Q] denote a group of consecutive segments from P to Q inclusive such that (0 <= P <= Q <= N-1).
   segments [P..Q] form a hill or a valley if all the following conditions are satisfied.
    ● The terrain height of each segment from P to Q is the same (A[P] = A[P+1] = ... = A[Q]);
    ● If P > 0 then A[P-1] < A[P] (for a hill) or A[P-1] > A[P] (for valley);
    ● If Q < N-1 then A[Q+1] <A[Q] (for a hill) or A[Q+1] > A[Q] (for a valley);
   That is, a hill is higher than its surroundings and a valley is lower than its surroundings.
   Note that if the surroundings on either side of the hill or valley don't exist.
   (i.e. at the edges of the area under consideration, where P = 0 or Q = N-1), then the condition is considered satisfied for that
   side of the hill/valley.
   The king is wondering how many castles is he going to build. Can you help him?
   For example, consider the following array A=[2,2,3,4,3,3,2,2,1,1,2,5]
 */
public class ValleyHill {

    public static void main(String...args) {
        assertEquals(4, solution(new int[] {2,2,3,4,3,3,2,2,1,1,2,5}));
        assertEquals(6, solution(new int[] {2,2,3,4,3,3,2,2,1,1,2,5,3,3,5}));
        assertEquals(2, solution(new int[] {2,2,3,3}));
    }

    public static int solution(int[] A) {
        int N = A.length;

        if(N <= 1) {
            return N;
        }

        if(N == 2) {
            return A[0] == A[1] ? 1 : 2;
        }

        int hill = 0;
        int valley = 0;
        int P = 0;
        int Q;

        for(int i = 0; i < N; i++) {
            Q = i;

            if(A[P] != A[Q]) {
                P = Q;
            }

            if(Q < N - 1) {
                if(A[Q] < A[Q+1] && (P == 0 || A[P-1] > A[P])) {
                    valley++;
                } else if(A[Q] > A[Q+1] && A[P-1] < A[P]) {
                    hill++;
                }
            } else {
                if(A[P] > A[P-1]) {
                    hill++;
                }
            }
        }

        return hill + valley;
    }
}
