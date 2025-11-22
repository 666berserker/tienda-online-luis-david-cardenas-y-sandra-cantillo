
package com.electiva2.tiendaonline.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CarritoItemRequest {

    @NotNull
    private Integer idProducto;

    @NotNull
    @Min(1)
    private Integer cantidad;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
