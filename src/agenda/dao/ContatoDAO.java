package agenda.dao;

import agenda.interfaces.IContato;
import agenda.model.Contato;
import agenda.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO implements IContato {
    
    private Connection con;
    private PreparedStatement cmd;

    public ContatoDAO() {
    }

    @Override
    public int adicionarContato(Contato contato) {
        try {
            String query = "INSERT INTO Contatos (Nome, Telefone, Email, Endereco, DataNascimento, Observacoes) VALUES (?,?,?,?,?,?)";
            con = DBConnection.conectar();
            cmd = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, contato.getNome());
            cmd.setString(2, contato.getTelefone());
            cmd.setString(3, contato.getEmail());
            cmd.setString(4, contato.getEndereco());
            cmd.setDate(5, Date.valueOf(contato.getDataNascimento()));
            cmd.setString(6, contato.getObservacoes());

            if (cmd.executeUpdate() > 0) {
                try (ResultSet rs = cmd.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            return -1;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO: " + e.getMessage());
            return -1;
            
        } finally {
            DBConnection.desconectar(con);
        }
    }
    
    @Override
    public Contato buscarContatoPorId(int contatoId) {
        try {
            String query = "SELECT ContatoID, Nome, Telefone, Email, Endereco, DataNascimento, Observacoes FROM Contatos WHERE ContatoID=?";
            con = DBConnection.conectar();
            cmd = con.prepareStatement(query);
            cmd.setInt(1, contatoId);
            ResultSet rs = cmd.executeQuery();

            if (rs.next()) {
                Contato contato = new Contato();
                contato.setContatoId(rs.getInt("ContatoID"));
                contato.setNome(rs.getString("Nome"));
                contato.setTelefone(rs.getString("Telefone"));
                contato.setEmail(rs.getString("Email"));
                contato.setEndereco(rs.getString("Endereco"));
                contato.setDataNascimento(rs.getDate("DataNascimento").toLocalDate());
                contato.setObservacoes(rs.getString("Observacoes"));
                return contato;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            DBConnection.desconectar(con);
        }
    }
    
    @Override
    public List<Contato> buscarTodosContatos() {
        List<Contato> lista = new ArrayList<>();
        try {
            String query = "SELECT ContatoID, Nome, Telefone, Email, Endereco, DataNascimento, Observacoes FROM Contatos";
            con = DBConnection.conectar();
            cmd = con.prepareStatement(query);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setContatoId(rs.getInt("ContatoID"));
                contato.setNome(rs.getString("Nome"));
                contato.setTelefone(rs.getString("Telefone"));
                contato.setEmail(rs.getString("Email"));
                contato.setEndereco(rs.getString("Endereco"));
                contato.setDataNascimento(rs.getDate("DataNascimento").toLocalDate());
                contato.setObservacoes(rs.getString("Observacoes"));
                lista.add(contato);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO: " + e.getMessage());
            return null;
            
        } finally {
            DBConnection.desconectar(con);
        }
        return lista;
    }
    
    @Override
    public int atualizarContato(Contato contato) {
        try {
            String query = "UPDATE Contatos SET Nome=?, Telefone=?, Email=?, Endereco=?, DataNascimento=?, Observacoes=? WHERE ContatoID=?";
            con = DBConnection.conectar();
            cmd = con.prepareStatement(query);
            cmd.setString(1, contato.getNome());
            cmd.setString(2, contato.getTelefone());
            cmd.setString(3, contato.getEmail());
            cmd.setString(4, contato.getEndereco());
            cmd.setDate(5, Date.valueOf(contato.getDataNascimento()));
            cmd.setString(6, contato.getObservacoes());
            cmd.setInt(7, contato.getContatoId());

            //cmd.executeUpdate();
            
            if(cmd.executeUpdate() > 0){
                return contato.getContatoId();
            }
            return -1;
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO: " + e.getMessage());
            return -1;
            
        } finally {
            DBConnection.desconectar(con);
        }
    }

    @Override
    public int deletarContato(Contato contato) {
        try {
                        
            String query = "DELETE FROM Contatos WHERE ContatoID=?";
            con = DBConnection.conectar();
            cmd = con.prepareStatement(query);
            cmd.setInt(1, contato.getContatoId());
            
            if(cmd.executeUpdate() > 0){
                return contato.getContatoId();
            }
            return -1;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            DBConnection.desconectar(con);
        }
    }
    
}
