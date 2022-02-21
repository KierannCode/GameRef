package fr.orsys.groupe3.gamerefback.exception;

import lombok.Getter;

@Getter
public class CustomValidationException extends Exception {
    String attribute;

    public CustomValidationException(String attribute, String message) {
        super(message);
        this.attribute = attribute;
    }
}
