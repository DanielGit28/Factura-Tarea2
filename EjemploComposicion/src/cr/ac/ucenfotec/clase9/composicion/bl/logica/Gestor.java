package cr.ac.ucenfotec.clase9.composicion.bl.logica;

import cr.ac.ucenfotec.clase9.composicion.bl.entidades.Cliente;
import cr.ac.ucenfotec.clase9.composicion.bl.entidades.Factura;
import cr.ac.ucenfotec.clase9.composicion.bl.entidades.LineaDetalle;
import cr.ac.ucenfotec.clase9.composicion.bl.entidades.Producto;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Daniel Zúñiga Rojas
 * @version 1.0
 */
public class Gestor {
    ArrayList<LineaDetalle> lineasDetalle = new ArrayList<> ();
    ArrayList<Producto> productos = new ArrayList<> ();
    ArrayList<Cliente> clientes = new ArrayList<> ();
    ArrayList<Factura> facturas = new ArrayList<> ();

    /**
     *
     * @param factura objeto factura
     * @return texto sobre la condicion de la factura
     */
    public String agregarFactura(Factura factura) {
        if(buscarFactura(factura.getNumeroFactura()) == null) {
            facturas.add(factura);
            return "Agregada exitosamente";
        } else {
            return "Factura ya existe";
        }
    }

    /**
     *
     * @param idCliente cadena de caracteres que permite indetificar el cliente asociado a la factura
     * @param numeroFactura entero que determina el numero de factura
     * @param lineas arrayList que contiene los productos de la factura y la cantidad
     */
    public void crearFactura(String idCliente, int numeroFactura, ArrayList<LineaDetalle> lineas) {
        for (int i = 0; i < facturas.size(); i++) {
            Factura tempFac = facturas.get(i);
            if(tempFac.getNumeroFactura() != numeroFactura) {
                for (int j = 0; j < clientes.size(); j++) {
                    Cliente tempCliente = clientes.get(j);
                    if(tempCliente.getIdentifacion().equals(idCliente)) {
                        Factura factura = new Factura(tempCliente, numeroFactura, lineas);
                        facturas.add(factura);
                    }
                }
            }
        }
    }
    /**
     *
     * @param numFactura entero que permite indentificar a cual objeto factura imprimir
     * @return texto
     */
    public Factura buscarFactura(int numFactura) {
        for(Factura factura:facturas) {
            if(factura.getNumeroFactura() == numFactura)
                return factura;
        }
        return null;
    }

    /**
     *
     * @param numFactura entero que permite indentificar a cual objeto factura imprimir
     * @return texto
     */
    public String imprimirFactura(int numFactura) {
        Factura factura = buscarFactura(numFactura);
        if(factura!= null) {
            return factura.toString();
        }
        return "Factura no existe";
    }

    /**
     *
     * @param numFactura entero que permite identificar a cual objeto factura eliminar
     */
    public void eliminarFactura(int numFactura) {
        facturas.remove(buscarFactura(numFactura));
    }

    /**
     *
     * @param codigo cadena de caracteres que determina el codigo del producto
     * @param descripcion cadena de caracteres que determina la descripcion del producto
     * @param precio el entero que determina el precio del producto
     */
    public void agregarProducto(String codigo, String descripcion, int precio) {
        Producto producto = new Producto(codigo, descripcion, precio);
        productos.add(producto);
    }

    /**
     *
     * @param nombre cadena de caracteres que determina el nombre del cliente
     * @param identificacion cadena de caracteres que determina la identificacion del cliente
     * @param genero caracter que determina el genero del cliente
     * @param fechaNac cadena de caracteres que determina la fecha de nacimiento del cliente
     * @param edad entero que determina la edad del cliente
     */
    public void agregarCliente(String nombre, String identificacion, char genero, String fechaNac, int edad) {
        Cliente cliente = new Cliente(nombre, identificacion, genero, fechaNac, edad);
        clientes.add(cliente);
    }

    public void agregarLineaDetalle(String codProducto, int cantidad) {
        for (int i = 0; i < productos.size(); i++) {
            Producto temp = productos.get(i);
            if(temp.getCodigo().equals(codProducto)) {
                LineaDetalle linea = new LineaDetalle(temp, cantidad);
                lineasDetalle.add(linea);
                break;
            }
        }
    }

    /**
     *
     * @return clientes arreglo de objetos de tipo Cliente
     */
    public ArrayList<Cliente> listarClientes() {
        return this.clientes;
    }

    /**
     *
     * @return productos arreglo de objetos de tipo Producto
     */
    public ArrayList<Producto> listarProductos() {
        return this.productos;
    }

    /**
     *
     * @return lineasDetalle arreglo de objetos de tipo LineaDetalle
     */
    public ArrayList<LineaDetalle> listarLineasDetalle() {
        return this.lineasDetalle;
    }

    /**
     *
     * @return facturas arreglo de objetos de tipo Factura
     */
    public ArrayList<Factura> listarFacturas() {
        return this.facturas;
    }
    /**
     *
     * @param pDia entero que determina el dia de nacimiento
     * @param pMes entero que determina el mes de nacimiento
     * @param pAnno entero que determina el año de nacimiento
     * @return edad entero que determina la edad
     */
    public int  calcularEdad(int pDia, int pMes, int pAnno) {
        Calendar c1 = Calendar.getInstance();
        int dia = c1.get(Calendar.DATE);
        int mes = c1.get(Calendar.MONTH);
        int annio = c1.get(Calendar.YEAR);
        int edad = 0;

        if (pMes < mes) { // si el mes de nacimiento ya pasó, ya cumplió años
            edad = annio - pAnno;
        } else if (pDia < dia && pMes == mes) { // si el dia de nacimiento ya pasó, ya cumplió años
            edad = annio - pAnno;
        } else if (pDia > dia && pMes == mes) { //si el mes de nacimiento es igual al actual y el dia de nacimiento es mayor al dia actual, aún no ha cumplido años este año
            edad = (annio - pAnno) - 1;
        } else if (pMes > mes) { //si el mes de nacimiento es mayor al actual, aún no ha cumplido años este año
            edad = (annio - pAnno) - 1;
        }

        return edad;
    }
}
