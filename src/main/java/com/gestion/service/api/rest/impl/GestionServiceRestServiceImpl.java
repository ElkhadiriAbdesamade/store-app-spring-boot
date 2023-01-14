package com.gestion.service.api.rest.impl;

import com.gestion.service.api.api.GestionRestService;
import com.gestion.service.api.dataaccess.entities.Facture;
import com.gestion.service.api.dataaccess.entities.Product;
import com.gestion.service.api.dataaccess.entities.User;
import com.gestion.service.api.to.FactureTo;
import com.gestion.service.api.to.ProductTo;
import com.gestion.service.api.to.UserTo;
import com.gestion.service.api.logic.api.GestionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public class GestionServiceRestServiceImpl implements GestionRestService {

    @Inject
    GestionService gestionService;

    //Users
    @Override
    public UserTo registerUserTo(User user) {
        return gestionService.registerNewUser(user);
    }

    @Override
    public UserTo updateUserTo(User user) {
        return gestionService.updateUser(user);
    }

    @Override
    public UserTo getUserToById(BigDecimal id) {
        return gestionService.getUserToById(id);
    }

    @Override
    public UserTo getUserToByEmail(String email) {
        return gestionService.getUserToByEmail(email);
    }

    @Override
    public List<UserTo> getAllUsersTo() {
        return gestionService.getAllUsers();
    }

    @Override
    public void deleteUserTo(Integer id) {
        gestionService.deleteUserTo(id);
    }


    //----------Products---------------------------------

    @Override
    public List<ProductTo> getAllProductsTo() {
        return gestionService.getAllProducts();
    }

    @Override
    public List<ProductTo> searchProductsTo(String productName) {
        return gestionService.searchProducts(productName);
    }

    @Override
    public ProductTo getProductToById(BigDecimal id) {
        return gestionService.getProductToById(id);
    }

    @Override
    public ProductTo addNewProduct(Product product) { return gestionService.addNewProduct(product);}

    @Override
    public void deleteProductTo(Integer id) {
        gestionService.deleteProductTo(id);
    }

    @Override
    public ProductTo updateProductTo(Product product) {
        return gestionService.updateProductTo(product);
    }


    //----------Facture---------------------------------

    @Override
    public List<FactureTo> getAllFacturesTo() {
        return gestionService.getAllFactures();
    }

    @Override
    public FactureTo getFactureToById(BigDecimal id) {
        return gestionService.getFactureById(id);
    }

    @Override
    public List<FactureTo> getFactureToByUserId(BigDecimal id) {
        return gestionService.getFactureByUserId(id);
    }

    @Override
    public FactureTo addNewFactureTo(Facture facture) { return gestionService.addNewFacture(facture);}

    @Override
    public void deleteFactureTo(Integer id) {
        gestionService.deleteFacture(id);
    }

    @Override
    public FactureTo updateFactureTo(Facture facture) {
        return gestionService.updateFacture(facture);
    }
}
