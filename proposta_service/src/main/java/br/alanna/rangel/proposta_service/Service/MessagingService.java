package br.alanna.rangel.proposta_service.Service;

import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);
    }
}

