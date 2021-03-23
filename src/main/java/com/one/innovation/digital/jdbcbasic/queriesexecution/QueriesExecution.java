package com.one.innovation.digital.jdbcbasic.queriesexecution;

import java.util.List;

public class QueriesExecution {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // =========================== 1 - Consulta =================================================
        List<Student> students = studentDAO.list();

        students.stream().forEach(System.out::println);


        // ======================= 1.1 - Consulta com filtro ========================================
        Student stundentToConsult = studentDAO.getById(1);

        //System.out.println(stundentToConsult);


        // =========================== 2 - Inserção =================================================
        Student studentToInsertion = new Student(
                "Vitor Manoel",
                21,
                "PE"
        );

        //studentDAO.create(studentToInsertion);


        // =========================== 3 - Delete ===================================================
        //studentDAO.delete(1);


        // =========================== 4 - Atualizar ================================================
        Student studentToUpdate = studentDAO.getById(3);
        studentToUpdate.setName("Joaquim");
        studentToUpdate.setAgesold(18);
        studentToUpdate.setState("PE");

        //studentDAO.update(studentToUpdate);
    }
}
