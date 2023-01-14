package com.gestion.service.api.api;

import com.gestion.service.api.dataaccess.entities.Facture;
import com.gestion.service.api.dataaccess.entities.Product;
import com.gestion.service.api.dataaccess.entities.User;
import com.gestion.service.api.to.FactureTo;
import com.gestion.service.api.to.ProductTo;
import com.gestion.service.api.to.UserTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "*")
@Path("/gestion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface GestionRestService {


/////////////////////User-----------------------------------------------------------------------------
    @POST
    @Path("/user/registerNewUser")
    UserTo registerUserTo(@RequestBody User user);

    @PUT
    @Path("/user/updateUser")
    UserTo updateUserTo(@RequestBody User user);



    @GET
    @Path("/user/id/{id}")
    UserTo getUserToById(@PathParam("id") BigDecimal id);

    @GET
    @Path("/user/allUsers")
    List<UserTo> getAllUsersTo();

    @GET
    @Path("/user/email/{email}")
    @GetMapping()
    UserTo getUserToByEmail(@PathParam("email") String email);

    @DELETE
    @Path("/user/delete/{id}")
    void deleteUserTo (@PathParam("id") Integer id);

/////////////////////Product-----------------------------------------------------------------------------

    @GET
    @Path("/product/allProducts")
    List<ProductTo> getAllProductsTo();

    @GET
    @Path("/product/searchProducts/{productName}")
    List<ProductTo> searchProductsTo(@PathParam("productName") String productName);

    @GET
    @Path("/product/id/{id}")
    ProductTo getProductToById(@PathParam("id") BigDecimal id);

    @POST
    @Path("/product/addNewProduct")
    ProductTo addNewProduct(@RequestBody Product product);

    @PUT
    @Path("/product/updateProduct")
    ProductTo updateProductTo(@RequestBody Product product);

    @DELETE
    @Path("/product/delete/{id}")
    void deleteProductTo (@PathParam("id") Integer id);


    /////////////////////Facture-----------------------------------------------------------------------------

    @GET
    @Path("/facture/allFactures")
    List<FactureTo> getAllFacturesTo();

    @GET
    @Path("/facture/id/{id}")
    FactureTo getFactureToById(@PathParam("id") BigDecimal id);

    @GET
    @Path("/facture/user_id/{id}")
    List<FactureTo> getFactureToByUserId(@PathParam("id") BigDecimal id);

    @POST
    @Path("/facture/addNewFacture")
    FactureTo addNewFactureTo(@RequestBody Facture facture);

    @PUT
    @Path("/facture/updateFacture")
    FactureTo updateFactureTo(@RequestBody Facture facture);

    @DELETE
    @Path("/facture/delete/{id}")
    void deleteFactureTo (@PathParam("id") Integer id);

}
