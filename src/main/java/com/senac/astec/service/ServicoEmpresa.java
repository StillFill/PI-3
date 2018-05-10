package com.senac.astec.service;
import com.senac.astec.dao.EmpresaDAO;
import com.senac.astec.dao.LoginDAO;
import com.senac.astec.model.Empresa;
import com.senac.astec.model.Login;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ana.cacosta1
 */
public class ServicoEmpresa {
    EmpresaDAO empresaDAO = new EmpresaDAO();
    
    public void cadastrarEmpresa(Empresa empresa) throws IOException, Exception {


        try {
            empresaDAO.inserirEmpresa(empresa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
