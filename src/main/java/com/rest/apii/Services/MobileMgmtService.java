package com.rest.apii.Services;


import java.util.List;

import com.rest.apii.DTO.MobileMgmtDTO;
import com.rest.apii.DTO.ProductDTO;
import com.rest.apii.entities.MobileMgmt;
import com.rest.apii.entities.Product;

public interface MobileMgmtService {

    void createMobile(MobileMgmtDTO mobileMgmtDTO);
    
    MobileMgmt getMobileById(long id);
    
    List<MobileMgmtDTO> getAllMobile();

    Product create(ProductDTO productDTO);

    void update(ProductDTO productDTO, int productDTO_id);

    void delete(int productId);

    List<ProductDTO> getAll();

    ProductDTO getProductDetail(int productId);

}

