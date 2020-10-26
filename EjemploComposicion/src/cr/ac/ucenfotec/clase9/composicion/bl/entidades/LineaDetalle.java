
package cr.ac.ucenfotec.clase9.composicion.bl.entidades;
/**
 * @author Daniel Zúñiga Rojas
 * @version 1.1
 */

public class LineaDetalle {
    private Producto producto;
    private int cantidad;


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public LineaDetalle() {}

    public LineaDetalle(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineaDetalle{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
