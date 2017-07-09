package net.keepers.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contacts")
public class Contact extends AbstractModel {
    @Column(name = "phone")
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Type type;
    @Column(name = "comment")
    private String comment;
}
