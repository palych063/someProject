package com.some.demo.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public final class Product {
    @NotEmpty
    @Size(min = 13, max = 13, message = "Wrong code id size, size should be equal 9 symbols")
    @Pattern(regexp="^[0-9]+$", message = "Must be only digits")
    final String code;

    final String name;
}
