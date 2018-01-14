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
    
            String chaine3 = "Ceci est un test d'un test\n comprenant un test.";
            String chaine4 = "Un tout petit chien, joli \n ronge un  joli petit os ;\nTout ce qui est petit est joli.";

            //Déclaration des fichiers à extraire puis indexer
            
            String path = "src/main/monFichier.txt";
            FileInputStream file = new FileInputStream(path);

            //Déclaration des extracteurs et des index
            
            IndexImpl<String, Integer> indexString = new IndexImpl<>();
            Extracteur ex = new ExtracteurMot(chaine3); 

            IndexImpl<String, Integer> indexFichier = new IndexImpl<>();
            Extracteur eF = new ExtracteurFichier(file);

            //TEST DE L'EXTRACTEUR FICHIER ET DE SON INDEXATION
            //Process extraction fichier vers indexation
            
            System.out.println("Extraction suivi de l'indexation à partir du fichier : \n");
            ExtractIdex(eF, indexFichier);

            //TEST DE L'EXTRACTEUR DE MOT ET DE SON INDEXATION
            //Process extraction mot vers indexation
            
            System.out.println("Extraction suivi de l'indexation à partir d'une chaine de caractères :  \n");
            ExtractIdex(ex, indexString);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

	/**
	 * Fonction simulant le processus d'extraction puis d'indexation
	 * 
	 * @param extracteur qui correspond à une instance d'extracteur
	 * @param index qui correspond à une instance d'indexImpl
	 */
    public static void ExtractIdex(Extracteur extracteur, IndexImpl<String, Integer> index) {
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
