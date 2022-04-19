package com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;
}
