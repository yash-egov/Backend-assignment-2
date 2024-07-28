//package digit.repository.rowmapper;
//
//import digit.web.models.*;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.*;
//
//@Component
//public class OrganisationRowMapper implements RowMapper<Organisation> {
//
//    @Override
//    public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Organisation organisation = new Organisation();
//        // Use maps to store unique entities by their IDs
//        Map<String, Address> addressMap = new HashMap<>();
//        Map<String, ContactDetails> contactDetailsMap = new HashMap<>();
//        Map<String, Identifier> identifierMap = new HashMap<>();
//        Map<String, Jurisdiction> jurisdictionMap = new HashMap<>();
//        Map<String, Function> functionMap = new HashMap<>();
//        Map<String, Document> documentFnMap = new HashMap<>();
//        Map<String, Document> documentMap = new HashMap<>();
//
//        // Initialize a flag to identify when the organisation object is being populated
//        boolean isFirstRow = true;
//
//        do {
//            if (isFirstRow) {
//                // Populate the main organisation fields only once
//                organisation.setId(UUID.fromString(rs.getString("oid")));
//                organisation.setTenantId(rs.getString("otenantid"));
//                organisation.setApplicationNumber(rs.getString("oapplicationnumber"));
//                organisation.setName(rs.getString("oname"));
//                isFirstRow = false;
//            }
//
//            // Handle Address
//            String addressId = rs.getString("aid");
//            if (addressId != null) {
//                Address address = addressMap.computeIfAbsent(addressId, id -> {
//                    Address addr = new Address();
//                    addr.setId(id);
//
//                    try {
//                        addr.setTenantId(rs.getString("atenantid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setAddressLine1(rs.getString("aaddressline1"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setAddressLine2(rs.getString("aaddressline2"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setCity(rs.getString("acity"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setPincode(rs.getString("apincode"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setOrgId(rs.getString("aorgid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setDoorNo(rs.getString("adoorno"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setLandmark(rs.getString("alandmark"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setBuildingName(rs.getString("abuildingname"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setLatitude(rs.getDouble("alatitude"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setLongitude(rs.getDouble("alongitude"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setStreet(rs.getString("astreet"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setDetail(rs.getString("adetail"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        addr.setBoundaryType(rs.getString("aboundarytype"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return addr;
//                });
//            }
//
//            // Handle Contact Details
//            String contactId = rs.getString("cid");
//            if (contactId != null) {
//                ContactDetails contactDetails = contactDetailsMap.computeIfAbsent(contactId, id -> {
//                    ContactDetails contact = new ContactDetails();
//                    contact.setId(id);
//
//                    try {
//                        contact.setContactName(rs.getString("cname"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        contact.setContactMobileNumber(rs.getString("cmobno"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        contact.setContactEmail(rs.getString("cemail"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return contact;
//                });
//            }
//
//            // Handle Identifier
//            String identifierId = rs.getString("idfid");
//            if (identifierId != null) {
//                Identifier identifier = identifierMap.computeIfAbsent(identifierId, id -> {
//                    Identifier idf = new Identifier();
//                    idf.setId(id);
//                    try {
//                        idf.setType(rs.getString("idftype"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        idf.setValue(rs.getString("idfvalue"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        idf.setIsActive(rs.getBoolean("idfisactive"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        idf.setAdditionalDetails(rs.getObject("idfadditionaldetails"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return idf;
//                });
//            }
//
//            // Handle Jurisdiction
//            String jurisdictionId = rs.getString("jrdid");
//            if (jurisdictionId != null) {
//                Jurisdiction jurisdiction = jurisdictionMap.computeIfAbsent(jurisdictionId, id -> {
//                    Jurisdiction jrd = new Jurisdiction();
//                    jrd.setId(id);
//                    try {
//                        jrd.setOrgId(rs.getString("jrdorgid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        jrd.setCode(rs.getString("jrdcode"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        jrd.setJurisdictionId(rs.getString("jrdjurisdictionid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        jrd.setAdditionalDetails(rs.getObject("jrdadditionaldetails"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return jrd;
//                });
//            }
//
//            // Handle Function
//            String functionId = rs.getString("fnid");
//            if (functionId != null) {
//                Function function = functionMap.computeIfAbsent(functionId, id -> {
//                    Function fn = new Function();
//                    fn.setId(id);
//                    try {
//                        fn.setOrgId(rs.getString("fnorgid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        fn.setType(rs.getString("fntype"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        fn.setCategory(rs.getString("fncategory"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        fn.setPropertyClass(rs.getString("fnclass"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        fn.setIsActive(rs.getBoolean("fnisactive"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        fn.setValidFrom(rs.getBigDecimal("fnvalidfrom"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        fn.setValidTo(rs.getBigDecimal("fnvalidto"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        fn.setAdditionalDetails(rs.getObject("fnadditionaldetails"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return fn;
//                });
//            }
//
//            // Handle function documents
//            String documentId = rs.getString("docid");
//            String documentFnId=rs.getString("docorgfnid");
//            if (documentId != null && documentFnId!=null) {
//                Document document = documentFnMap.computeIfAbsent(documentId, id -> {
//                    Document doc = new Document();
//                    doc.setId(id);
//                    try {
//                        doc.setOrgId(rs.getString("docorgid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        doc.setOrgFunctionId(rs.getString("docorgfnid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        doc.setDocumentType(rs.getString("docdoctype"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        doc.setFileStore(rs.getString("docfilestore"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        doc.setDocumentUid(rs.getString("docdocuid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        doc.setAdditionalDetails(rs.getObject("docadditionaldetails"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return doc;
//                });
//            }
//
//            // Handle Organisation Documents
//            String documentId1 = rs.getString("docid");
//            String documentFnId1=rs.getString("docorgfnid");
//            if (documentId1 != null && documentFnId1==null) {
//                Document document = documentMap.computeIfAbsent(documentId, id -> {
//                    Document doc = new Document();
//                    doc.setId(id);
//                    try {
//                        doc.setOrgId(rs.getString("docorgid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
////                    try {
////                        doc.setOrgFunctionId(rs.getString("docorgfnid"));
////                    } catch (SQLException e) {
////                        throw new RuntimeException(e);
////                    }
//                    try {
//                        doc.setDocumentType(rs.getString("docdoctype"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        doc.setFileStore(rs.getString("docfilestore"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        doc.setDocumentUid(rs.getString("docdocuid"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        doc.setAdditionalDetails(rs.getObject("docadditionaldetails"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return doc;
//                });
//            }
//
//        } while (rs.next());
//
//        // Set lists from the accumulated maps
//        organisation.setOrgAddress(new ArrayList<>(addressMap.values()));
//        organisation.setContactDetails(new ArrayList<>(contactDetailsMap.values()));
//        organisation.setIdentifiers(new ArrayList<>(identifierMap.values()));
//        organisation.setJurisdiction(new ArrayList<>(jurisdictionMap.values()));
//        organisation.setFunctions(new ArrayList<>(functionMap.values()));
//
//        organisation.setDocuments(new ArrayList<>(documentMap.values()));
//
//        return organisation;
//    }
//}

