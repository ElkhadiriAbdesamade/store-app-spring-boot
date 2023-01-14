package com.gestion.service.api.logic.impl;

import com.gestion.service.api.dataaccess.entities.Facture;
import com.gestion.service.api.dataaccess.facture.dao.FactureDAO;
import com.gestion.service.api.dataaccess.product.dao.ProductDAO;
import com.gestion.service.api.dataaccess.user.dao.UserDAO;
import com.gestion.service.api.dataaccess.entities.Product;
import com.gestion.service.api.dataaccess.entities.User;
import com.gestion.service.api.to.FactureTo;
import com.gestion.service.api.to.ProductTo;
import com.gestion.service.api.to.UserTo;
import com.gestion.service.api.logic.api.GestionService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Named


public class GestionServiceImpl implements GestionService {

    private static final Logger logger = LoggerFactory.getLogger(GestionServiceImpl.class);

    @Inject
    DozerBeanMapper dozer;


    @Inject
    UserDAO userDAO;

    @Inject
    ProductDAO productDAO;

    @Inject
    FactureDAO factureDAO;



    @Override
    public UserTo getUserToById(BigDecimal id) {
        User user =null;
        UserTo userTo =new UserTo();
        user = userDAO.getUserById(id);
        dozer.map(user, userTo);
        return userTo;
    }

    @Override
    public UserTo getUserToByEmail(String email) {
        User user =null;
        UserTo userTo =new UserTo();
        user = userDAO.getUserByEmail(email);
        if (user == null)
        {
            return new UserTo(0,"","","","","","","","");
        }
        dozer.map(user, userTo);
        return userTo;
    }



    @Override
    public void deleteUserTo(Integer id) {
        userDAO.deleteById(id);
        //userDAO.deleteUserById(id);
    }

    @Override
    public UserTo registerNewUser(User user) {
        UserTo userTo =new UserTo();
        user = userDAO.save(user);
        dozer.map(user, userTo);
        return userTo;
    }

    @Override
    public UserTo updateUser(User user) {
        UserTo userTo =new UserTo();
        userDAO.updateById(user.getFirst_name(),user.getLast_name(),user.getPhone(),user.getAddress(),user.getCountry(),user.getEmail(),user.getPassword(),user.getRole(),user.getId());
        dozer.map(user, userTo);
        return userTo;
    }

    @Override
    public List<UserTo> getAllUsers() {
        List<User> users =null;
        List<UserTo> usersTo =new ArrayList<UserTo>();
        users=userDAO.getAllUsers();
        dozer.map(users, usersTo);
        return usersTo;
    }



    ///--------------------------------Product------------------------------------------------------------
    @Override
    public List<ProductTo> getAllProducts() {
        List<Product> products =null;
        List<ProductTo> productsTo =new ArrayList<ProductTo>();
        products=productDAO.getAllProducts();
        dozer.map(products, productsTo);
        return productsTo;
    }

    @Override
    public List<ProductTo> searchProducts(String productName) {
        List<Product> products =null;
        List<ProductTo> productsTo =new ArrayList<ProductTo>();
        products=productDAO.searchProducts(productName);
        dozer.map(products, productsTo);
        return productsTo;
    }

    @Override
    public ProductTo getProductToById(BigDecimal id) {
        Product product =null;
        ProductTo productTo =new ProductTo();
        product = productDAO.getProductById(id);
        dozer.map(product, productTo);
        return productTo;
    }

    @Override
    public ProductTo addNewProduct(Product p) {
        ProductTo productTo =new ProductTo();
        p = productDAO.save(p);
        dozer.map(p, productTo);
        return productTo;
    }

    @Override
    public void deleteProductTo(Integer id) {
        productDAO.deleteProductById(id);
    }

    @Override
    public ProductTo updateProductTo(Product product) {
        ProductTo productTo =new ProductTo();
        productDAO.updateProductById(product.getName(),product.getDescription(),product.getQte_stock(),product.getSale(),product.getSale_amount(),product.getPrice(),product.getImage(),product.getId());
        dozer.map(product, productTo);
        return productTo;

    }

    ///--------------------------------Factures------------------------------------------------------------

    @Override
    public List<FactureTo> getAllFactures() {
        List<Facture> factures =null;
        List<FactureTo> facturesTo =new ArrayList<FactureTo>();
        factures=factureDAO.getAllFactures();
        dozer.map(factures, facturesTo);
        return facturesTo;
    }

    @Override
    public FactureTo getFactureById(BigDecimal id) {
        Facture facture =null;
        FactureTo factureTo =new FactureTo();
        facture=factureDAO.getFactureById(id);
        dozer.map(facture, factureTo);
        return factureTo;
    }

    @Override
    public List<FactureTo> getFactureByUserId(BigDecimal id) {
        List<Facture> factures =null;
        List<FactureTo> facturesTo =new ArrayList<FactureTo>();
        factures=factureDAO.getFacturesByUserId(id);
        dozer.map(factures, facturesTo);
        return facturesTo;
    }

    @Override
    public FactureTo addNewFacture(Facture facture) {
        FactureTo factureTo =new FactureTo();
        facture=factureDAO.save(facture);
        dozer.map(facture, factureTo);
        return factureTo;
    }

    @Override
    public void deleteFacture(Integer id) {
        factureDAO.deleteFactureById(id);
    }

    @Override
    public FactureTo updateFacture(Facture facture) {
        FactureTo factureTo =new FactureTo();
        factureDAO.updateFacture(facture.getUser_id(),facture.getProduct_id(),facture.getUser_fullName(),facture.getProduct_name(),facture.getProduct_qte(),facture.getTotal_price(),facture.getId());
        dozer.map(facture, factureTo);
        return factureTo;
    }


}
