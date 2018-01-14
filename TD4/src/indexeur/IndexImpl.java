package indexeur;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * CLasse concrète implémentant l'interface Index
 * @author julien et Elie
 *
 * @param <K> Comparable K
 * @param <V> Comparable V
 */
public class IndexImpl<K extends Comparable<K>, V extends Comparable<V>> implements Index<K,V> {

	/**
    * Fonction SortedMap qui va stocker les clés et les valeurs contenues dans l'index
    * 
    * @return un objet de type SortedMap 
    */
    private final SortedMap<K, List<V>> sortedMap;
    
    /**
     * Constructeur de la classe IndexImpl, on implémente SortedMap avec TreeMap
     */
    public IndexImpl() {
        this.sortedMap = new TreeMap<>(Collator.getInstance());
    }
	
    /**
     * Fonction qui supprime une clé de l'index ainsi que ces valeurs associées
     * 
     * @param cle K
     */
	public void supprimer(K cle) {
		this.sortedMap.remove(cle);
    }

	/**
	 * Fonction qui supprime une valeur de l'index et qui supprime la clé si c'est la dernière valeur de la clé
     *
     * @param cle K
     * @param valeur V
	 */
    public void supprimer(K cle, V valeur) {
    	this.sortedMap.get(cle).remove(valeur);
        if (this.sortedMap.get(cle).isEmpty()) {
            this.supprimer(cle);
        }
    }

    /**
     * Fonction qui ajoute clé et une valeur à l'index, si la clé existe déjà, ajoute la valeur à la clé existante
     *
     * @param cle K
     * @param valeur V
     */
    public void ajouter(K cle, V valeur) {
    	 if (this.sortedMap.containsKey(cle)) {
             this.sortedMap.get(cle).add(valeur);
         }else {
             this.sortedMap.put(cle, new ArrayList<>());
             this.sortedMap.get(cle).add(valeur);
         } 
    }

    /**
     * Fonction qui retourne les valeurs d'une clé K prise en entrée
     *
     * @param cle K
     * @return List
     */
    public List<V> rechercher(K cle) {
    	return this.sortedMap.get(cle); 
    }

    /**
     * Fonction qui vérifie si une clé contient bien la valeur passée en entrée
     *
     * @param cle K
     * @param valeur V 
     * @return boolean
     */
    public boolean rechercher(K cle, V valeur) {
    	List<V> listeV = this.rechercher(cle);
        return listeV.contains(valeur); 
    }

    /**
     * Fonction qui retourne le nombre de lcés dans l'index
     * 
     * @return int
     */
    public int nbeCles() {
    	return this.sortedMap.size();
    }

    /**
     * Fonction qui vérifie si l'index est vide ou non
     *
     * @return boolean
     */
    public boolean estVide() {
    	return this.sortedMap.isEmpty(); 
    }

    /**
     * Fonction qui vide l'index
     */
    public void vider() {
    	this.sortedMap.clear(); 
    }

    /**
     * Fonction qui retourne l'ensemble des clés présentes dans l'index
     *
     * @return Set
     */
    public Set<K> obtenirCles() {
    	return this.sortedMap.keySet();
    }
    
    /**
     * Fonction qui retourne une chaine de caractères contenant les informations présentes dans l'index
     *
     * @return String
     */
    public String toString(){
    	StringBuilder sb = new StringBuilder();
        for (K key : this.obtenirCles()) {
            sb.append(key);
            sb.append(" : ");
            sb.append(this.rechercher(key));
            sb.append('\n');
        }
        return sb.toString();
    }
}
