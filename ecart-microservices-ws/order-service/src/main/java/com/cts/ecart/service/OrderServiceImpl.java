package com.cts.ecart.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.ecart.dao.OrderDao;
import com.cts.ecart.dao.UserDao;
import com.cts.ecart.entity.ItemLine;
import com.cts.ecart.entity.Order;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.UserInfo;

@Service
public class OrderServiceImpl {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;

	private RestTemplate restTemplate = new RestTemplate();
	private RestTemplate productTemplate = new RestTemplate();

	private final String CART_BASE_URL = "http://localhost:8083/api/cart";

	// load all cart items of a specified user
	protected static SecureRandom random = new SecureRandom();

	public List<Order> placeOrder(String user) {

		ItemLine[] cartItems = restTemplate.getForObject(CART_BASE_URL + "/" + user, ItemLine[].class);
		List<Order> orders = new ArrayList<>();
		UserInfo userInfo = userDao.findByUserNameLike(user);

		System.out.println(">>> user:: "+userInfo);
		for (ItemLine itemLine : cartItems) {

			Product product = productTemplate
					.getForObject("http://localhost:8082/api/products/" + itemLine.getItem().getId(), Product.class);
			String transactionNumber = Math.abs(random.nextLong()) + "";

			Order order = new Order();

			order.setOrderDate(LocalDateTime.now());
			order.setProductId(product.getProductId());
			order.setPaymentStatus("Success");
			order.setQty(itemLine.getQty());
			order.setTotal(itemLine.getItem().getItemTotal());
			order.setTransactionId(transactionNumber);
			order.setUserId(userInfo.getUserId());
			//orderDao.save(order);
			orders.add(order); // save the order

		}

		// Order order=new Order(LocalDateTime.now(), "success", 0, 0, user, 0, 0)
		orderDao.saveAll(orders);
		return orders;
	}

}
