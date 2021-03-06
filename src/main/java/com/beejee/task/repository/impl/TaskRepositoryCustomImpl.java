package com.beejee.task.repository.impl;

import com.beejee.task.model.QTask;
import com.beejee.task.model.Task;
import com.beejee.task.model.search.TaskSearchModel;
import com.beejee.task.repository.TaskRepositoryCustom;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


public class TaskRepositoryCustomImpl implements TaskRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> getTasks(TaskSearchModel searchModel) {

        JPAQuery query = new JPAQuery(entityManager);
        QTask qTask = QTask.task;
        query.from(qTask);

        addQueryConditions(searchModel, qTask, query);

        if (searchModel.getFirst() != null) {
            query.offset(searchModel.getFirst());
        }

        if (searchModel.getPageSize() != null) {
            query.limit(searchModel.getPageSize());
        }

        if (searchModel.getSortParam() != null) {
            PathBuilder orderByExpression = new PathBuilder(Task.class, "task");
            Order orderExpression = searchModel.isAscending() ? Order.ASC : Order.DESC;
            query.orderBy(new OrderSpecifier<Comparable>(orderExpression, orderByExpression.get(searchModel.getSortParam())));
        } else {
            query.orderBy(qTask.id.desc());
        }

        return query.fetch();
    }

    private void addQueryConditions(TaskSearchModel searchModel, QTask qTask, JPAQuery query) {
        List<BooleanExpression> conditions = new ArrayList<>();

        if (StringUtils.isNotEmpty(searchModel.getBody())) {
            conditions.add(qTask.body.startsWithIgnoreCase(searchModel.getBody()));
            //BooleanExpression cond1 = qTask.body.startsWithIgnoreCase(searchModel.getBody());
        }

        if (searchModel.getStatus() != null) {
            conditions.add(qTask.status.eq(searchModel.getStatus()));
        }

        // Add conditions
        for (BooleanExpression booleanExpression : conditions) {
            query.where(booleanExpression);
        }
    }

}
