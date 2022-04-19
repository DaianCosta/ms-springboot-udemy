package com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.service;

import com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.domain.Entity.Client;
import com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.gateway.Repository.IClientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CreateOrUpdateClientService
{
    @Autowired
    private IClientRepository clientRepository;

    public void execute(Client client){
        log.info("Gravando client");
        clientRepository.save(client);
        log.info("client gravado com o ID = "+ client.getId());
    }
}
