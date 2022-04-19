package com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.gateway.Repository;

import com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.domain.Entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientRepository extends CrudRepository<Client, Long> {
}
