package pojos;

public class JsonPlaceRequestBodyPOJO {

    /*
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
     */

    // 1- Obje icerisindeki tum key degerlerini class level'da private variable olarak hazirlayalim
    private String title;
    private String body;
    private int userId;
    private int id;

    // 2- getter ve setter methodlarini hazirla
    // getter ile sadece okuma islemi yapiyorduk


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3- Tum parametreleri iceren constructor olustur


    public JsonPlaceRequestBodyPOJO(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4- Parametresiz constructor olustur

    public JsonPlaceRequestBodyPOJO() {
    }

    // 5- toString() methodu olustur

    @Override
    public String toString() {
        return "JsonPlaceRequestBodyPOJO{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }


}
