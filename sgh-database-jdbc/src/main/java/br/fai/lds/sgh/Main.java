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

        Connection conn = null;

        try {
            //Cria a conexão com o banco de dados
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sgh", "postgres", "postgres");

            //Prepara a sql para ser executada
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM guest");

            //Executa a sql(neste caso uma consulta) e retorna o resultado para o ResultSet
            ResultSet rs = stmt.executeQuery();

            //Itera a lista que veio do banco, criando um objeto por linha retornada, setando cada atributo correspondente a entidade Guest
            while (rs.next()) {

                Guest guest = new Guest();
                guest.setId(rs.getLong("id"));
                guest.setIdRoom(rs.getLong("id_room"));
                guest.setName(rs.getString("_name"));
                guest.setAge(rs.getInt("age"));
                guest.setCpf(rs.getString("cpf"));
                guest.setPhone(rs.getString("phone"));

                guestList.add(guest);
            }

            //Print da lista retornada do banco!
            for (Guest guest : guestList) {
                System.out.println(guest);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
