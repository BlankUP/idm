package com.idm.app.ruleengine.modelManage.modelMonitor.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VScoreModelDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VScoreModelDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIndexNameIsNull() {
            addCriterion("INDEX_NAME is null");
            return (Criteria) this;
        }

        public Criteria andIndexNameIsNotNull() {
            addCriterion("INDEX_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andIndexNameEqualTo(String value) {
            addCriterion("INDEX_NAME =", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotEqualTo(String value) {
            addCriterion("INDEX_NAME <>", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThan(String value) {
            addCriterion("INDEX_NAME >", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThanOrEqualTo(String value) {
            addCriterion("INDEX_NAME >=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThan(String value) {
            addCriterion("INDEX_NAME <", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThanOrEqualTo(String value) {
            addCriterion("INDEX_NAME <=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLike(String value) {
            addCriterion("INDEX_NAME like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotLike(String value) {
            addCriterion("INDEX_NAME not like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameIn(List<String> values) {
            addCriterion("INDEX_NAME in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotIn(List<String> values) {
            addCriterion("INDEX_NAME not in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameBetween(String value1, String value2) {
            addCriterion("INDEX_NAME between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotBetween(String value1, String value2) {
            addCriterion("INDEX_NAME not between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexScoreIsNull() {
            addCriterion("INDEX_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andIndexScoreIsNotNull() {
            addCriterion("INDEX_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andIndexScoreEqualTo(BigDecimal value) {
            addCriterion("INDEX_SCORE =", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreNotEqualTo(BigDecimal value) {
            addCriterion("INDEX_SCORE <>", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreGreaterThan(BigDecimal value) {
            addCriterion("INDEX_SCORE >", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INDEX_SCORE >=", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreLessThan(BigDecimal value) {
            addCriterion("INDEX_SCORE <", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INDEX_SCORE <=", value, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreIn(List<BigDecimal> values) {
            addCriterion("INDEX_SCORE in", values, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreNotIn(List<BigDecimal> values) {
            addCriterion("INDEX_SCORE not in", values, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INDEX_SCORE between", value1, value2, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INDEX_SCORE not between", value1, value2, "indexScore");
            return (Criteria) this;
        }

        public Criteria andIndexPercentIsNull() {
            addCriterion("INDEX_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andIndexPercentIsNotNull() {
            addCriterion("INDEX_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andIndexPercentEqualTo(BigDecimal value) {
            addCriterion("INDEX_PERCENT =", value, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andIndexPercentNotEqualTo(BigDecimal value) {
            addCriterion("INDEX_PERCENT <>", value, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andIndexPercentGreaterThan(BigDecimal value) {
            addCriterion("INDEX_PERCENT >", value, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andIndexPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INDEX_PERCENT >=", value, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andIndexPercentLessThan(BigDecimal value) {
            addCriterion("INDEX_PERCENT <", value, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andIndexPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INDEX_PERCENT <=", value, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andIndexPercentIn(List<BigDecimal> values) {
            addCriterion("INDEX_PERCENT in", values, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andIndexPercentNotIn(List<BigDecimal> values) {
            addCriterion("INDEX_PERCENT not in", values, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andIndexPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INDEX_PERCENT between", value1, value2, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andIndexPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INDEX_PERCENT not between", value1, value2, "indexPercent");
            return (Criteria) this;
        }

        public Criteria andDataTimeIsNull() {
            addCriterion("DATA_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDataTimeIsNotNull() {
            addCriterion("DATA_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDataTimeEqualTo(Date value) {
            addCriterionForJDBCDate("DATA_TIME =", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("DATA_TIME <>", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("DATA_TIME >", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DATA_TIME >=", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeLessThan(Date value) {
            addCriterionForJDBCDate("DATA_TIME <", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DATA_TIME <=", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeIn(List<Date> values) {
            addCriterionForJDBCDate("DATA_TIME in", values, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("DATA_TIME not in", values, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DATA_TIME between", value1, value2, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DATA_TIME not between", value1, value2, "dataTime");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("MODEL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("MODEL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("MODEL_NAME =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("MODEL_NAME <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("MODEL_NAME >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("MODEL_NAME <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("MODEL_NAME like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("MODEL_NAME not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("MODEL_NAME in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("MODEL_NAME not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("MODEL_NAME between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("MODEL_NAME not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("MODEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("MODEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("MODEL_ID =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("MODEL_ID <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("MODEL_ID >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_ID >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("MODEL_ID <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("MODEL_ID <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("MODEL_ID like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("MODEL_ID not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("MODEL_ID in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("MODEL_ID not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("MODEL_ID between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("MODEL_ID not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoIsNull() {
            addCriterion("QUERY_SEQ_NO is null");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoIsNotNull() {
            addCriterion("QUERY_SEQ_NO is not null");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoEqualTo(String value) {
            addCriterion("QUERY_SEQ_NO =", value, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoNotEqualTo(String value) {
            addCriterion("QUERY_SEQ_NO <>", value, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoGreaterThan(String value) {
            addCriterion("QUERY_SEQ_NO >", value, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoGreaterThanOrEqualTo(String value) {
            addCriterion("QUERY_SEQ_NO >=", value, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoLessThan(String value) {
            addCriterion("QUERY_SEQ_NO <", value, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoLessThanOrEqualTo(String value) {
            addCriterion("QUERY_SEQ_NO <=", value, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoLike(String value) {
            addCriterion("QUERY_SEQ_NO like", value, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoNotLike(String value) {
            addCriterion("QUERY_SEQ_NO not like", value, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoIn(List<String> values) {
            addCriterion("QUERY_SEQ_NO in", values, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoNotIn(List<String> values) {
            addCriterion("QUERY_SEQ_NO not in", values, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoBetween(String value1, String value2) {
            addCriterion("QUERY_SEQ_NO between", value1, value2, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andQuerySeqNoNotBetween(String value1, String value2) {
            addCriterion("QUERY_SEQ_NO not between", value1, value2, "querySeqNo");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNull() {
            addCriterion("PROD_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("PROD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(String value) {
            addCriterion("PROD_ID =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(String value) {
            addCriterion("PROD_ID <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(String value) {
            addCriterion("PROD_ID >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_ID >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(String value) {
            addCriterion("PROD_ID <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(String value) {
            addCriterion("PROD_ID <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLike(String value) {
            addCriterion("PROD_ID like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotLike(String value) {
            addCriterion("PROD_ID not like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<String> values) {
            addCriterion("PROD_ID in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<String> values) {
            addCriterion("PROD_ID not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(String value1, String value2) {
            addCriterion("PROD_ID between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(String value1, String value2) {
            addCriterion("PROD_ID not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdNameIsNull() {
            addCriterion("PROD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProdNameIsNotNull() {
            addCriterion("PROD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProdNameEqualTo(String value) {
            addCriterion("PROD_NAME =", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotEqualTo(String value) {
            addCriterion("PROD_NAME <>", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameGreaterThan(String value) {
            addCriterion("PROD_NAME >", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_NAME >=", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLessThan(String value) {
            addCriterion("PROD_NAME <", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLessThanOrEqualTo(String value) {
            addCriterion("PROD_NAME <=", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLike(String value) {
            addCriterion("PROD_NAME like", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotLike(String value) {
            addCriterion("PROD_NAME not like", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameIn(List<String> values) {
            addCriterion("PROD_NAME in", values, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotIn(List<String> values) {
            addCriterion("PROD_NAME not in", values, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameBetween(String value1, String value2) {
            addCriterion("PROD_NAME between", value1, value2, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotBetween(String value1, String value2) {
            addCriterion("PROD_NAME not between", value1, value2, "prodName");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}