package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.dto.ClientDto;
import ua.lviv.iot.service.ClientService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/client")
@RestController
public class ClientController {
  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<ClientDto>> getAll() {
    List<Client> clients = clientService.getAll();
    List<ClientDto> clientDtos = new ArrayList<>();
    for (Client client : clients) {
      ClientDto clientDto = new ClientDto (
          client.getId(),
          client.getFirstName(),
          client.getLastName(),
          client.getBirthday(),
          client.getGender(),
          client.getAddress(),
          client.getCityId()
      );
      clientDtos.add(clientDto);
    }
    return new ResponseEntity<>(clientDtos, HttpStatus.OK);
  }
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<ClientDto> getById(@PathVariable Integer id) {
    Client client = clientService.getById(id);
    try {
      if (clientService.getById(id) != null && clientService.getById(id).getFirstName() != null) {
        ClientDto clientDto = new ClientDto(
            client.getId(),
            client.getFirstName(),
            client.getLastName(),
            client.getBirthday(),
            client.getGender(),
            client.getAddress(),
            client.getCityId()
        );
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<ClientDto> create(@RequestBody Client client) {
    ClientDto clientDto = new ClientDto(
        client.getId(),
        client.getFirstName(),
        client.getLastName(),
        client.getBirthday(),
        client.getGender(),
        client.getAddress(),
        client.getCityId()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(clientDto);
  }
  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<ClientDto> update(@PathVariable Integer id,
                                        @RequestBody Client client) {
    try {
      client.setId(id);
      Client oldClient = clientService.getById(id);
      if (oldClient != null && oldClient.getFirstName() != null) {
        clientService.update(id, client);
        ClientDto newClientDto = new ClientDto(
            client.getId(),
            client.getFirstName(),
            client.getLastName(),
            client.getBirthday(),
            client.getGender(),
            client.getAddress(),
            client.getCityId()
        );
        return new ResponseEntity<>(newClientDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    try {
      if (clientService.getById(id) != null && clientService.getById(id).getFirstName() != null) {
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}

