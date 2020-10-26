package cr.ac.ucenfotec.clase9.composicion.bl.entidades;
/**
 * @author Daniel Zúñiga Rojas
 * @version 1.0
 */
public class Cliente {
    private String nombre;
    private String identifacion;
    private char genero;
    private String fechaNacimiento;
    private int edadCliente;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentifacion() {
        return identifacion;
    }

    public void setIdentifacion(String identifacion) {
        this.identifacion = identifacion;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }
    public Cliente() {}

    public Cliente(String nombre, String identifacion, char genero, String fechaNacimiento, int edadCliente) {
        this.nombre = nombre;
        this.identifacion = identifacion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.edadCliente = edadCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identifacion='" + identifacion + '\'' +
                ", genero=" + genero +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", edadCliente=" + edadCliente +
                '}';
    }
}
