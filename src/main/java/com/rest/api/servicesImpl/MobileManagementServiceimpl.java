package com.rest.api.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.dto.MobileManagementDTO;
import com.rest.api.dto.ProductDTO;
import com.rest.api.entities.MobileManagement;
import com.rest.api.entities.Product;
import com.rest.api.repositories.MobileManagementRepository;
import com.rest.api.repositories.ProductRepository;
import com.rest.api.services.MobileManagementService;

@Service
public class MobileManagementServiceimpl implements MobileManagementService {

	@Autowired
	private MobileManagementRepository mobileMgmtRepository;

	@Autowired
	private ProductRepository productRepository;

	public void createMobile(MobileManagementDTO mobileMgmtDTO) {
		MobileManagement mobileMgmt = new MobileManagement();
		mobileMgmt.setName(mobileMgmtDTO.getName());
		mobileMgmt.setAbout(mobileMgmtDTO.getAbout());
		mobileMgmt.setPrice(mobileMgmtDTO.getPrice());
		mobileMgmt.setAge(mobileMgmtDTO.getAge());
		mobileMgmtRepository.save(mobileMgmt);

	}

	public MobileManagement getMobileById(long id) {
		Optional<MobileManagement> mobileItem = this.mobileMgmtRepository.findById(id);
		return mobileItem.get();
	}

	public List<MobileManagementDTO> getAllMobile() {
		List<MobileManagement> all = this.mobileMgmtRepository.findAll();
		List<MobileManagementDTO> mobileMgmtDTOS = new ArrayList();
		for (MobileManagement mobileMgmt : all) {
			MobileManagementDTO mobileMgmtDTO = new MobileManagementDTO();
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
		product.setAbout(productDTO.getAbout());
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
			productDTO.setAbout(product.getAbout());
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
