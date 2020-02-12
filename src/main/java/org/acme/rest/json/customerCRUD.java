package org.acme.rest.json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.acme.rest.json.dto.CustomerDTO;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/service/customer")
public class customerCRUD {

    @Inject
    MongoClient mongoClient;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String payload) {

        JSONObject jsonObject;
        JSONObject data;
        JSONObject customerObj;

        try {
            jsonObject = new JSONObject(payload);
            data = jsonObject.getJSONObject("data");
            customerObj = data.getJSONObject("customer");
        } catch (JSONException jsonException) {
            return Response.ok()
                    .status(200)
                    .entity(new JSONObject().put("exception", jsonException.getMessage()).toString())
                    .build();
        }

        // Creamos el objeto Gson que se encargara de las conversiones
        Gson gson = new Gson();
        CustomerDTO customer;

        try {
            customer = gson.fromJson(customerObj.toString(), CustomerDTO.class);
        } catch (JsonSyntaxException jsonSyntaxException) {
            return Response.ok()
                    .status(200)
                    .entity(new JSONObject().put("exception", jsonSyntaxException.getMessage()).toString())
                    .build();
        }

        System.out.println(customer.toString());

        add(customer);

        return Response.ok()
                .status(200)
                .entity(new JSONObject().put("msg", "¡Todo ha ido bien!").toString())
                .build();
    }

    public boolean add(CustomerDTO customer){
        Document document = new Document();
        document.put("uuid", customer.getUuid());
        document.put("name", customer.getName());
        document.put("lname", customer.getLname());
        document.put("slname", customer.getSlname());
        document.put("email", customer.getEmail());
        document.put("phone", customer.getPhone());
        document.put("bdate", customer.getBdate());
        document.put("gender", customer.getGender());

        getCollection().insertOne(document);

        return true;
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("customer").getCollection("data_customer");
    }
}