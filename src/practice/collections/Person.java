package practice.collections;

public class Person {
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(! (obj instanceof Person ))
            return false;
        Person other = (Person) obj;
        boolean nameEquals = (this.name == null && other.name == null) || (this.name.equals(other.name));
        return this.age==other.age && nameEquals;
    }
}
