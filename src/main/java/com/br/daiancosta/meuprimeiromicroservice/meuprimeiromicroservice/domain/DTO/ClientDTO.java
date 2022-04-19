package com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    @NotNull(message = "{field.name.required}")
    @NotEmpty(message = "{field.name.empty}")
    private String name;
}
