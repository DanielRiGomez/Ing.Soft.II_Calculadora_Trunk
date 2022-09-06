package utils;

public class Expression {
    public int real;
    public int coefficient;
    public boolean hasImaginary;

    public Expression(int real, int coefficient, int exponent){
        this.real = real;
        this.coefficient = coefficient;
        checkExponent(exponent);
    }
    private void checkExponent(int exponent){
        //Revisa los exponentes y realiza las operaciones dadas por las propiedades de los exponent en imaginarios sobre la expresion
        int res = exponent % 4;
        if(res == 0){
            hasImaginary = false;
            this.real = this.real + this.coefficient;
            this.coefficient = 0;
        }else if(res == 1){
            hasImaginary = true;
        }else if(res == 2){
            this.coefficient *= -1;
            hasImaginary = false;
            this.real = this.real + this.coefficient;
            this.coefficient = 0;
        }else if(res == 3){
            this.coefficient *= -1;
            hasImaginary = true;
        }
    }
    @Override
    public String toString(){
        String coeffString = "";
        if(this.coefficient != 0){
            coeffString = this.coefficient >= 0 ? "+" + this.coefficient : this.coefficient+"";
        }
        String expString =  (this.real==0 ? "" : ""+ real) +
                            coeffString +
                            (this.hasImaginary? "i":"");
        return expString.equals("")? "0" : expString;
    }
}
