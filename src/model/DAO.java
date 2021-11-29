package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "91a80b56c23D@";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD Create **/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, fone, email) values (?,?,?);";
		try {
			// abrir a conexao com o banco
			Connection con = conectar();
			// preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parâmetros (?) pelo conteúdo das variáves java beans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos(){
		//Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<JavaBeans>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			//prepara a query
			PreparedStatement pst = con.prepareStatement(read);
			//Executa a query
			ResultSet rs = pst.executeQuery();
			// exibir o resultado
			while (rs.next()) {
				//variáveis de apoio
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				//popular o ArrayList
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// teste de conexao
	// public void testeConexao() {
	// try {
	// Connection con = conectar();
	// System.out.println(con);
	// con.close();
	// } catch (Exception e) {
	// System.out.println(e);
	// }
	// }
}
