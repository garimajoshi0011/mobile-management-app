package com.rest.apii.contollers;

import com.rest.apii.DTO.MobileMgmtDTO;
import com.rest.apii.DTO.ProductDTO;
import com.rest.apii.Services.MobileMgmtService;
import com.rest.apii.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mobilemgmt")
public class MobileMgmtController {

	@Autowired
	private MobileMgmtService mobilemgmtService;

	@RequestMapping(value = "/addmobilemgmt", method = RequestMethod.POST)
	public String createMobileMgmtDTO(@RequestBody MobileMgmtDTO mobileMgmtDTO) {
		mobilemgmtService.createMobile(mobileMgmtDTO);
		return "Data entered successfully";
	}

	@RequestMapping(value = "/showlistmobilemgmt", method = RequestMethod.GET)
	public List<MobileMgmtDTO> getAll() {
		List<MobileMgmtDTO> all = this.mobilemgmtService.getAllMobile();
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
