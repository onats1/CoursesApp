package com.example.coursesApp.topics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    List<Topic> getTopics() {

        List<Topic> topics = new ArrayList<>();

        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    Topic getTopic(String id) {
        return topicRepository.findById(id).get();
    }

    void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.delete(topicRepository.findById(id).get());
    }
}
