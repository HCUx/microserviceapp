package com.hcu.ticketservice.repository.es;

import com.hcu.ticketservice.entity.es.TicketES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketESRepository extends ElasticsearchRepository<TicketES, String> {
}
