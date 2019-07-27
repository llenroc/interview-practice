package Microsoft;

public class LC168ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }


    public int titleToNumber(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            res = res * 26 +( s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
