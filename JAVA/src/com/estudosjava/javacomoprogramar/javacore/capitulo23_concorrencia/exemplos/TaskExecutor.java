package com.estudosjava.javacomoprogramar.javacore.capitulo23_concorrencia.exemplos;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    public static void main(String[] args) {
        PrintTask task1 = new PrintTask("Task 1");
        PrintTask task2 = new PrintTask("Task 2");
        PrintTask task3 = new PrintTask("Task 3");
        PrintTask task4 = new PrintTask("Task 4");

        System.out.println("Starting Executor");

        // cria ExecutorService para gerenciar threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // inicia as três PrintTasks
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);

        // fecha ExecutorService -- ele decide quando fechar threads
        executorService.shutdown();

        System.out.printf("Tasks started, main ends.%n%n");
    }

}
