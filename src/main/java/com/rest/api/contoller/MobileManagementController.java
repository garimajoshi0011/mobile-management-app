package com.rest.api.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.dto.MobileManagementDTO;
import com.rest.api.dto.ProductDTO;
import com.rest.api.services.MobileManagementService;

@RestController
@RequestMapping("/mobilemanagement")
public class MobileManagementController {

	@Autowired
	private MobileManagementService mobilemgmtService;

	@RequestMapping(value = "/addmobilemgmt", method = RequestMethod.POST)
	public String createMobileMgmtDTO(@RequestBody MobileManagementDTO mobileMgmtDTO) {
		mobilemgmtService.createMobile(mobileMgmtDTO);
		return "Data entered successfully";
	}

	@RequestMapping(value = "/showlistmobilemgmt", method = RequestMethod.GET)
	public List<MobileManagementDTO> getAll() {
		List<MobileManagementDTO> all = this.mobilemgmtService.getAllMobile();
		return all;
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String createProduct(@RequestBody ProductDTO productDTO) {
		mobilemgmtService.create(productDTO);
		return "Product added successfully";
	}

	@RequestMapping(value = "/updateproduct/{productId}", method = RequestMethod.PUT)
	public String updateProduct(@RequestBody ProductDTO productDTO, @PathVariable int productId) {
		mobilemgmtService.update(productDTO, productId);
		return "The Product is Updated ";
	}

	@RequestMapping(value = "/deleteproduct", method = RequestMethod.DELETE)
	public String deleteProduct(@RequestParam int productId) {
		mobilemgmtService.delete(productId);
		//String message = Map.("message", "product is deleted");
		return "Product Deleted Successfully";
	}

	@RequestMapping(value = "/showproduct/{productId}", method = RequestMethod.GET)
	public ProductDTO getProduct(@PathVariable int productId) {
		ProductDTO productDTO = mobilemgmtService.getProductDetail(productId);
		return productDTO;
	}

	/*@RequestMapping(value = "/showlistproduct", method = RequestMethod.GET)
	public List<ProductDTO> getAll() {
		List<ProductDTO> all = mobilemgmtService.getAll();
		return all;
	}*/

}
