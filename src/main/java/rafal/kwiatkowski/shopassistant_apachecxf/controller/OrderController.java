package rafal.kwiatkowski.shopassistant_apachecxf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import rafal.kwiatkowski.shopassistant_apachecxf.model.OrderTbl;
import rafal.kwiatkowski.shopassistant_apachecxf.service.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@Path("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderTbl> findAllProducts() {
        return orderService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public OrderTbl findProduct(@PathParam(value = "id") Integer id) {
        return orderService.findOne(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OrderTbl createProduct(OrderTbl order) {
        return orderService.save(order);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OrderTbl updateProduct(@PathParam(value = "id") Integer id, OrderTbl orderWitchChanges) {
        return orderService.update(id, orderWitchChanges);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam(value = "id") Integer id) {
        orderService.delete(id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProduct() {
        orderService.deleteAll();
        return Response.noContent().build();
    }
}
