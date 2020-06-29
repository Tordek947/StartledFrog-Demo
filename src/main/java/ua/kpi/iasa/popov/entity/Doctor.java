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
import java.util.Set;
import javax.persistence.CascadeType;
import lombok.ToString;
import javax.persistence.OneToMany;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "doctor")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    private Long pk;

    @Column(name = "user_uid", nullable = false, unique = true)
    private String userUid;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "main_specialization", nullable = false)
    private String mainSpecialization;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @RestResource(exported = false)
    @OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "creator")
    private Set<MedicalCard> createdMedicalCards;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @RestResource(exported = false)
    @OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "entryCreator")
    private Set<MedicalCardEntry> createdEntries;
}
