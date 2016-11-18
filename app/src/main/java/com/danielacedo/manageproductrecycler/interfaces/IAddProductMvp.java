package com.danielacedo.manageproductrecycler.interfaces;

import com.danielacedo.manageproductrecycler.model.Product;

/**
 * Created by Daniel on 20/10/16.
 */

public interface IAddProductMvp {

    /**
     * Interface to be implemented by the presenter of the AddProduct MVP model
     * @author Daniel Acedo Calderón
     */
    interface View {
        /**
         * Sends an order to the view to display a message error
         *
         * @param messageError The message to be displayed
         * @author Daniel Acedo Calderón
         */
        void setMessageError(String messageError, int view);
    }

    /**
     * Interface to be implemented by the presenter of the AddProduct MVP model
     * @author Daniel Acedo Calderón
     */
    interface Presenter{

        /**
         * Check if the fields are correctly entered before adding the product
         * @param name Name of the product
         * @param description Description of the product
         * @param brand Brand of the product
         * @param dosage Dosage of the product
         * @param price Price of the product
         * @param stock Stock of the product
         * @param image Image's id
         */
        boolean validateProductFields(String name, String description, String brand, String dosage, String price, String stock, String image);

        void validateProduct(Product product);
    }
}
