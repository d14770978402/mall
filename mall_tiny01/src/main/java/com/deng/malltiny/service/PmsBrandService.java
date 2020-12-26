package com.deng.malltiny.service;

import com.deng.malltiny.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();
    List<PmsBrand> listBrand(int pageNum,int pageSize);
    PmsBrand getBrand(Long id);
    int updateBrand(Long id,PmsBrand brand);
    int creatBrand(PmsBrand brand);
    int deleteBrand(Long id);

}
