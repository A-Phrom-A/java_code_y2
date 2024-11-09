
class W2_1Complex {

    private double r, i;

    public void setR(double r) {
        this.r = r;
    }

    public void setI(double i) {
        this.i = i;
    }

    W2_1Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    W2_1Complex(W2_1Complex c) {
        this(c.r, c.i);
    }

    public void add(W2_1Complex c) {
        r += c.r;
        i += c.i;
    }

    public void sub(W2_1Complex c) {
        r -= c.r;
        i -= c.i;
    }

    public void multiply(W2_1Complex c) {
        double tempr = this.r * c.r - this.i * c.i; //ad-bd
        double tempi = this.r * c.i + this.i * c.r; // ad-bc
        r = tempr;
        i = tempi;
    }

    public void divide(W2_1Complex c) {
        //r = (ac-bd)/(c*c+d*d)
        double tempr = (this.r * c.r + this.i * c.i) / (c.r * c.r + c.i * c.i);
        //i = (bc-ad) / (c*c+d*d)
        double tempi = (this.i * c.r - this.r * c.i) / (c.r * c.r + c.i * c.i);
        r = tempr;
        i = tempi;
    }

    public void print() {
        System.out.println(r + " + i" + i);
    }
}

class ComplexTest {

    public static void main(String args[]) {
        W2_1Complex a = new W2_1Complex(1.0, 2.0);
        W2_1Complex b = new W2_1Complex(3.0, 4.0);
        W2_1Complex c = new W2_1Complex(a);
        c.add(b);
        c.print();
        c.setR(1.0);
        c.setI(2.0);
        c.sub(b);
        c.print();
        c.setR(1.0);
        c.setI(2.0);
        c.multiply(b);
        c.print();
        c.setR(1.0);
        c.setI(2.0);
        c.divide(b);
        c.print();
        c.setR(1.0);
        c.setI(2.0);
    }
}
