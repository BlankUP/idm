package com.idm.app.ruleengine.exceptionManage.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ErrorMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ErrorMessageExample() {
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

        public Criteria andQueryseqnoIsNull() {
            addCriterion("QUERYSEQNO is null");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoIsNotNull() {
            addCriterion("QUERYSEQNO is not null");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoEqualTo(String value) {
            addCriterion("QUERYSEQNO =", value, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoNotEqualTo(String value) {
            addCriterion("QUERYSEQNO <>", value, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoGreaterThan(String value) {
            addCriterion("QUERYSEQNO >", value, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoGreaterThanOrEqualTo(String value) {
            addCriterion("QUERYSEQNO >=", value, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoLessThan(String value) {
            addCriterion("QUERYSEQNO <", value, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoLessThanOrEqualTo(String value) {
            addCriterion("QUERYSEQNO <=", value, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoLike(String value) {
            addCriterion("QUERYSEQNO like", value, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoNotLike(String value) {
            addCriterion("QUERYSEQNO not like", value, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoIn(List<String> values) {
            addCriterion("QUERYSEQNO in", values, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoNotIn(List<String> values) {
            addCriterion("QUERYSEQNO not in", values, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoBetween(String value1, String value2) {
            addCriterion("QUERYSEQNO between", value1, value2, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andQueryseqnoNotBetween(String value1, String value2) {
            addCriterion("QUERYSEQNO not between", value1, value2, "queryseqno");
            return (Criteria) this;
        }

        public Criteria andIdnumberIsNull() {
            addCriterion("IDNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andIdnumberIsNotNull() {
            addCriterion("IDNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andIdnumberEqualTo(String value) {
            addCriterion("IDNUMBER =", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotEqualTo(String value) {
            addCriterion("IDNUMBER <>", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberGreaterThan(String value) {
            addCriterion("IDNUMBER >", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberGreaterThanOrEqualTo(String value) {
            addCriterion("IDNUMBER >=", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberLessThan(String value) {
            addCriterion("IDNUMBER <", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberLessThanOrEqualTo(String value) {
            addCriterion("IDNUMBER <=", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberLike(String value) {
            addCriterion("IDNUMBER like", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotLike(String value) {
            addCriterion("IDNUMBER not like", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberIn(List<String> values) {
            addCriterion("IDNUMBER in", values, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotIn(List<String> values) {
            addCriterion("IDNUMBER not in", values, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberBetween(String value1, String value2) {
            addCriterion("IDNUMBER between", value1, value2, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotBetween(String value1, String value2) {
            addCriterion("IDNUMBER not between", value1, value2, "idnumber");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIsNull() {
            addCriterion("ERRORCODE is null");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIsNotNull() {
            addCriterion("ERRORCODE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorcodeEqualTo(String value) {
            addCriterion("ERRORCODE =", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotEqualTo(String value) {
            addCriterion("ERRORCODE <>", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeGreaterThan(String value) {
            addCriterion("ERRORCODE >", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ERRORCODE >=", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLessThan(String value) {
            addCriterion("ERRORCODE <", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLessThanOrEqualTo(String value) {
            addCriterion("ERRORCODE <=", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLike(String value) {
            addCriterion("ERRORCODE like", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotLike(String value) {
            addCriterion("ERRORCODE not like", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIn(List<String> values) {
            addCriterion("ERRORCODE in", values, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotIn(List<String> values) {
            addCriterion("ERRORCODE not in", values, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeBetween(String value1, String value2) {
            addCriterion("ERRORCODE between", value1, value2, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotBetween(String value1, String value2) {
            addCriterion("ERRORCODE not between", value1, value2, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrortypeIsNull() {
            addCriterion("ERRORTYPE is null");
            return (Criteria) this;
        }

        public Criteria andErrortypeIsNotNull() {
            addCriterion("ERRORTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andErrortypeEqualTo(String value) {
            addCriterion("ERRORTYPE =", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeNotEqualTo(String value) {
            addCriterion("ERRORTYPE <>", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeGreaterThan(String value) {
            addCriterion("ERRORTYPE >", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeGreaterThanOrEqualTo(String value) {
            addCriterion("ERRORTYPE >=", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeLessThan(String value) {
            addCriterion("ERRORTYPE <", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeLessThanOrEqualTo(String value) {
            addCriterion("ERRORTYPE <=", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeLike(String value) {
            addCriterion("ERRORTYPE like", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeNotLike(String value) {
            addCriterion("ERRORTYPE not like", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeIn(List<String> values) {
            addCriterion("ERRORTYPE in", values, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeNotIn(List<String> values) {
            addCriterion("ERRORTYPE not in", values, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeBetween(String value1, String value2) {
            addCriterion("ERRORTYPE between", value1, value2, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeNotBetween(String value1, String value2) {
            addCriterion("ERRORTYPE not between", value1, value2, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrormessageIsNull() {
            addCriterion("ERRORMESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andErrormessageIsNotNull() {
            addCriterion("ERRORMESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andErrormessageEqualTo(String value) {
            addCriterion("ERRORMESSAGE =", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageNotEqualTo(String value) {
            addCriterion("ERRORMESSAGE <>", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageGreaterThan(String value) {
            addCriterion("ERRORMESSAGE >", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageGreaterThanOrEqualTo(String value) {
            addCriterion("ERRORMESSAGE >=", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageLessThan(String value) {
            addCriterion("ERRORMESSAGE <", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageLessThanOrEqualTo(String value) {
            addCriterion("ERRORMESSAGE <=", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageLike(String value) {
            addCriterion("ERRORMESSAGE like", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageNotLike(String value) {
            addCriterion("ERRORMESSAGE not like", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageIn(List<String> values) {
            addCriterion("ERRORMESSAGE in", values, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageNotIn(List<String> values) {
            addCriterion("ERRORMESSAGE not in", values, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageBetween(String value1, String value2) {
            addCriterion("ERRORMESSAGE between", value1, value2, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageNotBetween(String value1, String value2) {
            addCriterion("ERRORMESSAGE not between", value1, value2, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrorstatusIsNull() {
            addCriterion("ERRORSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andErrorstatusIsNotNull() {
            addCriterion("ERRORSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andErrorstatusEqualTo(String value) {
            addCriterion("ERRORSTATUS =", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusNotEqualTo(String value) {
            addCriterion("ERRORSTATUS <>", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusGreaterThan(String value) {
            addCriterion("ERRORSTATUS >", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusGreaterThanOrEqualTo(String value) {
            addCriterion("ERRORSTATUS >=", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusLessThan(String value) {
            addCriterion("ERRORSTATUS <", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusLessThanOrEqualTo(String value) {
            addCriterion("ERRORSTATUS <=", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusLike(String value) {
            addCriterion("ERRORSTATUS like", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusNotLike(String value) {
            addCriterion("ERRORSTATUS not like", value, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusIn(List<String> values) {
            addCriterion("ERRORSTATUS in", values, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusNotIn(List<String> values) {
            addCriterion("ERRORSTATUS not in", values, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusBetween(String value1, String value2) {
            addCriterion("ERRORSTATUS between", value1, value2, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andErrorstatusNotBetween(String value1, String value2) {
            addCriterion("ERRORSTATUS not between", value1, value2, "errorstatus");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
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