package pl.systemyinformatyczne.zakladfryzjerski;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController
{
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/test")
    public int test()
    {
        return 1;
    }

    @GetMapping("/clients")
    public List<Client> getAll()
    {
        return clientRepository.getAll();
    }
}
