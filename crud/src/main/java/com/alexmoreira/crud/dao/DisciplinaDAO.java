package com.alexmoreira.crud.dao;

import java.sql.PreparedStatement;
import com.alexmoreira.crud.dominio.Disciplina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;


public class DisciplinaDAO {
	
	
	public static void listagem() throws SQLException {
		  Connection conexao = FabricaDeConexao.getConnection();
		  String sql = "select * from disciplina";
		  PreparedStatement stmt = conexao.prepareStatement(sql);
		  ResultSet resultado = stmt.executeQuery();
		  while (resultado.next()) {
			  System.out.println("Id: "+resultado.getString("id"));
			  System.out.println("Disciplina: "+resultado.getString("nome1"));
			  
		  }
		  resultado.close();
		  stmt.close();
		  conexao.close();
		}

	public List<Disciplina> todos(){
		List<Disciplina> lista = new ArrayList<Disciplina>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from disciplina";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  int id = resultado.getInt("id");
				  String nomeDisciplina = resultado.getString("nome");
				  String professor = resultado.getString("professor");
				  int periodo = resultado.getInt("periodo");
				  String cod_sala = resultado.getString("codigo_sala_classroom");
				  Disciplina disciplina = new Disciplina(id, periodo, nomeDisciplina, professor, cod_sala);
				  lista.add(disciplina);
				  
			  }
			  resultado.close();
			  stmt.close();
			  conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}