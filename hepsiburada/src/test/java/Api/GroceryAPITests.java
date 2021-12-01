package Api;

import java.lang.reflect.Method;
import java.util.List;

public class GroceryAPITests {

        //Get access token

        public static void setup(){
            RestAssured.baseURI = "https://grocery.com/";
        }

        @Feature("GET all grocery info")
        public void test_ValidateAllGroceryEndpoint() {

            Response response = httpRequest.request(Method.GET, "/allGrocery");
            String responseBody = response.getBody().asString();
            List<String> groceries = response.getBody().jsonPath().getList("data.name");

            Assertions.assertEquals(200, response.statusCode());
            for(grocery: groceries) {
                Assertions.assertContains(grocery, responseBody);
            }
        }
        @Feature("GET grocery by valid names")
        public void test_ValidateGroceryByNameEndpoint() {

            List<String> groceries = response.getBody().jsonPath().getList("data.name");
            for(grocery: groceries){
                Response response = httpRequest.request(Method.GET, "/allGrocery/grocery");
                String responseBody = response.getBody().asString();

                Assertions.assertEquals(200, response.statusCode());
                Assertions.assertContains(grocery, responseBody);
            }
        }

        @Feature("GET grocery by invalid names")
        public void test_ValidateInvalidGroceryEndpoint() {

            Response response = httpRequest.request(Method.GET, "/allGrocery/elma");
            Assertions.assertEquals(404, response.statusCode());
        }

        @Feature("POST new grocery")

        public void test_ValidateAddNewGrocery()
        String newGrocery = "watermellon";

        Response response = httpRequest.request(Method.POST, "/add");

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertNotNull(response.getBody().jsonPath().getString("data.id"));
    }
}
