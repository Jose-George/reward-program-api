package com.reward.api.core.domain.score;

public enum TypeOperation {

    SUM(1,"SUM"),
    SUB(2, "SUB");

    private int cod;
    private String description;

    private TypeOperation(int cod, String descricao) {
        this.cod = cod;
        this.description = descricao;
    }

    public int getCod() {
        return this.cod;
    }

    public String getDescription(){
        return this.description;
    }


    public static TypeOperation toEnum(Integer cod) {

        if(cod == null) {
            return null;
        }

        for(TypeOperation x : TypeOperation.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido "+cod);
    }

    public static TypeOperation toEnum(String description) {

        if(description == null) {
            return null;
        }

        for(TypeOperation x : TypeOperation.values()) {
            if(description.equals(x.getDescription())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalid "+ description);
    }

}
