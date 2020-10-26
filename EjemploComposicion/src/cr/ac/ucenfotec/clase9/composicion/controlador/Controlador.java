package cr.ac.ucenfotec.clase9.composicion.controlador;

import cr.ac.ucenfotec.clase9.composicion.bl.entidades.Cliente;
import cr.ac.ucenfotec.clase9.composicion.bl.entidades.Factura;
import cr.ac.ucenfotec.clase9.composicion.bl.entidades.LineaDetalle;
import cr.ac.ucenfotec.clase9.composicion.bl.entidades.Producto;
import cr.ac.ucenfotec.clase9.composicion.bl.logica.Gestor;
import cr.ac.ucenfotec.clase9.composicion.iu.IU;

import java.util.ArrayList;

/**
 * @author Daniel Zúñiga Rojas
 * @version 1.0
 */
public class Controlador {
    private IU interfaz = new IU();
    private Gestor gestor = new Gestor();

    public void ejecutarPrograma() {
        int opcion = 0;
        do {
            interfaz.mostrarMenu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion!=7);
    }

    /**
     *
     * @param opcion el entero que procesa el switch con diferentes opciones
     */
    private void procesarOpcion(int opcion) {
        switch(opcion) {
            case 1:
                crearFactura();
                break;
            case 2:
                crearCliente();
                break;
            case 3:
                crearProducto();
            case 4:
                imprimirFactura();
                break;
            case 5:
                listarClientes();
                break;
            case 6:
                listarProductos();
                break;
            case 7:
                break;
            default:
                interfaz.imprimirMensaje("Opcion desconocida");
        }
    }

    private void crearFactura() {
        ArrayList<LineaDetalle> lineas = new ArrayList<>();
        interfaz.imprimirMensaje("Introduzca la identificación del cliente: ");
        String idCliente = interfaz.leerTexto();
        interfaz.imprimirMensaje("Introduzca el número de factura: ");
        int numFactura = interfaz.leerEntero();

        int opcion = 0;

        while (opcion != 1) {
            interfaz.imprimirMensaje("Si desea finalizar de ingresar productos a la factura ingrese 1, de lo contrario, ingrese 2: ");
            opcion = interfaz.leerEntero();
            if (opcion != 1) {
                interfaz.imprimirMensaje("Introduzca el código del producto: ");
                String codProducto = interfaz.leerTexto();
                interfaz.imprimirMensaje("Introduzca la cantidad de productos comprados: ");
                int cantidad = interfaz.leerEntero();

                for (int i = 0; i < gestor.listarProductos().size(); i++) {
                    Producto producto = gestor.listarProductos().get(i);
                    if (producto.getCodigo().equals(codProducto)) {
                        LineaDetalle linea = new LineaDetalle(producto, cantidad);
                        lineas.add(linea);
                    }
                }
            }

            gestor.crearFactura(idCliente, numFactura, lineas);
            interfaz.imprimirMensaje("\nFactura creada con éxito.");
        }
    }

    private void crearCliente() {
        interfaz.imprimirMensaje("Introduzca el nombre del cliente: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Introduzca el numero de identificacion: ");
        String identificacion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Introduzca M si es de género masculino o F si es es de género femenino: ");
        char genero = interfaz.leerChar();

        interfaz.imprimirMensaje("Introduzca el día de nacimiento: ");
        int dia = interfaz.leerEntero();
        interfaz.imprimirMensaje("Introduzca el mes de nacimiento: ");
        int mes = interfaz.leerEntero();
        interfaz.imprimirMensaje("Introduzca el año de nacimiento: ");
        int anio = interfaz.leerEntero();
        String fechaNac = Integer.toString(dia) + "/" + Integer.toString(mes) + "/"
                + Integer.toString(anio);
        int edad = gestor.calcularEdad(dia, mes, anio);

        gestor.agregarCliente(nombre, identificacion, genero, fechaNac, edad);
        interfaz.imprimirMensaje("Cliente creado con éxito");
    }
    public void crearProducto() {
        interfaz.imprimirMensaje("Introduzca el código del producto: ");
        String codProducto = interfaz.leerTexto();
        interfaz.imprimirMensaje("Introduzca la descripción del producto: ");
        String descripcion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Introduzca el precio del producto (solo el número) : ");
        int precio = interfaz.leerEntero();

        gestor.agregarProducto(codProducto, descripcion, precio);
    }

    public void imprimirFactura() {
        interfaz.imprimirMensaje("Ingrese el número de factura: ");
        int numFactura = interfaz.leerEntero();
        interfaz.imprimirMensaje(gestor.imprimirFactura(numFactura));
    }

    private void listarClientes() {
        ArrayList<Cliente> clientes = gestor.listarClientes();
        interfaz.imprimirMensaje("Lista de clientes");
        for (int i = 0; i < clientes.size(); i++) {
            interfaz.imprimirMensaje(clientes.get(i).toString());
        }
    }
    private void listarProductos() {
        ArrayList<Producto> productos = gestor.listarProductos();
        interfaz.imprimirMensaje("Lista de productos");
        for (int i = 0; i < productos.size(); i++) {
            interfaz.imprimirMensaje(productos.get(i).toString());
        }
    }
}
