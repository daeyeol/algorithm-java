package etc;

/**
   1
   2
   F
   4
   B
   F
   W
   8
   F
   B
   11
   12
   13
   W
   FB
 */
public class Multiple {

    public static void main(String...args) {
        solution(105);
    }

    public static void solution(int N) {
        String str = null;

        for(int i = 1; i <= N; i++) {
            str = "";

            if(i % 3 == 0) {
                str = "F";
            }

            if(i % 5 == 0) {
                str += "B";
            }

            if(i % 7 == 0) {
                str += "W";
            }

            if(str == "") {
                str = String.valueOf(i);
            }

            System.out.println(str);
        }
    }

}