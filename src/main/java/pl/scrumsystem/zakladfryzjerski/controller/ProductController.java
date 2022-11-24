package pl.scrumsystem.zakladfryzjerski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.scrumsystem.zakladfryzjerski.entity.Product;
import pl.scrumsystem.zakladfryzjerski.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController
{
    @Autowired
    private ProductRepository pRepo;

    @GetMapping({"/showProducts", "/", "/list"})
    public ModelAndView showProducts()
    {
        ModelAndView mav = new ModelAndView("list-products");
        List<Product> list = pRepo.findAll();
        mav.addObject("products", list);
        return mav;
    }

    @GetMapping("/addProductForm")
    public ModelAndView addProductForm() {
        ModelAndView mav = new ModelAndView("add-product-form");
        Product newProduct = new Product();
        mav.addObject("product", newProduct);
        return mav;
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product) {
        pRepo.save(product);
        return "redirect:/list";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Long productId) {
        pRepo.deleteById(productId);
        return "redirect:/list";
    }
    
    @GetMapping("/report")
    public ModelAndView reportProduct() { //Nie wiem czy tutaj ma być ModelAndView czy coś innego ale działa :)
        ModelAndView modelAndView = new ModelAndView("report");
        modelAndView.addObject("report", "report");
        return modelAndView;
    }
}
