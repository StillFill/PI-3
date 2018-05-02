package com.senac.astec.dao;

import com.senac.astec.model.Usuario;
import com.senac.astec.utils.ConexaoBanco;
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

public class UsuarioDAO extends ConexaoBanco{
        ConexaoBanco conexaoBanco = new ConexaoBanco();    
        Connection conn = conexaoBanco.createConnection();
    //insere novo usuário
    public void inserirUsuario(Usuario usuario){
        System.out.println("Iniciando processo de inserção de Usuario...");
        String query = "insert into usuarios (nome, login, senha, codigoperfil, codigoempresa) values (?,?,?,?,?)";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, usuario.getName());
            preparedStatement.setDate(1, usuario.getDataNasc());
            preparedStatement.setString(1, usuario.getRg());
            preparedStatement.setString(1, usuario.getCpf());
            preparedStatement.setString(1, usuario.getGender());
            preparedStatement.setString(1, usuario.getPhone());
            preparedStatement.setString(1, usuario.getCellphone());
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(1, usuario.getCEP());
            preparedStatement.setString(1, usuario.getLogradouro());
            preparedStatement.setString(1, usuario.getAddressNumber());
            preparedStatement.setString(1, usuario.getComplement());
            preparedStatement.setString(1, usuario.getNeighborhood());
            preparedStatement.setString(1, usuario.getCity());
            preparedStatement.setString(1, usuario.getState());
            preparedStatement.setString(1, usuario.getType());
            preparedStatement.setDouble(1, usuario.getSalary());
            preparedStatement.setInt(1, usuario.getIdEmpresa());
            
        
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Usuario inserido com sucesso.");
            
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erro ao salvar Usuário");
        }
    }
    //altera usuário existente
    public void updateUsuario(int codigo, int codigoempresa, int codigoperfil, String nome, String login, String senha) throws Exception{
        System.out.println("Atualizando Usuário...");
         String query = "UPDATE usuarios SET nome=?, login=?, senha=?, codigoperfil=?, codigoempresa=? where codigo =?";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, senha);
            preparedStatement.setInt(4, codigoperfil);
            preparedStatement.setInt(5, codigoempresa);
            preparedStatement.setInt(6, codigo);// estava 5 aqui
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar usuario");
            throw new Exception("Erro ao atualizar usuario", ex);
        }
    }  
    //lista usuários
    public List<Usuario> listarUsuario(String nome, int codigoempresa){ //retorna todos itens
        List<Usuario> lista = new ArrayList<>();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        boolean vazio = false;
        
        if("".equals(nome)){
            vazio = true;
            query = "SELECT * FROM usuarios WHERE codigoempresa=?";
        }else{
            vazio = false;
            query = "SELECT * FROM usuarios WHERE nome LIKE ? and codigoempresa=?";
        }
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            if(vazio == true){
                preparedStatement.setInt(1,codigoempresa);
            }else{
                preparedStatement.setString(1, nome+"%");
                preparedStatement.setInt(2,codigoempresa);
            }
            
            
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setName(rs.getString(1));
                usuario.setDataNasc(rs.getDate(2));
                usuario.setRg(rs.getString(3));
                usuario.setCpf(rs.getString(4));
                usuario.setGender(rs.getString(5));
                usuario.setPhone(rs.getString(6));
                usuario.setCellphone(rs.getString(7));
                usuario.setEmail(rs.getString(8));
                usuario.setCEP(rs.getString(9));
                usuario.setLogradouro(rs.getString(10));
                usuario.setAddressNumber(rs.getString(11));
                usuario.setComplement(rs.getString(12));
                usuario.setNeighborhood(rs.getString(13));
                usuario.setCity(rs.getString(14));
                usuario.setState(rs.getString(15));
                usuario.setType(rs.getString(16));
                usuario.setSalary(rs.getDouble(17));
               usuario.setIdEmpresa(rs.getInt(18));
                lista.add(usuario);
            }

            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar usuário: "+ex);
        }        
        return lista;
    
    }
    //encontra usuário por código
    public Usuario encontrarUsuario(String login, String senha, int empresa){//retorna um item
        List<Usuario> lista = new ArrayList<>();
        Usuario usuario = new Usuario();
        System.out.println("Buscando Usuário na base de dados...");
        String query = "SELECT * FROM usuarios WHERE login=? and senha=? and codigoempresa=?";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,senha);
            preparedStatement.setInt(3, empresa);
            
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                usuario.setName(rs.getString(1));
                usuario.setDataNasc(rs.getDate(2));
                usuario.setRg(rs.getString(3));
                usuario.setCpf(rs.getString(4));
                usuario.setGender(rs.getString(5));
                usuario.setPhone(rs.getString(6));
                usuario.setCellphone(rs.getString(7));
                usuario.setEmail(rs.getString(8));
                usuario.setCEP(rs.getString(9));
                usuario.setLogradouro(rs.getString(10));
                usuario.setAddressNumber(rs.getString(11));
                usuario.setComplement(rs.getString(12));
                usuario.setNeighborhood(rs.getString(13));
                usuario.setCity(rs.getString(14));
                usuario.setState(rs.getString(15));
                usuario.setType(rs.getString(16));
                usuario.setSalary(rs.getDouble(17));
               usuario.setIdEmpresa(rs.getInt(18));
                lista.add(usuario);
            }else{
                return null;
            }
            
            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar usuario"+ex);
            
        }        
        return usuario;
    }
    
    //encontra usuário por nome
    public boolean encontrarUsuarioNome(String login, int empresa){//retorna um boolean
        Usuario usuario = new Usuario();
        boolean verifica = false;
        System.out.println("Buscando Usuário na base de dados...");
        String query = "SELECT * FROM usuarios WHERE login=? and codigoempresa=?";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1,login);
            preparedStatement.setInt(2, empresa);
            
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()){
                usuario.setName(rs.getString(1));
                usuario.setDataNasc(rs.getDate(2));
                usuario.setRg(rs.getString(3));
                usuario.setCpf(rs.getString(4));
                usuario.setGender(rs.getString(5));
                usuario.setPhone(rs.getString(6));
                usuario.setCellphone(rs.getString(7));
                usuario.setEmail(rs.getString(8));
                usuario.setCEP(rs.getString(9));
                usuario.setLogradouro(rs.getString(10));
                usuario.setAddressNumber(rs.getString(11));
                usuario.setComplement(rs.getString(12));
                usuario.setNeighborhood(rs.getString(13));
                usuario.setCity(rs.getString(14));
                usuario.setState(rs.getString(15));
                usuario.setType(rs.getString(16));
                usuario.setSalary(rs.getDouble(17));
               usuario.setIdEmpresa(rs.getInt(18));
                verifica = true;
            } 
          
            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar usuario"+ex);
            
        }        
        return verifica;
    }
    
    //deletar usuário
    public void deletarUsuario(int codigo, int codigoempresa) throws Exception{
        System.out.println("Deletando de codigo: "+codigo);
        String query = "DELETE FROM USUARIOS WHERE codigo=? and codigoempresa=?";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            preparedStatement.setInt(1, codigo);
            preparedStatement.setInt(2, codigoempresa);  
            preparedStatement.execute();
            
            System.out.println("Usuário deletado");
        } catch (SQLException ex) {
            throw new Exception("Erro ao deletar usuário", ex);
        }
    }
    
     public Usuario encontrarUmUsuario(int codigo, int codigoempresa){//retorna um item
        List<Usuario> lista = new ArrayList<>();
        Usuario usuario = new Usuario();
        System.out.println("Buscando produto na base de dados...");
        String query = "SELECT * FROM usuarios WHERE codigo=? and codigoempresa=?";//addicionar o % %
        boolean verifica = false;//Variável verifica a existência do usuário
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1,codigo);
            preparedStatement.setInt(2,codigoempresa);
            
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                //usuario.setCodigo(rs.getInt(codigo));
                usuario.setName(rs.getString(1));
                usuario.setDataNasc(rs.getDate(2));
                usuario.setRg(rs.getString(3));
                usuario.setCpf(rs.getString(4));
                usuario.setGender(rs.getString(5));
                usuario.setPhone(rs.getString(6));
                usuario.setCellphone(rs.getString(7));
                usuario.setEmail(rs.getString(8));
                usuario.setCEP(rs.getString(9));
                usuario.setLogradouro(rs.getString(10));
                usuario.setAddressNumber(rs.getString(11));
                usuario.setComplement(rs.getString(12));
                usuario.setNeighborhood(rs.getString(13));
                usuario.setCity(rs.getString(14));
                usuario.setState(rs.getString(15));
                usuario.setType(rs.getString(16));
                usuario.setSalary(rs.getDouble(17));
               usuario.setIdEmpresa(rs.getInt(18));              
                
                lista.add(usuario);
                verifica = true;
                System.out.println("Busca efetuada com sucesso");
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }
        
        if(verifica == false){
            usuario = null;
        }
        
        return usuario;
    
    }
     
     
}
