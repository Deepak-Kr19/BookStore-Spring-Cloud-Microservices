package com.capg.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.capg.order.dto.BookDTO;

@FeignClient(name = "book-service")
public interface BookClient {

	@GetMapping("/api/books/{id}")
	BookDTO getBookById(@PathVariable Long id);

}