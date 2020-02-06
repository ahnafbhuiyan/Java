public class SLLSet {

    private int set;
    private SLLNode ref;

    public SLLSet() {
        this.ref = new SLLNode(0, null);
        this.set = 0;
    }

    public SLLSet(int[] sortedArray) {

        this.set = sortedArray.length;
        this.ref = new SLLNode(sortedArray[0], null);
        SLLNode x = this.ref;

        for (int i = 1; i < this.getSize(); i++) {
            x.next = new SLLNode(sortedArray[i], null);
            x = x.next;
        }

    }

    int getSize() {
        return this.set;
    }

    public SLLSet copy() {
        SLLSet x = new SLLSet();
        SLLNode head = x.ref;
        SLLNode y = this.ref;
        x.set = 1;


        while (y.next != null) {
            head.value = y.value;
            head.next = new SLLNode(y.next.value, null);
            head = head.next;
            y = y.next;
            x.set++;
        }
        x.ref  = this.ref;

        return x;
    }

    public boolean isIn(int v) {
        SLLNode x = this.ref;

        while (x!= null) {
            if (x.value == v) {
                return true;
            }
            x = x.next;
        }
        return false;
    }

    public void add(int v) {
        SLLNode x = this.ref;

        if (isIn(v) == true) {
            return;//If v is already in the set, then the function does nothing
        }
        else  if (x.value>v){
            this.ref = new SLLNode(v,x);
            this.set++;
            }
        else{
            while (x.next != null) {
                if (x.next.value>v) {//If v is smaller than the current x value, but less than the next x value, then it is inserted at that position
                    this.set++;
                    x.next = new SLLNode(v, x.next);
                    return;
                }
                x = x.next;
            }
                this.set++;
                x.next = new SLLNode(v, null);
                return;

        }
    }

    public void remove (int v) {
        SLLNode x = this.ref;

        if (isIn(v)) {
            while (x != null) {
                if (x.value == v) {
                    x.value = x.next.value;
                    x.next = x.next.next;
                    this.set--;
                    return;
                    }
                else if (x.next.value==v && x.next.next==null) {
                    x.next = null;
                    this.set--;
                    return;
                }
                x = x.next;
                }

            }
        }

    public SLLSet union (SLLSet s){

        SLLSet x  = this.copy();
        x.set = this.getSize() + s.getSize();
        SLLNode nodeT = this.ref;
        SLLNode z = s.ref;
        SLLNode xNode= x.ref;

        if (xNode.value>z.value){
            x.ref  = new SLLNode(z.value,x.ref);
        }

        while(z.next!=null && xNode.next!=null) {
            if (x.isIn(z.value)) {
                x.set--;
                z = z.next;
            }
            else if (xNode.next.value > z.value) {
                xNode.next = new SLLNode(z.value, xNode.next);
                z = z.next;
                xNode = xNode.next;
            }
            xNode = xNode.next;
        }
        if (xNode.next==null && xNode.value<z.value && !(x.isIn(z.value))){ System.out.println("Node loop3: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+xNode.next+ " " +xNode.value);
            xNode.next = new SLLNode(z.value,null);
            x.set++;
        }

        return x;


    }

    public SLLSet intersection (SLLSet s){
        int m = this.getSize() + s.getSize();
        SLLSet  inter = this.copy();
        inter.set = m;
        SLLNode nodeI = inter.ref;
        SLLNode nodeS = s.ref;
        /*
        while (nodeI.next!=null) {
            if (!s.isIn(nodeI.value)) {
                inter.remove(nodeI.value);
            }
            nodeI = nodeI.next;
        }
*/

            if (!inter.isIn(nodeS.value)){
                inter.remove(nodeS.value); //Removes an element if it is no in both "this" or "s"
            }
            if (!s.isIn(nodeI.value)){
                inter.remove(nodeI.value);
            }
            nodeI = nodeI.next;
            nodeS = nodeS.next;


        return inter;
    }


    public SLLSet difference(SLLSet s){
        SLLSet diff = new SLLSet();
        int size = 0;
        SLLNode nodeD = diff.ref;
        SLLNode nodeT = this.ref;
        SLLNode nodeS = s.ref;

        while(nodeT.next != null){
            nodeD.value = nodeT.value;
            nodeD.next = new SLLNode(0,null);
            size++;
            nodeD = nodeD.next;
            nodeT = nodeT.next;
        }
        diff.set = size;

        while (nodeS.next != null &&nodeD.next!=null){
            if (diff.isIn(nodeS.value)){
                diff.remove(nodeS.value);
            }
            nodeS = nodeS.next;
            nodeD = nodeD.next;
        }
        return diff;
    }

    public static SLLSet union( SLLSet[] sArray){
        SLLSet un = sArray[0];
        int len = sArray.length;

        for (int i=1; i<len;i++){
            un.union(sArray[i]);
        }

        return un;
    }

    public String toString(){
        String out =" ";
        SLLNode print  =this.ref;

        for (int i=0; i<this.getSize();i++){
            if (print.next ==null){
                out += +print.value;
            }
            else {
                out+= print.value+ ", ";
                print = print.next;
            }
        }
        return out;
    }
}
