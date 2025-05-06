package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoExchangeRate {

    private static final String CHAVE_API = "b78c13cd958e44784487d625";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + CHAVE_API + "/pair";

    // HTTP — é ele quem vai "enviar" a requisição para a internet.
    private final HttpClient cliente = HttpClient.newHttpClient();

    //Método  para retornar a taxa de câmbio  do tipo double, com os paâmetros de entrada de_pais,  para_pais
    public double buscarTaxaCambio(String de_pais, String para_pais) throws IOException, InterruptedException {
        HttpRequest requisicao = HttpRequest.newBuilder() //cria a requisição
                .uri(URI.create(BASE_URL + "/" + de_pais + "/" + para_pais)) // define o destino da requisição(a URL da API)
                .build(); // finaliza a requisição.
        //Usa o cliente(HttpCliente) para enviar a requisição HTTP, e armazena na variávl resposta.
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());//.BodyHandlers.ofString(): diz que queremos o corpo da resposta como uma String.



        JsonObject json = JsonParser.parseString(resposta.body()).getAsJsonObject();
        return json.get("conversion_rate").getAsDouble();

        //resposta.body() pega o conteúdo da resposta da API (é uma string JSON).
        // JsonParser.parseString(...): converte a String JSON em um objeto.
        // JsonParser.parseString(...): converte a String JSON em um objeto.
        // Acessa o campo "conversion_rate" do JSON (que é a taxa de câmbio).
        //getAsDouble(): transforma esse valor em double.
        //O nome "conversion_rate" é uma chave do JSON retornado pela API. Ela representa o valor da taxa de câmbio entre as duas moedas.

    }

}
