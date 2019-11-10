package br.com.bonuslike.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Repository;

import br.com.bonuslike.conexao.Conexao;
import br.com.bonuslike.model.Animal;
import br.com.bonuslike.model.Cliente;
import br.com.bonuslike.model.Cliente_AnimalDTO;

@Repository
public class DadosRepository implements IDadosRepository{
	
	
	private String procBuscarDados = "call sp_buscarCliente(?)";
	private String procObterDadosCliente = " call sp_obterCliente(?)";
	private String procObterDadosAnimal = " call sp_obterAnimal(?)";

	
		@Override
	public List<Cliente_AnimalDTO> buscarDados(String buscar) {
		
		Connection conn = null;
		PreparedStatement stBuscar = null;
		ResultSet rs = null;
		List<Cliente_AnimalDTO> listaCliente = new ArrayList<>();
		
		
		try {
	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stBuscar = conn.prepareStatement(procBuscarDados);
			stBuscar.setString(1, buscar);
			rs = stBuscar.executeQuery();
			
			while(rs.next()) {
				
				//Cliente_AnimalDTO clienteAnimal = new Cliente_AnimalDTO();
				
				Cliente cliente = new Cliente();
				Animal animal = new Animal();
				Cliente_AnimalDTO clienteAnimal = new Cliente_AnimalDTO();
				
				cliente.setNmcliente(rs.getString("nmcliente"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setIdcliente(rs.getLong("idcliente"));
				animal.setNmanimal(rs.getString("nmanimal"));
				animal.setRaca(rs.getString("raca"));
				animal.setSexo(rs.getString("sexo"));
				animal.setTipo(rs.getString("tipo"));
				animal.setDtnasc(rs.getString("dtnasc"));
				
				clienteAnimal.setCliente(cliente);
				clienteAnimal.setAnimal(animal);
				
				listaCliente.add(clienteAnimal);
				
				
				
			}
			
			conn.commit();
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException
				| NamingException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			
			try {
				conn.close();
				stBuscar.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return listaCliente;
	}

	@Override
	public Cliente obterDadosCliente(Long id) {
		Connection conn = null;
		PreparedStatement stBuscar = null;
		ResultSet rs = null;
		
		Cliente cliente = new Cliente();
		//Animal animal = new Animal();
		//Cliente_AnimalDTO clienteAnimal = new Cliente_AnimalDTO();
		
		try {
	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stBuscar = conn.prepareStatement(procObterDadosCliente);
			stBuscar.setLong(1, id);
			rs = stBuscar.executeQuery();
			
			if(rs.next()) {
				
				
				
				
				cliente.setNmcliente(rs.getString("nmcliente"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCep(rs.getString("cep"));
				cliente.setWhatsapp(rs.getString("whatsapp"));
				cliente.setDtnasc(rs.getString("dtnasc"));
				cliente.setIdcliente(rs.getLong("idcliente"));
				
			}
			
			conn.commit();
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException
				| NamingException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			
			try {
				conn.close();
				stBuscar.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return cliente;
	}

	@Override
	public List<Animal> obterDadosAnimal(Long id) {
		
		Connection conn = null;
		PreparedStatement stBuscar = null;
		ResultSet rs = null;
		List<Animal> listaAnimal = new ArrayList<>();
		
		
		try {
	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stBuscar = conn.prepareStatement(procObterDadosAnimal);
			stBuscar.setLong(1, id);
			rs = stBuscar.executeQuery();
			
			while(rs.next()) {
				
				Animal animal = new Animal();
				
				animal.setNmanimal(rs.getString("nmanimal"));
				animal.setRaca(rs.getString("raca"));
				animal.setSexo(rs.getString("sexo"));
				animal.setTipo(rs.getString("tipo"));
				animal.setDtnasc(rs.getString("dtnasc"));
				
			
				listaAnimal.add(animal);
				
				
				
			}
			
			conn.commit();
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException
				| NamingException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			
			try {
				conn.close();
				stBuscar.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


		
		return listaAnimal;
	}
	
	

}
