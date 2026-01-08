package com.mdxq.mall.order.orderController;

import com.mdxq.mall.entity.Order;
import com.mdxq.mall.entity.OrderItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*@RequestMapping("/api/v1/order")
@RestController*/
public class OrderController {
    @GetMapping("getInfo/{id}")
    public ResponseEntity<Order> getInfo(@PathVariable Long id) {
        return ResponseEntity.ok(new Order(id, LocalDateTime.now(),1000F, Arrays.asList(
                new OrderItem(id,"nick", 555F,1),
                new OrderItem(id,"adidas", 455F,1),
                new OrderItem(id,"pick", 255F,1)
        )));
    }
}
