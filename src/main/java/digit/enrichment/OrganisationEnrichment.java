package digit.enrichment;

import digit.web.models.AllOfOrganisationAuditDetails;
import digit.web.models.OrgRequest;
import digit.web.models.Organisation;
import org.egov.common.contract.models.AuditDetails;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class OrganisationEnrichment {
    public static void enrichOrganisation(OrgRequest organisation){

        organisation.getOrganisations().setId(UUID.fromString(UUID.randomUUID().toString()));

        for(int i=0;i<organisation.getOrganisations().getOrgAddress().size();i++) {
            organisation.getOrganisations().getOrgAddress().get(i).setId(String.valueOf(UUID.randomUUID()));
            organisation.getOrganisations().getOrgAddress().get(i).setOrgId(String.valueOf(organisation.getOrganisations().getId()));
        }
        for(int i=0;i<organisation.getOrganisations().getContactDetails().size();i++) {
            organisation.getOrganisations().getContactDetails().get(i).setId(UUID.randomUUID().toString());
            organisation.getOrganisations().getContactDetails().get(i).setOrgId(String.valueOf(organisation.getOrganisations().getId()));
        }

        for(int i=0;i<organisation.getOrganisations().getIdentifiers().size();i++) {
            organisation.getOrganisations().getIdentifiers().get(i).setId(UUID.randomUUID().toString());
            organisation.getOrganisations().getIdentifiers().get(i).setOrgId(String.valueOf(organisation.getOrganisations().getId()));
        }

        for(int i=0;i<organisation.getOrganisations().getFunctions().size();i++) {
            organisation.getOrganisations().getFunctions().get(i).setId(UUID.randomUUID().toString());
            organisation.getOrganisations().getFunctions().get(i).setOrgId(String.valueOf(organisation.getOrganisations().getId()));
           for(int j=0;j<organisation.getOrganisations().getFunctions().get(i).getDocuments().size();j++){
               organisation.getOrganisations().getFunctions().get(i).getDocuments().get(j).setDocumentUid(UUID.randomUUID().toString());
               organisation.getOrganisations().getFunctions().get(i).getDocuments().get(j).setOrgId(String.valueOf(organisation.getOrganisations().getId()));
               organisation.getOrganisations().getFunctions().get(i).getDocuments().get(j).setOrgFunctionId(organisation.getOrganisations().getFunctions().get(i).getId());

           }
        }

       for(int i=0;i<organisation.getOrganisations().getJurisdiction().size();i++) {
           organisation.getOrganisations().getJurisdiction().get(i).setId(UUID.randomUUID().toString());
           organisation.getOrganisations().getJurisdiction().get(i).setOrgId(String.valueOf(organisation.getOrganisations().getId()));
       }
        AuditDetails auditDetails = AuditDetails.builder().createdBy(organisation.getRequestInfo().getUserInfo().getUuid()).createdTime(System.currentTimeMillis()).lastModifiedBy(organisation.getRequestInfo().getUserInfo().getUuid()).lastModifiedTime(System.currentTimeMillis()).build();
        organisation.getOrganisations().setAuditDetails(auditDetails);
        return ;
    }
}
