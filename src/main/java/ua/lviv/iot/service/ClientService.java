package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService extends AbstractService<Client, Integer> {

  private final ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  protected JpaRepository<Client, Integer> getRepository() {
    return clientRepository;
  }

}
