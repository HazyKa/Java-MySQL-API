package br.com.michelhazy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MetodosDAO {

    public void mostrar(){
        String sql = "SELECT * FROM consultacep;";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet result = null;

        try{
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            
            result = pstm.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String cidade = result.getString("cidade");
                String estado = result.getString("estado");
                int cep = result.getInt("cep");

                System.out.println("========================" + "\n" + "ID: " + id + "\n" + "Nome: " + nome + "\n" + "Cidade: " + cidade + "\n" + "Estado: " + estado + "\n" + "CEP: " + cep);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (conn!=null) {
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(result!=null){
                    result.close();     
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void excluir(int usuario){
        String sql = "DELETE FROM consultacep WHERE id = ?;";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, usuario);

            pstm.execute();
            System.out.println("Excluido!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (conn!=null) {
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void adicionar(String nome, String cidade, String estado, int cep){
        String sql = "INSERT INTO consultacep (nome, cidade, estado, cep) values (?, ?, ?, ?);";

        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setString(2, cidade);
            pstm.setString(3, estado);
            pstm.setInt(4, cep);

            pstm.execute();
            System.out.println("Adicionado!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (conn!=null) {
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void editar(int id, String nome, String cidade, String estado, int cep){
        String sql = "UPDATE consultacep SET nome = ?, cidade = ?, estado = ?, cep = ? WHERE id = ?;";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.setString(2, cidade);
            pstm.setString(3, estado);
            pstm.setInt(4, cep);
            pstm.setInt(5, id);

            pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (conn!=null) {
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
