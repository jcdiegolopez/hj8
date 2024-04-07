package uvg.edu.gt;

public class Paciente implements Comparable<Paciente>{
    
    private String nombre;
    private String sintoma;
    private String prioridad;

    public Paciente(String nombre, String sintoma, String prioridad){
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Paciente o) {
        return this.prioridad.compareToIgnoreCase(o.prioridad); 
    }

    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", prioridad=" + prioridad + ", sintoma=" + sintoma + "]";
    }
}
