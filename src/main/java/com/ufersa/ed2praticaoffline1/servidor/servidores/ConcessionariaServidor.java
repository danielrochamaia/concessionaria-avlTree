package com.ufersa.ed2praticaoffline1.servidor.servidores;

import com.ufersa.ed2praticaoffline1.model.ArvoreAVL.ArvoreAVL;
import com.ufersa.ed2praticaoffline1.model.ArvoreAVL.No;
import com.ufersa.ed2praticaoffline1.model.Protocolos.AutomovelResponse;
import com.ufersa.ed2praticaoffline1.model.entities.Automovel;
import com.ufersa.ed2praticaoffline1.servidor.interfaces.IConcessioanariaServidor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConcessionariaServidor implements IConcessioanariaServidor {

    private ArvoreAVL<Automovel> arvoreAutomoveis;

    private int chave;

    public ConcessionariaServidor() throws IOException {
        this.arvoreAutomoveis = new ArvoreAVL<Automovel>();
        this.chave = 0;
    }

    public void addAutomovel(Automovel automovel) {
        chave = chave+1;
        arvoreAutomoveis.inserir(chave, automovel);
        arvoreAutomoveis.addLog("addAutomovel");
    }


    public No<Automovel> editarAutomovel(Automovel automovel, int chave) {
        return null;
    }


    public String removerAutomovel(int chave) {
        if(buscarPorChave(chave) == null){
            return "Chave não existe";
        }

        var quantAntes = buscarTodos().size();
        arvoreAutomoveis.remover(chave);
        arvoreAutomoveis.addLog("removerAutomovel");
        var quantDepois = buscarTodos().size();
        return "Quantidade de automoveis antes: " + quantAntes + "\n Quantidade de automoveis depois: " + quantDepois;
    }


    public List<AutomovelResponse> buscarTodos() {
        List<AutomovelResponse> list = new ArrayList<>();
        for(int i = 1; i <= chave; i++){
            var obj = arvoreAutomoveis.buscar(i);
            if(obj != null){
                list.add(new AutomovelResponse(obj.getChave(),obj.getValor()));
            }
        }
        return list;
    }


    public No<Automovel> buscarPorChave(int chave) {
        return arvoreAutomoveis.buscar(chave);
    }
}
