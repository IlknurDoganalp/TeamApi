package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */
    @Test
    public void get01(){

        // 1- URl olustur
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- Expected data hazirla
        JSONObject data=new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expecData=new JSONObject();
        expecData.put("status","success");
        expecData.put("data",data);
        expecData.put("message","Successfully! Record has been fetched.");

        // Response'i kaydet
        Response response=given().when().get(url);
        response.prettyPrint();


        SoftAssert softAssert=new SoftAssert();

        JsonPath resJP=response.jsonPath();

        softAssert.assertEquals(resJP.get("status"),expecData.get("status"));
        softAssert.assertEquals(resJP.get("message"),expecData.get("message"));
        softAssert.assertEquals(resJP.get("data.id"), expecData.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("data.employee_name"), expecData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJP.get("data.employee_salary"), expecData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJP.get("data.employee_age"), expecData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJP.get("data.profile_image"), expecData.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();

    }
}
