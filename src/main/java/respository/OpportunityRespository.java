package respository;

import entity.OpportunityEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OpportunityRespository implements PanacheRepository<OpportunityEntity> {

}
