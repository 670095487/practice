package com.example.dockerdemo.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author yunN
 * @date 2021/10/27
 */
@Entity(name = "T_USER")
@DynamicUpdate
@DynamicInsert
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   private String name;
   private int age;
   private String address;
   private LocalDate birthday;
   private LocalDateTime time;

   public LocalDate getBirthday() {
      return birthday;
   }

   public void setBirthday(LocalDate birthday) {
      this.birthday = birthday;
   }

   public LocalDateTime getTime() {
      return time;
   }

   public void setTime(LocalDateTime time) {
      this.time = time;
   }

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

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}
