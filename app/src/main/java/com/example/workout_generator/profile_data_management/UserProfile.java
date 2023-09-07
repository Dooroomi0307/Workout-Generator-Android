package com.example.workout_generator.profile_data_management;

/**
 * UserProfile class object that is constucted based on profile data in the userprofile table in the profiledb database
 * Holds Integer id, String name, Integer age, and String gender
 */
public class UserProfile {

    private Integer id;
    private String name;
    private Integer age;
    private String gender;

    public UserProfile(Integer id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
