package com.example.rentACar.business.requests;

import com.example.rentACar.entities.concretes.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelRequest {

    @NotNull
    @NotBlank
    @Size(min= 3, max= 20)
    private String name;

    @NotNull
    @NotBlank
    private int brandId;

}
