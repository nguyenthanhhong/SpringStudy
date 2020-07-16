package com.nth.SpringSecurityOauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/random")
    public String random(){
        return "JWT Hợp lệ mới có thể thấy được message này";
    }
}
