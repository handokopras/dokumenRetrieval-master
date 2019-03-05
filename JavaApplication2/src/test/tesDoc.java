/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import model.Document;
import model.InvertedIndex;
import model.Posting;
import model.Term;

/**
 *
 * @author admin
 */
public class tesDoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Document doc1 = new Document(1, "Siapa pergi memancing");
        Document doc2 = new Document(2, "pemancingan itu sangat ramai");
        Document doc3 = new Document(3, "saya dapat ikan di pemancingan itu");
        Document doc4 = new Document(4, "memancing itu hobi adik saya");
        
        InvertedIndex index = new InvertedIndex();
        
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);
        index.addNewDocument(doc4);
        // panggil fungsi make dictionary
      index.makeDictionaryWithTermNumber();
        ArrayList<Term> result = index.getDictionary();
        // tampilkan isi document dan id-nya
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Term = "+result.get(i).getTerm()+
                    ",numberOfDocument = "+result.get(i).getNumberOfDocument());
            ArrayList<Posting> tempPosting = result.get(i).getPostingList();
            for (int j = 0; j < tempPosting.size(); j++) {
                System.out.println("id_doc = "+tempPosting.get(j).getDocument().getId()
                +", numberofTerm = "+tempPosting.get(j).getNumberOfTerm());
            }
        }
        
        // number of document
        String tempString = "silver";
        int result2 = index.getDocumentFrequency(tempString);
        System.out.println("Number of Doc with "+tempString+" is "+result2);
        
        // idf
        String tempString1 = "silver";
        double result3 = index.getDocumentFrequency(tempString1);
        System.out.println("IDF of "+tempString1+" is "+result3);
        
        // tf
        // idf
        String tempString2 = "silver";
        int idDoc=2;
        int result4 = index.getTermFrequency(tempString2, idDoc);
        System.out.println("TF of "+tempString2+" in idDoc ="+idDoc+ " is "+result4);
        
    
        
    }
}
