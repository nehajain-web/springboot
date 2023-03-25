package com.example.demo.controller;

import com.example.demo.entity.product;
import com.example.demo.helper.Productmyesxcelhelper;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
public class productcontroller {

  @Autowired
  private ProductService productService;

  @PostMapping("/product/upload")
  public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file)
  {
    if(Productmyesxcelhelper.checkExcelFormat(file))
    {
      productService.save(file);
      return ResponseEntity.ok("success");
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("pls upload excel");
  }

  @GetMapping("/products")
  public List<product> getall()
  {

    return productService.getAll();

  }
}
