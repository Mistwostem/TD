package main;

import extracteur.*;
import indexeur.*;

import java.io.FileInputStream;

public class Main {

	public static void main(String[] args){
		
		try {

            // CLASSE MAIN
			
            System.out.println("\nCLASSE MAIN - INDEXATION PUIS CREATION DES INDEXES\n");
            
            //Déclaration des chaînes (qui seront indéxées par la suite)
    
            String chaine3 = "Incroyable " + '\r' + " on dirait \t de \n\n la \n\42MAGIE! ";
            String chaine4 = "Un tout petit chien, joli \n ronge un  joli petit os ;\nTout ce qui est petit est joli.";
            String chaine5 = chaine3 + chaine4;

            //Déclaration des fichiers à extraire puis indexer
            
            String path = "src/main/monFichier.txt";
            FileInputStream file = new FileInputStream(path);

            //Déclaration des extracteurs et des index
            
            IndexImpl<String, Integer> indexS = new IndexImpl<>();
            Extracteur ex = new ExtracteurMot(chaine3);
            // Extracteur ex2 = new ExtracteurString(chaine2);  

            IndexImpl<String, Integer> indexF = new IndexImpl<>();
            Extracteur eF = new ExtracteurFichier(file);

            //TEST DE L'EXTRACTEUR FILE ET DE L'INDEXATION
            //Méthode du processus extraction file -> indexation
            
            System.out.println("Extraction puis indexation à partir d'un fichier : \n");
            EI(eF, indexF);

            //TEST DE L'EXTRACTEUR STRING ET DE L'INDEXATION
            //Méthode du processus extraction string -> indexation
            
            System.out.println("Extraction puis indexation à partir d'une chaine de caractères :  \n");
            EI(ex, indexS);
            //  EI(ex2, new IndexImpl<>());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void EI(Extracteur extracteur, IndexImpl index) {
        InfosMot infoMot = new InfosMot();
        do {
            infoMot = extracteur.getNext();
            if (infoMot == null) {
                break;
            }

            index.ajouter(infoMot.getMot().toLowerCase(), infoMot.getLigne());
        } while (null != infoMot.getMot());
        System.out.println(index.toString());
    }
}
