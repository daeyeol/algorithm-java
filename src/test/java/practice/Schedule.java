package practice;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Schedule {

    public static void main(String...args) {
        assertEquals(5, solution("abbcdcad", "abcd"));
        assertEquals(-1, solution("aaaaaaaa", "abcd"));
        assertEquals(-1, solution("aaabbbaaaaac", "abcd"));
        assertEquals(9, solution("aaaabbbccccdddd", "abcd"));
        assertEquals(4, solution("abcdabcd", "abcd"));
        assertEquals(6, solution("bbbcccaddda", "abcd"));
    }

    public static int solution(String A, String B) {
        int N = A.length();
        int M = B.length();
        int day = Integer.MAX_VALUE;

        Set<Character> set = new HashSet<>();
        char[] arr = A.toCharArray();

        for(int i = 0; i < N - M; i++) {
            set.add(arr[i]);

            for(int j = i+1; j < N; j++) {
                set.add(arr[j]);

                if (set.size() == M) {
                    day = Math.min(day, j-i+1);
                    set.clear();
                    break;
                }
            }
        }

        return day == Integer.MAX_VALUE ? -1 : day;
    }

}