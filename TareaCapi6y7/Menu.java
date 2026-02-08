
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cuenta Bancaria");
            System.out.println("2. Polimorfismo Empleados");
            System.out.println("3. Ocultamiento de Atributos");
            System.out.println("4. Arrays y Referencias");
            System.out.println("5. Figuras Geometricas");
            System.out.println("6. Gestion de productos");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ejercicioCuenta();
                    pausa();

                    break;
                case 2:
                    ejercicioEmpleados();
                    pausa();
                    break;
                case 3:
                    ejercicioOcultamiento();
                    pausa();
                    break;
                case 4:
                    ejercicioArrays();
                    pausa();
                    break;
                case 5:
                    EjercicioFigura();
                    pausa();
                    break;
                case 6:
                    ejercicioProducto();
                    pausa();
                    break;
                    
                    
            }

        } while (opcion != 0);
    }

    public static void pausa() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\nPresione ENTER para volver al menu");
    sc.nextLine();
    }


    // EJERCICIO 1
    public static void ejercicioCuenta() {
        CuentaBancaria c = new CuentaBancaria("001", 1000);
        c.Depositar(500);
        c.retirar(200);
        System.out.println("Saldo final: " + c.getSaldo());
    }

    // EJERCICIO 2
    public static void ejercicioEmpleados() {
        Empleado e1 = new EmpleadoFijo(1500);
        Empleado e2 = new EmpleadoPorHora(40, 10);

        System.out.println("Salario fijo: " + e1.calcularSalario());
        System.out.println("Salario por hora: " + e2.calcularSalario());
    }

    // EJERCICIO 3
    public static void ejercicioOcultamiento() {
        A obj = new B();
        System.out.println("Valor de x: " + obj.x);

    
    }

    // EJERCICIO 4
    public static void ejercicioArrays() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;

        arr2[1] = 99;

        System.out.println("Contenido de arr1:");
        for (int n : arr1) {
            System.out.print(n + " ");
        }
    }

    //Ejercicio5
    public static void EjercicioFigura(){
        Figura[] figuras = new Figura[3];

        figuras[0] = new Cuadrado(4);
        figuras[1] = new Rectangulo(3,5);
        figuras[2] = new Circulo(2.5);



        for(int i = 0; i < figuras.length; i++){
            System.out.println("Area: " + figuras[i].area());
        }

    }

    //Ejercicio6
    public static void ejercicioProducto() {

    Producto p = new Producto("Laptop", 50000, 10);

    System.out.println("Producto: " + p.getNombre());
    System.out.println("Precio: " + p.getPrecio());
    System.out.println("Stock inicial: " + p.getStock());

    p.vender(3);

    System.out.println("Stock después de vender: " + p.getStock());
    }

    
    
}
