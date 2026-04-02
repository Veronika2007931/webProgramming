package org.example;

public class Teacher {
    private String Name;
    private String LastName;
    private String ThirdName;
    private int Age;
    private String TeachingSubject;

    public Teacher(String firstName, String lastName, String thirdName, int age, String teachingSubject) {
        setName(firstName);
        setLastName(lastName);
        setThirdName(thirdName);
        setAge(age);
        setTeachingSubject(teachingSubject);
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String firstName) {
        this.Name = firstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String thirdName) {
        this.ThirdName = thirdName;
    }

    public String getThirdName() {
        return this.ThirdName;
    }

    public void setThirdName(String thirdName) {
        this.ThirdName = thirdName;
    }

    public int getAge() {
        return this.Age;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.TeachingSubject = teachingSubject;
    }

    public String getTeachingSubject() {
        return this.TeachingSubject;
    }

    public void setAge(int age) {
        if (age > 18 && age < 86) {
            this.Age = age;
        } else {
            throw new IllegalArgumentException("Вік має бути від 18 до 86 років!");
        }
    }

}
