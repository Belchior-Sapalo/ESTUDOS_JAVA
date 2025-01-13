package com.estudosjava.maratonajava.javacore.Exceptions.tryWithResource.testes;

import com.estudosjava.maratonajava.javacore.Exceptions.tryWithResource.classes.Leitor1;
import com.estudosjava.maratonajava.javacore.Exceptions.tryWithResource.classes.Leitor2;

public class TryWithResourceTeste {
    public static void main(String[] args) {
        readFileNew();
    }

    public static void readFileNew(){
        //A partir da versao 7 do java
        //Ao usar o try with resources nao e obrigatorio fechar os recursos
        //explicitamente e pode se relancar a excessao
        try(Leitor1 leitor1 = new Leitor1(); Leitor2 leitor2 = new Leitor2()){
            //Os recursos sao fechados na ordem contraria a ordem dos parametros no try
            leitor1.reading();
            leitor2.reading();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readFileOld() {
        //Ate a versao 6 do java
        Leitor1 leitor1 = new Leitor1();
       try {
           leitor1.reading();
       }catch (Exception e){
            e.printStackTrace();
       }finally {
           try {
              leitor1.close();
           }catch (Exception e){
               e.printStackTrace();
           }
       }

        Leitor2 leitor2 = new Leitor2();
        try {
            leitor2.reading();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                leitor2.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
