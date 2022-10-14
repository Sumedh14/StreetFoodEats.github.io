package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.beans.OrderInfo;
import com.demo.beans.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

	@Query(value="select * from (select * from (select * from "
			+ "(select dish_Id,dish_Name,price,description,dish_Image from dish)V "
			+ "inner join (select * from "
			+ "(select order_1.order_Id,status,order_Received_Date_And_Time,dispatch_Date_And_Time,delivery_Date_And_Time,total_Amount,delivery_Agent_Id,shop_Id,customer_Id,order_dish.dish_Id,quantity,price_Xquantity from order_1,order_dish where order_dish.order_Id = order_1.order_Id)V "
			+ "natural join (select delivery_Agent_Id,delivery_Agent_Name,delivery_Agent_Phone_No from Delivery_Agent)V2 where V.delivery_Agent_Id=V2.delivery_Agent_Id)V2 using(dish_Id))V "
			+ "inner join (select shop_Id,shop_Name,phone,is_Active from shop_Info_Table)V2 using(shop_Id))V where status in ('dispatched','received') and customer_Id = :custId",nativeQuery=true)
	public List<Object> getAllOrderByCustomerId(@Param("custId") int custId);

	@Query(value="select * from (select * from (select * from "
			+ "(select dish_Id,dish_Name,price,description,dish_Image from dish)V "
			+ "inner join (select * from "
			+ "(select order_1.order_Id,status,order_Received_Date_And_Time,dispatch_Date_And_Time,delivery_Date_And_Time,total_Amount,delivery_Agent_Id,shop_Id,customer_Id,order_dish.dish_Id,quantity,price_Xquantity from order_1,order_dish where order_dish.order_Id = order_1.order_Id)V "
			+ "natural join (select delivery_Agent_Id,delivery_Agent_Name,delivery_Agent_Phone_No from Delivery_Agent)V2 where V.delivery_Agent_Id=V2.delivery_Agent_Id)V2 using(dish_Id))V "
			+ "inner join (select shop_Id,shop_Name,phone,is_Active from shop_Info_Table)V2 using(shop_Id))V where status in ('delivered','cancelled') and customer_Id = :custId",nativeQuery=true)
	public List<Object> getAllOrderHistoryByCustomerId(@Param("custId") int customerId);

	@Query(value="select order_Id from order_1 where customer_Id = :customerId and shop_Id = :shopId and status = :status",nativeQuery=true)
	public int getOrderId(@Param("customerId") int customerId,@Param("shopId") Integer shopId,@Param("status") String status);

	@Query(value="select * from order_1 where delivery_Agent_Id = :daId and status != 'delivered' and status != 'cancelled'",nativeQuery=true)
	public List<Order> findOrders(@Param("daId") int daId);
	
	@Query(value="select * from order_1 where customer_Id = :cId and status in('dispatched','received')",nativeQuery=true)
	public List<Order> findLiveOrders(@Param("cId") int cId);

	@Query(value="select * from order_1 where customer_Id = :cId and status in('delivered','cancelled')",nativeQuery=true)
	public List<Order> findOrdersHistory(int cId);
	
//	@Procedure(procedureName="cancelOrder")
//	public void cancelOrder(int customerId,int orderId,boolean a);

	}
