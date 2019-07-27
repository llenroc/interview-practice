package yahoo;

public class CountPrimesLC204 {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count =0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                count++;
                for(int j = 2; j * i < n; j++){
                    notPrime[j * i] = true;
                }
            }
        }
        return count;
    }
}
