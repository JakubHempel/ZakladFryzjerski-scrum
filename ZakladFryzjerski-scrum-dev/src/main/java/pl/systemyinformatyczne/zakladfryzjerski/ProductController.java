package pl.systemyinformatyczne.zakladfryzjerski;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class ProductController
{
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public List<Product> getAll()
    {
        return productRepository.getAll();
    }
}
