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

import ua.cmathtutor.startledfrog.entity.Containable;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "health_index")
@Data
public class HealthIndex implements Containable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    private Long pk;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "value", nullable = false)
    private String value;
    
    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medical_card_entry_PK", nullable = false)
    private MedicalCardEntry medicalCardEntry;

    @JsonIgnore
    @Override
    public Object getContainer() {
        return getMedicalCardEntry();
    }
}
