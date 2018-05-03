/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.dao;

import com.senac.astec.model.Cliente;
import com.senac.astec.utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    ConexaoBanco conexaoBanco = new ConexaoBanco();

    Connection conn = conexaoBanco.createConnection();

    public void inserirCliente(Cliente cliente) {

        String query = " insert into clientes (nome, sobrenome, sexo, cpf, rg, datanasc, telefone, telefone2, email,"
                + "endereco, numero, complemento, cep, cidade, estado, codigoempresa)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, cliente.getName());
            preparedStatement.setString(4, cliente.getBirthday());
            preparedStatement.setString(5, cliente.getDocumentNumber());
            preparedStatement.setString(6, cliente.getCpf());
            preparedStatement.setString(6, cliente.getGender());
            preparedStatement.setString(6, cliente.getPhone());
            preparedStatement.setString(7, cliente.getCellphone());
            preparedStatement.setString(8, cliente.getEmail());
            preparedStatement.setString(9, cliente.getCEP());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(12, cliente.getAddressNumber());
            preparedStatement.setString(13, cliente.getComplement());
            preparedStatement.setString(14, cliente.getNeighborhood());
            preparedStatement.setString(15, cliente.getCity());
            preparedStatement.setString(16, cliente.getState());
            preparedStatement.setInt(17, cliente.getIdEmpresa());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente" + ex);
        }
    }

    public Cliente updateCliente(Cliente cliente) throws Exception {
        System.out.println("Iniciando processo de atualização de cliente...");
        String query = "UPDATE clientes SET nome=?, sobrenome=?, sexo=?, rg=?, datanasc=?, telefone=?, telefone2=?, email=?, "
                + "endereco=?,  numero=?, complemento=?, cidade=?,  estado=?, codigoempresa=?, cep=? WHERE cpf=?";

        System.out.println(cliente.toString());
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, cliente.getName());
            preparedStatement.setString(4, cliente.getBirthday());
            preparedStatement.setString(5, cliente.getDocumentNumber());
            preparedStatement.setString(6, cliente.getCpf());
            preparedStatement.setString(6, cliente.getGender());
            preparedStatement.setString(6, cliente.getPhone());
            preparedStatement.setString(7, cliente.getCellphone());
            preparedStatement.setString(8, cliente.getEmail());
            preparedStatement.setString(9, cliente.getCEP());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(12, cliente.getAddressNumber());
            preparedStatement.setString(13, cliente.getComplement());
            preparedStatement.setString(14, cliente.getNeighborhood());
            preparedStatement.setString(15, cliente.getCity());
            preparedStatement.setString(16, cliente.getState());
            preparedStatement.setInt(17, cliente.getIdEmpresa());

            System.out.println("cpf: " + cliente.getCpf());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new Exception("Erro ao atualizar cliente!", ex);
        }

        return cliente;

    }

    public List<Cliente> listarCliente(String nome, int codigoempresa) throws Exception {
        System.out.println("Iniciando listagem de cliente...");
        List<Cliente> lista = new ArrayList<>();
        String query = "";

        boolean vazio = true;

        if (nome.length() == 0) {
            vazio = true;
            query = "SELECT * FROM clientes WHERE codigoempresa=?";
        } else {
            vazio = false;
            query = "SELECT * FROM clientes WHERE nome LIKE ? and codigoempresa = ?";
        }

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            if (vazio != true) {
                preparedStatement.setString(1, nome + "%");
                preparedStatement.setInt(2, codigoempresa);
            } else {
                preparedStatement.setInt(1, codigoempresa);
            }

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("nome"));
                cliente.setBirthday(rs.getString("dataNasc"));
                cliente.setDocumentNumber(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setGender(rs.getString("gender"));
                cliente.setPhone(rs.getString("phone"));
                cliente.setCellphone(rs.getString("cellphon/e"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCEP(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setAddressNumber(rs.getString("addressNumber"));
                cliente.setComplement(rs.getString("complement"));
                cliente.setNeighborhood(rs.getString("neighborhood"));
                cliente.setCity(rs.getString("city"));
                cliente.setState(rs.getString("state"));
                cliente.setIdEmpresa(rs.getInt("idEmpresa"));
                lista.add(cliente);
            }

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar cliente", ex);
        }

        return lista;

    }

    public List<Cliente> listarClientes(int codigoempresa) throws Exception {
        System.out.println("Iniciando listagem de cliente...");
        List<Cliente> lista = new ArrayList<>();
        String query = "";

        boolean vazio = true;

        query = "SELECT * FROM clientes WHERE codigoempresa=?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, codigoempresa);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("nome"));
                cliente.setBirthday(rs.getString("dataNasc"));
                cliente.setDocumentNumber(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setGender(rs.getString("gender"));
                cliente.setPhone(rs.getString("phone"));
                cliente.setCellphone(rs.getString("cellphon/e"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCEP(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setAddressNumber(rs.getString("addressNumber"));
                cliente.setComplement(rs.getString("complement"));
                cliente.setNeighborhood(rs.getString("neighborhood"));
                cliente.setCity(rs.getString("city"));
                cliente.setState(rs.getString("state"));
                cliente.setIdEmpresa(rs.getInt("idEmpresa"));
                lista.add(cliente);
            }

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar cliente", ex);
        }

        return lista;

    }

    public List<Cliente> listarClientestotais() throws Exception {
        System.out.println("Iniciando listagem de cliente...");
        List<Cliente> lista = new ArrayList<>();
        String query = "";

        boolean vazio = true;

        query = "SELECT * FROM clientes";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("nome"));
                cliente.setBirthday(rs.getString("dataNasc"));
                cliente.setDocumentNumber(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setGender(rs.getString("gender"));
                cliente.setPhone(rs.getString("phone"));
                cliente.setCellphone(rs.getString("cellphon/e"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCEP(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setAddressNumber(rs.getString("addressNumber"));
                cliente.setComplement(rs.getString("complement"));
                cliente.setNeighborhood(rs.getString("neighborhood"));
                cliente.setCity(rs.getString("city"));
                cliente.setState(rs.getString("state"));
                cliente.setIdEmpresa(rs.getInt("idEmpresa"));
                lista.add(cliente);
            }

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar cliente", ex);
        }

        return lista;

    }

    public Cliente encontrarClientePorCpf(String cpf, int codigoempresa) throws Exception {
        System.out.println("Iniciando listagem de cliente...");

        Cliente cliente = new Cliente();
        String query = "SELECT * FROM clientes WHERE cpf LIKE ? and codigoempresa=?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cpf + "%");
            preparedStatement.setInt(2, codigoempresa);

            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("Busca efetuada com sucesso");

            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("nome"));
                cliente.setBirthday(rs.getString("dataNasc"));
                cliente.setDocumentNumber(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setGender(rs.getString("gender"));
                cliente.setPhone(rs.getString("phone"));
                cliente.setCellphone(rs.getString("cellphon/e"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCEP(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setAddressNumber(rs.getString("addressNumber"));
                cliente.setComplement(rs.getString("complement"));
                cliente.setNeighborhood(rs.getString("neighborhood"));
                cliente.setCity(rs.getString("city"));
                cliente.setState(rs.getString("state"));
                cliente.setIdEmpresa(rs.getInt("idEmpresa"));
            }

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar cliente", ex);
        }

        return cliente;
    }

    public Cliente encontrarClientePorIdCarrinho(int id, int codigoempresa) throws Exception {
        System.out.println("Iniciando listagem de cliente...");

        Cliente cliente = new Cliente();
        String query = "SELECT * FROM clientes WHERE id=? and codigoempresa = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.setString(2, String.valueOf(codigoempresa));

            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("Busca efetuada com sucesso");

            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("nome"));
                cliente.setBirthday(rs.getString("dataNasc"));
                cliente.setDocumentNumber(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setGender(rs.getString("gender"));
                cliente.setPhone(rs.getString("phone"));
                cliente.setCellphone(rs.getString("cellphon/e"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCEP(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setAddressNumber(rs.getString("addressNumber"));
                cliente.setComplement(rs.getString("complement"));
                cliente.setNeighborhood(rs.getString("neighborhood"));
                cliente.setCity(rs.getString("city"));
                cliente.setState(rs.getString("state"));
                cliente.setIdEmpresa(rs.getInt("idEmpresa"));;
            }

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar cliente", ex);
        }

        return cliente;
    }

    public Cliente encontrarClientePorId(int id) throws Exception {
        System.out.println("Iniciando listagem de cliente...");

        Cliente cliente = new Cliente();
        String query = "SELECT * FROM clientes WHERE id=?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("Busca efetuada com sucesso");

            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("nome"));
                cliente.setBirthday(rs.getString("dataNasc"));
                cliente.setDocumentNumber(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setGender(rs.getString("gender"));
                cliente.setPhone(rs.getString("phone"));
                cliente.setCellphone(rs.getString("cellphon/e"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCEP(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setAddressNumber(rs.getString("addressNumber"));
                cliente.setComplement(rs.getString("complement"));
                cliente.setNeighborhood(rs.getString("neighborhood"));
                cliente.setCity(rs.getString("city"));
                cliente.setState(rs.getString("state"));
                cliente.setIdEmpresa(rs.getInt("idEmpresa"));
            }

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar cliente", ex);
        }

        return cliente;
    }

    public void deletarCliente(String cpf, int codigoempresa) throws Exception {
        System.out.println("Deletando clientes de cpf: " + cpf);
        String query = "DELETE FROM clientes WHERE cpf=? and codigoempresa=?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            preparedStatement.setInt(2, codigoempresa);

            preparedStatement.execute();
            System.out.println("Cliente deletado");
        } catch (SQLException ex) {
            throw new Exception("Erro ao deletar o cliente", ex);

        }
    }
}
