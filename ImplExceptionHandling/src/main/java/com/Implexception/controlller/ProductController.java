package com.Implexception.controlller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Implexception.Exception.ProductNotFoundException;
import com.Implexception.entity.product;


@RestController
public class ProductController {
   
	public static Map<String,product> productrepo=new HashMap<>();
	
	static {
		 product p1=new product("1","Amsa");
		  product p2=new product("2", "nitin");
		  productrepo.put(p1.getId(),p1);
		  productrepo.put(p2.getId(), p2);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable String id,@RequestBody product product){
		 if(!productrepo.containsKey(id)) throw new ProductNotFoundException();
		 productrepo.remove(id);
		  product.setId(id);
		  productrepo.put(id, product);
		return new ResponseEntity<>("product updated successfully",HttpStatus.OK);
		
	}
	
	@GetMapping("product")
	public ResponseEntity<List<product>> getAllproduct(){
		return new ResponseEntity(productrepo,HttpStatus.OK);
		
	}
}
