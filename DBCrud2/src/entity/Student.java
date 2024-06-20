
package entity;

public class Student {

    private int id;
    private String name;
    private String email;
    private String address;
    private String cellNo;

    public Student() {
    }

    public Student(int id, String name, String email, String address, String cellNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.cellNo = cellNo;
    }

    public Student(String name, String email, String address, String cellNo) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.cellNo = cellNo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", cellNo=" + cellNo + '}';
    }
    
    
}
