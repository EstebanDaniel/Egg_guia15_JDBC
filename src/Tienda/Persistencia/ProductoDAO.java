
package Tienda.Persistencia;

import Tienda.Entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;


public final class ProductoDAO extends DAO {
    
      public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }

            String sql = "INSERT INTO Producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ( '" + producto.getNombre()+ "' , '" + producto.getPrecio()+ "', '" + producto.getCodigoFabricante()+ "' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }

            String sql = "UPDATE Producto SET "
                    + "precio = '" + producto.getPrecio()+ "' WHERE nombre = '" + producto.getNombre()+ "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(String nombre) throws Exception {
        try {

            String sql = "DELETE FROM Usuario WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }


    public Collection<Producto> listarProductosPorNombre() throws Exception {
        try {
            String sql = "SELECT nombre FROM Producto";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
       public Collection<Producto> listarProductosPorNombrePrecios() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
       
       public Collection<Producto> listarPorPrecioDeterminado() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202;";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setPrecio(resultado.getDouble(3));
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
       
         public Collection<Producto> listaPortatil() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%portatil%';";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(2));
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
         
          public Producto precioMin() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto WHERE precio = (SELECT MIN(precio) FROM producto);";

            consultarBase(sql);

            Producto producto = null;
          
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                      
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    
 
    public Producto buscarProductoPorNombre(String nombre) throws Exception {
       try {
           String sql = "SELECT * FROM Producto "
                   + " WHERE nombre = '" + nombre + "'";

           consultarBase(sql);

           Producto producto = null;
         while (resultado.next()) {
                producto = new Producto();
               producto.setCodigo(resultado.getInt(1));
               producto.setNombre(resultado.getString(2));
               producto.setPrecio(resultado.getDouble(3));
               producto.setCodigoFabricante(resultado.getInt(4));
           }
            desconectarBase();
           return producto;
       } catch (Exception e) {
           desconectarBase();
          throw e;
        }
    }
}
//
//    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
//        try {
//
//            String sql = "SELECT * FROM Usuario "
//                    + " WHERE id = '" + id + "'";
//
//            consultarBase(sql);
//
//            Usuario usuario = null;
//            while (resultado.next()) {
//                usuario = new Usuario();
//                usuario.setId(resultado.getInt(1));
//                usuario.setCorreoElectronico(resultado.getString(2));
//                usuario.setClave(resultado.getString(3));
//            }
//            desconectarBase();
//            return usuario;
//        } catch (Exception e) {
//            desconectarBase();
//            throw e;
//        }
//    }