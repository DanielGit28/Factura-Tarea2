/**
*@author Daniel Zuniga
*@version 1.1
*
*/
package cr.ac.ucenfotec.clase9.composicion.bl.entidades;

import java.util.ArrayList;


public class Factura {
    private Cliente cliente;
    private String codFactura;
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

    public String getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    public ArrayList<LineaDetalle> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaDetalle> lineas) {
        this.lineas = lineas;
    }
    public Factura() {}

    public Factura(Cliente cliente, String codFactura, ArrayList<LineaDetalle> lineas) {
        this.cliente = cliente;
        this.codFactura = codFactura;
        this.lineas = lineas;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", codFactura='" + codFactura + '\'' +
                ", lineas=" + lineas +
                '}';
    }
}
