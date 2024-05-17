package com.sharanya.mds.springbootmds.orderrepository;

import com.sharanya.mds.springbootmds.orderentities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface OrderDAO extends CrudRepository<Order,Integer> {
}
