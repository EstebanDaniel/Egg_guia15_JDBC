
package Main;

import Tienda.Services.ProductoService;


public class Guia15ej1JDBC {

    
    public static void main(String[] args) throws Exception {
        
        ProductoService productoService = new ProductoService();
        
        
           
        try {
            //Creamos productos
//            productoService.crearProducto("calculadora", 80.0, 3);
//              productoService.modificarProductoPrecio("calculadora", 40.00);
//                productoService.listarProductosPorNombre();
                productoService.listarProductosMin();
                
           
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        
    }
    
}
