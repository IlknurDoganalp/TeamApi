package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Post_ResponseBodyTesti {

    /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */

    @Test
    public void post01(){

        // 1-Url olustur
        String url="https://jsonplaceholder.typicode.com/posts";

        // 2- request body olustur
        JSONObject reqBody=new JSONObject(); //Request body icin obje olusturduk asagida body icerisindeki elemanlari yazdik
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        System.out.println("Request Body : "+ reqBody);

        //3- Response'i kaydet.

        // Kullanacagimiz method post methodu oldugu icin body gondermemiz gerekir.
        //Body gondermek icin de given'dan sonra Content Type gondermemiz gerekir
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(toString())//olusturdugumuz body her ne kadar json formatinda da olsa tostringe cevirip gondermemiz gerekir
                .post(url);
        response.prettyPrint(); // response'i yadirma islemi
        
        /* 4- Assertion'i olustur
         response.then()
                 .assertThat()
                 .statusCode(201)
                 .contentType("application/json")
                 .body("title", Matchers.equalTo("API"))
                 .body("userId", Matchers.lessThan(100)) //Less than ...'dan kucuk mu? onun sorgulamasi yapilir.
                 .body("body", Matchers.containsString("API"));

         */







    }
}
