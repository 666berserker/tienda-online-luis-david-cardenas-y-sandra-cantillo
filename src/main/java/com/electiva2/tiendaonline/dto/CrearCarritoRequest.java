
package com.electiva2.tiendaonline.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CrearCarritoRequest {

    @NotEmpty
    private List<CarritoItemRequest> items;

    public List<CarritoItemRequest> getItems() {
        return items;
    }

    public void setItems(List<CarritoItemRequest> items) {
        this.items = items;
    }
}
