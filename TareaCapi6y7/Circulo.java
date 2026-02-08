public class Circulo extends Figura{
    private double radio;
    private double PI = 3.1416;

    public Circulo(double rad){
        this.radio = rad;
    }
    @Override
    public double area(){
        return PI * radio * radio;
    }


    
}
