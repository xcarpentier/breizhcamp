package com.cloudbees.breizhcamp.services;

import com.cloudbees.breizhcamp.PersistenceTestCase;
import com.cloudbees.breizhcamp.Schedule;
import com.cloudbees.breizhcamp.domain.Speaker;
import com.cloudbees.breizhcamp.domain.Talk;
import com.cloudbees.breizhcamp.domain.Theme;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.matchers.IsCollectionContaining;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;

/**
 * @author: <a hef="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
public class ScheduleTest extends PersistenceTestCase {

    @Autowired
    private Schedule schedule;

    @Test
    public void basicTest() throws Exception {
        Speaker speaker = new Speaker();
        speaker.setFirstName("James");
        speaker.setLastName("Gosling");
        speaker.setPicture(new URL("http://upload.wikimedia.org/wikipedia/commons/0/00/James_Gosling_2005.jpg"));

        Talk talk = new Talk();
        talk.setTitle("Java and more");
        talk.setAbstract("What's coming in Java 9, 1O, 11");
        talk.setRoom("Amphi");
        talk.setStart(new Date(123456789012L));
        talk.setEnd(new Date(123456789999L));
        talk.setTheme(Theme.DECOUVRIR);

        talk.getSpeakers().add(speaker);
        speaker.getTalks().add(talk);

        em.persist(speaker);
        em.persist(talk);
        em.flush();

        List<Talk> talks = schedule.getSchedule("Amphi");
        assertThat(talks, hasItem(talk));
    }
}
