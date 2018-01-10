package main;

import extracteur.*;
import indexeur.*;
import java.text.Collator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args){
		
	    Extracteur eF = new ExtracteurFile();
	    Extracteur eS = new ExtracteurMot();  
	    
	  //Test de la classe IndexImpl seule
        System.out.println("TESTS DE LA CLASSE INDEXATION SEULE\n");

        SortedMap m = new TreeMap<>(Collator.getInstance());

        IndexImpl<String, Integer> i = new IndexImpl<>(m);
        i.ajouter("Where", 1);
        i.ajouter("is", 2);
        i.ajouter("my", 3);
        i.ajouter("my", 9);
        i.ajouter("mind", 3);
        i.ajouter("mind", 4);
        i.ajouter("?", 2);

        System.out.println("Affichage de l'index :\n" + i.toString());
        i.supprimer("Where");
        System.out.println("Apr�s suppresion de la cl� Where :\n" + i.toString() + '\n');
        i.supprimer("mind", 3);
        System.out.println("Apr�s suppresion de la valeur 3 de la cl� mind :\n" + i.toString() + '\n');
        i.supprimer("mind", 4);
        System.out.println("Apr�s suppresion de la valeur 4 de la cl� mind :\n" + i.toString() + '\n');
        System.out.println("Recherche des valeurs de la cl� my :\n" + i.rechercher("my") + '\n');
        System.out.println("V�rifier si la valeur 9 existe pour la cl� my :\n" + i.rechercher("my", 9) + '\n');
        System.out.println("Nombre de cl�s :\n" + i.nbeCles() + '\n');
        System.out.println("V�rifier si l'index est vide :\n" + i.estVide() + '\n');
        System.out.println("Obtenir toutes les cl�s de l'index :\n" + i.obtenirCles() + '\n');
        i.vider();
        System.out.println("Affichage de l'index :\n" + i.toString());
    }
}
