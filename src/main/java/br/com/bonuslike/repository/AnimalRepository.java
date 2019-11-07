package br.com.bonuslike.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.springframework.stereotype.Repository;

import br.com.bonuslike.conexao.Conexao;
import br.com.bonuslike.model.Animal;

@Repository
public class AnimalRepository implements IAnimalRepository{

	
	private String procGravarAnimal = "call sp_cadastrarAnimal(?,?,?,?,?,?)";
	private String procRemove = " call sp_removerAnimal(?)";
	
	
	
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
	
	
	
	@Override
	public void gravar(Animal animal, long idCliente) {
	
		Connection conn = null;
		PreparedStatement stGravar = null;
		
		try {
		    	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stGravar = conn.prepareStatement(procGravarAnimal);
			
			stGravar.setLong(1, idCliente);
			stGravar.setString(2, animal.getNmanimal());
			stGravar.setString(3, animal.getDtnasc());
			stGravar.setString(4, animal.getRaca());
			stGravar.setString(5, animal.getTipo());
			stGravar.setString(6, animal.getSexo());
			stGravar.execute();
			
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
				stGravar.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


	@Override
	public void atualizar(Animal animal, long idCliente) {
		// TODO Auto-generated method stub
		
	}

		
	
	
	

}
