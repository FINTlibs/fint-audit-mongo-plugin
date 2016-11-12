package no.fint.audit.plugin.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AuditMongoRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void save(MongoAuditEvent mongoAuditEvent) {
        mongoTemplate.save(mongoAuditEvent);
    }

    @Profile(value = "test")
    public List<MongoAuditEvent> getAllEvents() {
        return mongoTemplate.findAll(MongoAuditEvent.class);
    }
}
