package com.example.CartOrderService.controller;

import com.example.CartOrderService.dto.responses.OrderHistoryResponseDto;
import com.example.CartOrderService.entity.CartItem;
import com.example.CartOrderService.entity.Merchant;
import com.example.CartOrderService.entity.OrderHistory;
import com.example.CartOrderService.entity.Product;
import com.example.CartOrderService.services.OrderHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/orderHistory")
public class OrderHistoryController {
    @Autowired
    OrderHistoryService orderHistoryService;
    @GetMapping("/orderByUser")
    ResponseEntity<List<OrderHistoryResponseDto>> getOrderHistory(@RequestParam String userId){
             List<OrderHistoryResponseDto> orderHistoryResponseDto = orderHistoryService.getOrderHistory(userId);
             if(orderHistoryResponseDto==null)
             return new ResponseEntity<>(orderHistoryResponseDto,HttpStatus.BAD_REQUEST);
             else
                 return new ResponseEntity<>(orderHistoryResponseDto,HttpStatus.ACCEPTED);
//             System.out.print()
      }

      @PostMapping("/addOrderDetails")
      ResponseEntity<Boolean> postOrderDetails(@RequestParam String userId, @RequestBody CartItem cartItem){
                Boolean postOrder = orderHistoryService.addOrderHistory(userId,cartItem);
                return new ResponseEntity<>(postOrder,HttpStatus.ACCEPTED);
      }

      @GetMapping("/getMerchantDetails")
       ResponseEntity<Merchant> getMerchantDetails(@RequestParam String merchantId){

        Merchant merchant = orderHistoryService.getMerchantById(merchantId);

        if(merchant!=null)
            return new ResponseEntity<>(merchant,HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(merchant,HttpStatus.ACCEPTED);
      }

    @GetMapping("/getProductDetails")
    ResponseEntity<Product> getProductDetails(@RequestParam String prodcutId){

        Product product  = orderHistoryService.getProductById(prodcutId);
        if(product!=null)
            return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
    }
}

