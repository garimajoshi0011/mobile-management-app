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

	public void createMobile(UserProductDTO userProductDTO) {
		UserProduct userProduct = new UserProduct();
		//User user = new User();
		BeanUtils.copyProperties(userProductDTO,userProduct);
		userProductRepository.save(userProduct);


//		userProduct.setUserName(userProductDTO.getUserName());
//		userProduct.setPrice(userProductDTO.getPrice());
//		//userProduct.setProductId(userProductDTO.getProductId());
//		//userProduct.setUserId(userProductDTO.getUserId());
//		user.setAge(userProductDTO.getUser().getAge());
//		user.setUserName(userProductDTO.getUser().getName());
//		user.setPassword(userProductDTO.getUser().getPassword());
//		user.setId(userProductDTO.getUser().getId());
//		product.setBrand(userProductDTO.getProduct().getBrand());
//		product.setColour(userProductDTO.getProduct().getColour());
//		product.setPrice(userProductDTO.getProduct().getPrice());
//		product.setId(userProductDTO.getProduct().getId());
//		userProduct.setUserId(user);
//		userProduct.setProductId(product);
//		userProductRepository.save(userProduct);

	}

	public UserProduct getMobileById(long id) {
		Optional<UserProduct> mobileItem = this.userProductRepository.findById(id);
		return mobileItem.get();
	}

	public List<UserProductDTO> getAllMobile() {
		List<UserProduct> all = this.userProductRepository.findAll();
		List<UserProductDTO> userProductDTOS = new ArrayList();
		for (UserProduct userProduct : all) {
			UserProductDTO userProductDTO = new UserProductDTO();
			BeanUtils.copyProperties(userProduct,userProductDTO);
			userProductDTOS.add(userProductDTO);
		}
		return userProductDTOS;
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
