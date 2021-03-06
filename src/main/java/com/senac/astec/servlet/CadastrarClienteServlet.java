/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.servlet;

import com.senac.astec.dao.ClienteDAO;
import com.senac.astec.model.Cliente;
import com.senac.astec.service.ServicoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "cadastrarCliente", urlPatterns = {"/cadastrar-cliente"})
public class CadastrarClienteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destino = "Pages/CadastrarCliente.jsp";
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String documentNumber = request.getParameter("documentNumber");
        String cpf = request.getParameter("cpf");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String cellphone = request.getParameter("cellphone");
        String email = request.getParameter("email");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String addressNumber = request.getParameter("addressNumber");
        String complement = request.getParameter("complement");
        String neighborhood = request.getParameter("neighborhood");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        PrintWriter imprimir = response.getWriter();
        Cliente newClient = new Cliente();
            newClient.setNome(name);
            newClient.setDataNasc(birthday);
            newClient.setRg(documentNumber);
            newClient.setCpf(cpf);
            newClient.setSexo(gender);
            newClient.setTelefone(phone);
            newClient.setCelular(cellphone);
            newClient.setEmail(email);
            newClient.setCep(cep);
            newClient.setLogradouro(logradouro);
            newClient.setNumero(addressNumber);
            newClient.setComplemento(complement);
            newClient.setBairro(neighborhood);
            newClient.setCidade(city);
            newClient.setEstado(state);
            newClient.setEnabled(true);
//            newClient.setCodigoempresa();
        ServicoCliente servicoCliente = new ServicoCliente();
        try {
            servicoCliente.cadastrarCliente(newClient);  
            imprimir.println("deu bom");
        } catch(Exception e) {
            imprimir.println("deu ruim");
        }

//        response.sendRedirect(request.getContextPath() + "/cadastrar-cliente");
    }
    // deletar
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    // atualizar
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    // recebe sessão, token,
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
}
