
package cr.ac.ucenfotec.clase9.composicion.bl.entidades;


public class LineaDetalle {
    private int cantidad;
    private int codigo;
    private String descripcion;
    private double precio;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public LineaDetalle() {
        
    }
    public LineaDetalle(int cantidad, int codigo, String descripcion, double precio){
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "LineaDetalle{" +
                "cantidad=" + cantidad + 
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion +
                ", precio='" + precio +
                '}';
    }
    
    
}
