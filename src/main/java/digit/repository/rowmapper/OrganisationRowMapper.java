//package digit.repository.rowmapper;
//
//import digit.web.models.*;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.UUID;
//
//@Component
//public class OrganisationRowMapper implements RowMapper<Organisation> {
//
//    @Override
//    public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Organisation organisation = new Organisation();
//        organisation.setId(UUID.fromString(rs.getString("oid")));
//        organisation.setTenantId(rs.getString("otenantid"));
//        organisation.setApplicationNumber(rs.getString("oapplicationnumber"));
//        organisation.setName(rs.getString("oname"));
//
//        Address address = new Address();
//        address.setId(rs.getString("aid"));
//        address.setTenantId(rs.getString("atenantid"));
////        address.setType(rs.getString("atype"));
//        address.setAddressLine1(rs.getString("aaddressline1"));
//        address.setAddressLine2(rs.getString("aaddressline2"));
//        address.setCity(rs.getString("acity"));
//        address.setPincode(rs.getString("apincode"));
//        address.setOrgId(rs.getString("aorgid"));
//        address.setDoorNo(rs.getString("adoorno"));
//        address.setLandmark(rs.getString("alandmark"));
//        address.setBuildingName(rs.getString("abuildingname"));
//        address.setLatitude(rs.getDouble("alatitude"));
//        address.setLongitude(rs.getDouble("alongitude"));
//        address.setStreet(rs.getString("astreet"));
//        address.setDetail(rs.getString("adetail"));
//        address.setBoundaryType(rs.getString("aboundarytype"));
//
//
//       List<Address>alladdresses = List.of(address);
////       alladdresses.add(address);
//        organisation.setOrgAddress(alladdresses);
//
//
//        ContactDetails contactDetails = new ContactDetails();
//        contactDetails.setId(rs.getString("cid"));
//        contactDetails.setContactName(rs.getString("cname"));
//        contactDetails.setContactMobileNumber(rs.getString("cmobno"));
//        contactDetails.setContactEmail(rs.getString("cemail"));
//        List<ContactDetails>allContactDetails= List.of(contactDetails);
//        organisation.setContactDetails(allContactDetails);
//
//
//        Identifier identifier=new Identifier();
//        identifier.setId(rs.getString("idfid"));
//        identifier.setType(rs.getString("idftype"));
//        identifier.setValue(rs.getString("idfvalue"));
//        identifier.setIsActive(rs.getBoolean("idfisactive"));
//        identifier.setAdditionalDetails(rs.getObject("idfadditionaldetails"));
//        List<Identifier>allIdentifiers=List.of(identifier);
//        organisation.setIdentifiers(allIdentifiers);
//
//        Jurisdiction jurisdiction=new Jurisdiction();
//        jurisdiction.setId(rs.getString("jrdid"));
//        jurisdiction.setOrgId(rs.getString("jrdorgid"));
//        jurisdiction.setCode(rs.getString("jrdcode"));
//        jurisdiction.setJurisdictionId(rs.getString("jrdjurisdictionid"));
//        jurisdiction.setAdditionalDetails(rs.getObject("jrdadditionaldetails"));
//        List<Jurisdiction>allJurisdiction=List.of(jurisdiction);
//        organisation.setJurisdiction(allJurisdiction);
//
//
//        Function function=new Function();
//        function.setId(rs.getString("fnid"));
//        function.setOrgId(rs.getString("fnorgid"));
//        function.setType(rs.getString("fntype"));
//        function.setCategory(rs.getString("fncategory"));
//        function.setPropertyClass(rs.getString("fnclass"));
//        function.setIsActive(rs.getBoolean("fnisactive"));
//        function.setValidFrom(rs.getBigDecimal("fnvalidfrom"));
//        function.setValidTo(rs.getBigDecimal("fnvalidto"));
////        function.setApplicationStatus(rs.getString("fnapplicationstatus"));
//        function.setAdditionalDetails(rs.getObject("fnadditionaldetails"));
//
//        List<Function>allFunctions=List.of(function);
//        organisation.setFunctions(allFunctions);
//
//        Document document=new Document();
//        document.setId(rs.getString("docid"));
//        document.setOrgId(rs.getString("docorgid"));
//        document.setOrgFunctionId(rs.getString("docorgfnid"));
//        document.setDocumentType(rs.getString("docdoctype"));
//        document.setFileStore(rs.getString("docfilestore"));
//        document.setDocumentUid(rs.getString("docdocuid"));
//        document.setAdditionalDetails(rs.getObject("docadditionaldetails"));
//
//        List<Document>allDocuments=List.of(document);
//        organisation.setDocuments(allDocuments);
//
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
                Address address = addressMap.computeIfAbsent(addressId, id -> {
                    Address addr = new Address();
                    addr.setId(id);

                    try {
                        addr.setTenantId(rs.getString("atenantid"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setAddressLine1(rs.getString("aaddressline1"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setAddressLine2(rs.getString("aaddressline2"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setCity(rs.getString("acity"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setPincode(rs.getString("apincode"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setOrgId(rs.getString("aorgid"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setDoorNo(rs.getString("adoorno"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setLandmark(rs.getString("alandmark"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setBuildingName(rs.getString("abuildingname"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setLatitude(rs.getDouble("alatitude"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setLongitude(rs.getDouble("alongitude"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setStreet(rs.getString("astreet"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        addr.setDetail(rs.getString("adetail"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
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
                ContactDetails contactDetails = contactDetailsMap.computeIfAbsent(contactId, id -> {
                    ContactDetails contact = new ContactDetails();
                    contact.setId(id);

                    try {
                        contact.setContactName(rs.getString("cname"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        contact.setContactMobileNumber(rs.getString("cmobno"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
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
                Identifier identifier = identifierMap.computeIfAbsent(identifierId, id -> {
                    Identifier idf = new Identifier();
                    idf.setId(id);
                    try {
                        idf.setType(rs.getString("idftype"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        idf.setValue(rs.getString("idfvalue"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        idf.setIsActive(rs.getBoolean("idfisactive"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
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
                Jurisdiction jurisdiction = jurisdictionMap.computeIfAbsent(jurisdictionId, id -> {
                    Jurisdiction jrd = new Jurisdiction();
                    jrd.setId(id);
                    try {
                        jrd.setOrgId(rs.getString("jrdorgid"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        jrd.setCode(rs.getString("jrdcode"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        jrd.setJurisdictionId(rs.getString("jrdjurisdictionid"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
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
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        fn.setType(rs.getString("fntype"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        fn.setCategory(rs.getString("fncategory"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        fn.setPropertyClass(rs.getString("fnclass"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        fn.setIsActive(rs.getBoolean("fnisactive"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        fn.setValidFrom(rs.getBigDecimal("fnvalidfrom"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        fn.setValidTo(rs.getBigDecimal("fnvalidto"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        fn.setAdditionalDetails(rs.getObject("fnadditionaldetails"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return fn;
                });
            }

            // Handle Document
            String documentId = rs.getString("docid");
            if (documentId != null) {
                Document document = documentMap.computeIfAbsent(documentId, id -> {
                    Document doc = new Document();
                    doc.setId(id);
                    try {
                        doc.setOrgId(rs.getString("docorgid"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        doc.setOrgFunctionId(rs.getString("docorgfnid"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        doc.setDocumentType(rs.getString("docdoctype"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        doc.setFileStore(rs.getString("docfilestore"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        doc.setDocumentUid(rs.getString("docdocuid"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
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
        organisation.setFunctions(new ArrayList<>(functionMap.values()));
        organisation.setDocuments(new ArrayList<>(documentMap.values()));

        return organisation;
    }
}
