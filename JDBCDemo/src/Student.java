public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private Integer agestart;
    private Integer ageend;
    public Integer getAgestart() {
        return agestart;
    }

    public void setAgestart(Integer agestart) {
        this.agestart = agestart;
    }

    public Integer getAgeend() {
        return ageend;
    }

    public void setAgeend(Integer ageend) {
        this.ageend = ageend;
    }

    public Student() {
        // TODO 自动生成的构造函数存根
    }

    public Student(Integer id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}