public class SimpleLinealRegressionByCrammer {
    // ! Private Variables
    private String y;
    private int beta_0;
    private int beta_1;
    private int[] SetX;
    private int[] SetY;
    private int Xi = 0;
    private int Yi = 0;
    private int n;
    private int[][] matrix;
    private int[][] matrixB0;
    private int[][] matrixB1;
    private int detT = 0;
    private int detB0 = 0;
    private int detB1 = 0;

    // ! Constructor
    SimpleLinealRegressionByCrammer(int[] _setX, int[] _setY) {
        setSetX(_setX);
        setSetY(_setY);
        setN(getSetX().length);
        for (int i = 0; i < _setX.length; i++) {
            this.Xi = this.Xi + _setX[i];
        }
        for (int i = 0; i < _setY.length; i++) {
            this.Yi = this.Yi + _setY[i];
        }
        setMatrix();
        setMatrixB0();
        setMatrixB1();
        setDetMatrixT();
        setDetMatrixB0();
        setDetMatrixB1();
        setBeta_0();
        setBeta_1();
    }

    // ! Getters
    public String getY() {
        return this.y;
    }

    public int getBeta_0() {
        return this.beta_0;
    }

    public int getBeta_1() {
        return this.beta_1;
    }

    public int[] getSetX() {
        return this.SetX;
    }

    public int[] getSetY() {
        return this.SetY;
    }

    public int getXi() {
        return this.Xi;
    }

    public int getYi() {
        return this.Yi;
    }

    public int getN() {
        return this.n;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public int[][] getMatrixB0() {
        return this.matrixB0;
    }

    public int[][] getMatrixB1() {
        return this.matrixB1;
    }

    public int getDetT() {
        return this.detT;
    }

    public int getDetB0() {
        return this.detB0;
    }

    public int getDetB1() {
        return this.detB1;
    }

    public void getVectorBetas() {
        System.out.println("Beta 0: " + getBeta_0());
        System.out.println("Beta 1: " + getBeta_1());
    }

    // ! Setters
    public void setY(String y) {
        this.y = y;
    }

    public void setBeta_0(int beta_0) {
        this.beta_0 = beta_0;
    }

    public void setBeta_1(int beta_1) {
        this.beta_1 = beta_1;
    }

    public void setSetX(int[] setX) {
        SetX = setX;
    }

    public void setSetY(int[] setY) {
        SetY = setY;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setMatrix() {
        this.matrix = new int[2][2];
        this.matrix[0][0] = getN();
        this.matrix[0][1] = getXi();
        this.matrix[1][0] = getXi();
        this.matrix[1][1] = getXi() * getXi();
        /*
         * for (int i = 0; i < 2; i++) {
         * for (int j = 0; j < 2; j++) {
         * System.out.print(this.matrix[i][j] + " ");
         * }
         * System.out.println();
         * }
         */
    }

    public void setMatrixB0() {
        this.matrixB0 = new int[2][2];
        this.matrixB0[0][0] = getYi();
        this.matrixB0[0][1] = getXi();
        this.matrixB0[1][0] = getYi() * getXi();
        this.matrixB0[1][1] = getXi() * getXi();
        /*
         * for (int i = 0; i < 2; i++) {
         * for (int j = 0; j < 2; j++) {
         * System.out.print(this.matrixB0[i][j] + " ");
         * }
         * System.out.println();
         * }
         */
    }

    public void setMatrixB1() {
        this.matrixB1 = new int[2][2];
        this.matrixB1[0][0] = getN();
        this.matrixB1[0][1] = getYi();
        this.matrixB1[1][0] = getXi();
        this.matrixB1[1][1] = getYi() * getXi();
        /*
         * for (int i = 0; i < 2; i++) {
         * for (int j = 0; j < 2; j++) {
         * System.out.print(this.matrixB1[i][j] + " ");
         * }
         * System.out.println();
         * }
         */
    }

    public void setDetMatrixT() {
        this.detT = (this.matrix[0][0] * this.matrix[1][1]) - (this.matrix[1][0] * this.matrix[0][1]);
    }

    public void setDetMatrixB0() {
        this.detB0 = (this.matrixB0[0][0] * this.matrixB0[1][1]) - (this.matrixB0[1][0] * this.matrixB0[0][1]);
    }

    public void setDetMatrixB1() {
        this.detB1 = (this.matrixB1[0][0] * this.matrixB1[1][1]) - (this.matrixB1[1][0] * this.matrixB1[0][1]);
    }

    public void setBeta_0() {
        this.beta_0 = getDetB0() / getDetT();
    }

    public void setBeta_1() {
        this.beta_1 = getDetB1() / getDetT();
    }

    public String getFormula() {
        this.y = "y = " + this.beta_0 + " + " + this.beta_1 + "x1 + ε";
        return this.y;
    }

    // ! PREDICT METHODS

    public int predict(int _x1) {
        return this.beta_0 + (this.beta_1 * _x1);
    }
}
