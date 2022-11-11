package com.rest.apii.Services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.apii.DTO.MobileMgmtDTO;
import com.rest.apii.DTO.ProductDTO;
import com.rest.apii.Services.MobileMgmtService;
import com.rest.apii.entities.MobileMgmt;
import com.rest.apii.entities.Product;
import com.rest.apii.repositories.MobileMgmtRepository;
import com.rest.apii.repositories.ProductRepository;

@Service
public class MobileMgmtServiceimpl implements MobileMgmtService {

	@Autowired
	private MobileMgmtRepository mobileMgmtRepository;

	@Autowired
	private ProductRepository productRepository;

	public void createMobile(MobileMgmtDTO mobileMgmtDTO) {
		MobileMgmt mobileMgmt = new MobileMgmt();
		mobileMgmt.setName(mobileMgmtDTO.getName());
		mobileMgmt.setAbout(mobileMgmtDTO.getAbout());
		mobileMgmt.setPrice(mobileMgmtDTO.getPrice());
		mobileMgmt.setAge(mobileMgmtDTO.getAge());
		mobileMgmtRepository.save(mobileMgmt);

	}

	public MobileMgmt getMobileById(long id) {
		Optional<MobileMgmt> mobileItem = this.mobileMgmtRepository.findById(id);
		return mobileItem.get();
	}

	public List<MobileMgmtDTO> getAllMobile() {
		List<MobileMgmt> all = this.mobileMgmtRepository.findAll();
		List<MobileMgmtDTO> mobileMgmtDTOS = new ArrayList();
		for (MobileMgmt mobileMgmt : all) {
			MobileMgmtDTO mobileMgmtDTO = new MobileMgmtDTO();
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
