package yahoo;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length(), n = b.length(), carry = 0;
        int i = m - 1, j = n - 1;
        while( i >= 0 || j >= 0){
            int sum = 0;
            if(i >= 0) sum+= a.charAt(i) - '0';
            if(j >= 0) sum += b.charAt(j) - '0';
            i--;
            j--;
            sum += carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if(carry != 0){
            sb.append(1);
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
