package com.cosmetic.cosmeticController;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetic.cosmeticModel.CosmeticProductList;
import com.cosmetic.cosmeticModel.CosmeticUser;
import com.cosmetic.cosmeticService.CosmeticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
public class CosmeticController {
	
	@Autowired
	CosmeticService cosmeticService;
	
	
	@PostMapping("/saveUser")
	public CosmeticUser saveUser(@RequestBody CosmeticUser user){
		
		CosmeticUser info = cosmeticService.saveUserInfo(user.getName(), user.getMobile(), user.getEmail(), user.getUsername(), user.getPassword());
		return info;
	}
	
	@PostMapping("/saveproduct")
	public CosmeticProductList saveProduct(@RequestBody CosmeticProductList product) {
		CosmeticProductList productInfo = cosmeticService.saveProducts(product.getUsername(),product.getProductname(), product.getPrice());
		return productInfo;
		
	}
	
//	@GetMapping("/login")
//	public ResponseEntity<?> saveUser1( CosmeticUser user) {
//		
//		CosmeticUser info = 
//		}
	
	@GetMapping("/login")
    public Optional<CosmeticUser> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return CosmeticUser.getUserByUsernameAndPassword(username, password);
    }
	

}
