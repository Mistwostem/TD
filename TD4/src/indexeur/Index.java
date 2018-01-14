package indexeur;

import java.util.List;
import java.util.Set;

/**
 * @author julien et Elie
 *
 * @param <K> Comparable K
 * @param <V> Comparable V
 */
public interface Index<K extends Comparable<K>, V extends Comparable<V>> {
    
	/**
     * Fonction qui supprime la clé de l'index ainsi que les valeurs qui sont attachées
     *
     * @param une clé qui est à supprimer de notre index
     */
    public void supprimer(K cle);

    /**
     * Fonction qui supprime une valeur de l'index, or si c'est la dernière alors la clé est supprimée
     * 
     * @param une cle K
     * @param une valeur V
     */
    public void supprimer(K cle, V valeur);

    /**
     * Fonction qui prend en entrée une clé et une valeur puis les ajoute à l'index si la clé existe dèja alors 
     * on ajoute la valeur à celle ci
     *
     * @param une cle K
     * @param une valeur V
     */
    public void ajouter(K cle, V valeur);

    /**
     * Fonction qui retourne la ou les valeurs de la clé K prise en entrée
     *
     * @param une cle K de l'index
     * @return une liste comportant des valeurs
     */
    public List<V> rechercher(K cle);

    /**
     * Fonction qui vérifie si la clé contient bien les valeurs prises en entrée
     *
     * @param une cle K
     * @param une valeur V
     * @return une variable booléenne qui vaut vrai si  l'index contient le couple présent en entrée
     */
    public boolean rechercher(K cle, V valeur);

    /**
     * Fonction qui retourne le nombre de clés présentes dans l'index
     *
     * @return la taille de l'index
     */
    public int nbeCles();

    /**
     * Fonction qui vérifie si l'index est vide ou non
     *
     * @return une variable booléenne indiquant vrai si l'index et vide et faux sinon
     */
    public boolean estVide();

    /**
     * Fonction qui vide l'index
     */
    public void vider();
 
    /**
     * Fonction qui retourne l'ensemble des clés présentes dans l'index
     *
     * @return les différentes les clés de l'index
     */
    public Set<K> obtenirCles();

    /**
     * Fonction qui retourne une chaine de caractères contenant les informations présentes dans l'index
     *
     * @return une chaîne de caractères
     */
    @Override
    public String toString();

}
