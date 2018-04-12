package fiap.scj.restful.ws.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class VehicleClient {

    public static void main(String[] args) {

        String REST_URI = "http://localhost:8080/restexample/vehicle/1";
        Client client = Client.create();
        WebResource webResource = client.resource(REST_URI);

        ClientResponse response = webResource
                .accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        //List<Aluno> output = response.getEntity(new GenericType<List<Al>>(){});

        System.out.println("Output from Server .... \n");
        System.out.println(response.getEntity(String.class));
    }

}
