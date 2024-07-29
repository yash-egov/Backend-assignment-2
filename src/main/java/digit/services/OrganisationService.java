package digit.services;

import digit.config.Configuration;
import digit.enrichment.OrganisationEnrichment;
import digit.kafka.Producer;
import digit.repository.ServiceRequestRepository;
import digit.web.models.OrgRequest;
import digit.web.models.OrgSearchCriteria;
import digit.web.models.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganisationService {


    private Producer producer;


    private ServiceRequestRepository serviceRequestRepository;


    private Configuration config;

    public OrganisationService(Producer producer, ServiceRequestRepository serviceRequestRepository, Configuration config) {
        this.producer = producer;
        this.serviceRequestRepository = serviceRequestRepository;
        this.config = config;
    }

    public Organisation registerOrganisation(OrgRequest body) {
        OrganisationEnrichment.enrichOrganisation(body);
        System.out.println(config.getKafkaCreateTopic());
        producer.push(config.getKafkaCreateTopic(), body);
        return body.getOrganisations();
    }

    public List<Organisation> searchOrganisations(OrgSearchCriteria body) {
        List<Organisation> organisations = serviceRequestRepository.getOrganisations(body);
        return organisations;
    }

}
