/**
*@author Daniel Zuniga
*@version 1.0
*
*/
package cr.ac.ucenfotec.clase9.composicion.bl.entidades;

import java.util.ArrayList;


public class Factura {
    private int numero;
    private String cliente;
    private ArrayList<LineaDetalle> lineas;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaDetalle> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaDetalle> lineas) {
        this.lineas = lineas;
    }
    
    public Factura() {
        this.lineas = new ArrayList<>();
    }
    public Factura(int numero, String cliente, ArrayList<LineaDetalle> lineas) {
        this.numero = numero;
        this.cliente = cliente;
        this.lineas = lineas;
    }
    
    @Override
    public String toString() {
        return "Factura{" +
                "numero=" + numero + 
                ", cliente='" + cliente + '\'' +
                ", lineas='" + lineas +
                '}';
    }
    public void save() throws Exception{
        if(this.lineas == null || this.lineas.size() == 0) {
            throw new Exception("Factura no puede carecer de lineas de detalle");
        }else {
            /*aqui iria el codigo de salvar*/
        }
    }
}
