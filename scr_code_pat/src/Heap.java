/**
 * Created by yizhaoyang on 6/17/17.
 */
public class Heap {

    // 画图

    private int[] arr;
    private int size;
    public Heap(){

    }


    public void resize(){

    }

    public boolean isEmpty(){
        return size <= 1;
    }

    // Log(n)
    public void insert(int val){
        if(size == arr.length - 1){
            resize();
        }
        size++;
        int i = lookUp(size,val);
        arr[i] = val;
    }

    public int length(){
        return this.size;
    }

    // Log(n)
    // return the deleted value
    public int deleteMin() throws Exception {
        if(isEmpty()){
            throw new Exception("the array is empty");
        }
        int ans = arr[1];
        int hole = lookDown(1,arr[size]);
        arr[hole] = arr[size];
        size--;
        return ans;
    }


    public int lookUp(int hole, int val){
        while(hole > 1 && arr[hole/ 2] > val){
            arr[hole] = arr[hole / 2];
            hole = hole / 2;
        }
        return hole;
    }

    public int lookDown(int hole, int val){

        while(hole * 2 <= this.size){ // check the next level
            int left = hole * 2, right = hole * 2 +1;
            int target = 0;
            if(right > size|| arr[left] < arr[right]){
                target = left;
            }else {
                target = right;
            }
            if(val > arr[target]){
                arr[hole] = arr[target];
                hole = target;
            }else{
                break;
            }
        }
        return hole;

    }

    public void buildHeap(){
        for(int i = size / 2; i > 0; i --){
            int val = arr[i];
            int hole = lookDown(i,val);
            arr[hole] = val;
        }
    }




}
