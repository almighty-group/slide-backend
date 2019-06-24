package com.group.almighty.slidebackend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(2)
    @Column(nullable = false)
    private String firstName;

    @Min(2)
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "[^0-9]+[a-zA-z]*+[0-9]*[.-_&&[a-zA-z]*[0-9]*]?[a-zA-z]*@[a-zA-z]*.[a-z]+")
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "phoneNumber", unique = true, insertable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String oldPassword;

    private String status;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Column(nullable = false, unique = true)
    private String memberId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date createdAt;

    public User() {
    }

    public User(String phone, String password, GrantedAuthority authority) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(!this.role.getRoleName().isEmpty()){
            return Arrays.asList(new SimpleGrantedAuthority(this.role.getRoleName()));
        }

        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public User(long id, @Min(2) String firstName, @Min(2) String lastName, @Pattern(regexp = "[^0-9]+[a-zA-z]*+[0-9]*[.-_&&[a-zA-z]*[0-9]*]?[a-zA-z]*@[a-zA-z]*.[a-z]+") String email, String phoneNumber, String username, String password, String oldPassword, String status, Role role, String memberId, Date createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.oldPassword = oldPassword;
        this.status = status;
        this.role = role;
        this.memberId = memberId;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
