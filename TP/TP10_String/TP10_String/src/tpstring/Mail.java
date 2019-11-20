package tpstring;

/**
 * Exercice Mail.
 */
class Mail {

    /**
     * Une adresse mail.
     */
    String adresseMail;

    /**
     * Constructeur.
     *
     * @param uneAdresseMail l'adresse mail de ce mail.
     */
    Mail(String uneAdresseMail) {
        adresseMail = uneAdresseMail;
    }

    /**
     * Indique si l'adresse mail est valide
     *
     * @return vrai ssi l'adresse mail est valide.
     */
    boolean isValidMail() {
        String parti1;
        String parti2;
        String parti3;
        
        int posArobase = adresseMail.indexOf('@');
        if (posArobase == -1) {
            return false;
        }

        int posPoint = adresseMail.indexOf('.',posArobase);
        if (posPoint == -1){
            return false;
        }
        
        parti1 = adresseMail.substring(0, posArobase);
        parti2 = adresseMail.substring(posArobase+1, posPoint);
        parti3 = adresseMail.substring(posPoint+1, this.adresseMail.length());

        
        if (parti1.length()<3 || parti1.length()>20 || parti2.length()<3 || parti2.length()>20){
            return false;
        }
        
        
                
        return (parti3.length()<=7 && parti3.length()>=2);
    }
}


