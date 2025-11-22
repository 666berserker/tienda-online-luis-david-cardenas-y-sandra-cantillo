
package com.electiva2.tiendaonline.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrdenProductoId implements Serializable {

    private Integer idOrden;
    private Integer idProducto;

    public OrdenProductoId() {
    }

    public OrdenProductoId(Integer idOrden, Integer idProducto) {
        this.idOrden = idOrden;
        this.idProducto = idProducto;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdenProductoId)) return false;
        OrdenProductoId that = (OrdenProductoId) o;
        return Objects.equals(idOrden, that.idOrden) && Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrden, idProducto);
    }
}
