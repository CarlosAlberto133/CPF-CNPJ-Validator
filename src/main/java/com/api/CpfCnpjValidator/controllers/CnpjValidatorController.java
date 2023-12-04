package com.api.CpfCnpjValidator.controllers;

import br.com.caelum.stella.validation.CNPJValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/CNPJ")
public class CnpjValidatorController {
    @GetMapping
    public ResponseEntity<Map<String, String>> validarCnpj(@RequestParam String cnpj) {
        Map<String, String> response = new HashMap<>();

        cnpj = removeSpecialCharacters(cnpj);

        CNPJValidator cnpjValidator = new CNPJValidator();

        try {
            cnpjValidator.assertValid(cnpj);
            response.put("mensagem", "CNPJ válido " + formatCnpj(cnpj));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("mensagem", "CNPJ inválido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    private String removeSpecialCharacters(String cnpj) {
        // Remove caracteres especiais do cnpj
        return cnpj.replaceAll("[^0-9]", "");
    }

    private String formatCnpj(String cnpj) {
        // Adiciona os caracteres especiais ao cnpj
        return String.format("%s.%s.%s/%s-%s", cnpj.substring(0, 2), cnpj.substring(2, 5),
                cnpj.substring(5, 8), cnpj.substring(8, 12), cnpj.substring(12));
    }
}