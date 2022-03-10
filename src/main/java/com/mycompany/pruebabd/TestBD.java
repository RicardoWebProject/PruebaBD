/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebabd;

import java.sql.*;

/**
 *
 * @author luisr
 */
public class TestBD {
    public static void main(String[] args) {
        //CRUD -> Create, Read, Update & Delete.
        
        //url -> jdbc:mysql//host:3306/baseDeDatos?argumentos
        String url = "jdbc:mysql://localhost:3306/ejemplo_conexion?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //(urlConexion, usuario, contraseña)
            Connection conexion = DriverManager.getConnection(url, "root", "johnlennon09");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT idmarca, nombre FROM marca";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            //Lectura del resultado del query
            while(resultado.next()){
                System.out.println("ID marca: " + resultado.getInt("idmarca"));
                System.out.println("Nombre de la marca: " + resultado.getString("nombre"));
                System.out.println("...................");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
