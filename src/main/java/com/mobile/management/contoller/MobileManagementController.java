package com.mobile.management.contoller;

import java.util.List;

import com.mobile.management.dto.UserProductDTO;
import com.mobile.management.dto.ProductDTO;
import com.mobile.management.services.MobileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobilemanagement")
public class MobileManagementController {

	@Autowired
	private MobileManagementService mobilemgmtService;

	@RequestMapping(value = "/add-userproduct", method = RequestMethod.POST)
	public String createUserProduct(@RequestBody UserProductDTO userProductDTO) {
		mobilemgmtService.createMobile(userProductDTO);
		return "Data entered successfully";
	}

	@RequestMapping(value = "/show-list-userproduct", method = RequestMethod.GET)
	public List<UserProductDTO> getAll() {
		List<UserProductDTO> all = this.mobilemgmtService.getAllMobile();
		return all;
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String createProduct(@RequestBody ProductDTO productDTO) {
		mobilemgmtService.create(productDTO);
		return "Product added successfully";
	}

	@RequestMapping(value = "/update-product/{productId}", method = RequestMethod.PUT)
	public String updateProduct(@RequestBody ProductDTO productDTO, @PathVariable int productId) {
		mobilemgmtService.update(productDTO, productId);
		return "The Product is Updated ";
	}

	@RequestMapping(value = "/delete-product", method = RequestMethod.DELETE)
	public String deleteProduct(@RequestParam int productId) {
		mobilemgmtService.delete(productId);
		return "Product Deleted Successfully";
	}

	@RequestMapping(value = "/show-product/{productId}", method = RequestMethod.GET)
	public ProductDTO getProduct(@PathVariable int productId) {
		ProductDTO productDTO = mobilemgmtService.getProductDetail(productId);
		return productDTO;
	}

	@RequestMapping(value = "/get-product-bybrand", method = RequestMethod.GET)
	public List<ProductDTO> getByBrand(@RequestParam String brandName) {
		List<ProductDTO> all = this.mobilemgmtService.getMobileByBrand(brandName);
		return all;
	}
//&brand=samsung
}
