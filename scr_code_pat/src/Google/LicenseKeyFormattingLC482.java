package Google;

/**
 * Created by yizhaoyang on 6/20/17.
 */
public class LicenseKeyFormattingLC482 {
    public String licenseKeyFormatting(String S, int K) {
        String s= S.replace("-","");
        s = s.toUpperCase();
        int len = s.length();

        StringBuilder sb = new StringBuilder(s);

        for(int i = K; i < len; i = i + K){
            sb.insert(len - i,"-");
        }
        return sb.toString();
    }
}
