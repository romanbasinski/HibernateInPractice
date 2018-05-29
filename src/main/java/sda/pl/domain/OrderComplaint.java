package sda.pl.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String message;

    @Enumerated(value = EnumType.STRING)
    ComplaintStatus complaintStatus;

    @ManyToMany(mappedBy = "orderComplaintSet", cascade = CascadeType.ALL)
    // relacja wiele do wielu
    Set<Order> orderSet;

}
