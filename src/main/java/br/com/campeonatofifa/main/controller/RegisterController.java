package br.com.campeonatofifa.main.controller;

import br.com.campeonatofifa.main.dto.request.RegisterPlayer;
import br.com.campeonatofifa.main.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/player")
    public ResponseEntity<Object> registerPlayer(@RequestBody RegisterPlayer registerPlayer){
        return registerService.registerPlayer(registerPlayer);
    }
}
