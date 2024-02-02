package com.reward.api.core.domain;

import com.reward.api.core.exception.CpfException;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Cpf implements Supplier<String> {

    private final String value;

    private Cpf(String value) {
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
        Cpf cpf = (Cpf) o;
        return Objects.equals(value, cpf.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Cpf{" +
                "value='" + value + '\'' +
                '}';
    }

    /**
     * Cria uma instância de CPF válida
     *
     * @param cpf um texto a ser validado como CPF
     * @return uma instância de CPF
     * @throws NullPointerException     quando o parâmetro é nulo
     * @throws CpfException quando a string não é válida como CPF
     */
    public static Cpf of(String cpf) {
        Objects.requireNonNull(cpf, "CPF is required");

        // Expressão regular para validar CPF (formato: XXX.XXX.XXX-XX)
        String cpfRegex = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$";

        // Compila a expressão regular
        Pattern pattern = Pattern.compile(cpfRegex);

        // Faz a correspondência da expressão regular com o CPF fornecido
        Matcher matcher = pattern.matcher(cpf);

        // Verifica se a correspondência é encontrada e é a string completa
        if (matcher.matches()) {
            return new Cpf(cpf);
        } else {
            throw new CpfException("Invalid CPF format");
        }
    }
}
