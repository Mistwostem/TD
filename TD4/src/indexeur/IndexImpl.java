package indexeur;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * CLasse concr�te impl�mentant l'interface Index
 * @author julien et Elie
 *
 * @param <K> Comparable K
 * @param <V> Comparable V
 */
public class IndexImpl<K extends Comparable<K>, V extends Comparable<V>> implements Index<K,V> {

	/**
    * Fonction SortedMap qui va stocker les cl�s et les valeurs contenues dans l'index
    * 
    * @return un objet de type SortedMap 
    */
    private final SortedMap<K, List<V>> sortedMap;
    
    /**
     * Constructeur de la classe IndexImpl, on impl�mente SortedMap avec TreeMap
     */
    public IndexImpl() {
        this.sortedMap = new TreeMap<>(Collator.getInstance());
    }
	
    /**
     * Fonction qui supprime une cl� de l'index ainsi que ces valeurs associ�es
     * 
     * @param cle K
     */
	public void supprimer(K cle) {
		this.sortedMap.remove(cle);
    }

	/**
	 * Fonction qui supprime une valeur de l'index et qui supprime la cl� si c'est la derni�re valeur de la cl�
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
     * Fonction qui ajoute cl� et une valeur � l'index, si la cl� existe d�j�, ajoute la valeur � la cl� existante
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
     * Fonction qui retourne les valeurs d'une cl� K prise en entr�e
     *
     * @param cle K
     * @return List
     */
    public List<V> rechercher(K cle) {
    	return this.sortedMap.get(cle); 
    }

    /**
     * Fonction qui v�rifie si une cl� contient bien la valeur pass�e en entr�e
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
     * Fonction qui retourne le nombre de lc�s dans l'index
     * 
     * @return int
     */
    public int nbeCles() {
    	return this.sortedMap.size();
    }

    /**
     * Fonction qui v�rifie si l'index est vide ou non
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
     * Fonction qui retourne l'ensemble des cl�s pr�sentes dans l'index
     *
     * @return Set
     */
    public Set<K> obtenirCles() {
    	return this.sortedMap.keySet();
    }
    
    /**
     * Fonction qui retourne une chaine de caract�res contenant les informations pr�sentes dans l'index
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
