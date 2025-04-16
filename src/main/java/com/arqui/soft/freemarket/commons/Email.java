package com.arqui.soft.freemarket.commons;

import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Email {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-.]+@[\\w-]+\\.+[\\w-]{2,}$");
    private final String value;

    public Email(String value) throws InvalidEmailException {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new InvalidEmailException("Email inválido");
        }
        this.value = value;
    }
}
