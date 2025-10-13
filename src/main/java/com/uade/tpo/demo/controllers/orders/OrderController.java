package com.uade.tpo.demo.controllers.orders;

import com.uade.tpo.demo.entity.Order;
import com.uade.tpo.demo.entity.OrderItemRequest;
import com.uade.tpo.demo.entity.User;
import com.uade.tpo.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // Solo usuarios con rol USER pueden hacer compras
    @PreAuthorize("hasAuthority('USER','ADMIN')")
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody List<OrderItemRequest> items, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Order order = orderService.createOrder(user, items);
        return ResponseEntity.ok(order);
    }
}
