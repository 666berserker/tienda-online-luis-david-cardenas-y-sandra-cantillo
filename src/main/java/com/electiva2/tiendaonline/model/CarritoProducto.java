
package com.electiva2.tiendaonline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Carrito_Productos")
public class CarritoProducto {

    @EmbeddedId
    private CarritoProductoId id = new CarritoProductoId();

    @ManyToOne
    @MapsId("idCarrito")
    @JoinColumn(name = "idCarrito")
    private CarritoDeCompras carrito;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "idProducto")
    private Producto producto;

    private Integer cantidad = 1;

    public CarritoProducto() {
    }

    public CarritoProducto(CarritoDeCompras carrito, Producto producto, Integer cantidad) {
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
        this.id = new CarritoProductoId(carrito.getIdCarrito(), producto.getIdProducto());
    }

    public CarritoProductoId getId() {
        return id;
    }

    public void setId(CarritoProductoId id) {
        this.id = id;
    }

    public CarritoDeCompras getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoDeCompras carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
