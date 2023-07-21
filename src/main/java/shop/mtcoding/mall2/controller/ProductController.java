package shop.mtcoding.mall2.controller;

import shop.mtcoding.mall2.model.Product;
import shop.mtcoding.mall2.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/product")
    public String write(String name, int price, int qty, HttpServletResponse response) throws IOException {
        productRepository.save(name, price, qty);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request) {
        Product product = productRepository.findById(id);
        request.setAttribute("p", product);
        return "detail";
    }

    @PostMapping("/product/delete")
    public String delete(int id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/product/update")
    public String update(String name, int price, int qty, int id) {
        productRepository.update(name, price, qty, id);
        return "redirect:/";
    }
}
