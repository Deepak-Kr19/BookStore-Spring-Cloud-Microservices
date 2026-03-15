package com.capg.order.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.order.client.BookClient;
import com.capg.order.dto.BookDTO;
import com.capg.order.model.Order;
import com.capg.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private BookClient bookClient;

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	public Order createOrder(Order order) {

		BookDTO book = bookClient.getBookById(order.getBookId());

		double total = book.getPrice() * order.getQuantity();

		order.setTotalPrice(total);
		order.setStatus("PLACED");
		order.setOrderDate(LocalDate.now());

		return orderRepository.save(order);
	}

	public Order updateOrderStatus(Long id, String status) {

		Order order = orderRepository.findById(id).orElse(null);

		if (order != null) {
			order.setStatus(status);
			return orderRepository.save(order);
		}

		return null;
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

}