package com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.domain.DTO;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiError {
    @Getter
    private List<String> errors;

    public ApiError(List<String> errors) {
        this.errors = errors;
    }

    public ApiError(String mensagemErro){
        this.errors = Arrays.asList(mensagemErro);
    }
}
