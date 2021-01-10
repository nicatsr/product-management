package az.product.repository.query;

public class ProductQuery {

    public static String GET_CATEGORY_LIST  = "select id , name , idate , " +
            " udate " +
            "from category";

    public static String INSERT_PRODUCT = "insert into product(name , category_id ,description ," +
            " photo_id , idate , udate) " +
            "values(:name , :category_id , :description , :photo_id , :idate ,:udate) ";

    public static String GET_PRODUCT_LIST = " select pr.name , c.name ,description ,photo_id ,pr.id " +
            "from product pr join category c on pr.category_id = c.id ";

    public static String DELETE_PRODUCT_BY_ID = "delete from product " +
            " where id = :id ";

    public static String GET_PRODUCT_BY_ID = " select pr.name , c.name , pr.id , description , photo_id " +
            "from product pr join category c on pr.category_id = c.id " +
            "where pr.id = ? ";

    public static String GET_CATEGORY_BY_NAME = "select id , name , udate , idate " +
            "from category where name = ? ";

    public static String UPDATE_PRODUCT = "update product " +
            "set " +
            "name = :name ," +
            "category_id = :category_id , " +
            "description = :description , " +
            "photo_id = :photo_id , " +
            "udate = :udate " +
            "where id = :id ";

    public static String CHECK_PHOTO_EXISTS = "select count(*) " +
            "from photo " +
            "where id = :photo_id and id != 42";
}
