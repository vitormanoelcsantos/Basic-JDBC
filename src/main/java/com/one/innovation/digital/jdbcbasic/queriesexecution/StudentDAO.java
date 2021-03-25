package com.one.innovation.digital.jdbcbasic.queriesexecution;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    // 1 - Consulta
    public List<Student> list() {
        //Preparar lista que irá retornar alunos após consultar o banco de dados;
        List<Student> students = new ArrayList<>();

        // Designer pattern Factory
        try (Connection conn = ConnectionFactory.getConnection()) {
            //Preparar consulta SQL.
            String sql = "SELECT * FROM student";

            //Preparar statement com os parâmetros recebidos (nesta função não tem parâmetros, pois irá retornar
            //todos os valores da tabela aluno)
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Criar um objeto aluno e guardar na lista de alunos.
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int agesold = rs.getInt("agesold");
                String state = rs.getString("state");

                students.add(new Student(
                        id,
                        name,
                        agesold,
                        state
                ));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de alunos falhou!");
            e.printStackTrace();
        }

        //Retornar todos os alunos encontrados no banco de dados.
        return students;
    }

    // 1.1 - Consulta com filtro
    public Student getById(int id) {
        //Preparar objeto aluno para receber os valores do banco de dados.
        Student students = new Student();

        try (Connection conn = ConnectionFactory.getConnection()) {
            //Preparar consulta SQL
            String sql = "SELECT * FROM student WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Guardar valores retornados da tabela aluno no objeto aluno
            if (rs.next()){
                students.setId(rs.getInt("id"));
                students.setName(rs.getString("name"));
                students.setAgesold(rs.getInt("agesold"));
                students.setState(rs.getString("state"));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de alunos falhou!");
            e.printStackTrace();
        }

        //Retorna aluno encontrado no banco de dados.
        return students;
    }

    // 2 - Inserção
    public void create(Student students) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para inserção de dados do aluno.
            String sql = "INSERT INTO student(name, agesold, state) VALUES(?, ?, ?)";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , students.getName());
            stmt.setInt(2, students.getAgesold());
            stmt.setString(3 , students.getState());

            //Executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção bem sucedida!. Foi adicionada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Inserção falhou!");
            e.printStackTrace();
        }
    }

    // 3 - Delete
    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para deletar uma linha.
            String sql = "DELETE FROM student WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            //Executa delete e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Deleção bem sucedida! Foi deletada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Deleção falhou!");
            e.printStackTrace();
        }
    }

    // 4 - Atualizar
    public void update(Student students) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para atualizar linhas.
            String sql = "UPDATE student SET name = ?, agesold = ?, state = ? WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, students.getName());
            stmt.setInt(2, students.getAgesold());
            stmt.setString(3, students.getState());
            stmt.setInt(4, students.getId());

            //Executa atualização e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização bem sucedida! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização falhou!");
            e.printStackTrace();
        }
    }
}
