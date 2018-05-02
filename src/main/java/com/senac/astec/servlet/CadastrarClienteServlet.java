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
        String name = request.getParameter("name").toLowerCase();
        String birthday = request.getParameter("birthday").toLowerCase();
        String documentNumber = request.getParameter("documentNumber").toLowerCase();
        String cpf = request.getParameter("cpf").toLowerCase();
        String gender = request.getParameter("gender").toLowerCase();
        String phone = request.getParameter("phone").toLowerCase();
        String cellphone = request.getParameter("cellphone").toLowerCase();
        String email = request.getParameter("email").toLowerCase();
        String cep = request.getParameter("cep").toLowerCase();
        String logradouro = request.getParameter("logradouro").toLowerCase();
        String addressNumber = request.getParameter("addressNumber").toLowerCase();
        String complement = request.getParameter("complement").toLowerCase();
        String neighborhood = request.getParameter("neighborhood").toLowerCase();
        String city = request.getParameter("city").toLowerCase();
        String state = request.getParameter("state").toLowerCase();

        Cliente newClient = new Cliente();
        newClient.setName(name);
        newClient.setBirthday(birthday);
        newClient.setDocumentNumber(documentNumber);
        newClient.setCpf(cpf);
        newClient.setGender(gender);
        newClient.setPhone(phone);
        newClient.setCellphone(cellphone);
        newClient.setEmail(email);
        newClient.setCEP(cep);
        newClient.setLogradouro(logradouro);
        newClient.setAddressNumber(addressNumber);
        newClient.setComplement(complement);
        newClient.setNeighborhood(neighborhood);
        newClient.setCity(city);
        newClient.setState(state);
                
        PrintWriter imprimir = response.getWriter();
 
        imprimir.println();

//        response.sendRedirect(request.getContextPath() + "/cadastrar-cliente");
    }
    
}
