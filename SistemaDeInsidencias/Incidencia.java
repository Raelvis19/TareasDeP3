package SistemaDeInsidencias;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Incidencia{
    private int id;
    private String descripcion;
    private Date FechaRegiValida;
    private NivelDePrioridad NivelPrioridad;

    public Incidencia(int id, String descripcion, String fechaRegistro, String nivelPrioridad)  throws DescripcionInvalidaException , PrioridadInvalidaException, FechaInvalidaException{
        
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        fecha.setLenient(false);

        Date FechaValida;
        try{
            FechaValida = fecha.parse(fechaRegistro);
        }catch(ParseException e){
            throw new FechaInvalidaException("La Fecha debe tener Formato 'dd/mm/yyyy' y ser valida.");
        }



        if (descripcion == null || descripcion.isEmpty()) {
            throw new DescripcionInvalidaException("La Descripcion No Puede estar Vacia o ser Nula");
        }else if (descripcion.trim().isEmpty()){
            throw new DescripcionInvalidaException("La descripcion no puede solo ser espacios");

        }else if (descripcion.trim().length() < 10) {
            throw new DescripcionInvalidaException("La descripcion debe tener al menos 10 caracteres");
            
        }

        NivelDePrioridad nivel;
        try {
         nivel = NivelDePrioridad.valueOf(nivelPrioridad.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new PrioridadInvalidaException("El nivel de prioridad solo puede ser ALTA, MEDIA o BAJA");
        }


        this.id = id;
        this.descripcion = descripcion;
        this.FechaRegiValida = FechaValida;
        this.NivelPrioridad = nivel;
        
    }

    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    return "ID: " + id +
           " | Descripción: " + descripcion +
           " | Fecha: " + sdf.format(FechaRegiValida) +
           " | Prioridad: " + NivelPrioridad;
    }
    



}