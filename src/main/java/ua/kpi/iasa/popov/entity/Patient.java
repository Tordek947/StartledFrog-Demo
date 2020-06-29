package ua.kpi.iasa.popov.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.FetchType;
import org.springframework.data.rest.core.annotation.RestResource;
import lombok.EqualsAndHashCode;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import lombok.ToString;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    private Long pk;

    @Column(name = "user_uid", nullable = false, unique = true)
    private String userUid;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @RestResource(exported = false)
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = true, mappedBy = "patient")
    private MedicalCard medicalCard;
}
