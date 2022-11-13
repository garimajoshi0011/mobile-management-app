package com.rest.api.services;


import java.util.List;

import com.rest.api.dto.MobileManagementDTO;
import com.rest.api.dto.ProductDTO;
import com.rest.api.entities.MobileManagement;
import com.rest.api.entities.Product;

public interface MobileManagementService {

    void createMobile(MobileManagementDTO mobileMgmtDTO);
    
    MobileManagement getMobileById(long id);
    
    List<MobileManagementDTO> getAllMobile();

    Product create(ProductDTO productDTO);

    void update(ProductDTO productDTO, int productDTO_id);

    void delete(int productId);

    List<ProductDTO> getAll();

    ProductDTO getProductDetail(int productId);

}

