package com.mars.rover.marsrovercontroller.enums;

import java.util.Arrays;

public enum ComandoEnum {
    Avanzar ('A'),
    Retroceder ('R'),
    GirarIzquierda ('I'),
    GirarDerecha ('D');

    private char codigo;

    ComandoEnum(char codigo) {
        this.codigo = codigo;
    }



    public char getCodigo(){
        return codigo;
    }
    public static ComandoEnum getComandoByCode(char comando){

        return Arrays.stream(ComandoEnum.values()).filter((comandoEnum) -> comando == comandoEnum.getCodigo()).findFirst().get();
    }

    public static boolean existeElCodigo(char comando) {

        return Arrays.stream(ComandoEnum.values()).anyMatch((comandoEnum) -> comando == comandoEnum.getCodigo());
    }
}
    

