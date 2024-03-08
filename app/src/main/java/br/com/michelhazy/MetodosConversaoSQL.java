package br.com.michelhazy;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MetodosConversaoSQL {
    MetodosDAO dao = new MetodosDAO();

    public void adicionar(String nome, int cep) throws ClientProtocolException, IOException{

        HttpGet request = new HttpGet("http://viacep.com.br/ws/"+ cep +"/json/");

        

        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
            CloseableHttpResponse response = httpClient.execute(request)){

            HttpEntity entity = response.getEntity();

            if(entity!=null){
                String result = EntityUtils.toString(entity);
                Gson gson = new Gson();
                
                JsonObject jsonObject = gson.fromJson(result, JsonObject.class);

                String cidade = jsonObject.get("localidade").getAsString();
                String estado = jsonObject.get("uf").getAsString();

                Endereco endereco = new Endereco(cidade, estado, cep);
                Usuario usuario = new Usuario(nome, endereco);

                dao.adicionar(usuario.getNome(), usuario.getEndereco().getCidade(), usuario.getEndereco().getEstado(), usuario.getEndereco().getCep());

            }

        }
    }

    public void editar(int id, String nome, int cep)  throws ClientProtocolException, IOException{

        HttpGet request = new HttpGet("http://viacep.com.br/ws/"+ cep +"/json/");

        

        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
            CloseableHttpResponse response = httpClient.execute(request)){

            HttpEntity entity = response.getEntity();

            if(entity!=null){
                String result = EntityUtils.toString(entity);
                Gson gson = new Gson();
                
                JsonObject jsonObject = gson.fromJson(result, JsonObject.class);

                String cidade = jsonObject.get("localidade").getAsString();
                String estado = jsonObject.get("uf").getAsString();

                Endereco endereco = new Endereco(cidade, estado, cep);
                Usuario usuario = new Usuario(nome, endereco);

                dao.editar(id, usuario.getNome(), usuario.getEndereco().getCidade(), usuario.getEndereco().getEstado(), usuario.getEndereco().getCep());

            }
        }
    }
}
