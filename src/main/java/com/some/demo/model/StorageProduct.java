package com.some.demo.model;

import lombok.Data;

@Data
public final class StorageProduct {
    String publicCode;
    String internalData;

    public StorageProduct(String publicCode, String internalData) {
        this.publicCode = publicCode;
        this.internalData = internalData;
    }
}
