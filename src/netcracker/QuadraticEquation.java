package netcracker;

public class QuadraticEquation {
    private double a; //старший коэффициент
    private double b; //средний коэффициент
    private double c; //свободный член

    QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /*
       Внутренний класс для вычисления дискриминанта
    */
    class Discriminant{
        //Значение дискриминанта
        private double discriminant;

        public double getDiscriminant(){
            return discriminant;
        }
        //Вычисление дискриминанта
        public void calculate(double a, double b, double c){
            this.discriminant = Math.pow(b, 2) - 4 * a * c;
        }
    }
    /*
       Вычисление корней
    */
    public String roots(){
        Discriminant d = new Discriminant();
        d.calculate(a, b, c);
        double x1 = (-b + Math.sqrt(d.getDiscriminant())) / (2 * a);
        double x2 = (-b - Math.sqrt(d.getDiscriminant())) / (2 * a);
        String answer = "x1 = " + x1 + "\nx2 = "  + x2;
        return answer;
    }
}
