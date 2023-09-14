package com.mycompany.restaurante;

public class Menu {
    
    private String cliente;
    private String comida;
    private int precio;

    // Constructores, getters y setters

    public Menu() {
        // Constructor vacío requerido para Firebase
    }
    
    public Menu(String cliente, String comida, int precio) {
    this.cliente = cliente;
    this.comida = comida;
    this.precio = precio;
    }

    // Getters y setters
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
        public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }
    
    
}
