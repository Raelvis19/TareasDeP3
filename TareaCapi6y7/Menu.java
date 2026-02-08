
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
            System.out.println("7. Inventario de Arrays");
            System.out.println("8. Copia de Arrays");
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
                case 7:
                    ejercicioInventario();
                    pausa();
                    break;
                case 8:
                    ejercicioCopiaArray();
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

    //Ejercicio7
    public static void ejercicioInventario() {

    // 1. Crear array de tamaño fijo
    Producto[] inventario = new Producto[5];

    // 2. Inicializar al menos 3 productos
    inventario[0] = new Producto("Laptop", 50000, 5);
    inventario[1] = new Producto("Mouse", 800, 0);
    inventario[2] = new Producto("Teclado", 1500, 3);

    double valorTotal = 0;

    System.out.println("Productos con stock disponible:");

    // 3. Recorrer el array
    for (Producto p : inventario) {

        if (p != null) { // evita error por posiciones vacias

            // 4. Calcular valor total
            valorTotal += p.getPrecio() * p.getStock();

            // 5. Mostrar solo si hay stock
            if (p.getStock() > 0) {
                System.out.println(
                    p.getNombre() +
                    " | Precio: " + p.getPrecio() +
                    " | Stock: " + p.getStock()
                );
            }
        }
    }

    System.out.println("Valor total del inventario: " + valorTotal);
    }

    //Ejercicio8
    public static void ejercicioCopiaArrays() {

    // Array original
    int[] original = {10, 20, 30};

    // Copia usando clone()
    int[] copia = original.clone();

    // Modificamos la copia
    copia[1] = 99;

    System.out.println("Array original:");
    for (int n : original) {
        System.out.print(n + " ");
    }

    System.out.println("\nArray copia:");
    for (int n : copia) {
        System.out.print(n + " ");
    }

    /*
     EXPLICACION:
     clone() crea un nuevo array en otra posicion de memoria
     Por eso al modificar la copia el original NO cambia

     Esto se considera una copia profunda para tipos primitivos
     Si fueran objetos (Producto[] por ejemplo)
     solo copiaría las referencias y sería copia superficial
    */
    }



    
    
}
