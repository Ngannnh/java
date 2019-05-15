package com.store.snacks.java.sweet.controller;

import com.store.snacks.java.sweet.models.Product;
import com.store.snacks.java.sweet.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ngan nnh on 5/13/2019
 * @project sweet
 */
@Controller
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    private static ProductRepository productRepository;

    @Autowired public ProductController(ProductRepository productRepository) {
        ProductController.productRepository = productRepository;
    }

    @RequestMapping(value = { "/products" }, method = RequestMethod.GET) public ModelAndView products() {
        ModelAndView modelAndView = MainController.getMAV();
        modelAndView.addObject("products", productRepository.findAll());
        modelAndView.setViewName("product/products");
        return modelAndView;
    }

    @RequestMapping(value = { "/product-add" }, method = RequestMethod.GET) public ModelAndView addProduct() {
        ModelAndView modelAndView = MainController.getMAV();
        modelAndView.setViewName("product/product-add");
        return modelAndView;
    }

    @RequestMapping(value = { "/product-details/{id}" }, method = RequestMethod.GET)
    public ModelAndView productDetails(@PathVariable String id) {
        ModelAndView modelAndView = MainController.getMAV();
        modelAndView.addObject("product", getProductById(id));
        modelAndView.setViewName("product/product-details");
        return modelAndView;
    }

    @RequestMapping(value = { "/product-update/{id}" }, method = RequestMethod.GET)
    public ModelAndView productUpdate(@PathVariable String id) {
        ModelAndView modelAndView = MainController.getMAV();
        modelAndView.addObject("product", getProductById(id));
        modelAndView.setViewName("product/product-update");
        return modelAndView;
    }

    @RequestMapping(value = { "/save" }, method = RequestMethod.POST)
    public ModelAndView save(@RequestParam String id, @RequestParam String name, @RequestParam Integer price,
            @RequestParam String details) {
        ModelAndView modelAndView = MainController.getMAV();
        modelAndView.setViewName("redirect:/product-details/" + addProduct(id, name, price, details).getId());
        return modelAndView;
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable String id) {
        ModelAndView modelAndView = MainController.getMAV();
        modelAndView.setViewName("redirect:/products/");
        productRepository.delete(getProductById(id));
        return modelAndView;
    }

    private Product getProductById(String id) {
        try {
            Product product = new Product();
            if (productRepository.findById(id).isPresent()) {
                product = productRepository.findById(id).get();
            }
            LOGGER.info("Product ID: " + product.getId());
            return product;
        } catch (Exception e) {
            LOGGER.error("Exception " + MainController.getMethodName() + ": " + e);
            return new Product();
        }
    }

    private Product addProduct(String id, String name, int price, String details) {
        try {
            Product product = getProductById(id);
            product.setName(name);
            product.setPrice(price);
            product.setDetails(details);
            productRepository.save(product);
            LOGGER.info("Save product " + name + " success!");
            return product;
        } catch (Exception e) {
            LOGGER.error("Exception " + MainController.getMethodName() + ": " + e);
            return new Product();
        }
    }
}
