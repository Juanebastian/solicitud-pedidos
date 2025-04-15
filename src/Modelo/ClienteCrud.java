
package Modelo;
/*========================================================================== 
  Encabezado de los M�dulos (Bibliotecas) 
 =========================================================================== 
*/ 

import java.sql.Connection;/*Proporciona interfaces para la conexión con bases de datos*/
import java.sql.PreparedStatement;/*Es una interfaz utilizada para ejecutar consultas SQL precompiladas.*/
import java.sql.ResultSet;/*Representa un conjunto de resultados de una consulta SQL.*/
import java.sql.SQLException;/*Es una excepción que indica errores relacionados con operaciones de bases de datos*/
import java.util.ArrayList;/* Implementa la interfaz List y proporciona una implementación de matriz*/
import java.util.List;/* define operaciones básicas para trabajar con listas.*/
import javax.swing.JOptionPane;/*se utiliza para mostrar cuadros de diálogo*/



public class ClienteCrud {
    // se crea una nueva instancia de la clase Conexion y se está asignando a la variable "cn". Conexion es una clase que maneja la conexión a la base de datos.
    Conexion cn = new Conexion();
    //Se está declarando una variable llamada con del tipo Connection. Esta variable  se utilizará para representar la conexión a la base de datos.
    Connection con;
    //Se está declarando una variable llamada ps del tipo PreparedStatement. Este tipo de objeto se utiliza para ejecutar consultas SQL precompiladas.
    PreparedStatement ps;
    //Se está declarando una variable llamada rs del tipo ResultSet. Esta variable se utilizará para almacenar los resultados de una consulta SQL y navegar a través de ellos.
    ResultSet rs;
     
    /*=========================================================================*
     * Metodos
     *=========================================================================*/
    
    /**
     * <b>RegistrarCliente()</b>
     * <b>OBJETIVO:</b>  Registra un nuevo cliente en la base de datos.
     * @param cl Objeto Cliente que contiene la información del cliente a registrar.
     * @return true si el cliente se registra con éxito, false si ocurre un error.
     */
    public boolean AgregarCliente(Cliente cl){
        //Se define una cadena sqlque representa una consulta SQL de inserción para agregar un nuevo cliente a la tabla "clientes".
        String sql = "INSERT INTO pedidos_clientes (`id`, `no_doc`, `nombre`, `menu_1`, `menu_2`, `menu_3`, `menu_4`, `total`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            //Se establece una conexión a la base de datos utilizando un objeto llamado cn.
            //La conexión se almacena en un objeto con.
            con = cn.getConnection();
            //Se prepara una declaración SQL utilizando la conexión establecida y la cadena SQL definida anteriormente.
            ps = con.prepareStatement(sql);
            //Se ejecuta la consulta y se obtiene un conjunto de resultados ( ResultSet) llamado rs.
            ps.setInt(1,cl.getId());
            ps.setInt(2,cl.getDoc());
            ps.setString(3, cl.getNombres());
            ps.setInt(4, cl.getMenu_1());
            ps.setInt(5, cl.getMenu_2());
            ps.setInt(6, cl.getMenu_3());
            ps.setInt(7, cl.getMenu_4());
            ps.setInt(8, cl.getTotal());
            //Se ejecuta la consulta de inserción.
            ps.execute();
            return true;
        } //Fin try
        catch (SQLException e) {//En caso de que ocurra una excepción de tipo SQLException
            //se muestra un mensaje de diálogo con el mensaje de error 
            JOptionPane.showMessageDialog(null, e.toString());
            //y se devuelve false
            return false;
        }//Fin catch
        finally{
            try {
                con.close();
            } //Fin try
            catch (SQLException e) {
                System.out.println(e.toString());
            }//Fin catch
        }//Fin finally
    }//Fin metodo RegistrarCliente
    
    public List<Cliente> ListarCliente() {
    List<Cliente> ListaCl = new ArrayList<>();
    String sql = "SELECT * FROM pedidos_clientes"; // Modificado para reflejar el nombre correcto de la tabla
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Cliente cl = new Cliente();
            cl.setId(rs.getInt("id"));
            cl.setDoc(rs.getInt("no_doc")); // Modificado para reflejar el nombre correcto de la columna
            cl.setNombres(rs.getString("nombre")); // Modificado para reflejar el nombre correcto de la columna
            cl.setMenu_1(rs.getInt("menu_1")); // Modificado para reflejar el nombre correcto de la columna
            cl.setMenu_2(rs.getInt("menu_2")); // Modificado para reflejar el nombre correcto de la columna
            cl.setMenu_3(rs.getInt("menu_3")); // Modificado para reflejar el nombre correcto de la columna
            cl.setMenu_4(rs.getInt("menu_4")); // Modificado para reflejar el nombre correcto de la columna
            cl.setTotal(rs.getInt("total")); // Modificado para reflejar el nombre correcto de la columna
            ListaCl.add(cl);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    return ListaCl;
}

    /**
     * <b>EliminarCliente()</b>
     * <b>OBJETIVO:</b>  Elimina un cliente de la base de datos por su ID.
     *
     * @param id El ID del cliente a eliminar.
     * @return true si la eliminación es exitosa, false si ocurre un error.
     */
    public boolean EliminarCliente(int id) {
        String sql = "DELETE FROM pedidos_clientes WHERE id = ?";
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
           //Se ejecuta la consulta de eliminación.
            ps.execute();
           return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    /**
     * <b>ModificarCliente()</b>
     * <b>OBJETIVO:</b>     Modifica la información de un cliente en la base de datos.
     *
     * @param cl Objeto Cliente que contiene la nueva información del cliente.
     * @return true si la modificación es exitosa, false si ocurre un error.
     */
    public boolean ActualizarCliente(Cliente cl) {
        String sql = "UPDATE pedidos_clientes SET nombre=?, no_doc=?, menu_1=?, menu_2=?, menu_3=?, menu_4=?, total=? WHERE id=?";
        try {
           con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,cl.getNombres());
            ps.setInt(2,cl.getDoc());
            ps.setInt(3,cl.getMenu_1());
            ps.setInt(4,cl.getMenu_2());
            ps.setInt(5,cl.getMenu_3());
            ps.setInt(6,cl.getMenu_4());
            ps.setInt(7,cl.getTotal());
            ps.setInt(8,cl.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }  
   
}//Fin clase ClienteCrud
