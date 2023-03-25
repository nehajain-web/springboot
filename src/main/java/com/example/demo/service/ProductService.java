package com.example.demo.service;

import com.example.demo.Repo.ProductRepo;
import com.example.demo.entity.product;
import com.example.demo.helper.Productmyesxcelhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
  @Autowired
  private ProductRepo productRepo;
  public void save(MultipartFile file)
  {
    try {
      List<product> products = Productmyesxcelhelper.convertExcelToListOfProduct(file.getInputStream());
      this.productRepo.saveAll(products);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }



  public List<product> getAll()
  {
return productRepo.findAll();
  }
}
