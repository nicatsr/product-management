package az.product.model.db;

import java.util.Arrays;

public enum Role {

    ADMIN(1);

    private long id;
    private String roleName;
    private String successPage;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    Role(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSuccessPage() {
        return successPage;
    }

    public void setSuccessPage(String successPage) {
        this.successPage = successPage;
    }


    public static Role fromValue(long v) {
        Role role;
        role = Arrays.stream(values())
                .filter(f -> f.id == v)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown role id " + v));

        return role;
    }

}
