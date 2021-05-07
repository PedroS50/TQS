package pedro93221;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {

    public AppTest() {}

    @Test
    public void whenGetAllToDo_thenReturnStatusCode200() {
        //get("https://jsonplaceholder.typicode.com/todos/4").then().statusCode(200);
    }

    @Test
    public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect() {
        get("https://jsonplaceholder.typicode.com/todos/4").then().statusCode(200).assertThat()
           .body("title", equalTo("et porro tempora"));
    }

    @Test
    public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenContains198and199() {
        get("https://jsonplaceholder.typicode.com/todos").then().statusCode(200).assertThat()
        .body("id", hasItems(198, 199));
    }

}
