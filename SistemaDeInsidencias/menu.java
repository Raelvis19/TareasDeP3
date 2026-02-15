package SistemaDeInsidencias;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class menu {
    List <Incidencia> incidencias = new LinkedList<>();
    public void lanzarMenu(){
    Scanner sc = new Scanner(System.in);
    int opcion;

    do{
        System.out.println("---MENU---");
        System.out.println("1. Registrar Incidencia");
        System.out.println("2. Listar Incidencias");
        System.out.println("3. Buscar Incidencia Por Palabra clave");
        System.out.println("0. Salir");
        opcion = sc.nextInt();
        sc.nextLine();
        

        switch (opcion) {
            case 1:
                System.out.println("Ingrese El Id: ");
                int id = sc.nextInt();
                System.out.println("Ingrese la Descripcion: ");
                sc.nextLine();
                String descrip = sc.nextLine();
                System.out.println("Ingrese la fecha de Registro: ");
                String Fecha1 = sc.nextLine();
                System.out.println("Ingrese el Nivel de Prioridad: ");
                System.out.println("ALTA, MEDIA, BAJA ");
                String prio = sc.nextLine();
                registrarIncidencia(id, descrip, Fecha1, prio);
                break;
            case 2:
                ListarIncidencia();
                break;
            case 3:
                System.out.println("Ingrese una palabra clave para buscar: ");
                String clave = sc.nextLine();
                buscarClave(clave);
                break;
            case 0:
                System.out.println("Gracias por usar el sistema....");
                break;
            default:
                
                break;
            
        }

    }while(opcion != 0);
  }
    
    public void registrarIncidencia(int id1, String descripcion1,String fechaRegistr, String nivelPrio) {
        

        try {
        Incidencia nueva = new Incidencia(id1, descripcion1, fechaRegistr, nivelPrio);
        incidencias.add(nueva);
        System.out.println("Incidencia registrada correctamente");

        } catch (DescripcionInvalidaException e) {
        System.out.println(e.getMessage());
        } catch (PrioridadInvalidaException e) {
        System.out.println(e.getMessage());
        } catch (FechaInvalidaException e) {
        System.out.println(e.getMessage());
        }
        
        

    }
    public void ListarIncidencia(){
        for (Incidencia i : incidencias) {
            System.out.println(i);
        }

    }

    public void buscarClave(String Palabra){
        String Palabra1 = Palabra.toLowerCase().trim();

        for (Incidencia i : incidencias) {
            if (i.getDescripcion().toLowerCase().contains(Palabra1)) {
                System.out.println(i);
                
            }
        }

    }

}
