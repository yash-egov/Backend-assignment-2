package digit.repository.querybuilder;

import digit.web.models.OrgSearchCriteria;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class OrganisationsQueryBuilder {
    private static final String BASE_ORG_QUERY = " SELECT org.id as oid, org.tenant_id as otenantid, org.application_number as oapplicationnumber, org.name as oname, ";

    private static final String ADDRESS_SELECT_QUERY = " add.id as aid, add.tenant_id as atenantid, add.type as atype, add.address_line1 as aaddressline1, add.address_line2 as aaddressline2, add.city as acity, add.pincode as apincode, add.organisation_id as aorgid, add.door_no as adoorno, add.building_name as abuildingname, add.landmark as alandmark, add.latitude as alatitude, add.longitude as alongitude, add.street as astreet, add.boundary_type as aboundarytype, add.detail as adetail, ";

    private static final String CONTACT_SELECT_QUERY =" cd.id as cid, cd.contact_name as cname, cd.contact_mobile_number as cmobno, cd.contact_email as cemail, ";

    private static final String IDENTIFIERS_SELECT_QUERY=" idf.id as idfid, idf.type as idftype, idf.value as idfvalue, idf.is_active as idfisactive, idf.additional_details as idfadditionaldetails, ";

    private static final String JURISDICTION_SELECT_QUERY = " jrd.id as jrdid, jrd.organisation_id as jrdorgid, jrd.code as jrdcode, jrd.jurisdiction_id as jrdjurisdictionid, jrd.additional_details as jrdadditionaldetails, ";//jurisdiction

    private static final String FUNCTION_SELECT_QUERY=" fn.id as fnid, fn.organisation_id as fnorgid, fn.type as fntype, fn.category as fncategory, fn.class as fnclass, fn.valid_from as fnvalidfrom, fn.valid_to as fnvalidto, fn.is_active as fnisactive, fn.application_status as fnapplicationstatus, fn.additional_details as fnadditionaldetails, ";

    private static final String DOCUMENTS_SELECT_QUERY=" doc.id as docid, doc.organisation_id as docorgid, doc.org_function_id as docorgfnid, doc.document_type as docdoctype, doc.file_store as docfilestore, doc.document_uid as docdocuid, doc.additional_details as docadditionaldetails ";

    private static final String FROM_TABLES = " FROM organisations org LEFT JOIN org_address add ON org.id = add.organisation_id LEFT JOIN contact_details cd ON org.id = cd.organisation_id LEFT JOIN identifier idf ON org.id = idf.organisation_id LEFT JOIN jurisdiction jrd ON org.id = jrd.organisation_id LEFT JOIN functions fn ON org.id=fn.organisation_id LEFT JOIN document doc ON org.id=doc.organisation_id ";



    private final String ORDERBY_CREATEDTIME = " ORDER BY btr.createdtime DESC ";

    public String getOrganisationSearchQuery(OrgSearchCriteria criteria, List<Object> preparedStmtList){
        StringBuilder query = new StringBuilder(BASE_ORG_QUERY);
        query.append(ADDRESS_SELECT_QUERY);
        query.append(CONTACT_SELECT_QUERY);
        query.append(IDENTIFIERS_SELECT_QUERY);
        query.append(JURISDICTION_SELECT_QUERY);
        query.append(FUNCTION_SELECT_QUERY);
        query.append(DOCUMENTS_SELECT_QUERY);
        query.append(FROM_TABLES);

        // in search criteri id is List of Strings
        if(!CollectionUtils.isEmpty(criteria.getId())){
            addClauseIfRequired(query, preparedStmtList);
            query.append(" org.id IN ( ").append(createQuery(criteria.getId())).append(" ) ");
            addToPreparedStatement(preparedStmtList, criteria.getId());
        }
        if(!ObjectUtils.isEmpty(criteria.getTenantId())){
            addClauseIfRequired(query, preparedStmtList);
            query.append(" org.tenant_id = ? ");
            preparedStmtList.add(criteria.getTenantId());
        }
        if(!ObjectUtils.isEmpty(criteria.getName())){
            addClauseIfRequired(query, preparedStmtList);
            query.append(" org.name = ? ");
            preparedStmtList.add(criteria.getName());
        }
//        if(!ObjectUtils.isEmpty(criteria.getApplicationNumber())){
//            addClauseIfRequired(query, preparedStmtList);
//            query.append(" org.application_number = ? ");
//            preparedStmtList.add(criteria.getApplicationNumber());
//        }

        // order birth registration applications based on their createdtime in latest first manner
//        query.append(ORDERBY_CREATEDTIME);

        return query.toString();
    }

    private void addClauseIfRequired(StringBuilder query, List<Object> preparedStmtList){
        if(preparedStmtList.isEmpty()){
            query.append(" WHERE ");
        }else{
            query.append(" AND ");
        }
    }

    private String createQuery(List<String> ids) {
        StringBuilder builder = new StringBuilder();
        int length = ids.size();
        for (int i = 0; i < length; i++) {
            builder.append(" ?");
            if (i != length - 1)
                builder.append(",");
        }
        return builder.toString();
    }

    private void addToPreparedStatement(List<Object> preparedStmtList, List<String> ids) {
        ids.forEach(id -> {
            preparedStmtList.add(id);
        });
    }
}

