package com.waracle.cakemanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Cake", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
@EntityListeners(AuditingEntityListener.class)
@Data
public class CakeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer cakeId;

    @Column(name = "TITLE", nullable = false, length = 100)
    @JsonProperty("title")
    private String title;

    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    @JsonProperty("desc")
    private String description;

    @Column(name = "IMAGE_URL", nullable = false, length = 300)
    @JsonProperty("image")
    private String image;


}