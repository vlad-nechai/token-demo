package me.leantech.tokendemo.controllers;

import lombok.AllArgsConstructor;
import me.leantech.tokendemo.services.SecurIdCodeGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codes")
@AllArgsConstructor
public class TokenController {

    private SecurIdCodeGeneratorService codeGeneratorService;

    @GetMapping("/generate/{token}")
    public String generateCode(@PathVariable String token) {
        return codeGeneratorService.generateCode(token);
    }

}
