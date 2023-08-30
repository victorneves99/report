package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat.Builder;

import dto.OpportunityDTO;

public class CSVHelper {

  public static ByteArrayInputStream opportunittiesToCSV(List<OpportunityDTO> opportunities) {

    Builder bilder = CSVFormat.Builder.create();
    CSVFormat format = bilder.setHeader("Id Proposta", "Cliente", "Preço por Tonelada", "Melhor cotação de Moeda")
        .build();

    try {

      ByteArrayOutputStream out = new ByteArrayOutputStream();

      CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);

      for (OpportunityDTO opportunityDTO : opportunities) {

        List<String> data = Arrays.asList(String.valueOf(opportunityDTO.getProposalId()), opportunityDTO.getCustomer(),
            String.valueOf(opportunityDTO.getPriceTonne()), String.valueOf(opportunityDTO.getLastDollarQuotation()));

        csvPrinter.printRecord(data);

      }

      csvPrinter.flush();
      // csvPrinter.close();

      return new ByteArrayInputStream(out.toByteArray());

    } catch (IOException e) {

      throw new RuntimeException("Fail to import data to CSV file :" + e.getMessage());

    }

  }
}
