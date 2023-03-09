package com.example.rentACar.business.rules;


import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.core.utilities.exceptions.BusinessException;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExits(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand already exists!");
        }
    }
}
