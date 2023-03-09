package com.example.rentACar.business.concretes;

import com.example.rentACar.business.abstracts.ModelService;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllModelsResponse;
import com.example.rentACar.business.rules.BrandBusinessRules;
import com.example.rentACar.core.utilities.exceptions.BusinessException;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.ModelRepository;
import com.example.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = modelRepository.findAll();


        List<GetAllModelsResponse> responseItems = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model,GetAllModelsResponse.class)).collect(Collectors.toList());

        return responseItems;


    }

    @Override
    public void add(CreateModelRequest createModelRequest) {

        this.brandBusinessRules.checkIfBrandNameExits(createModelRequest.getName());

        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }
}
