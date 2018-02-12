package practice;

import static org.junit.Assert.assertEquals;

public class ReverseString {

    public static void main(String...args) {
        assertEquals("FEDCBA", solution("ABCDEF"));
        assertEquals("mhtirogla", solution("algorithm"));
        assertEquals("FEDCBA", solution2("ABCDEF"));
        assertEquals("mhtirogla", solution2("algorithm"));
    }

    public static String solution(String S) {
        int end = S.length() - 1;
        char[] arr = S.toCharArray();

        for(int i = 0; i < end; i++, end--) {
            char temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
        }

        return String.valueOf(arr);
    }

    public static String solution2(String S) {
        int end = S.length() - 1;
        char[] arr = S.toCharArray();

        for(int i = 0; i < end; i++, end--) {
            arr[i] ^= arr[end];
            arr[end] ^= arr[i];
            arr[i] ^= arr[end];
        }

        return String.valueOf(arr);
    }

}