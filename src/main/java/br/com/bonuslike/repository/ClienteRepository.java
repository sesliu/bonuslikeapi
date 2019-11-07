package br.com.bonuslike.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;



import br.com.bonuslike.conexao.Conexao;
import br.com.bonuslike.model.Cliente;

@Repository
public class ClienteRepository implements IClienteRepository{
	

	private String procGravarCliente = "call sp_cadastrarCliente(?,?,?,?,?,?)";
	private String procAtualizarCliente = "call sp_atualizarCliente(?,?,?,?,?,?,?)";
	private String procRemove = " call sp_removerCliente(?)";

	@Override
	public long gravar(Cliente cliente) {
		
		Connection conn = null;
		PreparedStatement stGravar = null;
		ResultSet rs;
		long idCliente = 0;
		
		try {
		    	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stGravar = conn.prepareStatement(procGravarCliente);
		
			stGravar.setString(1, cliente.getNmcliente());
			stGravar.setString(2, cliente.getCpf());
			stGravar.setString(3, cliente.getEmail());
			stGravar.setString(4, cliente.getWhatsapp());
			stGravar.setString(5, cliente.getCep());
			stGravar.setString(6, cliente.getDtnasc());
			rs = stGravar.executeQuery();
			
			if(rs.first()) {
				
				idCliente = rs.getLong(1);
				conn.commit();
			}else {
				conn.rollback();
			}
			
		
			
		} catch (Exception  e) {
			e.printStackTrace();
			
			try {
				
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			
			try {
				conn.close();
				stGravar.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return idCliente;
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		
		Connection conn = null;
		PreparedStatement stGravar = null;
	
		
		try {
		    	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stGravar = conn.prepareStatement(procAtualizarCliente);
		
			stGravar.setString(1, cliente.getNmcliente());
			stGravar.setString(2, cliente.getCpf());
			stGravar.setString(3, cliente.getEmail());
			stGravar.setString(4, cliente.getWhatsapp());
			stGravar.setString(5, cliente.getCep());
			stGravar.setString(6, cliente.getDtnasc());
			stGravar.setLong(7, cliente.getIdcliente());
			
			stGravar.execute();
			conn.commit();
			
		} catch (Exception  e) {
			e.printStackTrace();
			
			try {
				
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			
			try {
				conn.close();
				stGravar.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
		
	}
	
	public void remover (Long idCliente) {
		
		Connection conn = null;
		PreparedStatement stRemove = null;
		
		try {
		    	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stRemove = conn.prepareStatement(procRemove);
			stRemove.setLong(1, idCliente);
			stRemove.execute();
			
			conn.commit();
			
			
		} catch (Exception e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			
			try {
				conn.close();
				stRemove.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	

	}

