package com.example.CartOrderService.services;


import com.example.CartOrderService.dto.responses.OrderHistoryResponseDto;
import com.example.CartOrderService.entity.CartItem;
import com.example.CartOrderService.entity.Merchant;
import com.example.CartOrderService.entity.OrderHistory;
import com.example.CartOrderService.entity.Product;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderHistoryService {

      List<OrderHistoryResponseDto> getOrderHistory (String userId);
      Boolean addOrderHistory(String userId , CartItem cartItem);
      Product getProductById(String prodcutId);
       Merchant getMerchantById(String merchantId);
}
