/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.model;

/**
 *
 * @author Kayque Rodrigues esta classe tem como objetivo obter um objeto do
 * token(jwt)
 */
public class Token {

    //atributo de cadas token
    //data de criacao do token
    private long iss;
    //data de expiraçao do token
    private long exp;
    //id do usuario dono do token
    private int id;
    
    private int idFuncionario;

    //metudo construtor do token vazio
    public Token() {
    }

    //getters e setters
    public long getIss() {
        return iss;
    }

    public void setIss(long iss) {
        this.iss = iss;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
}
