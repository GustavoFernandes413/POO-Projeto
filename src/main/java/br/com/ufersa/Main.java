package br.com.ufersa;

import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.services.LocaisServiceImpl;

public class Main {
    public static void main(String[] args) {
        Locais locais = new Locais("Casa Kanalense", "Quarto");
        LocaisServiceImpl locaisService = new LocaisServiceImpl() ;
        locaisService.cadastrarLocal(locais);

    }
}
