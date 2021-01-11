package az.product.model.db;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private long id;

    private String fullName;

    private String email;

    private String password;

    private List<Role> roleList;

    private LocalDateTime idate;

    private LocalDateTime udate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public LocalDateTime getIdate() {
        return idate;
    }

    public void setIdate(LocalDateTime idate) {
        this.idate = idate;
    }

    public LocalDateTime getUdate() {
        return udate;
    }

    public void setUdate(LocalDateTime udate) {
        this.udate = udate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleList=" + roleList +
                ", idate=" + idate +
                ", udate=" + udate +
                '}';
    }
}
