package com.example.shop.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Revenue extends EntittyId {
    @ManyToOne
    @JoinColumn(name="IdLocation")
    private Location location;
    private LocalDate datee;
    private BigDecimal suma;

    public Revenue(Location loc){
        this.location = loc;
    }

}
