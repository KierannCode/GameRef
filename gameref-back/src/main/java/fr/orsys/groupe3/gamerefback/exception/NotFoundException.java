package fr.orsys.groupe3.gamerefback.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends Exception {
    private String entity;

    public NotFoundException(String entity, String message) {
        super(message);
        this.entity = entity;
    }
}
