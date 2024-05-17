package com.sharanya.mds.springbootmds.productrepoistory;

import com.sharanya.mds.springbootmds.productentities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product,Integer> {
}
