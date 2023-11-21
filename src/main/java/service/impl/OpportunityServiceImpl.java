package service.impl;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dto.OpportunityDTO;
import dto.ProposalDTO;
import dto.QuotationDto;
import entity.OpportunityEntity;
import entity.QuotationEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import respository.OpportunityRespository;
import respository.QuotationRespository;
import service.OpportunityService;

@ApplicationScoped

public class OpportunityServiceImpl implements OpportunityService {

  @Inject
  QuotationRespository quotationRespository;

  @Inject
  OpportunityRespository opportunityRespository;

  @Override
  public void buildOpportunnity(ProposalDTO proposalDTO) {

    // [0,1,2,3,4] reverse [4,3,2,1,0]
    List<QuotationEntity> quotationEntities = quotationRespository.findAll().list().stream()
        .sorted(Collections.reverseOrder())
        .toList();

    opportunityRespository.persist(OpportunityEntity.builder()
        .date(LocalDateTime.now())
        .proposalId(proposalDTO.getProposalId())
        .customer(proposalDTO.getCustomer())
        .priceTonne(proposalDTO.getPriceTonne())
        .lastDollarQuotation(quotationEntities.get(0).getCurrenyPrice())
        .build());

  }

  @Override
  @Transactional
  public void saveQuotation(QuotationDto quotationDto) {

    quotationRespository.persist(QuotationEntity.builder()
        .date(LocalDateTime.now())
        .currenyPrice(quotationDto.getCurrencyPrice())
        .build());

  }

  @Override
  public List<OpportunityDTO> generateOpportunityData() {

    List<OpportunityDTO> opportunities = new ArrayList<>();

    opportunityRespository.findAll().stream().forEach(item -> {

      opportunities.add(OpportunityDTO.builder()
          .proposalId(item.getProposalId())
          .customer(item.getCustomer())
          .priceTonne(item.getPriceTonne())
          .lastDollarQuotation(item.getLastDollarQuotation())
          .build());

    });

    return opportunities;

  }

}
