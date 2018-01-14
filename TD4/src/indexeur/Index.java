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
     * Fonction qui supprime la cl� de l'index ainsi que les valeurs qui sont attach�es
     *
     * @param une cl� qui est � supprimer de notre index
     */
    public void supprimer(K cle);

    /**
     * Fonction qui supprime une valeur de l'index, or si c'est la derni�re alors la cl� est supprim�e
     * 
     * @param une cle K
     * @param une valeur V
     */
    public void supprimer(K cle, V valeur);

    /**
     * Fonction qui prend en entr�e une cl� et une valeur puis les ajoute � l'index si la cl� existe d�ja alors 
     * on ajoute la valeur � celle ci
     *
     * @param une cle K
     * @param une valeur V
     */
    public void ajouter(K cle, V valeur);

    /**
     * Fonction qui retourne la ou les valeurs de la cl� K prise en entr�e
     *
     * @param une cle K de l'index
     * @return une liste comportant des valeurs
     */
    public List<V> rechercher(K cle);

    /**
     * Fonction qui v�rifie si la cl� contient bien les valeurs prises en entr�e
     *
     * @param une cle K
     * @param une valeur V
     * @return une variable bool�enne qui vaut vrai si  l'index contient le couple pr�sent en entr�e
     */
    public boolean rechercher(K cle, V valeur);

    /**
     * Fonction qui retourne le nombre de cl�s pr�sentes dans l'index
     *
     * @return la taille de l'index
     */
    public int nbeCles();

    /**
     * Fonction qui v�rifie si l'index est vide ou non
     *
     * @return une variable bool�enne indiquant vrai si l'index et vide et faux sinon
     */
    public boolean estVide();

    /**
     * Fonction qui vide l'index
     */
    public void vider();
 
    /**
     * Fonction qui retourne l'ensemble des cl�s pr�sentes dans l'index
     *
     * @return les diff�rentes les cl�s de l'index
     */
    public Set<K> obtenirCles();

    /**
     * Fonction qui retourne une chaine de caract�res contenant les informations pr�sentes dans l'index
     *
     * @return une cha�ne de caract�res
     */
    @Override
    public String toString();

}
