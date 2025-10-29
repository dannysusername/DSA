package Projects;

import Projects.Objects.Document;
import Projects.Objects.Passwords;

public class CommandCenter {

    public static void main(String [] args) {
        Vault DannysVault = new Vault();
        DannysVault.addDocument("The Beginning", "test");
        DannysVault.addDocument("Test1", "Test1");
        DannysVault.addDocument("Test2", "Test2");

        DannysVault.addDocument("womp", "test");
        DannysVault.addDocument("penjamin", "Test1");
        DannysVault.addDocument("ez dub", "Test2");
        DannysVault.addPassword("Google",null, "dannibar201", "11240303");

        DannysVault.getAllDocuments();


        /* Now I can create Documents and Passwords, Documents would hold sensitive information such as SSN, seed phrase, bank documents.
            Password documents hold password information
         * 
         */

    }
    
}
