/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Marca;
import java.sql.*;
import java.util.*;

/**
 *
 * @author luisr
 */

// DAO -> Data Access Object
// Patrón de Diseño

public class MarcaDAO {
    //CRUD -> Create, Read, Update, Delete
    //Lectura
    private static final String SQL_SELECT = "SELECT idmarca, nombre FROM marca";
    //Creación
    //Caracter Comodín -> ? -> parámetro
    private static final String SQL_INSERT = "INSERT INTO marca(nombre) VALUES (?)";
    //Actualización
    //UPDATE nombreTabla SET campo = valor, campo2 = valor2 ... WHERE idmarca = x
    private static final String SQL_UPDATE = "UPDATE marca SET nombre = ? WHERE idmarca = ?";
    //Elminiación
    //DELETE FROM nombreTabla WHERE id = x
    private static final String SQL_DELETE = "DELETE FROM marca WHERE idmarca = ?";
    
    public ArrayList<Object[]> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Object[]> marcas = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                //Object[número de columnas de mi tabla]
                Object[] marca = new Object[2];
                //numero[] = {1, 2, 3, 4, 5};
                //numero[] = {pos0, pos1, pos2, pos3, pos4};
                //Iterar un array
                //marca[] = {pos0, pos1}
                for(int i = 0; i <= 1; i++){
                    //marca[0] <= {Objeto}
                    marca[i] = rs.getObject(i+1);
                }
                //Almacenamos en la lista
                marcas.add(marca);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return marcas;
    }
    
    public int insertar(Marca marca){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try{
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            //Capturamos información del objeto proveniente
            //setString(índice/ubicación, "string");
            stmt.setString(1, marca.getNombre());
            //executeUpdate() nos ayuda a manipular datos de la BD.
            registros = stmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Marca marca){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try{
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            //Capturamos información del objeto proveniente
            //setString(índice/ubicación, "string");
            stmt.setString(1, marca.getNombre());
            //Capturamos el ID del registro a manipular, y lo enviamos
            //al parámetro número 2.
            stmt.setInt(2, marca.getIdMarca());
            //executeUpdate() nos ayuda a manipular datos de la BD.
            registros = stmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminar(Marca marca){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try{
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            //Capturamos información del objeto proveniente
            //Capturamos el ID del registro a manipular, y lo enviamos al parámetro número 1.
            stmt.setInt(1, marca.getIdMarca());
            //executeUpdate() nos ayuda a manipular datos de la BD.
            registros = stmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
