// https://www.codewars.com/kata/52a78825cdfc2cfc87000005/train/java
/*
优先级+左结合：
E := AddSub
AddSub := AddSub ['+'|'-'] MulDiv
AddSub := MulDiv 
MulDiv := MulDiv ['+'|'-'] Term
MulDiv := Term
Term := Num
Term := '-' Term
Term := '(' E ')'

消除左递归：
E := AddSub
AddSub := MulDiv ( ['+'|'-'] MulDiv )*
MulDiv := Term ( ['*'|'/'] Term )*
Term := Num
Term := '-' Term
Term := '(' E ')'

*/

public class MathEvaluator {

  public double calculate(String expression) {
    if (expression.trim().equals("")) {
      return 0;
    }
    Parser p = new Parser(expression);
    Expr e = p.parse();
    return e.eval();
  }
  public static void main(String[] args) {
    if (args.length != 1) {
       return; 
    }
    MathEvaluator e = new MathEvaluator();
    System.out.println(e.calculate(args[0]));
  } 
}
class Parser {
    private final String str;
    private int idx = 0;

    Parser(String str) {
        this.str = str;
    }

    private boolean optionCharacter(char c) {
        if (idx < str.length() && str.charAt(idx) == c) {
            idx += 1;
            return true;
        }
        return false;
    }

    private void whitespace() {
        while (idx < str.length() && str.charAt(idx) == ' ') {
            idx += 1;
        }
    }

    private int integer() {
        whitespace();
        boolean pos = true;
        if (optionCharacter('-')) {
            pos = false;
        }
        optionCharacter('+');
        int end = idx;
        while (end < str.length() && Character.isDigit(str.charAt(end))) {
            end += 1;
        }
        int res = Integer.parseInt(str.substring(idx, end));
        if (!pos) {
            res = -res;
        }
        idx = end;
        return res;
    }

    private double number() {
        whitespace();
        double part1 = integer();
        double part2 = 0;
        if (optionCharacter('.')) {
            part2 = integer();
        }
        while (part2 >= 1) {
            part2 /= 10;
        }
        return part1 + part2;
    }

    private Expr addsub() {
        whitespace();
        Expr res = muldiv();
        whitespace();
        while (idx < str.length() && (str.charAt(idx) == '+' || str.charAt(idx) == '-')) {
            if (optionCharacter('+')) {
                res = new Add(res, muldiv());
            } else if (optionCharacter('-')) {
                res = new Sub(res, muldiv());
            }
            whitespace();
        }
        return res;
    }

    private Expr muldiv() {
        whitespace();
        Expr res = term();
        whitespace();
        while (idx < str.length() && (str.charAt(idx) == '*' || str.charAt(idx) == '/')) {
            if (optionCharacter('*')) {
                res = new Mul(res, term());
            }
            if (optionCharacter('/')) {
                res = new Div(res, term());
            }
            whitespace();
        }
        return res;
    }

    private Expr term() {
        whitespace();
        if (optionCharacter('(')) {
            Expr e = expr();
            optionCharacter(')');
            return e;
        } else if (optionCharacter('-')) {
            Expr t = term();
            return new Sub(new Const(0), t);
        } else {
            return new Const(number());
        }
    }

    private Expr expr() {
        whitespace();
        return addsub();
    }

    public Expr parse() {
        return expr();
    }
}

interface Expr {
    double eval();
}

class Add implements Expr {
    public final Expr expr1;
    public final Expr expr2;

    Add(Expr expr1, Expr expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public double eval() {
        return expr1.eval() + expr2.eval();
    }
}

class Sub implements Expr {
    public final Expr expr1;
    public final Expr expr2;

    Sub(Expr expr1, Expr expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public double eval() {
        return expr1.eval() - expr2.eval();
    }
}

class Mul implements Expr {
    public final Expr expr1;
    public final Expr expr2;

    Mul(Expr expr1, Expr expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public double eval() {
        return expr1.eval() * expr2.eval();
    }
}

class Div implements Expr {
    public final Expr expr1;
    public final Expr expr2;

    Div(Expr expr1, Expr expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public double eval() {
        return expr1.eval() / expr2.eval();
    }
}

class Const implements Expr {
    public final double num;

    Const(double num) {
        this.num = num;
    }

    @Override
    public double eval() {
        return num;
    }
}

