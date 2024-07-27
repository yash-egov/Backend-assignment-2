package digit.repository.rowmapper;

import digit.web.models.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Component
public class OrganisationRowMapper implements RowMapper<Organisation> {

    @Override
    public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Organisation organisation = new Organisation();
        organisation.setId(UUID.fromString(rs.getString("oid")));
        organisation.setTenantId(rs.getString("otenantid"));
        organisation.setApplicationNumber(rs.getString("oapplicationnumber"));
        organisation.setName(rs.getString("oname"));

        Address address = new Address();
        address.setId(rs.getString("aid"));
        address.setTenantId(rs.getString("atenantid"));
//        address.setType(rs.getString("atype"));
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


       List<Address>alladdresses = List.of(address);
//       alladdresses.add(address);
        organisation.setOrgAddress(alladdresses);


        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setId(rs.getString("cid"));
        contactDetails.setContactName(rs.getString("cname"));
        contactDetails.setContactMobileNumber(rs.getString("cmobno"));
        contactDetails.setContactEmail(rs.getString("cemail"));
        List<ContactDetails>allContactDetails= List.of(contactDetails);
        organisation.setContactDetails(allContactDetails);


        Identifier identifier=new Identifier();
        identifier.setId(rs.getString("idfid"));
        identifier.setType(rs.getString("idftype"));
        identifier.setValue(rs.getString("idfvalue"));
        identifier.setIsActive(rs.getBoolean("idfisactive"));
        identifier.setAdditionalDetails(rs.getObject("idfadditionaldetails"));
        List<Identifier>allIdentifiers=List.of(identifier);
        organisation.setIdentifiers(allIdentifiers);

        Jurisdiction jurisdiction=new Jurisdiction();
        jurisdiction.setId(rs.getString("jrdid"));
        jurisdiction.setOrgId(rs.getString("jrdorgid"));
        jurisdiction.setCode(rs.getString("jrdcode"));
        jurisdiction.setJurisdictionId(rs.getString("jrdjurisdictionid"));
        jurisdiction.setAdditionalDetails(rs.getObject("jrdadditionaldetails"));
        List<Jurisdiction>allJurisdiction=List.of(jurisdiction);
        organisation.setJurisdiction(allJurisdiction);


        Function function=new Function();
        function.setId(rs.getString("fnid"));
        function.setOrgId(rs.getString("fnorgid"));
        function.setType(rs.getString("fntype"));
        function.setCategory(rs.getString("fncategory"));
        function.setPropertyClass(rs.getString("fnclass"));
        function.setIsActive(rs.getBoolean("fnisactive"));
        function.setValidFrom(rs.getBigDecimal("fnvalidfrom"));
        function.setValidTo(rs.getBigDecimal("fnvalidto"));
//        function.setApplicationStatus(rs.getString("fnapplicationstatus"));
        function.setAdditionalDetails(rs.getObject("fnadditionaldetails"));

        List<Function>allFunctions=List.of(function);
        organisation.setFunctions(allFunctions);

        Document document=new Document();
        document.setId(rs.getString("docid"));
        document.setOrgId(rs.getString("docorgid"));
        document.setOrgFunctionId(rs.getString("docorgfnid"));
        document.setDocumentType(rs.getString("docdoctype"));
        document.setFileStore(rs.getString("docfilestore"));
        document.setDocumentUid(rs.getString("docdocuid"));
        document.setAdditionalDetails(rs.getObject("docadditionaldetails"));

        List<Document>allDocuments=List.of(document);
        organisation.setDocuments(allDocuments);


        return organisation;
    }
}
