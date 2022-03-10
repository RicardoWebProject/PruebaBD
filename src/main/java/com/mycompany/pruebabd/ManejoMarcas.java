/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebabd;

import datos.MarcaDAO;
import domain.Marca;
import java.util.List;

/**
 *
 * @author luisr
 */
public class ManejoMarcas {
    public static void main(String[] args) {
        //Instanciar un nuevo objeto DAO de Marcas
        MarcaDAO marcaDao = new MarcaDAO();
        
        /*Insertar nueva marca*/
        Marca nuevaMarca = new Marca("Nike");
        marcaDao.insertar(nuevaMarca);
        
        /*Listado de marcas*/
//        List<Marca> marcas = marcaDao.seleccionar();
//        //Recorremos el listado
//        marcas.forEach(marca -> {
//            System.out.println("Marca: " + marca);
//        });
        
        /*Actualizar/Modificar un registro*/
        //constructor(id que quiero modificar, el nuevo valor)
//        Marca marcaModificada = new Marca(5, "Nike");
//        marcaDao.actualizar(marcaModificada);

        /*Eliminar un registro*/
//        Marca marcaEliminada = new Marca(5);
//        marcaDao.eliminar(marcaEliminada);
    }
}
