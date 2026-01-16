package com.example.Learn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "password_hash")
    private String password;

    //2 scnerios delete and orphan
    //@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})  if cascade remove on there on table check v1 migration
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @Builder.Default
    List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    @ManyToMany()
    @JoinTable(
            name = "user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    public void addTag(String tagName) {
        Tag tag = new Tag(tagName);
        tags.add(tag);
        tag.getUsers().add(this);
    }

    public void removeTag(Tag tagObject) {
        tags.remove(tagObject);
        tagObject.setUsers(null);
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Profile profile;

    public void addProfile(Profile profile) {
        this.profile = profile;
        profile.setUser(this);
    }

    public void removeProfile(Profile profile) {
        profile.setUser(null);
        this.profile = null;
    }

    @ManyToMany()
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> wishList = new HashSet<>();
}
//
//
//Before Lombok
//
//        package com.example.Learn.entities;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "users")
//public class user {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(nullable = false, name = "name")
//    private String name;
//
//    @Column(nullable = false, name = "email")
//    private String email;
//
//    @Column(nullable = false, name = "password_hash")
//    private String password;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
//
