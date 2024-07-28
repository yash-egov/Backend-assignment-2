package digit.repository.rowmapper;

import digit.web.models.*;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class OrganisationRowMapper implements ResultSetExtractor<List<Organisation>> {

    @Override
    public List<Organisation> extractData(ResultSet rs) throws SQLException {
        Map<UUID, Organisation> organisationMap = new LinkedHashMap<>();

        while (rs.next()) {
            UUID orgId = UUID.fromString(rs.getString("oid"));

            Organisation organisation = organisationMap.computeIfAbsent(orgId, id -> {
                Organisation org = new Organisation();
                org.setId(id);
                try {
                    org.setTenantId(rs.getString("otenantid"));
                    org.setApplicationNumber(rs.getString("oapplicationnumber"));
                    org.setName(rs.getString("oname"));
                }catch (Exception e){
                    System.out.println("error "+e);
                }
                org.setOrgAddress(new ArrayList<>());
                org.setContactDetails(new ArrayList<>());
                org.setIdentifiers(new ArrayList<>());
                org.setJurisdiction(new ArrayList<>());
                org.setFunctions(new ArrayList<>());
                org.setDocuments(new ArrayList<>());
                return org;
            });

            // Handle Address
            String addressId = rs.getString("aid");
            if (addressId != null) {
                Address address = new Address();
                address.setId(addressId);
                address.setTenantId(rs.getString("atenantid"));
                address.setAddressLine1(rs.getString("aaddressline1"));
                address.setAddressLine2(rs.getString("aaddressline2"));
                address.setCity(rs.getString("acity"));
                address.setPincode(rs.getString("apincode"));
                address.setOrgId(rs.getString("aorgid"));
                address.setDoorNo(rs.getString("adoorno"));
                address.setLandmark(rs.getString("alandmark"));
                address.setBuildingName(rs.getString("abuildingname"));
                address.setLatitude(rs.getDouble("alatitude"));
                address.setLongitude(rs.getDouble("alongitude"));
                address.setStreet(rs.getString("astreet"));
                address.setDetail(rs.getString("adetail"));
                address.setBoundaryType(rs.getString("aboundarytype"));

                if (organisation.getOrgAddress().stream().noneMatch(a -> a.getId().equals(addressId))) {
                    organisation.getOrgAddress().add(address);
                }
            }

            // Handle Contact Details
            String contactId = rs.getString("cid");
            if (contactId != null) {
                ContactDetails contactDetails = new ContactDetails();
                contactDetails.setId(contactId);
                contactDetails.setContactName(rs.getString("cname"));
                contactDetails.setContactMobileNumber(rs.getString("cmobno"));
                contactDetails.setContactEmail(rs.getString("cemail"));

                if (organisation.getContactDetails().stream().noneMatch(c -> c.getId().equals(contactId))) {
                    organisation.getContactDetails().add(contactDetails);
                }
            }

            // Handle Identifier
            String identifierId = rs.getString("idfid");
            if (identifierId != null) {
                Identifier identifier = new Identifier();
                identifier.setId(identifierId);
                identifier.setType(rs.getString("idftype"));
                identifier.setValue(rs.getString("idfvalue"));
                identifier.setIsActive(rs.getBoolean("idfisactive"));
                identifier.setAdditionalDetails(rs.getObject("idfadditionaldetails"));

                if (organisation.getIdentifiers().stream().noneMatch(i -> i.getId().equals(identifierId))) {
                    organisation.getIdentifiers().add(identifier);
                }
            }

            // Handle Jurisdiction
            String jurisdictionId = rs.getString("jrdid");
            if (jurisdictionId != null) {
                Jurisdiction jurisdiction = new Jurisdiction();
                jurisdiction.setId(jurisdictionId);
                jurisdiction.setOrgId(rs.getString("jrdorgid"));
                jurisdiction.setCode(rs.getString("jrdcode"));
                jurisdiction.setJurisdictionId(rs.getString("jrdjurisdictionid"));
                jurisdiction.setAdditionalDetails(rs.getObject("jrdadditionaldetails"));

                if (organisation.getJurisdiction().stream().noneMatch(j -> j.getId().equals(jurisdictionId))) {
                    organisation.getJurisdiction().add(jurisdiction);
                }
            }

            // Handle Function
            String functionId = rs.getString("fnid");
            if (functionId != null) {
                Function function = organisation.getFunctions().stream()
                        .filter(f -> f.getId().equals(functionId))
                        .findFirst()
                        .orElseGet(() -> {
                            Function fn = new Function();
                            try {
                                fn.setId(functionId);
                                fn.setOrgId(rs.getString("fnorgid"));
                                fn.setType(rs.getString("fntype"));
                                fn.setCategory(rs.getString("fncategory"));
                                fn.setPropertyClass(rs.getString("fnclass"));
                                fn.setIsActive(rs.getBoolean("fnisactive"));
                                fn.setValidFrom(rs.getBigDecimal("fnvalidfrom"));
                                fn.setValidTo(rs.getBigDecimal("fnvalidto"));
                                fn.setAdditionalDetails(rs.getObject("fnadditionaldetails"));
                            }catch (Exception e){
                                System.out.println("erorr "+e);
                            }
                            fn.setDocuments(new ArrayList<>());
                            organisation.getFunctions().add(fn);
                            return fn;
                        });

                // Handle Documents for Function
                String documentId = rs.getString("docid");
                String documentFnId = rs.getString("docorgfnid");
                if (documentId != null && documentFnId != null && functionId.equals(documentFnId)) {
                    Document document = new Document();
                    document.setId(documentId);
                    document.setOrgId(rs.getString("docorgid"));
                    document.setOrgFunctionId(rs.getString("docorgfnid"));
                    document.setDocumentType(rs.getString("docdoctype"));
                    document.setFileStore(rs.getString("docfilestore"));
                    document.setDocumentUid(rs.getString("docdocuid"));
                    document.setAdditionalDetails(rs.getObject("docadditionaldetails"));

                    if (function.getDocuments().stream().noneMatch(d -> d.getId().equals(documentId))) {
                        function.getDocuments().add(document);
                    }
                }
            }

            // Handle Organisation Documents
            String documentId1 = rs.getString("docid");
            if (documentId1 != null && rs.getString("docorgfnid") == null) {
                Document document = new Document();
                document.setId(documentId1);
                document.setOrgId(rs.getString("docorgid"));
                document.setDocumentType(rs.getString("docdoctype"));
                document.setFileStore(rs.getString("docfilestore"));
                document.setDocumentUid(rs.getString("docdocuid"));
                document.setAdditionalDetails(rs.getObject("docadditionaldetails"));

                if (organisation.getDocuments().stream().noneMatch(d -> d.getId().equals(documentId1))) {
                    organisation.getDocuments().add(document);
                }
            }
        }

        return new ArrayList<>(organisationMap.values());
    }
}
