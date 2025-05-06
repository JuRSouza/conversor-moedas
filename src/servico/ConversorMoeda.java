package servico;

import api.ServicoExchangeRate;
import modelo.ConversaoMoeda;

import java.sql.SQLOutput;

public class ConversorMoeda {

    //Injeção de dependência
    private final ServicoExchangeRate servicoApi;

    //ServicoExchangeRate está sendo injetado na classe ConversorMoeda por meio do construtor.
    public ConversorMoeda(ServicoExchangeRate servicoApi) {
        this.servicoApi = servicoApi;
    }

    //método para converter moeda (Do Record ConversaoMoeda)
    public ConversaoMoeda converter(String de_pais, String para_pais, double valor) {
        try {
            double taxa = servicoApi.buscarTaxaCambio(de_pais, para_pais);
            double resultado = valor * taxa;
            return new ConversaoMoeda(de_pais, para_pais, valor, resultado);
        } catch (Exception e) {
            System.out.println("Erro ao converter moeda: " + e.getMessage());
            return null;
        }
    }

}
