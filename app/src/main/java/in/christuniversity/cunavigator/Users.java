package in.christuniversity.cunavigator;

public class Users {

    public String name, image, department;

    public Users(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Users(String name, String image, String department) {
        this.name = name;
        this.image = image;
        this.department = department;
    }
}
