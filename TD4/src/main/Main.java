package main;

import extracteur.*;
import indexeur.*;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
	

	public static void main(String[] args){
		
		LOGGER.setLevel(Level.INFO);

		try {
			
			LOGGER.info("\nCLASSE MAIN - INDEXATION PUIS CREATION DES INDEX\n");
                
            String chaine = "Un tout petit chien, joli \n ronge un  joli petit os; \nTout ce qui est petit est joli.";
            String chaineNull = null;
            
            IndexImpl<String, Integer> indexString = new IndexImpl<>();
            Extracteur ex = new ExtracteurMot(chaine); 
            
            IndexImpl<String, Integer> indexStringNull = new IndexImpl<>();
            Extracteur extracteurStringNull = new ExtracteurMot(chaineNull); 

            IndexImpl<String, Integer> indexFichier = new IndexImpl<>();
            Extracteur eF = new ExtracteurFichier(new FileInputStream("src/main/monFichier.txt"));
            
            IndexImpl<String, Integer> indexFichierVide = new IndexImpl<>();
            Extracteur extracteurFichierVide = new ExtracteurFichier(new FileInputStream("src/main/fichierVide.txt"));
 
            LOGGER.info("\nTESTS SUR FICHIER\n");
            
            LOGGER.info("Extraction suivi de l'indexation à partir du fichier : \n");
            ExtractIdex(eF, indexFichier);
            
            LOGGER.info("Extraction suivi de l'indexation à partir d'un fichier vide : \n");
            ExtractIdex(extracteurFichierVide, indexFichierVide);
            
            LOGGER.info("Suppression de la clé \"chien\" \n");
            indexFichier.supprimer("chien");
            System.out.println(indexFichier.toString());
            
            LOGGER.info("Suppression de la clé \"petit\" et sa valeur 2 \n");
            indexFichier.supprimer("petit", 2);
            System.out.println(indexFichier.toString());
            
            LOGGER.info("Ajout du couple clé, valeur \"ajout\", 2 \n");
            indexFichier.ajouter("ajout", 2);
            System.out.println(indexFichier.toString());
            
            LOGGER.info("Recherche de la clé \"joli\" \n");
            System.out.println(indexFichier.rechercher("joli"));
            
            LOGGER.info("Recherche du couple clé, valeur \"ronge\", 3 \n");
            System.out.println(indexFichier.rechercher("ronge", 3));
            
            LOGGER.info("Recherche du couple clé, valeur \"ronge\", 2 \n");
            System.out.println(indexFichier.rechercher("ronge", 2));
            
            LOGGER.info("Combien de clés comporte l'index ? \n");
            System.out.println(indexFichier.nbeCles());
            
            LOGGER.info("Obtention des clés de l'index \n");
            System.out.println(indexFichier.obtenirCles());
            
            LOGGER.info("L'index est-il vide ? \n");
            System.out.println(indexFichier.estVide());
            
            LOGGER.info("Vidage de l'index \n");
            indexFichier.vider();
            
            LOGGER.info("L'index est-il vide maintenant ? \n");
            System.out.println(indexFichier.estVide());
             
            LOGGER.info("\nTESTS SUR CHAÎNE DE CARACTERES\n");
            
            LOGGER.info("Extraction suivi de l'indexation à partir d'une chaine de caractères :  \n");
            ExtractIdex(ex, indexString);
            
            LOGGER.info("Suppression de la clé \"chien\" \n");
            indexString.supprimer("chien");
            System.out.println(indexString.toString());
            
            LOGGER.info("Suppression de la clé \"petit\" et sa valeur 2 \n");
            indexString.supprimer("petit", 2);
            System.out.println(indexString.toString());
            
            LOGGER.info("Ajout du couple clé, valeur \"ajout\", 2 \n");
            indexString.ajouter("ajout", 2);
            System.out.println(indexString.toString());
            
            LOGGER.info("Recherche de la clé \"joli\" \n");
            System.out.println(indexString.rechercher("joli"));
            
            LOGGER.info("Recherche du couple clé, valeur \"ronge\", 3 \n");
            System.out.println(indexString.rechercher("ronge", 3));
            
            LOGGER.info("Recherche du couple clé, valeur \"ronge\", 2 \n");
            System.out.println(indexString.rechercher("ronge", 2));
            
            LOGGER.info("Combien de clés comporte l'index ? \n");
            System.out.println(indexString.nbeCles());
            
            LOGGER.info("Obtention des clés de l'index \n");
            System.out.println(indexString.obtenirCles());
            
            LOGGER.info("L'index est-il vide ? \n");
            System.out.println(indexString.estVide());
            
            LOGGER.info("Vidage de l'index \n");
            indexString.vider();
            
            LOGGER.info("L'index est-il vide maintenant ? \n");
            System.out.println(indexString.estVide());
            
            LOGGER.info("Extraction suivi de l'indexation à partir d'une chaine de caractères null :  \n");
            ExtractIdex(extracteurStringNull, indexStringNull);
    
        } catch (Exception e) {
            e.getMessage();
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
