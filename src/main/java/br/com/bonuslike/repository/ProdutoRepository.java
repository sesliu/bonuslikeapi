package br.com.bonuslike.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.naming.NamingException;

import org.springframework.stereotype.Repository;

import br.com.bonuslike.conexao.Conexao;
import br.com.bonuslike.model.Produto_CampanhaDTO;

@Repository
public class ProdutoRepository implements IProdutoRepository{
	
	private String procGravarQauntidade = " call sp_cadastrarProdutoCampanha(?,?,?)";

	@Override
	public void registrarQuantidade(Produto_CampanhaDTO produto) {
		Connection conn = null;
		PreparedStatement stBuscar = null;
	
		
		
		try {
	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stBuscar = conn.prepareStatement(procGravarQauntidade);
			stBuscar.setString(1, produto.getCodproduto());
			stBuscar.setInt(2, produto.getQtdproduto());
			stBuscar.setLong(3, produto.getIdcampanha());
			stBuscar.execute();
		
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
