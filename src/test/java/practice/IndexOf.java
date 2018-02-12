package practice;

import static org.junit.Assert.assertEquals;

public class IndexOf {

    public static void main(String...args) {
        assertEquals(0, solution(123456, 12));
        assertEquals(5, solution(23434634, 6));
        assertEquals(2, solution(5464562, 645));
        assertEquals(4, solution(345655, 55));
        assertEquals(-1, solution(23456457, 235));
    }

    public static int solution(int A, int B) {
        String SA = String.valueOf(A);
        String SB = String.valueOf(B);

        int N = SA.length();
        int M = SB.length();

        for(int i = 0; i < N; i++) {
            int j = 0;

            for(;j < M; j++) {
                if(SA.charAt(i + j) != SB.charAt(j)) {
                    break;
                }
            }

            if(j == M) {
                return i;
            }
        }

        return -1;
    }

}