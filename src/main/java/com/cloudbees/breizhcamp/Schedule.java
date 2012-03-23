package com.cloudbees.breizhcamp;

import com.cloudbees.breizhcamp.domain.Talk;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author: <a hef="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
@Service
public class Schedule {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Talk> getSchedule(String room) {
        Query q = em.createQuery("select t from Talk t where t.room = :room order by t.start");
        q.setParameter("room", room);
        return q.getResultList();
    }
}
