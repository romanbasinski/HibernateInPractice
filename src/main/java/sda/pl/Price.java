package sda.pl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Data
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    BigDecimal priceGross;
    BigDecimal priceNet;
    String priceSymbol;

    @Transient //nieuwzględnia przy dodawaniu do bazy danych
    BigDecimal vat;


}
