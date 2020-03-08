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
import br.com.bonuslike.model.Campanha;
import br.com.bonuslike.model.Cliente;
import br.com.bonuslike.model.Cliente_AnimalDTO;
import br.com.bonuslike.model.Cliente_CupomDTO;
import br.com.bonuslike.model.Cupom_UtilizacaoDTO;
import br.com.bonuslike.model.Produto;


@Repository
public class CupomRepository implements ICupomRepository{
	
	private String procBuscarDados = "call sp_buscaCupom(?)";
	private String procBuscaDadosCliente = "call sp_buscarClienteCupom(?)";
	private String procBuscaDadosProduto = "call sp_buscarProdutoCupom(?)";
	private String procGravarCupom = "call sp_gravarUtilizacao_cupom(?,?,?,?,?,?,?)";

	@Override
	public Cliente_CupomDTO buscarCupom(String buscar) {
	
		Connection conn = null;
		PreparedStatement stBuscar = null;
		ResultSet rs = null;
		Cliente_CupomDTO cliente_cupom = new Cliente_CupomDTO();
		
	
		try {
	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stBuscar = conn.prepareStatement(procBuscarDados);
			stBuscar.setString(1, buscar);
			rs = stBuscar.executeQuery();
			
			if(rs.next()) {
				
				
				Campanha campanha = new Campanha();
				
				campanha.setNmcampanha(rs.getString("nmcampanha"));
				campanha.setDesconto(rs.getInt("desconto"));
				campanha.setFlativo(rs.getString("flativo"));
				campanha.setIdcampanha(rs.getLong("idcampanha"));
				campanha.setDtvalidade(rs.getString("dthora"));
				
				cliente_cupom.setCampanha(campanha);
				
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

		return cliente_cupom;
		
	}

	@Override
	public List<Cliente_AnimalDTO> buscarClienteCupom(String cupom) {
		Connection conn = null;
		PreparedStatement stBuscar = null;
		ResultSet rs = null;
		List<Cliente_AnimalDTO> listaCliente = new ArrayList<>();
		
	
		try {
	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stBuscar = conn.prepareStatement(procBuscaDadosCliente);
			stBuscar.setString(1, cupom);
			rs = stBuscar.executeQuery();
			
			while(rs.next()) {
				
				
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
	public List<Produto> buscarProsutoCupom(String cupom) {
		Connection conn = null;
		PreparedStatement stBuscar = null;
		ResultSet rs = null;
		List<Produto> listaProduto = new ArrayList<>();
		
	
		try {
	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			stBuscar = conn.prepareStatement(procBuscaDadosProduto);
			stBuscar.setString(1, cupom);
			rs = stBuscar.executeQuery();
			
			while(rs.next()) {
				
				
				Produto produto = new Produto();
				
				produto.setCodproduto(rs.getString("codproduto"));
				produto.setDescricao(rs.getString("descricao"));
				
				listaProduto.add(produto);
				
				
				
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

		return listaProduto;
		

	}
	
	@Override
	public void gravarCupomUtlizado(Cupom_UtilizacaoDTO cupom) {

		Connection conn = null;
		PreparedStatement st = null;
	
		try {
	
			
			conn = Conexao.getConnection();
			conn.setAutoCommit(false);
			
			st = conn.prepareStatement(procGravarCupom);
			st.setLong(1, cupom.getNrnf());
			st.setString(2, cupom.getIdentfunc());
			st.setLong(3, cupom.getIdcliente());
			st.setLong(4, cupom.getIdestabelecimento());
			st.setString(5, cupom.getCodproduto());
			st.setLong(6, cupom.getIdcampanha());
			st.setString(7, cupom.getCodcupom());
			
			st.execute();
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
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}		

}
