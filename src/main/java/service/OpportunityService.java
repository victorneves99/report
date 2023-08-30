package service;

import java.io.ByteArrayInputStream;
import java.util.List;

import dto.OpportunityDTO;
import dto.ProposalDTO;
import dto.QuotationDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface OpportunityService {

  void buildOpportunnity(ProposalDTO proposalDTO);

  void saveQuotation(QuotationDto quotationDto);

  List<OpportunityDTO> generateOpportunityData();

  ByteArrayInputStream genereteCSVOpportunityResport();

}
