# CPF-CNPJ-Validator

A API designed for validating Brazilian Individual Taxpayer Registry (CPF) and National Register of Legal Entities (CNPJ) numbers.

# API Information

## CPF Validation Endpoint
Endpoint: GET https://cpf-cnpj-validator.onrender.com/CPF?cpf={valor_do_cpf}
Parameters:

cpf: The CPF number to be validated. Must be a valid CPF format.
Object Return:
{"mensagem": "CPF válido", "mensagem": "CPF inválido"}

## CNPJ Validation Endpoint
Endpoint: GET https://cpf-cnpj-validator.onrender.com/CNPJ?cnpj={valor_do_cnpj}
Parameters:

cnpj: The CNPJ number to be validated. Must be a valid CNPJ format.
Object Return:
{"mensagem": "CNPJ válido", "mensagem": "CNPJ inválido"}

## Additional Information
The CPF and CNPJ can be provided with or without special characters. 
The validation process will handle both cases, checking the format and validity of the numbers. 
The response will indicate whether the provided number is valid or invalid.
