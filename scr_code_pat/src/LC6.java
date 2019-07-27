/**
 * Created by yizhaoyang on 9/10/17.
 */
public class LC6 {

    public static String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
        StringBuilder strBuilder = new StringBuilder();
        int borderRowStep = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            if (i == 0 || i == nRows - 1) {
                for (int j = i; j < s.length(); j = j + borderRowStep) {
                    strBuilder.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                int insideRowLargeStep = 2 * (nRows - 1 - i);
                int insideRowSmallStep = borderRowStep - insideRowLargeStep;
                while (j < s.length()) {
                    strBuilder.append(s.charAt(j));
                    if (flag)
                        j = j + insideRowLargeStep;
                    else
                        j = j + insideRowSmallStep;
                    flag = !flag;
                }
            }
        }
        return strBuilder.toString();

    }

    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSKU";
        System.out.println("Result is " + convert(s,4));
    }
}
