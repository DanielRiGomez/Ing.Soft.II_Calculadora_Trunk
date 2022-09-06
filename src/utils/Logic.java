package utils;

public class Logic{
    public Logic() {
        Expression e1 = parseStringToExp("-3-2i^4");
        Expression e2 = parseStringToExp("4-2i^3");
        System.out.println(this.summ(e1, e2));
    }
    private Expression parseStringToExp(String expString){
        int real=0, coefficient=0, exponent=0;
        String[] parts = expString.split("\\^|\\+|\\-");
        Expression r;
        if(parts.length == 3 && expString.startsWith("-")){
            real = 0;
            coefficient = Integer.parseInt(parts[1].replaceAll("[^0-9]", "")) * -1;
            exponent = Integer.parseInt(parts[2]);
        }else if(parts.length == 3 && !expString.startsWith("-")){
            real = Integer.parseInt(parts[0]);
            coefficient = Integer.parseInt(parts[1].replaceAll("[^0-9]", "")) * -1;
            exponent = Integer.parseInt(parts[2]);
        }
        else if(parts.length == 2){
            real = 0;
            coefficient = Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
            exponent = Integer.parseInt(parts[1]);
        }else if(parts.length == 4){
            real = Integer.parseInt(parts[1]);
            real = expString.charAt(0) == '-'? real*-1 : real; 
            coefficient = Integer.parseInt(parts[2].replaceAll("[^0-9]", ""));
            exponent = Integer.parseInt(parts[3]);
        }
        r = new Expression(real, coefficient, exponent);
        return r;
    }

    public Expression summ(Expression e1, Expression e2){
        return new Expression(e1.real + e2.real, e1.coefficient + e2.coefficient, 1);
    }

    public Expression substract(Expression e1, Expression e2){
        return new Expression(e1.real - e2.real, e1.coefficient-e2.coefficient,1);
    }
}