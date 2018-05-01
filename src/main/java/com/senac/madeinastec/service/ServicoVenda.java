/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.madeinastec.service;

import com.senac.madeinastec.dao.ItemVendaDAO;
import com.senac.madeinastec.dao.VendaDAO;
import com.senac.madeinastec.exceptions.DataSourceException;
import com.senac.madeinastec.exceptions.ItemVendaException;
import com.senac.madeinastec.exceptions.VendaException;
import com.senac.madeinastec.model.ItemVenda;
import com.senac.madeinastec.model.validador.ValidadorVenda;
import com.senac.madeinastec.model.Venda;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magno
 */
public class ServicoVenda {
    public static List<Venda> listaVendas = new ArrayList<>();
    VendaDAO vendaDAO = new VendaDAO();
    ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
    
    //Insere um Produto na fonte de dados
    public Integer cadastrarVenda(Venda venda) throws VendaException, DataSourceException, ItemVendaException {
        try {
            return vendaDAO.cadastrarVenda(venda);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
        //Retorna Carrinho
   public List<Venda> listavendas(String codigoempresa, Date datainicial, Date datafinal) throws VendaException, DataSourceException, ItemVendaException, Exception{
        
        try {
            return vendaDAO.listavendas(codigoempresa, datainicial, datafinal);
            //return vendaDAO.(codigocarrinho);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
}
