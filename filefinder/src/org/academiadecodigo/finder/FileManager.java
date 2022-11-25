package org.academiadecodigo.finder;

import org.academiadecodigo.finder.exceptions.FileNotFoundException;
import org.academiadecodigo.finder.exceptions.NotEnoughPermissionsException;
import org.academiadecodigo.finder.exceptions.NotEnoughtSpaceException;

public class FileManager {

    private File[] files;
    private boolean loggedIn = false;

    public FileManager(int maxFiles) {
        this.files = new File[maxFiles];
    }

    public void login() {
        this.loggedIn = true;
    }

    public void logout() {
        this.loggedIn = false;
    }

    // TODO: remove this method


    public File getFile(String fileName) throws NotEnoughPermissionsException, FileNotFoundException {
        boolean isFound = false;
        if(loggedIn == false) {
            throw new NotEnoughPermissionsException("You have to LogIn");
        }

        for (File file : files) {

            if (file == null) {
                break;
            } else if(file.getName().equals(fileName)) {
                isFound = true;
                System.out.println("Found it");
                return file;
            }
        }

        throw new FileNotFoundException("File Not Found");
    }





    // TODO: implement this method
    public void createNewFile(String fileName) throws NotEnoughtSpaceException {
        for(int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = new File(fileName);
                break;
            } else if( files[i] != null &&  i < files.length){

            } else {
                throw new NotEnoughtSpaceException("Memory full. Cannot create more files");
            }
        }
    }
}
