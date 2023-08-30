package respository;

import entity.QuotationEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuotationRespository implements PanacheRepository<QuotationEntity> {

}
