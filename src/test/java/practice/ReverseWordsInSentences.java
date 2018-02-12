package practice;

import org.junit.Assert;

/**
 * 단어로 구성된 문자열 반전
 */
public class ReverseWordsInSentences {

    public static void main(String...args) {
        System.out.println(solution("This is a Career Monk String"));
        Assert.assertEquals("String Monk Career a is This", solution("This is a Career Monk String"));
    }

    public static String solution(String A) {
        int N = A.length();
        char[] arr = A.toCharArray();

        revers(arr, 0, N - 1);

        for(int i = 0; i < N; i++) {
            char ch = arr[i];
            int startIndex = i;

            if(ch != ' ') {
                while(i < N && arr[i] != ' ') {
                    i++;
                }

                i--;
                revers(arr, startIndex, i);
            }
        }

        return new String(arr);
    }

    public static void revers(char[] arr, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            char temp = arr[endIndex];
            arr[endIndex] = arr[startIndex];
            arr[endIndex] = arr[startIndex];
            arr[startIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

}