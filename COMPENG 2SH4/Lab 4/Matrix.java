public class Matrix {

    private int row;
    private int coloumns;
    private int mat[][];


    public Matrix (int row, int col){
        this.row = row;
        this.coloumns = col;
        if (row<=0){
            this.row = 3;
        }
        else if (col<=0){
            this.coloumns = 3;
        }
        this.mat= new int [this.row][this.coloumns];

        for (int i = 0; i<this.row;i++){
            for (int j =0; j<this.coloumns;j++){
                this.mat[i][j]=0;
            }
        }
    }

    public Matrix (int [][] table){
        this.row = table.length;
        this.coloumns = table[0].length;
        this.mat = new int [this.row][this.coloumns];

        for (int i=0;i<row;i++){
            for (int j=0;j<this.coloumns;j++){
                this.mat[i][j]= table[i][j];
            }
        }
    }

    public int getRow() {
        return row;
    }

    public int getColoumns() {
        return coloumns;
    }


    public int getElement(int i, int j) throws IndexOutOfBoundsException {
            int row = this.row;
            int col = this.coloumns;

            if (i<0|| i>row){
                throw new IndexOutOfBoundsException("Invalid indexes");
            }
            else if (j<0|| j>col){
                throw new IndexOutOfBoundsException("Invalid indexes");
            }
            else {
                return this.mat[i][j];
            }
    }

    public boolean setElement(int x, int i, int j){
        int row = this.row;
        int col = this.coloumns;

        if ((i>=0 && i<=row) && (j>=0 && j<=col)){
            this.mat[i][j] = x;
            return true;
        }
        else {
            return false;
        }
    }

    public Matrix copy(){
        Matrix newMat = new Matrix (this.mat);
        return newMat;
    }

    public void addTo(Matrix m) throws ArithmeticException{
        int rowM = m.row;
        int colM = m.coloumns;
        int rowThis = this.row;
        int colThis = this.coloumns;
        int arr [][]= m.mat;

        if (rowM!= rowThis|| colM!= colThis){
            throw new ArithmeticException("Invalid Operation");
        }
        else{
            for (int i=0; i<rowM;i++){
                for (int j=0; j<colM;j++){
                    this.mat[i][j] += arr[i][j];
                }
            }
        }
    }

    public Matrix subMatrix (int i, int j) throws ArithmeticException{
        int arr[][]= new int [i][j];

        if (i> this.row||j>this.coloumns){
            throw new ArithmeticException("Submatrix not defined");
        }
        else {
            for (int l=0;l<i; l++){
                for (int k=0; k<j;k++){
                    arr[l][k] = this.mat[l][k];
                }
            }
        }
        Matrix last = new Matrix(arr);

        return last;
    }

    public boolean isUpperTr(){
        int rowThis = this.row;
        int colThis = this.coloumns;
        int arr[][] = this.mat;

        for (int i= 1; i<rowThis; i++){
            for (int j=0; j<i;j++){
                if (arr[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }

    public static Matrix sum(Matrix[] matArray) throws ArithmeticException{
        Matrix summed = matArray[0];
        int len = matArray.length;

        for (int i =0;i<len;i++){
            summed.addTo(matArray[i]);
        }
        return summed;
    }

    public String toString(){
        String send = "";
        int row = this.row;
        int col = this.coloumns;
        int matrix [][] = this.mat;

        for (int i=0;i<row;i++){
            for (int j = 0;j<col;j++){
                send += matrix[i][j]+ "  ";
            }
            send += "\n";
        }
        return send;
    }


}
