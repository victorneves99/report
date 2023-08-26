package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "opportunity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpportunityEntity {

  @Id
  @GeneratedValue
  private Long id;

  private LocalDateTime date;

  @Column(name = "proposal_id")
  private Long proposalId;

  private String customer;

  @Column(name = "price_tonne")
  private BigDecimal priceTonne;

  @Column(name = "last_currency_quotation")
  private BigDecimal lastDollarQuotation;

}
