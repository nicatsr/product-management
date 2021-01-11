package az.product.repository.query;

public class UserQuery {

    public static String INSERT_USER = "insert into users(full_name , email ," +
            " password , idate , udate) " +
            "values(:full_name ,:email ,:password ,:idate ,:udate)";

    public static String GET_USER_BY_EMAIL = "select id , full_name ,email ,password ,idate ,udate" +
            " from users " +
            "where email = ? ";

    public static String INSERT_USER_ROLE = "insert into user_role(role_id , user_id ) " +
            "values(:role_id , :user_id)";

    public static String GET_USER_ROLES = "select r.id ,r.role_name , r.success_page " +
            "from role r join user_role ur on r.id = ur.role_id " +
            "join users u on u.id = ur.user_id " +
            "where u.id = ? ";

    public static String IS_EMAIL_EXISTS = "select count(*) " +
            "from users " +
            "where email = :email";
}
