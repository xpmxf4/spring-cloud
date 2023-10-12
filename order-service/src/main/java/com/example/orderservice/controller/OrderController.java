package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.vo.RequestOrder;
import com.example.orderservice.vo.ResponseOrder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{user_id}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@PathVariable String user_id,
                                                     @RequestBody RequestOrder orderDetails) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        OrderDto orderDto = mapper.map(orderDetails, OrderDto.class);
        orderDto.setUserId(user_id);
        OrderDto createdDto = orderService.createOrder(orderDto);
        ResponseOrder returnValue = mapper.map(createdDto, ResponseOrder.class);

        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }
}
