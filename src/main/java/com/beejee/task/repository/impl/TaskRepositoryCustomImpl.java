package com.beejee.task.repository.impl;

import com.beejee.task.model.QTask;
import com.beejee.task.model.Task;
import com.beejee.task.model.search.TaskSearchModel;
import com.beejee.task.repository.TaskRepositoryCustom;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Order;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.path.PathBuilder;
import org.apache.commons.lang3.StringUtils;

import com.mysema.query.types.expr.BooleanExpression;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


public class TaskRepositoryCustomImpl implements TaskRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> getTasks(TaskSearchModel searchModel) {

        return null;
    }


    /*@Override
    public List<Task> getTasks(TaskSearchModel searchModel) {

        QTask qTask = QTask.task;
        JPAQuery query = new JPAQuery(entityManager);
        query.from((EntityPath<?>) qTask);
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

        return query.list(qTask);
    }


    private void addQueryConditions(TaskSearchModel searchModel, QTask qTask, JPAQuery query) {
        List<BooleanExpression> conditions = new ArrayList<>();

        if (StringUtils.isNotEmpty(searchModel.getBody())) {
            BooleanExpression cond1 = qTask.body.startsWithIgnoreCase(searchModel.getBody());
            //conditions.add(qTask.body.startsWithIgnoreCase(searchModel.getBody()));
        }

        if (searchModel.getStatus() != null) {
            conditions.add(qTask.status.eq(searchModel.getStatus()));
        }

        // Add conditions
        for (BooleanExpression booleanExpression : conditions) {
            query.where(booleanExpression);
        }
    }*/

}
