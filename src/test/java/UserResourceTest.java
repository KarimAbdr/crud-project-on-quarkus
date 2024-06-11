import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.describedAs;
import static org.hamcrest.Matchers.equalTo;

 class UserResourceTest {
    private static final String url = "http://localhost:8080";

    @Test
     void getAllUsers(){
        String query = "query: \"query{↵ GetAllUsers{↵ userId↵ name↵ age↵ balance↵ quantity↵ }";
        given()
                .contentType(ContentType.JSON)
                .body(query)
                .log().all()
                .when().post(url).then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
    @Test
     void findById(){
        String query = "query{↵ FindById(id: 1) {↵ name↵ age↵ balance↵ quantity↵ }↵}↵";
        given().contentType(ContentType.JSON).body(query)
                .log().all()
                .when().post(url)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .and().body("data.FindById.id",equalTo(1) );
    }
    @Test
     void createUser(){
        String mutation = "{\"query\":\"mutation { CreateUser(user: { name: \\\"Alfa\\\", age: 30, balance: 100.0, quantity: 5 }) { name, userId } }\"}";
        given().contentType(ContentType.JSON).body(mutation)
                .post(url)
                .then().assertThat().statusCode(200)
                .and().body("data.CreateUser.name", equalTo("Alfa"))
                .and().body("data.CreateUser.age",equalTo(30))
                .and().body("data.CreateUser.balance",equalTo(100.0))
                .and().body("data.CreateUser.quantity",equalTo(5));
    }
}
