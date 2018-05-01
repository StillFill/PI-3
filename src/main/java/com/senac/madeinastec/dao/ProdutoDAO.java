package com.senac.madeinastec.dao;

import com.senac.madeinastec.model.Produto;
import com.senac.madeinastec.utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
        ConexaoBanco conexaoBanco = new ConexaoBanco();    
        Connection conn = conexaoBanco.createConnection();
    //insere produto
    public void inserirProduto(Produto produto){
        System.out.println("Iniciando processo de inserção de produto...");
        String query = "insert into produtos (codigoempresa, nome, descricao, codigofornecedor, codigocategoria, precocompra, precovenda, estoque) values (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1, produto.getCodigoempresa());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setInt(4, produto.getCodigoFornecedor());
            preparedStatement.setInt(5, produto.getCategoria());
            preparedStatement.setDouble(6, produto.getPrecocompra());
            preparedStatement.setDouble(7, produto.getPrecovenda());
            preparedStatement.setInt(8, produto.getEstoque());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Produto inserido com sucesso.");
            
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erro ao salvar produto");
        }
    }
    //atualiza produto
    public Produto updateProduto(Produto produto) throws Exception{
        System.out.println("Atualizando produto...");
         String query = "UPDATE produtos SET codigoempresa=?, nome=?, descricao=?, codigofornecedor=?, codigocategoria=?, precocompra=?, precovenda=?, estoque=? WHERE codigo=?";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1, produto.getCodigoempresa());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setInt(4, produto.getCodigoFornecedor());
            preparedStatement.setInt(5, produto.getCategoria());
            preparedStatement.setDouble(6, produto.getPrecocompra());
            preparedStatement.setDouble(7, produto.getPrecovenda());
            preparedStatement.setInt(8, produto.getEstoque());
            preparedStatement.setInt(9, produto.getCodigo());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto");
            throw new Exception("Erro ao atualizar produto", ex);
        }

        return produto;
    }
    //atualiza estoque
    public void atualizarEstoque(int codigo, int estoque) throws Exception{
        System.out.println("Atualizando produto...");
         String query = "UPDATE produtos SET estoque=? WHERE codigo=?";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
          
            preparedStatement.setInt(1, estoque);
            preparedStatement.setInt(2, codigo);
            System.out.println("Estoque:"+estoque);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto");
            throw new Exception("Erro ao atualizar produto", ex);
        }
    }
    
    //lista produtos
    public List<Produto> listarProduto(String nome, int codigoempresa){ //retorna todos itens
        List<Produto> lista = new ArrayList<>();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        
        boolean vazio = true;
        
        if(nome.length() == 0){
            vazio = true;
            query = "SELECT * FROM produtos WHERE codigoempresa = ?";
        }else{
            vazio = false;
            query = "SELECT * FROM produtos WHERE nome LIKE ? and codigoempresa = ?";
        }
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            if(vazio != true){
                preparedStatement.setString(1, nome+"%");
                preparedStatement.setInt(2,codigoempresa);
            }else{
                preparedStatement.setInt(1,codigoempresa);
            }
            
            ResultSet rs = preparedStatement.executeQuery();

            
                while (rs.next()){
                    Produto produto = new Produto();
                    produto.setCodigo(rs.getInt(1));
                    produto.setCodigoempresa(rs.getInt(2));
                    produto.setNome(rs.getString(3));
                    produto.setDescricao(rs.getString(4));
                    produto.setCodigoFornecedor(rs.getInt(5));
                    produto.setCategoria(rs.getInt(6));
                    produto.setPrecocompra(rs.getDouble(7));
                    produto.setPrecovenda(rs.getDouble(8));
                    produto.setEstoque(rs.getInt(9));
                    lista.add(produto);
                }

            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return lista;
    
    }
    //lista produtos
    public List<Produto> listarProdutos(int codigoempresa){ //retorna todos itens
        List<Produto> lista = new ArrayList<>();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        
        query = "SELECT * FROM produtos WHERE codigoempresa = ?";
      
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1,codigoempresa);
            
            ResultSet rs = preparedStatement.executeQuery();

            
            while (rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCodigoFornecedor(rs.getInt(5));
                produto.setCategoria(rs.getInt(6));
                produto.setPrecocompra(rs.getDouble(7));
                produto.setPrecovenda(rs.getDouble(8));
                produto.setEstoque(rs.getInt(9));
                lista.add(produto);
            }

            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return lista;
    
    }
    
    //lista produtos
    public List<Produto> listarProdutostotais(){ //retorna todos itens
        List<Produto> lista = new ArrayList<>();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        
        query = "SELECT * FROM produtos";
      
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = preparedStatement.executeQuery();

            
            while (rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCodigoFornecedor(rs.getInt(5));
                produto.setCategoria(rs.getInt(6));
                produto.setPrecocompra(rs.getDouble(7));
                produto.setPrecovenda(rs.getDouble(8));
                produto.setEstoque(rs.getInt(9));
                lista.add(produto);
            }

            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return lista;
    
    }
    
    
    //encontra produto por nome
    public Produto encontrarProduto(String nome, int codigoempresa){//retorna um item
        Produto produto = new Produto();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        boolean vazio = false;
        
        if(nome.length() == 0){
            vazio = true;
            query = "SELECT * FROM produtos WHERE codigoempresa=?";//addicionar o % %
        }else{
            query = "SELECT * FROM produtos WHERE nome=? and codigoempresa=?";//addicionar o % %
        }
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            if(vazio = false){
                preparedStatement.setString(1,nome);
                preparedStatement.setInt(2,codigoempresa);
            }else{
                preparedStatement.setInt(1,codigoempresa);
            }
            
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCodigoFornecedor(rs.getInt(5));
                produto.setCategoria(rs.getInt(6));
                produto.setPrecocompra(rs.getDouble(7));
                produto.setPrecovenda(rs.getDouble(8));
                produto.setEstoque(rs.getInt(9));
            }
            
            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return produto;
    
    }
    
    //encontra produto por nome
    public Produto encontrarProdutoCodigo(int codigo, int codigoempresa){//retorna um item
        Produto produto = new Produto();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        query = "SELECT * FROM produtos WHERE codigo=? and codigoempresa=?";//addicionar o % %

        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1,codigo);
            preparedStatement.setInt(2,codigoempresa);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCodigoFornecedor(rs.getInt(5));
                produto.setCategoria(rs.getInt(6));
                produto.setPrecocompra(rs.getDouble(7));
                produto.setPrecovenda(rs.getDouble(8));
                produto.setEstoque(rs.getInt(9));
            }
            
            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return produto;
    
    }
    
    //encontra produto por nome
    public boolean encontrarProdutoCadastro(String nome, int codigoempresa){//retorna um item
        Produto produto = new Produto();
        System.out.println("Buscando produto na base de dados...");
        String query = "SELECT * FROM produtos WHERE nome=? and codigoempresa=?";//addicionar o % %
        boolean encontra = false;
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1,nome);
            preparedStatement.setInt(2,codigoempresa);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                encontra = true;
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCodigoFornecedor(rs.getInt(5));
                produto.setCategoria(rs.getInt(6));
                produto.setPrecocompra(rs.getDouble(7));
                produto.setPrecovenda(rs.getDouble(8));
                produto.setEstoque(rs.getInt(9));
            }
            
            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return encontra;
    
    }
    //
    public void deletarProduto(int codigo, int codigoempresa) throws Exception{
        System.out.println("Deletando produto de codigo: "+codigo);
        String query = "DELETE FROM produtos WHERE codigo=? and codigoempresa=?";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            preparedStatement.setInt(1, codigo);
            preparedStatement.setInt(2, codigoempresa);   
            preparedStatement.execute();
            
            System.out.println("Produto deletado");
        } catch (SQLException ex) {
            throw new Exception("Erro ao deletar produto", ex);
        }
    }
}
