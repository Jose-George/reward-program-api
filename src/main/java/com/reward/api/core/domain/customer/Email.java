package com.reward.api.core.domain.customer;

import com.reward.api.core.exception.EmailException;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class Email implements Supplier<String> {

    private final String value;

    private Email(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Email{" +
                "value='" + value + '\'' +
                '}';
    }

    /**
     * Cria uma instancia de email válida
     * @param email um texto a ser validado
     * @return uma instancia de email
     * @throws NullPointerException quando o parametro é nulo
     * @throws EmailException quando a string nao é válida
     */
    public static Email of(String email) {
        Objects.requireNonNull(email, "email is required");

        // Expressão regular para validar o formato básico de um e-mail
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        // Compila a expressão regular
        Pattern pattern = Pattern.compile(emailRegex);

        // Faz a correspondência da expressão regular com o e-mail fornecido
        Matcher matcher = pattern.matcher(email);

        // Verifica se a correspondência é encontrada
        if (matcher.matches()) {
            return new Email(email);
        } else {
            throw new EmailException("Invalid email format");
        }
    }

}