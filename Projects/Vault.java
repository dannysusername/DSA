package Projects;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import Projects.Objects.BaseDocument;
import Projects.Objects.Document;
import Projects.Objects.Passwords;

public class Vault {

    private int no;
    private HashMap<Integer, Document> Vault1;

    public Vault(){
        this.no = 0;
        Vault1 = new HashMap<>();

    }

    public void addDocument(String title, String description) {
        no++;
        Document newDoc = new BaseDocument(no, title, description);
        Vault1.put(no, newDoc);

    }

    public void addPassword(String title, String description, String username, String password) {
        no++;
        Passwords newDoc = new Passwords(no, title, description, username, password);
        Vault1.put(no, newDoc);

    }

    public Document getDocumentByTitle(int title) {

        Document result = Vault1.getOrDefault(title, null);

        if(result == null) {
            System.out.println("Document not found, null returned");
            return null;
        } else {
            return result;
        }
        
    }

    public void getAllDocuments() {
        int listNumber = 1;

        for(Map.Entry<Integer, Document> MapNode : Vault1.entrySet()) {
            System.out.print(listNumber + ". ");
            printDocument(MapNode.getValue());
            listNumber++;
            System.out.print(" key: " + MapNode.getKey() +"\n");

        }

    }

    public void printDocument(Document doc) {
        if(doc instanceof Passwords) {
            Passwords pwdDoc = (Passwords) doc;
            System.out.print("Title: {" + pwdDoc.getTitle() + "} Username: " + pwdDoc.getUsername() + " Date: " + pwdDoc.getDate());
            return;
        }

        System.out.print("Title: {" + doc.getTitle() + "} Date: " + doc.getDate());

    }

    public void getOnlyPasswords() {
        int num = 1;

        for(Map.Entry<Integer, Document> entry : Vault1.entrySet()) {
            if(entry.getValue().getClass() == Passwords.class) {
                System.out.println(num + ". Title: {" + entry.getValue().getTitle() + "} Date: " + entry.getValue().getDate());
                num++;
            }
        }
        /* 
            for(Document document : Vault1.values()) {
                if(document instanceof Passwords) {
                System.out.println(num + ". Title: {" + document.getTitle() + "} Date: " + document.getDate());
                num++;
            }
        */

    }

    public void getOnlyDocuments(){
        int num = 1;

        for(Map.Entry<Integer, Document> entry : Vault1.entrySet()) {
            if(entry.getValue().getClass() == Document.class) {
                System.out.println(num + ". Title: {" + entry.getValue().getTitle() + "} Date: " + entry.getValue().getDate() + " key: " + entry.getKey());
                num++;
            }
        }
        /* 
            for(Document document : Vault1.values()) {
                if(document instanceof Document && !(document instanceof Passwords)) {
                System.out.println(num + ". Title: {" + document.getTitle() + "} Date: " + document.getDate());
                num++;
            }
        */

    }
    
    public void editDocument(Scanner in) {
        System.out.println("Enter the key of the document to edit: ");
        int key = in.nextInt();

        Document doc = Vault1.get(key);
        if(doc == null) {
            System.out.println("No document found for key: " + key);
            return;
        }

        System.out.println("==============");
        printDocument(doc);
        System.out.println("==============");

        System.out.println("Starting edit method in doc");
        doc.edit(in);



    }

    
}
