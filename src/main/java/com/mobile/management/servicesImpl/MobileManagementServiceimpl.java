package com.mobile.management.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mobile.management.dto.UserProductDTO;
import com.mobile.management.dto.ProductDTO;
import com.mobile.management.entities.UserProduct;
import com.mobile.management.entities.Product;
import com.mobile.management.entities.User;
import com.mobile.management.repositories.UserProductRepository;
import com.mobile.management.repositories.ProductRepository;
import com.mobile.management.services.MobileManagementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileManagementServiceimpl implements MobileManagementService {

	@Autowired
	private UserProductRepository userProductRepository;

	@Autowired
	private ProductRepository productRepository;

	public void createMobile(UserProductDTO mobileMgmtDTO) {
		UserProduct mobileMgmt = new UserProduct();
		User user = new User();
		Product product = new Product();
		mobileMgmt.setName(mobileMgmtDTO.getName());
		mobileMgmt.setAbout(mobileMgmtDTO.getAbout());
		mobileMgmt.setPrice(mobileMgmtDTO.getPrice());
		//mobileMgmt.setProductId(mobileMgmtDTO.getProductId());
		//mobileMgmt.setUserId(mobileMgmtDTO.getUserId());
		user.setAge(mobileMgmtDTO.getUser().getAge());
		user.setName(mobileMgmtDTO.getUser().getName());
		user.setPassword(mobileMgmtDTO.getUser().getPassword());
		user.setId(mobileMgmtDTO.getUser().getId());
		product.setBrand(mobileMgmtDTO.getProduct().getBrand());
		product.setColour(mobileMgmtDTO.getProduct().getColour());
		product.setPrice(mobileMgmtDTO.getProduct().getPrice());
		product.setId(mobileMgmtDTO.getProduct().getId());
		mobileMgmt.setUserId(user);
		mobileMgmt.setProductId(product);
		userProductRepository.save(mobileMgmt);

	}

	public UserProduct getMobileById(long id) {
		Optional<UserProduct> mobileItem = this.userProductRepository.findById(id);
		return mobileItem.get();
	}

	public List<UserProductDTO> getAllMobile() {
		List<UserProduct> all = this.userProductRepository.findAll();
		List<UserProductDTO> mobileMgmtDTOS = new ArrayList();
		for (UserProduct mobileMgmt : all) {
			UserProductDTO mobileMgmtDTO = new UserProductDTO();
			mobileMgmtDTO.setPrice(mobileMgmt.getPrice());
			mobileMgmtDTO.setName(mobileMgmt.getName());
			mobileMgmtDTO.setAbout(mobileMgmt.getAbout());
			mobileMgmtDTOS.add(mobileMgmtDTO);
		}
		return mobileMgmtDTOS;
	}

	public Product create(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		return productRepository.save(product);
	}

	public void update(ProductDTO productDTO, int productDTO_id) {
		Product product = productRepository.findById(productDTO_id).orElse(null);
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setProductName(productDTO.getProductName());
		product.setBrand(productDTO.getBrand());
		product.setColour(productDTO.getColour());
		productRepository.save(product);

	}

	public void delete(int productId) {
		Product product1 = this.productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product is not found !!"));
		productRepository.delete(product1);

	}

	public List<ProductDTO> getAll() {
		List<Product> all = productRepository.findAll();
		List<ProductDTO> ProductDTOS = new ArrayList();
		for (Product product : all) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setPrice(product.getPrice());
			productDTO.setDescription(product.getDescription());
			product.setProductName(productDTO.getProductName());
			product.setBrand(productDTO.getBrand());
			product.setColour(productDTO.getColour());
			ProductDTOS.add(productDTO);
		}
		return ProductDTOS;
	}

	public ProductDTO getProductDetail(int productId) {
		Product product = productRepository.findById(productId).orElse(null);
        ProductDTO productDTO = new ProductDTO();
        if(product!=null){
            BeanUtils.copyProperties(product,productDTO);
        }
        return  productDTO;
	}

}
