package com.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ashokit.dto.ProductEvent;
import com.ashokit.entity.Product;
import com.ashokit.repository.ProductRepository;

@Service//Ashutosh
public class ProductCommandService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public Product createProduct(ProductEvent productEvent){
    	//Create Product DB Call
        Product productDO = repository.save(productEvent.getProduct());
        ProductEvent event=new ProductEvent("CreateProduct", productDO);
        
        //Sending the Create Product to KAFKA Topic
        kafkaTemplate.send("product-event-topic", event);
        return productDO;
    }

    public Product updateProduct(long id,ProductEvent productEvent){
    	
    	//DB Code for Updating Product
        Product existingProduct = repository.findById(id).get();
        Product newProduct=productEvent.getProduct();
        existingProduct.setName(newProduct.getName());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setDescription(newProduct.getDescription());
        Product productDO = repository.save(existingProduct);
        
        //Sending Update Event to Kafka
        ProductEvent event=new ProductEvent("UpdateProduct", productDO);
        kafkaTemplate.send("product-event-topic", event);
        return productDO;
    }

}
