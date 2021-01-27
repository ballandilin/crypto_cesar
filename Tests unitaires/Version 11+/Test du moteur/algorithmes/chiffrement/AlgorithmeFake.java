package algorithmes.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import exceptions.ExceptionCryptographie;


/**
 * Description de la classe
 * @author Matthieu
 */
public class AlgorithmeFake implements Algorithme {

    @Override
    public String getNom() {
       return "Algorithme de Test";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        return new MessageString("Chiffre");
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        return new MessageString("Dechiffre");
    }

}
