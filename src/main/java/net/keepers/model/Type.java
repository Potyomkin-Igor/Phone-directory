package net.keepers.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "types")
public class Type extends AbstractModel{
    @Column(name = "name")
    private String name;
}
