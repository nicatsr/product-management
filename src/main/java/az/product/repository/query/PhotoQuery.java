package az.product.repository.query;

public class PhotoQuery {

    public static String ADD_PHOTO = "insert into photo(url , content_type,idate ," +
            " udate) values(:url ,:content_type, :idate , :udate)";

    public static String GET_PHOTO_BY_URL = "select id , url , idate , udate , content_type " +
            " from photo " +
            " where url = ?";

    public static String GET_PHOTO_BY_ID = "select id , url , idate , udate , content_type " +
            " from photo " +
            " where id = ?";
}
