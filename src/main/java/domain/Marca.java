/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author luisr
 */
public class Marca {
    //Atributos
    private int idMarca;
    private String nombre;
    
    //Constructores
    public Marca(){
    }

    //Para eliminar un registro
    public Marca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    //Para crear un nuevo registro
    public Marca(String nombre) {
        this.nombre = nombre;
    }

    //Actualizar un registro
    public Marca(int idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "idMarca= " + idMarca + ", nombre= " + nombre;
    }
}
