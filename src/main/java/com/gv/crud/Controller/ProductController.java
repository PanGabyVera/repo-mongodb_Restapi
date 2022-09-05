/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gv.crud.Controller;

import com.gv.crud.Model.ProductDTO;
import com.gv.crud.Repository.IProductDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pandora
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})

@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired
    private IProductDAO respository;
    
    @PostMapping("/crear")
    public ProductDTO create(@Validated @RequestBody ProductDTO p) {
        return respository.insert(p);
    }
    
    @GetMapping("/")
    public List<ProductDTO> readAll() {
        return respository.findAll();
    }
    
    @PutMapping("/editar/{id}")
    public ProductDTO update(@PathVariable String id, @Validated @RequestBody ProductDTO p) {
        return respository.save(p);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        respository.deleteById(id);
    }
}
