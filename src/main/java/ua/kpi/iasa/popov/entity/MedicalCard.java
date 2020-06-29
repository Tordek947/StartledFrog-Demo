package ua.kpi.iasa.popov.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.springframework.data.rest.core.annotation.RestResource;
import lombok.EqualsAndHashCode;
import java.util.Set;
import lombok.ToString;
import javax.persistence.OneToMany;

import ua.cmathtutor.startledfrog.entity.Containable;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "medical_card")
@Data
public class MedicalCard implements Containable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    private Long pk;
    
    @Column(name = "creation_year", nullable = false)
    private Integer creationYear;
    
    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "creator_doctor_PK")
    private Doctor creator;
    
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_PK", nullable = false, unique = true)
    private Patient patient;
    
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @RestResource(exported = false)
    @OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "medicalCard")
    private Set<MedicalCardEntry> entries;

    @JsonIgnore
    @Override
    public Object getContainer() {
        return getCreator();
    }
}