package digit.repository.rowmapper;

import digit.web.models.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class OrganisationRowMapper implements RowMapper<Organisation> {

    @Override
    public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Organisation organisation = new Organisation();
        // Use maps to store unique entities by their IDs
        Map<String, Address> addressMap = new HashMap<>();
        Map<String, ContactDetails> contactDetailsMap = new HashMap<>();
        Map<String, Identifier> identifierMap = new HashMap<>();
        Map<String, Jurisdiction> jurisdictionMap = new HashMap<>();
        Map<String, Function> functionMap = new HashMap<>();
        Map<String, List<Document>> functionDocumentsMap = new HashMap<>();
        Map<String, Document> documentMap = new HashMap<>();

        // Initialize a flag to identify when the organisation object is being populated
        boolean isFirstRow = true;

        do {
            if (isFirstRow) {
                // Populate the main organisation fields only once
                organisation.setId(UUID.fromString(rs.getString("oid")));
                organisation.setTenantId(rs.getString("otenantid"));
                organisation.setApplicationNumber(rs.getString("oapplicationnumber"));
                organisation.setName(rs.getString("oname"));
                isFirstRow = false;
            }

            // Handle Address
            String addressId = rs.getString("aid");
            if (addressId != null) {
                addressMap.computeIfAbsent(addressId, id -> {
                    Address addr = new Address();
                    addr.setId(id);
                    try {
                        addr.setTenantId(rs.getString("atenantid"));
                        addr.setAddressLine1(rs.getString("aaddressline1"));
                        addr.setAddressLine2(rs.getString("aaddressline2"));
                        addr.setCity(rs.getString("acity"));
                        addr.setPincode(rs.getString("apincode"));
                        addr.setOrgId(rs.getString("aorgid"));
                        addr.setDoorNo(rs.getString("adoorno"));
                        addr.setLandmark(rs.getString("alandmark"));
                        addr.setBuildingName(rs.getString("abuildingname"));
                        addr.setLatitude(rs.getDouble("alatitude"));
                        addr.setLongitude(rs.getDouble("alongitude"));
                        addr.setStreet(rs.getString("astreet"));
                        addr.setDetail(rs.getString("adetail"));
                        addr.setBoundaryType(rs.getString("aboundarytype"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return addr;
                });
            }

            // Handle Contact Details
            String contactId = rs.getString("cid");
            if (contactId != null) {
                contactDetailsMap.computeIfAbsent(contactId, id -> {
                    ContactDetails contact = new ContactDetails();
                    contact.setId(id);
                    try {
                        contact.setContactName(rs.getString("cname"));
                        contact.setContactMobileNumber(rs.getString("cmobno"));
                        contact.setContactEmail(rs.getString("cemail"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return contact;
                });
            }

            // Handle Identifier
            String identifierId = rs.getString("idfid");
            if (identifierId != null) {
                identifierMap.computeIfAbsent(identifierId, id -> {
                    Identifier idf = new Identifier();
                    idf.setId(id);
                    try {
                        idf.setType(rs.getString("idftype"));
                        idf.setValue(rs.getString("idfvalue"));
                        idf.setIsActive(rs.getBoolean("idfisactive"));
                        idf.setAdditionalDetails(rs.getObject("idfadditionaldetails"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return idf;
                });
            }

            // Handle Jurisdiction
            String jurisdictionId = rs.getString("jrdid");
            if (jurisdictionId != null) {
                jurisdictionMap.computeIfAbsent(jurisdictionId, id -> {
                    Jurisdiction jrd = new Jurisdiction();
                    jrd.setId(id);
                    try {
                        jrd.setOrgId(rs.getString("jrdorgid"));
                        jrd.setCode(rs.getString("jrdcode"));
                        jrd.setJurisdictionId(rs.getString("jrdjurisdictionid"));
                        jrd.setAdditionalDetails(rs.getObject("jrdadditionaldetails"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return jrd;
                });
            }

            // Handle Function
            String functionId = rs.getString("fnid");
            if (functionId != null) {
                Function function = functionMap.computeIfAbsent(functionId, id -> {
                    Function fn = new Function();
                    fn.setId(id);
                    try {
                        fn.setOrgId(rs.getString("fnorgid"));
                        fn.setType(rs.getString("fntype"));
                        fn.setCategory(rs.getString("fncategory"));
                        fn.setPropertyClass(rs.getString("fnclass"));
                        fn.setIsActive(rs.getBoolean("fnisactive"));
                        fn.setValidFrom(rs.getBigDecimal("fnvalidfrom"));
                        fn.setValidTo(rs.getBigDecimal("fnvalidto"));
                        fn.setAdditionalDetails(rs.getObject("fnadditionaldetails"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return fn;
                });

                // Handle Documents for Function
                String documentId = rs.getString("docid");
                String documentFnId= rs.getString("docorgfnid");
                if (documentId != null  &&  documentFnId!=null && functionId.equals(documentFnId)) {
                    Document document = functionDocumentsMap
                            .computeIfAbsent(functionId, k -> new ArrayList<>())
                            .stream()
                            .filter(doc -> documentId.equals(doc.getId()))
                            .findAny()
                            .orElseGet(() -> {
                                Document doc = new Document();
                                doc.setId(documentId);
                                try {
                                    doc.setOrgId(rs.getString("docorgid"));
                                    doc.setOrgFunctionId(rs.getString("docorgfnid"));
                                    doc.setDocumentType(rs.getString("docdoctype"));
                                    doc.setFileStore(rs.getString("docfilestore"));
                                    doc.setDocumentUid(rs.getString("docdocuid"));
                                    doc.setAdditionalDetails(rs.getObject("docadditionaldetails"));
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                functionDocumentsMap.get(functionId).add(doc);
                                return doc;
                            });
                }
            }

            // Handle Organisation Documents
            String documentId1 = rs.getString("docid");
            if (documentId1 != null && rs.getString("docorgfnid") == null) {
                documentMap.computeIfAbsent(documentId1, id -> {
                    Document doc = new Document();
                    doc.setId(id);
                    try {
                        doc.setOrgId(rs.getString("docorgid"));
                        doc.setDocumentType(rs.getString("docdoctype"));
                        doc.setFileStore(rs.getString("docfilestore"));
                        doc.setDocumentUid(rs.getString("docdocuid"));
                        doc.setAdditionalDetails(rs.getObject("docadditionaldetails"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return doc;
                });
            }

        } while (rs.next());

        // Set lists from the accumulated maps
        organisation.setOrgAddress(new ArrayList<>(addressMap.values()));
        organisation.setContactDetails(new ArrayList<>(contactDetailsMap.values()));
        organisation.setIdentifiers(new ArrayList<>(identifierMap.values()));
        organisation.setJurisdiction(new ArrayList<>(jurisdictionMap.values()));

        // Add functions and their documents
        List<Function> functions = new ArrayList<>(functionMap.values());
        for (Function function : functions) {
            function.setDocuments(functionDocumentsMap.getOrDefault(function.getId(), Collections.emptyList()));
        }
        organisation.setFunctions(functions);

        organisation.setDocuments(new ArrayList<>(documentMap.values()));

        return organisation;
    }
}

