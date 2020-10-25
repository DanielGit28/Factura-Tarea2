
package cr.ac.ucenfotec.clase9.composicion;

import cr.ac.ucenfotec.clase9.composicion.bl.entidades.Factura;
import cr.ac.ucenfotec.clase9.composicion.bl.entidades.LineaDetalle;


public class Main {


    public static void main(String[] args) throws Exception {
        Factura unaFactura = new Factura();
        unaFactura.setCliente("Marito");
        unaFactura.setNumero(33);
        
        LineaDetalle unaLinea = new LineaDetalle(2, 333,"Cartones de Huevos", 2400);
        
        unaFactura.getLineas().add(unaLinea);
        System.out.println(unaFactura);
        unaFactura.save();
    }
    
}
