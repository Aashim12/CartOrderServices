package com.example.CartOrderService.feignClient;

import com.example.CartOrderService.entity.Merchant;
import com.example.CartOrderService.entity.Product;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "cart",url = "http://10.20.3.173:8081",fallbackFactory = CartFeignServiceImpl.class)
@EnableFeignClients
public interface CartFeign  {


    @RequestMapping(method = RequestMethod.GET,value = "product/get-product-by-id/{productId}")
      public Product getProductById(@PathVariable("productId")String prodcutId);

    @RequestMapping(method = RequestMethod.GET,value = "merchant/get-merchant-by-id/{merchantId}")
    public Merchant getMerchantById(@PathVariable("merchantId")String merchantId);
}
