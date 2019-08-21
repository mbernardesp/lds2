/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh;

import br.fai.lds.sgh.database.entity.Guest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Lista criada para receber o resultado da pesquisa do banco
        List<Guest> guestList = new ArrayList<>();

        //Aqui vamos testar nossas classes DAO, aguardem..
    }

}
