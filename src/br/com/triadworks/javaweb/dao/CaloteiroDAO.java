package br.com.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.triadworks.javaweb.modelo.Caloteiro;

public class CaloteiroDAO {

	private Connection conexao;

	public CaloteiroDAO() {
		this.conexao = new ConnectionFactory().getConnection();
	}

	public void adiciona(Caloteiro caloteiro) {
		String sql = "insert into caloteiro " + "(nome, email, devendo, dataDivida)" + "values (?,?,?,?)";

		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, caloteiro.getNome());
			pstmt.setString(2, caloteiro.getEmail());
			pstmt.setInt(3, caloteiro.getDevendo());
			pstmt.setDate(4, new Date(caloteiro.getDataDivida().getTimeInMillis()));

			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Caloteiro> getLista() {

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select * from caloteiro");

			List<Caloteiro> caloteiros = new ArrayList<Caloteiro>();
			Caloteiro caloteiro = null;
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				int devendo = rs.getInt("devendo");

				Calendar dataDivida = Calendar.getInstance();
				dataDivida.setTime(rs.getDate("dataDivida"));

				caloteiro = new Caloteiro();

				caloteiro.setNome(nome);
				caloteiro.setEmail(email);
				caloteiro.setDevendo(new Integer(devendo));
				caloteiro.setDataDivida(dataDivida);

				caloteiros.add(caloteiro);
			}
			rs.close();
			stmt.close();
			return caloteiros;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Caloteiro caloteiro) {
		String sql = "update caloteiro set nome=?, email=?, devendo=?, dataDivida=? where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, caloteiro.getNome());
			stmt.setString(2, caloteiro.getEmail());
			stmt.setInt(3, caloteiro.getDevendo());
			stmt.setDate(4, new Date(caloteiro.getDataDivida().getTimeInMillis()));

			stmt.setLong(5, caloteiro.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Durante alteração caloteiro.");
			throw new RuntimeException(e);
		}

	}

	public void deleta(Caloteiro caloteiro) {
		String sql = "delete from caloteiro where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, caloteiro.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Caloteiro getCaloteiro(Long id) {
		String sql = "select * from caloteiro where id=?";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setLong(1, id);

			Caloteiro caloteiro = null;
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Long idCaloteiro = rs.getLong("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				int devendo = rs.getInt("devendo");
				Calendar dataDivida = Calendar.getInstance();
				dataDivida.setTime(rs.getDate("dataDivida"));

				caloteiro = new Caloteiro();

				caloteiro.setId(idCaloteiro);
				caloteiro.setNome(nome);
				caloteiro.setEmail(email);
				caloteiro.setDevendo(devendo);
				caloteiro.setDataDivida(dataDivida);
			}
			rs.close();
			stmt.close();
			return caloteiro;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
