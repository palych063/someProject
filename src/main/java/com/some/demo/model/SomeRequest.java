package com.some.demo.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public final class SomeRequest {

    @NotEmpty
    @Size(min = 9, max = 9, message = "Wrong customer size, size should be equal 9 symbols")
    @Pattern(regexp = "^[0-9]+$", message = "Must be only digits")
    final String customer;

    @NotEmpty
    @Size(min = 9, max = 9, message = "Wrong seller size, size should be equal 9 symbols")
    @Pattern(regexp = "^[0-9]+$", message = "Must be only digits")
    final String seller;

    @NotEmpty
    @Valid
    final List<Product> products;

    public String getSomeId() {
        return getCustomer() + "_" + getSeller();
    }
}
