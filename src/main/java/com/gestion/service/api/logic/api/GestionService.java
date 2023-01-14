package com.gestion.service.api.logic.api;

import com.gestion.service.api.dataaccess.entities.Facture;
import com.gestion.service.api.dataaccess.entities.Product;
import com.gestion.service.api.dataaccess.entities.User;
import com.gestion.service.api.to.FactureTo;
import com.gestion.service.api.to.ProductTo;
import com.gestion.service.api.to.UserTo;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public interface GestionService {

//User--------------------
    UserTo getUserToById(BigDecimal id);

    UserTo getUserToByEmail(String email);

    void deleteUserTo(Integer id);

    UserTo registerNewUser(User user);

    UserTo updateUser(User user);

    List<UserTo> getAllUsers();


//Product--------------------
    List<ProductTo> getAllProducts();

    List<ProductTo> searchProducts(String productName);


    ProductTo getProductToById(BigDecimal id);

    ProductTo addNewProduct(Product product);

    void deleteProductTo(Integer id);

    ProductTo updateProductTo(Product product);


    //Facture--------------------------------------------

    List<FactureTo> getAllFactures();

    FactureTo getFactureById(BigDecimal id);

    List<FactureTo> getFactureByUserId(BigDecimal user_id);

    FactureTo addNewFacture(Facture facture);

    void deleteFacture(Integer id);

    FactureTo updateFacture(Facture facture);
}
