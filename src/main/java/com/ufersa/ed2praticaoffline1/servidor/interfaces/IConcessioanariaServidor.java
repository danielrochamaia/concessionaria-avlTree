package com.ufersa.ed2praticaoffline1.servidor.interfaces;

import com.ufersa.ed2praticaoffline1.model.ArvoreAVL.No;
import com.ufersa.ed2praticaoffline1.model.Protocolos.AutomovelResponse;
import com.ufersa.ed2praticaoffline1.model.entities.Automovel;

import java.util.List;

public interface IConcessioanariaServidor {
    void addAutomovel(Automovel automovel);

    No<Automovel> editarAutomovel(Automovel automovel, int chave);

    String removerAutomovel(int chave);

    List<AutomovelResponse> buscarTodos();

    No<Automovel> buscarPorChave(int chave);

}
