package rafal.kwiatkowski.shopassistant_apachecxf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import rafal.kwiatkowski.shopassistant_apachecxf.model.Product;
import rafal.kwiatkowski.shopassistant_apachecxf.repository.ProductRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@Path("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_XML)
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Product finProduct(@PathParam(value = "id") Integer id) {
        return productRepository.findOne(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Product updateProduct(@PathParam(value = "id") Integer id, Product productWithChanges) {
        return productRepository.update(id, productWithChanges);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response deleteProduct(@PathParam(value = "id") Integer id) {
        productRepository.delete(id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/")
    @Consumes(MediaType.APPLICATION_XML)
    public Response deleteProduct() {
        productRepository.deleteAll();
        return Response.noContent().build();
    }

}
