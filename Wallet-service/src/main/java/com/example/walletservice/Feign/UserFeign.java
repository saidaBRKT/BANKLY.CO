package com.example.walletservice.Feign;

import com.example.walletservice.Dto.ResponseTemplateDto;
import com.example.walletservice.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user",url = "http://localhost:9094/api/v1/users/")
public interface UserFeign {
    @GetMapping("/cin/{cin}")
    public UserDto getOneUser(@PathVariable("cin") String userCin);
}
