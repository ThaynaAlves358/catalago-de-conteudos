package serviço;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.ConteudoOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ApiExterna {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner conteudo = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("QUE FILME VOCÊ DESEJA BUSCAR ?? ");
        System.out.println("======================================");

        String busca = conteudo.nextLine();

        String buscaFormatada = URLEncoder.encode(busca, StandardCharsets.UTF_8);
        String endereco = "https://www.omdbapi.com/?t=" + buscaFormatada + "&apikey=968664d7";

        //cliente HTTP:

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        // envia a resposta do request

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // aqui recebe o json (corpo da api)
        String json = response.body();
        System.out.println(json);
          // converte o JSON para Objt JAVA!

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();



        ConteudoOmdb resultadoConteudo = gson.fromJson(json, ConteudoOmdb.class);
        System.out.println("RESULTADO DA BUSCA :");
        System.out.println("----------------------");

        System.out.println(resultadoConteudo);









    }


}
