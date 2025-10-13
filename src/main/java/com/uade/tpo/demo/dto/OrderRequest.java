package com.uade.tpo.demo.dto;

import java.util.List;

public class OrderRequest {
    private List<OrdenItemRequest> items;

    public List<OrdenItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrdenItemRequest> items) {
        this.items = items;
    }
}
