package test;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_BodyTekrarlardanKurtulma {

     /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                    "firstname" in,"Jim",
                    ve "lastname“in, "Jones",
                    ve "totalprice“in, 533,
                    ve "depositpaid“in,false,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

    @Test
    public void get01(){

        // 1- Url hazirla
        String url="https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected data hazirla

        //3- Response'i kaydet
        Response response = given().when().get(url);

        response.prettyPrint();

        // 4 - Assertion

        /* response
                 .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json; charset=utf-8")
                    .body("firstname", Matchers.equalTo("Susan"),
                            "lastname", Matchers.equalTo("Wilson"),
                            "totalprice",Matchers.equalTo(613),
                            "depositpaid", Matchers.equalTo(false),
                            "additionalneeds", Matchers.equalTo("Breakfast"));
        */

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Susan"),
                        "lastname", equalTo("Wilson"),
                        "totalprice",equalTo(613),
                        "depositpaid", equalTo(false),
                        "additionalneeds", equalTo("Breakfast"));

    }
}
