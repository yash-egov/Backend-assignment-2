package digit.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import digit.repository.querybuilder.OrganisationsQueryBuilder;
import digit.repository.rowmapper.OrganisationRowMapper;
import digit.web.models.OrgSearchCriteria;
import digit.web.models.Organisation;
import lombok.extern.slf4j.Slf4j;
import org.egov.tracer.model.ServiceCallException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static digit.config.ServiceConstants.*;

@Repository
@Slf4j
@Service
public class ServiceRequestRepository {


    private ObjectMapper mapper;

    private RestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrganisationsQueryBuilder queryBuilder;

    @Autowired
    private OrganisationRowMapper rowMapper;

    @Autowired
    public ServiceRequestRepository(ObjectMapper mapper, RestTemplate restTemplate) {
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    public List<Organisation> getOrganisations(OrgSearchCriteria searchCriteria) {
        List<Object> preparedStmtList = new ArrayList<>();
        System.out.println("Inside Service repository ");
        String query = queryBuilder.getOrganisationSearchQuery(searchCriteria, preparedStmtList);
//        log.info("Final query: " + query);
        System.out.println("Query " + query);
//        return jdbcTemplate.query(query,);
        System.out.println(jdbcTemplate.query(query, preparedStmtList.toArray(), rowMapper));
        return jdbcTemplate.query(query, preparedStmtList.toArray(), rowMapper);
//        return new ArrayList<>();
    }



    public Object fetchResult(StringBuilder uri, Object request) {
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        Object response = null;
        try {
            response = restTemplate.postForObject(uri.toString(), request, Map.class);
        }catch(HttpClientErrorException e) {
            log.error(EXTERNAL_SERVICE_EXCEPTION,e);
            throw new ServiceCallException(e.getResponseBodyAsString());
        }catch(Exception e) {
            log.error(SEARCHER_SERVICE_EXCEPTION,e);
        }

        return response;
    }


}