/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TechNova;

/**
 *
 * @author Eider
 */
public class Producto {

    private String nombre;
    private String categoria;
    private String descripcion;
    private String precio;
    private String imagen;

    public Producto(String nombre, String categoria,
                    String descripcion, String precio,
                    String imagen) {

        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public String getImagen() {
        return imagen;
    }
}

