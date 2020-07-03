package school.app;

/**
 *
 * @author ashik
 */
public class Student_bean {
    private int id;
    private String name;
    private float cgpa;
    private String dob;
    private byte[] photo;
    
    public Student_bean(int id, String name, float cgpa, String dob, byte[] photo){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
        this.dob=dob;
        this.photo=photo;
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

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
}
