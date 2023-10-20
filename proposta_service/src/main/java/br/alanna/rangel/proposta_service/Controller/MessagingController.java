package br.alanna.rangel.proposta_service.Controller;

import br.alanna.rangel.proposta_service.Service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessagingController {
    @Autowired
    private MessagingService messagingService;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody String message) {
        messagingService.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}