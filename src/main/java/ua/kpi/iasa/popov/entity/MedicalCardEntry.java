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
import org.springframework.data.rest.core.annotation.RestResource;
import lombok.EqualsAndHashCode;
import java.util.Set;
import lombok.ToString;
import javax.persistence.OneToMany;

import ua.cmathtutor.startledfrog.entity.Containable;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "medical_card_entry")
@Data
public class MedicalCardEntry implements Containable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    private Long pk;
    
    @Column(name = "date", nullable = false)
    private String date;
    
    @Column(name = "message")
    private String message;
    
    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entry_creator_doctor_PK", nullable = false)
    private Doctor entryCreator;
    
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @RestResource(exported = false)
    @OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "medicalCardEntry")
    private Set<HealthIndex> healthIndices;
    
    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medical_card_PK", nullable = false)
    private MedicalCard medicalCard;

    @JsonIgnore
    @Override
    public Object getContainer() {
        return getMedicalCard();
    }
}
