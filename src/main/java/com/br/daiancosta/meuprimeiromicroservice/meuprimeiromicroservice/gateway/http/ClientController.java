package com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.gateway.http;

import com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.domain.Entity.Client;
import com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.gateway.Repository.IClientRepository;
import com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.service.CreateOrUpdateClientService;
import com.br.daiancosta.meuprimeiromicroservice.meuprimeiromicroservice.domain.DTO.ClientDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private CreateOrUpdateClientService createOrUpdateClientService;

    @Autowired
    private IClientRepository clientRepository;

    @PostMapping
    @ResponseBody
    public ClientDTO Post(@Valid @RequestBody ClientDTO clientDTO){
        log.info(clientDTO);
        Client clientEntity = Client.builder().name(clientDTO.getName()).build();
        createOrUpdateClientService.execute(clientEntity);
        return clientDTO;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Put(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO){
        log.info(clientDTO);

        var client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado."));

        Client clientEntity = Client.builder().id(client.getId()).name(clientDTO.getName()).build();
        createOrUpdateClientService.execute(clientEntity);

    }

    @GetMapping
    @ResponseBody
    public List<ClientDTO> getClient(){

        List<ClientDTO> clients = new ArrayList<>();
        Iterable<Client> allEntity= clientRepository.findAll();
        allEntity.forEach(client -> clients.add(
                ClientDTO
                .builder()
                .id(client.getId())
                .name(client.getName())
                .build())
        );

        return clients;
    }
}
