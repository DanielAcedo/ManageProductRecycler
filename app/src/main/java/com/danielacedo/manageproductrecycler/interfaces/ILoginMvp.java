package com.danielacedo.manageproductrecycler.interfaces;

/**
 * Created by Daniel on 6/10/16.
 */

/**
 * Base interfaces for the MVP model, it contains all the methods necessary to implement for the components of this pattern
 * @author Daniel Acedo Calderón
 */
public interface ILoginMvp {

    int OK = 0; // Success
    int PASSWORD_DIGIT = 1; //The password doesn't comply with the password minimum digit policy
    int PASSWORD_UPPERLOWERCASE = 2; //The password doesn't comply with the password minimum lowercase/uppercase policy
    int PASSWORD_LENGTH = 3; //The password doesn't comply with the password length policy
    int DATA_EMPTY = 4; //The user or password field is empty

    /**
     * Interface to be implemented by the view in the pattern
     * @author Daniel Acedo Calderón
     */
    interface View{
        /**
         * Sends an order to the view to display a message error
         * @param messageError The message to be displayed
         * @author Daniel Acedo Calderón
         */
        void setMessageError(String messageError, int view);
    }

    /**
     * Interface to be implemented by the presenter in the pattern
     */
    interface Presenter{
        void validateCredentials(String user, String pass);
    }
}
