package br.com.estudo.postech.exceptions;

public class EstudanteJaExistenteException extends RuntimeException {
    public EstudanteJaExistenteException(String message) {
        super(message);
    }
}
