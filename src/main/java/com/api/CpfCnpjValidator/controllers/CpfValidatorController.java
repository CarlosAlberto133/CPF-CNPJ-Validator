package com.api.CpfCnpjValidator.controllers;

import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/CPF")
public class CpfValidatorController {
    @GetMapping
    public ResponseEntity<Map<String, String>> validarCpf(@RequestParam String cpf) {
        Map<String, String> response = new HashMap<>();

        cpf = removeSpecialCharacters(cpf);

        CPFValidator cpfValidator = new CPFValidator();

        try {
            cpfValidator.assertValid(cpf);
            response.put("mensagem", "CPF válido " + formatCpf(cpf));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("mensagem", "CPF inválido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    private String removeSpecialCharacters(String cpf) {
        // Remover caracteres especiais do cpf
        return cpf.replaceAll("[^0-9]", "");
    }

    private String formatCpf(String cpf) {
        // Adiciona os caracters especiais ao cpf
        return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6),
                cpf.substring(6, 9), cpf.substring(9));
    }
}