package note.vo;

public class User {
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String email, String flag) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.flag = flag;
    }

    public User(int id, String name, String password, String email, String flag, String image) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.flag = flag;
        this.image = image;
    }

    private int id;
    private String name;
    private String password;
    private String email;
    private String flag;
    private String active;
    private String image;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
