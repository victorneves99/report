package message;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.ProposalDTO;
import dto.QuotationDto;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import service.OpportunityService;

public class KefkaEvent {

  private final Logger LOG = LoggerFactory.getLogger(KefkaEvent.class);

  @Inject
  OpportunityService opportunityService;

  @Incoming("proposal")
  @Transactional
  public void receiveProposal(ProposalDTO proposalDTO) {

    LOG.info("--Recebendo nova proposta do topico kafka --");
    opportunityService.buildOpportunnity(proposalDTO);

  }

  @Incoming("quotation")
  @Blocking
  public void receiveQuotation(QuotationDto quotationDto) {

    LOG.info("-- Recebendo nova cotacao de moeda do topico kafka --");
    opportunityService.saveQuotation(quotationDto);

  }

}
