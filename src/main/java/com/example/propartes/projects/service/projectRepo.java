package com.example.propartes.projects.service;

import com.example.propartes.projects.data.Project;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface projectRepo extends MongoRepository<Project,String> {

    @Aggregation(pipeline = {
            "{$addFields: {hasMatchingKey: { $cond: { if: { $gt: [ { $size: { $setIntersection: [ ?0, { $map: { input: { $objectToArray: \"$floorPlans\", }, as: \"v\", in: \"$$v.k\", }, }, ], }, }, 0, ], }, then: true, else: false, }, }}}",
            "{$match: {hasMatchingKey: true}}",
            "{$project: { hasMatchingKey: 0,}}",
            "{$match: { completion: { $in: ?1, }, location: { $regex: ?2, $options: \"i\", }, \"short_description.type\": { $in: ?3, }, price_from: { $gte: ?4, $lte: ?5, }, area: { $in: ?6, }, size:{ $gte: ?7, $lte: ?8, } }}"
    })
    List<Project> getFilteredProjects(List<String> bedrooms,List<String> completion,String location,List<String> type,Double priceFrom,Double priceTo,List<String> areas,Double sizeFrom,Double sizeTo);
}
