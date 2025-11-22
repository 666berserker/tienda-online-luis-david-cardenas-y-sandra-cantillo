
package com.electiva2.tiendaonline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Orden_Productos")
public class OrdenProducto {

    @EmbeddedId
    private OrdenProductoId id = new OrdenProductoId();

    @ManyToOne
    @MapsId("idOrden")
    @JoinColumn(name = "idOrden")
    private OrdenDeCompra orden;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "idProducto")
    private Producto producto;

    private Integer cantidad;

    private Double precioUnitario;

    public OrdenProducto() {
    }

    public OrdenProducto(OrdenDeCompra orden, Producto producto, Integer cantidad, Double precioUnitario) {
        this.orden = orden;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.id = new OrdenProductoId(orden.getIdOrden(), producto.getIdProducto());
    }

    public OrdenProductoId getId() {
        return id;
    }

    public void setId(OrdenProductoId id) {
        this.id = id;
    }

    public OrdenDeCompra getOrden() {
        return orden;
    }

    public void setOrden(OrdenDeCompra orden) {
        this.orden = orden;
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

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
