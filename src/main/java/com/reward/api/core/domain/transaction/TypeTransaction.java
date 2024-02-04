package com.reward.api.core.domain.transaction;

public enum TypeTransaction {

    //status
    TIPO_1(1,"TIPO_1"),
    TIPO_2(2, "TIPO_2");

    private int cod;
    private String description;

    private TypeTransaction(int cod, String descricao) {
        this.cod = cod;
        this.description = descricao;
    }

    public int getCod() {
        return this.cod;
    }

    public String getDescription(){
        return this.description;
    }


    public static TypeTransaction toEnum(Integer cod) {

        if(cod == null) {
            return null;
        }

        for(TypeTransaction x : TypeTransaction.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido "+cod);
    }

    public static TypeTransaction toEnum(String description) {

        if(description == null) {
            return null;
        }

        for(TypeTransaction x : TypeTransaction.values()) {
            if(description.equals(x.getDescription())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalid "+ description);
    }

}
