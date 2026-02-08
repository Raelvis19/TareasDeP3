public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double bas , double alt){
        this.altura = alt;
        this.base = bas;
    }

    @Override
    public double area(){
        return base * altura;
    }
    
}
