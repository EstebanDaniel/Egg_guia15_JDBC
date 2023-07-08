
package Tienda.Services;

import Tienda.Entidades.Producto;
import Tienda.Persistencia.ProductoDAO;
import java.util.Collection;


public class ProductoService {
    
       private ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(String nombre, double precio, int codigoFabricante) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }

            //Creamos el usuario
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProductoPrecio(String nombre,double nuevoPrecio) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
 
            //Buscamos
            Producto producto = dao.buscarProductoPorNombre(nombre);


            //Modificamos
            producto.setPrecio(nuevoPrecio);

            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
        public void listarProductosPorNombre() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosPorNombre();
            imprimirProductos(productos);
            
        } catch (Exception e) {
            throw e;
        }
    }
        
                public void listarProductosPorNombrePrecio() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosPorNombrePrecios();
            imprimirProductos(productos);
            
        } catch (Exception e) {
            throw e;
        }
     
    }
                
       public void listarProductosPorPrecioDeterminado() throws Exception {

        try {

            Collection<Producto> productos = dao.listarPorPrecioDeterminado();
            imprimirProductos(productos);
            
        } catch (Exception e) {
            throw e;
        }
     
    }
       
           public void listarProductosPortatil() throws Exception {

        try {

            Collection<Producto> productos = dao.listaPortatil();
            imprimirProductos(productos);
            
        } catch (Exception e) {
            throw e;
        }
     
    }
           
                 public void listarProductosMin() throws Exception {

        try {

            Producto producto = dao.precioMin();
            System.out.println(producto);
            
        } catch (Exception e) {
            throw e;
        }
     
    }
        

    public void imprimirProductos(Collection<Producto> productos) throws Exception {

        try {

            //Listamos los productos
            

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

//    public void eliminarUsuario(String correoElectronico) throws Exception {
//
//        try {
//
//            //Validamos 
//            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
//                throw new Exception("Debe indicar el correo electrónico");
//            }
//
//            dao.eliminarUsuario(correoElectronico);
//        } catch (Exception e) {
//            throw e;
//        }
//    }

//    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {
//
//        try {
//
//            //Validamos
//            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
//                throw new Exception("Debe indicar el correo electrónico");
//            }
//
//            Usuario usuario = dao.buscarUsuarioPorCorreoElectronico(correoElectronico);
//
//            return usuario;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
//
//        try {
//
//            //Validamos
//            if (id == null) {
//                throw new Exception("Debe indicar el id");
//            }
//
//            Usuario usuario = dao.buscarUsuarioPorId(id);
//
//            return usuario;
//        } catch (Exception e) {
//            throw e;
//        }
//    }


    
    
}
