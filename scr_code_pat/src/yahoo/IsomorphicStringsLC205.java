package yahoo;

public class IsomorphicStringsLC205 {
    /*
The main idea is to store the last seen positions of current (i-th) characters in both strings.
 If previously stored positions are different then we know that the fact they’re occuring in
  the current i-th position simultaneously is a mistake. We could use a map for storing
  but as we deal with chars which are basically ints and can be used as indices we can do the whole thing with an array.



     */
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}
