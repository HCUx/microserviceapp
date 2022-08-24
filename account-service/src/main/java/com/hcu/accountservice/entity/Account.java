package com.hcu.accountservice.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("account")
@EqualsAndHashCode(of = {"id"})
@ToString
public class Account implements Serializable {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column(value = "uname")
    private String username;

    @Column(value = "name")
    private String name;

    @Column(value = "surname")
    private String surname;

    @Column(value = "email")
    private String email;

    @Column(value = "birth_date")
    private Date birthDate;

    @Column(value = "pwd")
    private String passwd;

    @Column(value = "created_at")
    @CreatedDate
    private Date createdAt;

    @Column(value = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @Column(value = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(value = "modified_by")
    @LastModifiedBy
    private String modifiedBy;

    @Column(value = "is_active")
    private boolean active = true;
}
