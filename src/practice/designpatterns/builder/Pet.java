package practice.designpatterns.builder;

import java.util.Date;

public class Pet {
    private String animal;
    private String name;
    private Integer age;
    private String breed; //Optional
    private Date dateOfBirth; //Optional

    public Pet(String animal, String name, int age, String breed, Date dateOfBirth) {
        this.animal = animal;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
    }

    private Pet() {

    }

    public static class Builder {
        private String animal;
        private String name;
        private Integer age;
        private String breed; //Optional
        private Date dateOfBirth; //Optional

        public Builder withAnimal(String animal){
            this.animal = animal;
            return this;
        }
        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withAge(int age){
            this.age = age;
            return this;
        }
        public Builder withBreed(String breed){
            this.breed = breed;
            return this;
        }
        public Builder withDateOfBirth(Date date) {
            this.dateOfBirth = date;
            return this;
        }
        public Pet build(){
            if(this.name == null || this.animal == null || this.age == null){
                throw new IllegalArgumentException();
            }else{
                return new Pet(animal,name,age,breed,dateOfBirth);
            }
        }
    }

    public static void main(String[] args) {
        Pet myCat = new Pet.Builder().withName("kalu").withAge(2).withAnimal("cat").build();
        System.out.println(myCat.name);
    }
}
