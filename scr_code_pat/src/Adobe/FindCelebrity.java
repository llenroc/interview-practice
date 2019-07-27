package Adobe;

public class FindCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
        // 一直更新 candidate 直到 candidate谁也不认识
        for(int i = 0; i < n; i ++){
            if(knows(candidate,i)){
                candidate = i;
            }
        }
        // 重新检查 一遍 这个candidate有没有问题
        for(int i =0; i < n; i++){
            // candidte 认识人 和 有人不认识这个candidate
            if(i != candidate && (knows(candidate,i) || !knows(i,candidate))){
                return -1;
            }
        }
        return candidate;
    }



    private boolean knows(int a, int b){
        return false;
    }
}
