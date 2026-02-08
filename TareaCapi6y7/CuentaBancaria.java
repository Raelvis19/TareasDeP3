

public class CuentaBancaria {

    private String NumeroCuenta;
    private double Saldo;

    public CuentaBancaria(){

    }

    public CuentaBancaria(String Num , double sald){
        this.NumeroCuenta = Num;
        this.Saldo = sald;
    }

    public double getSaldo(){
        return Saldo;
    }

    public void Depositar(double monto){
        Saldo += monto;

    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= Saldo) {
            Saldo -= monto;
        }
    }

}