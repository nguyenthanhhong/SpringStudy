package com.nth.SpringSecurityOauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/random")
    public String random(){
        return "ai cũng có thể thấy được message này";
    }
}
