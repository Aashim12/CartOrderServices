package com.example.CartOrderService.feignClient;

import com.example.CartOrderService.entity.Merchant;
import com.example.CartOrderService.entity.Product;
import feign.hystrix.FallbackFactory;

public class CartFeignServiceImpl implements FallbackFactory<CartFeign> {

    @Override
    public CartFeign create(Throwable throwable) {
        return new CartFeign() {
            @Override
            public Product getProductById(String prodcutId) {
                return new Product();
            }

            @Override
            public Merchant getMerchantById(String merchantId) {
                return new Merchant();
            }
        };
    }
}
