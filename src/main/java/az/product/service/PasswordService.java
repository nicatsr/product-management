package az.product.service;

public interface PasswordService {

    String hashPassword(String plainPassword);
    boolean passwordsMatch(String plainPassword, String hashedPassword);
}
