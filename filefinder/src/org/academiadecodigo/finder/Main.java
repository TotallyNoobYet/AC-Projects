package org.academiadecodigo.finder;

import org.academiadecodigo.finder.exceptions.FileNotFoundException;
import org.academiadecodigo.finder.exceptions.NotEnoughPermissionsException;
import org.academiadecodigo.finder.exceptions.NotEnoughtSpaceException;

public class Main {

    public static void main(String[] args) {

        FileManager mourinho = new FileManager(5);
        

       try {
           mourinho.login();
           mourinho.createNewFile("text");
           mourinho.getFile("text");



       } catch (NotEnoughPermissionsException ex){
           System.out.println(ex.getMessage());
       } catch (NotEnoughtSpaceException ex){
           System.out.println(ex.getMessage());
       } catch (FileNotFoundException ex){
           System.out.println(ex.getMessage());
       }



    }
}
