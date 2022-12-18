package practice.collections;

public class DeepCopyTypes {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*
        * Checking normal copy or shallow copy
        * */
/*
        Address address = new Address("Tasgaon","India");
        User onkar = new User("Onkar",25,address);

        User onkarCopy = new User(onkar.getName(),onkar.getAge(),onkar.getAddress());

        address.city = "Pune";

        System.out.println(onkarCopy.getAddress().getCity());
*/
/*

        //Checking deep copy
        Address address = new Address("Tasgaon","India");
        User onkar = new User("Onkar",25,address);
        User onkarDeepCopy = new User(onkar);

        address.city = "Delhi";
        System.out.println(onkar.getAddress().getCity());
        System.out.println(onkarDeepCopy.getAddress().getCity());
*/
        //Testing clone method
        Address address = new Address("Tasgaon","India");
        User onkar = new User("Onkar",25,address);
        User onkarDeepCopy = (User) onkar.clone();

        address.city = "Delhi";
        System.out.println(onkar.getAddress().getCity());
        System.out.println(onkarDeepCopy.getAddress().getCity());
    }
}

class Address implements Cloneable{
    String city;
    String country;


    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public Address(Address that){
        this(that.city,that.country);
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class User implements Cloneable{
    String name;
    int age;
    Address address;

    public User(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public User(User that){
        this(that.getName(),that.age,new Address(that.getAddress()));
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = null;
        user = (User) super.clone();
        user.address = (Address) this.address.clone();
        return user;
    }
}


