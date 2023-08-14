package com.ufersa.ed2praticaoffline1.model.Protocolos;

import com.ufersa.ed2praticaoffline1.model.entities.Automovel;

public class AutomovelResponse {

    public int chave;
    public Automovel automvel;

    public AutomovelResponse(int chave, Automovel automovel){
        this.chave = chave;
        this.automvel = automovel;
    }
}
