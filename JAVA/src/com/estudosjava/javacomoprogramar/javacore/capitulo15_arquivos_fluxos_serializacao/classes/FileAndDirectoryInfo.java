package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.classes;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;

public class FileAndDirectoryInfo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um nome de arquivo ou directorio");
        Path path = Paths.get(s.nextLine());

        if(Files.exists(path)){ // se o caminho existe, gera uma saída das informações sobre ele
            try{
                System.out.printf("%n%s exists%n", path.getFileName());
                System.out.printf("%s a directory%n", Files.isDirectory(path) ? "Is" : "Is not");
                System.out.printf("%s an absolute path%n", path.isAbsolute() ? "Is" : "Is not");
                System.out.printf("Last modified: %s%n", Files.getLastModifiedTime(path));
                System.out.printf("Size: %s%n", Files.size(path));
                System.out.printf("Path: %s%n", path);
                System.out.printf("Absolute path: %s%n", path.toAbsolutePath());
                if (Files.isDirectory(path)){
                    System.out.printf("%nDirectory contents:%n");

                    // objeto para iteração pelo conteúdo de um diretórioÿ
                    DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                    for (Path file : directoryStream){
                        System.out.printf("%s%n", file);
                    }
                }else{
                    System.out.printf("%s does not exist%n", path);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
