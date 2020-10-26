/**
*@author Daniel Zuniga
*@version 1.1
*
*/
package cr.ac.ucenfotec.clase9.composicion.bl.entidades;

import java.util.ArrayList;


public class Factura {
    private Cliente cliente;
    private int numeroFactura;
    private ArrayList<LineaDetalle> lineas;


    public void save() throws Exception{
        if(this.getLineas() == null || this.getLineas().size() == 0) {
            throw new Exception("Factura no puede carecer de lineas de detalle");
        }else {
            /*aqui iria el codigo de salvar*/
        }
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public ArrayList<LineaDetalle> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaDetalle> lineas) {
        this.lineas = lineas;
    }

    public Factura() {
    }

    public Factura(Cliente cliente, int numeroFactura, ArrayList<LineaDetalle> lineas) {
        this.cliente = cliente;
        this.numeroFactura = numeroFactura;
        this.lineas = lineas;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", numeroFactura=" + numeroFactura +
                ", lineas=" + lineas +
                '}';
    }
}
