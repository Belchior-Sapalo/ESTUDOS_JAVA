package com.estudosjava.maratonajava.javacore.JDBC.database;

import com.estudosjava.maratonajava.javacore.JDBC.Conection.ConnectionFactory;
import com.estudosjava.maratonajava.javacore.JDBC.classes.Comprador;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompradorDB {
    public static void save(Comprador comprador) {
        String sql = "insert into `agencia`.`comprador` (cpf, nome) values ('" + comprador.getCpf() + "', '" + comprador.getNome() + "')";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
            System.out.println("Comprador salvo com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Nao foi possivel deletar o comprador");
            return;
        }
        String sql = "delete from `agencia`.`comprador` where id = '" + comprador.getId() + "'";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
            System.out.println("Comprador eliminado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Integer compradorId) {
        if (compradorId == null) {
            System.out.println("Nao foi possivel deletar o comprador");
            return;
        }
        String sql = "delete from `agencia`.`comprador` where id = '" + compradorId + "'";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
            System.out.println("Comprador eliminado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Nao foi possivel atualizar o comprador");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = '" + comprador.getCpf() + "', `nome` = '" + comprador.getNome() + "' WHERE (`id` = '" + comprador.getId() + "')";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
            System.out.println("Comprador atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePrepareStatement(String cpf, String nome, int idComprador) {
        if (idComprador < 0 || idComprador == 0) {
            System.out.println("Nao foi possivel atualizar o comprador");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE (`id` = ?)";
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, nome);
            stmt.setInt(3, idComprador);
            stmt.executeUpdate();
            ConnectionFactory.close(conn, stmt);
            System.out.println("Comprador atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> findAll() {
        String sql = "select id, nome, cpf from `agencia`.`comprador`";
        Connection conn = ConnectionFactory.getConnection();
        List<Comprador> compradorList = new ArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConnectionFactory.close(conn, stmt, rs);
            System.out.println("Sem mais compradores");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compradorList;
    }

    public static List<Comprador> findAllCached() {
        String sql = "select id, nome, cpf from `agencia`.`comprador`";
        CachedRowSet cachedRowSet = ConnectionFactory.getRowSetConnectionCached();
        List<Comprador> compradorList = new ArrayList();
        try {
            cachedRowSet.setCommand(sql);
            cachedRowSet.execute();;
            while (cachedRowSet.next()) {
                compradorList.add(new Comprador(cachedRowSet.getInt("id"), cachedRowSet.getString("cpf"), cachedRowSet.getString("nome")));
            }
            System.out.println("Sem mais compradores");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compradorList;
    }

    public static void findById(Integer id) {
        String sql = "SELECT cpf, id, nome from `agencia`.`comprador` WHERE id = '" + id + "'";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("Comprador: %d, %s, %s%n", rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"));
            }
            ConnectionFactory.close(conn, stmt, rs);
            System.out.println("Sem mais compradores");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findByName(String key) {
        String sql = "SELECT cpf, id, nome from `agencia`.`comprador` WHERE cpf = '" + key + "' or nome = '" + key + "'";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("Comprador: %d, %s, %s%n", rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"));
            }
            ConnectionFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findByNameprePareStatement(String key) {
        String sql = "SELECT * from `agencia`.`comprador` WHERE nome = ?";
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.printf("Comprador: %d, %s, %s%n", rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"));
            }
            ConnectionFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findByNamepreJdcbRowSet(String key) {
        String sql = "SELECT * from `agencia`.`comprador` WHERE nome = ?";
        JdbcRowSet jdbcRowSet = ConnectionFactory.getRowSetConnection();
        try {
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setString(1, key);
            jdbcRowSet.execute();
            while (jdbcRowSet.next()) {
                System.out.printf("Comprador: %d, %s, %s%n", jdbcRowSet.getInt("id"), jdbcRowSet.getString("nome"), jdbcRowSet.getString("cpf"));
            }
            ConnectionFactory.close(jdbcRowSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> findByLatter(String key) {
        String sql = "SELECT cpf, id, nome from `agencia`.`comprador` WHERE nome like '%" + key + "'";
        Connection conn = ConnectionFactory.getConnection();
        List<Comprador> compradorList = new ArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConnectionFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compradorList;
    }

    public static void getMetadata() {
        String sql = "SELECT * FROM `agencia`.`comprador`";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            rs.next();
            int getColumns = metaData.getColumnCount();
            System.out.println("Quantidade de colunas: " + getColumns);

            for (int i = 1; i <= getColumns; i++) {
                System.out.print("Coluna: " + metaData.getColumnName(i));
                System.out.print(" Tabela: " + metaData.getTableName(i));
                System.out.println(" Tamanho: " + metaData.getColumnDisplaySize(i));
            }
            ConnectionFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkDatabaseSuports() {
        Connection conn = ConnectionFactory.getConnection();
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            if (metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                //TYPE_FORWARD_ONLY -> Que itera simplesmente de cima para baixa (top down)
                System.out.print("Suporta TYPE_FORWARD_ONLY ");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    //CONCUR_UPDATABLE -> Os dados podem ser atualizados enquanto o resultSet estiver aberto
                    System.out.println("E tambem suporta CONCUR_UPDATABLE");
                }
            }

            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                //TYPE_SCROLL_INSENSITIVE -> Que itera de cima para baixo e de baixo para cima.
                //As mudancas feitas no banco de dados nao se refletem no actual resutSet enquanto estiver aberto
                System.out.print("Suporta TYPE_SCROLL_INSENSITIVE ");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    //CONCUR_UPDATABLE -> Os dados podem ser atualizados enquanto o resultSet estiver aberto
                    System.out.println("E tambem suporta CONCUR_UPDATABLE");
                }
            }

            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                //TYPE_SCROLL_SENSITIVE -> Que itera de cima para baixo e de baixo para cima.
                //As mudancas feitas no banco de dados se refletem automaticamente no actual resutSet enquanto estiver aberto
                System.out.print("Suporta TYPE_SCROLL_SENSITIVE ");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    //CONCUR_UPDATABLE -> Os dados podem ser atualizados enquanto o resultSet estiver aberto
                    System.out.println("E tambem suporta CONCUR_UPDATABLE");
                }
            }
            ConnectionFactory.close(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
