package net.keepers.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contacts")
public class Contact extends AbstractModel {
    @Column(name = "phone")
    private String phoneNumber;
    @Column(name = "type")
    private String type;
    @Column(name = "comment")
    private String comment;
}