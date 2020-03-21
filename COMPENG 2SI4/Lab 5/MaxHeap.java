public class MaxHeap {
    private Integer [] heap;
    private int sizeArr;
    private int sizeHeap;

    public MaxHeap (int arr){
        this.heap = new Integer[arr];
        this.sizeArr = arr;
        this.sizeHeap = 0;
    }

    public MaxHeap (Integer []array){
        this.sizeHeap = 0;
        this.sizeArr = array.length+1;
        this.heap = new Integer[this.sizeArr];

        for (int i:array){
            this.insert(i);
        }
    }


    public void insert (int n){

        if (this.sizeHeap==this.sizeArr){
            Integer [] newArr = new Integer[2*this.sizeArr];
            for (int i=0;i<this.sizeHeap;i++){
                newArr[i] = this.heap[i];
            }
            this.heap = newArr;
            this.sizeArr+=this.sizeArr;
        }

        this.heap[this.sizeHeap] = n;

        int par = this.sizeHeap;
        boolean breaker  = false;//Indicates when to close while 
        while (!breaker){
            if (this.heap[parent(par)] !=null){
                if (this.heap[parent(par)]<this.heap[par]){
                    swap(par,parent(par));//Swaps the parent with the larger child
                    par = parent(par);//Redefines the current node
                }
                else {
                    breaker = true;
                }
            }
            else {
                this.heap[parent(par)] = n;
                this.heap[par] = 0;
            }

        }
        this.sizeHeap++;
    }

    private int deleteMax(){
        int max = this.heap[0];
        this.heap[0] = this.heap[this.sizeHeap-1];
        this.sizeHeap--;
        this.heaped(0);
        return max;
    }

    private void heaped(int node){//Heaps up an indicated subtree at index "node"
        int left = 2*node+1;//Left child
        int right = 2*node+2;//Right child

        if (this.checkLeaf(node)) {//Checks if the current node is a leaf
            return;
        }

        if (this.heap[node]<this.heap[left]|| this.heap[node]<this.heap[right]){//If either of the children are greater than the parent
            if (this.heap[left]>this.heap[right]){//If the left child is greater than the right
                this.swap(node, left);//Swap the parent and left child
                this.heaped(left);//Recursively calls from the left child
            }
            else {
                this.swap(node, right);//Swap parent and right child
                this.heaped(right);//Recursively calls from the right child
            }
        }

    }

    public static void heapsort (Integer [] arr){
        MaxHeap mess = new MaxHeap(arr);
        int messSize = mess.sizeHeap;
        for (int i=0;i<messSize;i++){
            arr[i] = mess.deleteMax();
        }
    }

    public String toString (){
        String out = "";
        for (int i=0;i<this.sizeHeap;i++) {
            out += this.heap[i] + ", ";
        }
        return out;
    }

    public int getSize(){
        return this.sizeHeap;
    }
    public int getCapacity(){
        return this.sizeArr;
    }

    private int parent(int p){//Returns the parent of a certain node
        return (p-1)/2;
    }
    private void swap (int p1, int p2){//Swaps two elements at the inputted indexes
        int temp = heap[p1];
        heap [p1] = heap[p2];
        heap[p2] = temp;
    }

    private boolean checkLeaf(int node){//Verifies if the current node is a leaf
        if ((node>=this.sizeHeap/2)&&(node<=this.sizeHeap)){//Checks if the indexed node is at the last row and within the size of the heap
            return true;
        }
        else {
            return false;
        }
    }

}
