package com.mobile.management.services;


import java.util.List;

import com.mobile.management.dto.UserProductDTO;
import com.mobile.management.dto.ProductDTO;
import com.mobile.management.entities.UserProduct;
import com.mobile.management.entities.Product;

public interface MobileManagementService {

    void createMobile(UserProductDTO mobileMgmtDTO);
    
    UserProduct getMobileById(long id);
    
    List<UserProductDTO> getAllMobile();

    Product create(ProductDTO productDTO);

    void update(ProductDTO productDTO, int productDTO_id);

    void delete(int productId);

    List<ProductDTO> getAll();

    ProductDTO getProductDetail(int productId);

}

