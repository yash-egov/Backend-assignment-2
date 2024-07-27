package digit.services;

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

    @Autowired
    private OrganisationEnrichment enrichmentUtil;

    @Autowired
    private Producer producer;

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    public Organisation registerOrganisation(OrgRequest body) {
        OrganisationEnrichment.enrichOrganisation(body);
        producer.push("save-org-application", body);
        return body.getOrganisations();
    }

    public  List<Organisation> searchOrganisations(OrgSearchCriteria body) {
        System.out.println("inside Organisation Service");
        List<Organisation> organisations = serviceRequestRepository.getOrganisations(body);
        return organisations;
    }

}
