package com.example.logonrm.configuracaopersonagem

/**
 * Para instaciar a troca de imagens quando selecionar item, Enum tem ideia de array */

/*classe enum*/
enum class TipoPersonagemEnum constructor(val id: Int){
    /*os enum em si*/

    ANAO (0),
    ARQUEIRO (1),
    BARDO (2),
    ELFO (3),
    GUERREIRO(4),
    MAGO(5);

    companion object {
        fun from(findValue: Int): TipoPersonagemEnum =
                TipoPersonagemEnum.values().first {it.id == findValue}
    }
}