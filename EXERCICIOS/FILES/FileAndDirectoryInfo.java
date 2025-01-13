import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileAndDirectoryInfo{
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira um directório");

        Path path = Paths.get(scan.nextLine());
        scan.close();
        if (Files.exists(path)){

            System.out.printf("%s%nInformações do caminho fornecido%n%s%n", "-----------------------------------------", "-----------------------------------------");
            System.out.printf("Nome: %s%n", path.getFileName());
            System.out.printf("%s um caminho absoluto%n", path.isAbsolute() ? "É": "Não é");
            System.out.printf("%s um directorio%n", Files.isDirectory(path) ? "É": "Não");
            System.out.printf("Últimas modificações: %s%n", Files.getLastModifiedTime(path));
            System.out.printf("Tamanho: %s%n", Files.size(path));

            if (Files.isDirectory(path)){
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                for (Path p : directoryStream) {
                    System.out.println(p);
                }
                directoryStream.close();
            }
        }else{
            System.out.printf("%s náo existe", path);
        }
    }
}