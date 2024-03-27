package com.example.onism.validator;



import com.example.onism.entity.KichThuoc;
import com.example.onism.entity.Loai;
import com.example.onism.validator.annotation.ValidKichThuocId;
import com.example.onism.validator.annotation.ValidLoaiId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidKichThuocValidator implements ConstraintValidator<ValidKichThuocId, KichThuoc>{

    @Override
    public boolean isValid(KichThuoc kichThuoc, ConstraintValidatorContext context){
        return kichThuoc != null && kichThuoc.getId() != null;
    }
}
