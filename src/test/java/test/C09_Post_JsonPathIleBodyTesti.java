package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class C09_Post_JsonPathIleBodyTesti {
    /*
            https://restful-booker.herokuapp.com/booking
            url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             },
                            "additionalneeds" : "wi-fi"
                        }
            donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */

    @Test
    public void post01(){
        // 1- url olustur
        String url="https://restful-booker.herokuapp.com/booking";

        // 2- Request body olustur
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("additionalneeds","wi-fi");
        reqBody.put("bookingdates",bookingdates);

        // 3- Expected Data

        // 4- Response kaydet
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
        response.prettyPrint();

        //5- Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstname", equalTo("Ali")
                ,"booking.lastname",equalTo("Bak")
                ,"booking.totalprice",equalTo(500)
                ,"booking.depositpaid",equalTo(false)
                ,"booking.additionalneeds",equalTo("wi-fi")
                ,"booking.bookingdates.checkin",equalTo("2021-06-01")
                ,"booking.bookingdates.checkout",equalTo("2021-06-10"));


    }
}
