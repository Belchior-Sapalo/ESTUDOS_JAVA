package com.estudosjava.javacomoprogramar.javacore.capitulo14_Strings_ExpressoesRegulares.Strings;

public class ComparandoStringsTeste {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = "goodbye";
        String s3 = "Happy Birthday";
        String s4 = "happy birthday";
        String s5 = "happy birthday";
        System.out.printf("s1 = %s%ns2 = %s%ns3 = %s%ns4 = %s%n%n", s1, s2, s3, s4);

        //Teste para igualdade dos conteudos contidos nos objectos (valores)
        if(s1.equals("hello")){
            System.out.println("s1 equals \"hello\"");
        }else{
            System.out.println("s1 not equals \"hello\"");
        }

        //Testa igualdade dos objectos Strings, ou seja retorna true se as referencias referenciam o mesmo objecto na memoria
        if(s1 == "hello"){
            System.out.println("s1 is the same object as \"hello\"");
        }else{
            System.out.println("s1 is not the same object as \"hello\"");
        }

        //Teste para igualdade dos conteudos contidos nos objectos (valores) ignorando case
        if(s3.equalsIgnoreCase(s4)){
            System.out.printf("%s equals %s with case ignored%n", s3, s4);
        }else{
            System.out.println("s3 does not equal s4");
        }

        //Teste compareTo
        //O método compareTo retorna 0 se as Strings forem iguais
        //O método compareTo retorna um número negativo se a String que invoca compareTo for menor que a String que é passada como um argumento
        //O método compareTo retorna um número positivo se a String que invoca compareTo for maior que a String que é passada como um argumento.
        System.out.printf("%ns1.compareTo(s2) is %d", s1.compareTo(s2));
        System.out.printf("%ns2.compareTo(s1) is %d", s2.compareTo(s1));
        System.out.printf("%ns1.compareTo(s1) is %d", s1.compareTo(s1));
        System.out.printf("%ns3.compareTo(s4) is %d", s3.compareTo(s4));
        System.out.printf("%ns4.compareTo(s3) is %d%n%n", s4.compareTo(s3));

        // testa regionMatches (distingue maiúsculas e minúsculas)
        //Determina se os caracteres nos limites especificados sao iguais em amabs as palavras
        //Primeiro argumento indice inicial de s3
        //Segundo argumento objecto para a comparacao(s4)
        //Terceiro argumento indice inicial de s4, objecto de comparacao
        //Quarto argumento e o numero de caracteres a serem comparados
        if (s3.regionMatches(0, s4, 0, 5))
            System.out.println("First 5 characters of s3 and s4 match");
        else
            System.out.println("First 5 characters of s3 and s4 do not match");

        // testa regionMatches (ignora maiúsculas e minúsculas)
        //Determina se os caracteres nos limites especificados sao iguais em amabs as palavras
        //Primeiro argumento, true para ignoras maiusculas e minusculas
        //Segundo argumento indice inicial de s3
        //Terceiro argumento objecto para a comparacao(s4)
        //Quarto argumento indice inicial de s4, objecto de comparacao
        //Quinto argumento e o numero de caracteres a serem comparados
        if (s3.regionMatches(true, 0, s4, 0, 5))
            System.out.println("First 5 characters of s3 and s4 match with case ignored");
        else
            System.out.println("First 5 characters of s3 and s4 do not match");
    }
}
