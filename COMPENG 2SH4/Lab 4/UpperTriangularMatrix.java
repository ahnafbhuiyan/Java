public class UpperTriangularMatrix {
    private int n;
    private int eff [];

    public UpperTriangularMatrix(int n){
        this.n = n;
        if (n<=0){
            this.n=1;
        }

        int size = this.n*(this.n+1)/2;
        this.eff = new int [size];
        for(int i = 0;i<size-1;i++){
                this.eff[i] = 0;
        }
    }

    public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException{
        int size = upTriM.getRow();
        int k = size*(size+1)/2;
        this.eff = new int [k];
        int count=0;

        if (upTriM.isUpperTr()){
            for (int i =0; i<size;i++){
                for (int j = 0; j<size;j++){
                    if (upTriM.getElement(i,j)!=0){
                        this.eff[count] = upTriM.getElement(i,j);
                        count++;
                    }
                }

            }
        }
        else {
            throw new IllegalArgumentException("Not Triangular");
        }
        this.n = size;
    }

    public int getDim(){
        return this.n;
    }

    public void setElement(int x, int i, int j) throws IndexOutOfBoundsException{
        Matrix set = this.fullMatrix();
        int row = this.n;

        if ((i<0||i>=row ||j>=row||j<0)||(j<i && x!=0)){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        else {
                set.setElement(x,i,j);
        }

        }
    public Matrix fullMatrix (){
        int size = this.n;
        Matrix full = new Matrix (size,size);
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int x = this.eff[count];
                full.setElement(x,i,j);
                count++;
            }
        }
        return full;
    }
    public int getElement(int i, int j) throws IndexOutOfBoundsException{
        Matrix ele = this.fullMatrix();

        if (i<0||i>this.n||j<0||j>this.n){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        else{
            return ele.getElement(i,j);
        }
    }

    public void print1DArray(){
        int size = this.n*(this.n+1)/2;

        for (int i = 0; i<size;i++) {
            System.out.print(this.eff[i] + "  ");
        }
    }

    public String toString(){
        Matrix print = this.fullMatrix();

        return print.toString();
    }

    public int getDet(){
        Matrix det = this.fullMatrix();
        int prod = 1;
        int size = this.n;

        for (int i =0; i<size;i++){
            prod = prod*det.getElement(i,i);
        }
        return prod;
    }

    public double[] effSolve(double[] b) throws IllegalArgumentException{
        int len = b.length-1,size = this.n-1,count =0,push=0;
        double x[] = new double[len+1];
        int newN = size*(size+1)/2;
        double temp = 0,eq =0;
        int det = this.getDet();

        if (len!=size || (det==0)) {
            throw new IllegalArgumentException("Not the correct dimension");
        }
        else {
            double ans = b[size-count];
            for (int l = newN - 1; l >= 0; l -= count) {
                count++;
                for (int i = l; i > l - count; i--) {
                    if (push + 1 != count) {
                        ans -= x[count - push] * this.eff[i];
                    } else {
                        eq= ans / this.eff[i];
                    }
                    push++;
                }
                x[size- count] = eq;
            }
        }

        return x;
    }

}
