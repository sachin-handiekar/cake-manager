package com.waracle.cakemanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Cake", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
@EntityListeners(AuditingEntityListener.class)
public class CakeEntity implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCakeId() {
        return cakeId;
    }

    @Override
    public String toString() {
        return "CakeEntity{" +
                "cakeId=" + cakeId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}