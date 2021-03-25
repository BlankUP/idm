package com.idm.app.ruleengine.datasourceManage.innerDatasourceManage.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BankInnerDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankInnerDataExample() {
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

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("CUST_NAME =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("CUST_NAME <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("CUST_NAME >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NAME >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("CUST_NAME <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("CUST_NAME <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("CUST_NAME like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("CUST_NAME not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("CUST_NAME in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("CUST_NAME not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("CUST_NAME between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("CUST_NAME not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("GENDER like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("GENDER not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("AGE like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("AGE not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andBirthIsNull() {
            addCriterion("BIRTH is null");
            return (Criteria) this;
        }

        public Criteria andBirthIsNotNull() {
            addCriterion("BIRTH is not null");
            return (Criteria) this;
        }

        public Criteria andBirthEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTH =", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTH <>", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThan(Date value) {
            addCriterionForJDBCDate("BIRTH >", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTH >=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThan(Date value) {
            addCriterionForJDBCDate("BIRTH <", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTH <=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthIn(List<Date> values) {
            addCriterionForJDBCDate("BIRTH in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotIn(List<Date> values) {
            addCriterionForJDBCDate("BIRTH not in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BIRTH between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BIRTH not between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNull() {
            addCriterion("CERT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNotNull() {
            addCriterion("CERT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeEqualTo(String value) {
            addCriterion("CERT_TYPE =", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotEqualTo(String value) {
            addCriterion("CERT_TYPE <>", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThan(String value) {
            addCriterion("CERT_TYPE >", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE >=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThan(String value) {
            addCriterion("CERT_TYPE <", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE <=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLike(String value) {
            addCriterion("CERT_TYPE like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotLike(String value) {
            addCriterion("CERT_TYPE not like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeIn(List<String> values) {
            addCriterion("CERT_TYPE in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotIn(List<String> values) {
            addCriterion("CERT_TYPE not in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeBetween(String value1, String value2) {
            addCriterion("CERT_TYPE between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotBetween(String value1, String value2) {
            addCriterion("CERT_TYPE not between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertNumIsNull() {
            addCriterion("CERT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCertNumIsNotNull() {
            addCriterion("CERT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCertNumEqualTo(String value) {
            addCriterion("CERT_NUM =", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumNotEqualTo(String value) {
            addCriterion("CERT_NUM <>", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumGreaterThan(String value) {
            addCriterion("CERT_NUM >", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_NUM >=", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumLessThan(String value) {
            addCriterion("CERT_NUM <", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumLessThanOrEqualTo(String value) {
            addCriterion("CERT_NUM <=", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumLike(String value) {
            addCriterion("CERT_NUM like", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumNotLike(String value) {
            addCriterion("CERT_NUM not like", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumIn(List<String> values) {
            addCriterion("CERT_NUM in", values, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumNotIn(List<String> values) {
            addCriterion("CERT_NUM not in", values, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumBetween(String value1, String value2) {
            addCriterion("CERT_NUM between", value1, value2, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumNotBetween(String value1, String value2) {
            addCriterion("CERT_NUM not between", value1, value2, "certNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumIsNull() {
            addCriterion("MOBILE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andMobileNumIsNotNull() {
            addCriterion("MOBILE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andMobileNumEqualTo(String value) {
            addCriterion("MOBILE_NUM =", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumNotEqualTo(String value) {
            addCriterion("MOBILE_NUM <>", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumGreaterThan(String value) {
            addCriterion("MOBILE_NUM >", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE_NUM >=", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumLessThan(String value) {
            addCriterion("MOBILE_NUM <", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumLessThanOrEqualTo(String value) {
            addCriterion("MOBILE_NUM <=", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumLike(String value) {
            addCriterion("MOBILE_NUM like", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumNotLike(String value) {
            addCriterion("MOBILE_NUM not like", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumIn(List<String> values) {
            addCriterion("MOBILE_NUM in", values, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumNotIn(List<String> values) {
            addCriterion("MOBILE_NUM not in", values, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumBetween(String value1, String value2) {
            addCriterion("MOBILE_NUM between", value1, value2, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumNotBetween(String value1, String value2) {
            addCriterion("MOBILE_NUM not between", value1, value2, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsIsNull() {
            addCriterion("SERIAL_PAYROLL_MONTHS is null");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsIsNotNull() {
            addCriterion("SERIAL_PAYROLL_MONTHS is not null");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsEqualTo(String value) {
            addCriterion("SERIAL_PAYROLL_MONTHS =", value, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsNotEqualTo(String value) {
            addCriterion("SERIAL_PAYROLL_MONTHS <>", value, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsGreaterThan(String value) {
            addCriterion("SERIAL_PAYROLL_MONTHS >", value, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsGreaterThanOrEqualTo(String value) {
            addCriterion("SERIAL_PAYROLL_MONTHS >=", value, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsLessThan(String value) {
            addCriterion("SERIAL_PAYROLL_MONTHS <", value, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsLessThanOrEqualTo(String value) {
            addCriterion("SERIAL_PAYROLL_MONTHS <=", value, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsLike(String value) {
            addCriterion("SERIAL_PAYROLL_MONTHS like", value, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsNotLike(String value) {
            addCriterion("SERIAL_PAYROLL_MONTHS not like", value, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsIn(List<String> values) {
            addCriterion("SERIAL_PAYROLL_MONTHS in", values, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsNotIn(List<String> values) {
            addCriterion("SERIAL_PAYROLL_MONTHS not in", values, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsBetween(String value1, String value2) {
            addCriterion("SERIAL_PAYROLL_MONTHS between", value1, value2, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andSerialPayrollMonthsNotBetween(String value1, String value2) {
            addCriterion("SERIAL_PAYROLL_MONTHS not between", value1, value2, "serialPayrollMonths");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndIsNull() {
            addCriterion("CURR_PAYROLL_IND is null");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndIsNotNull() {
            addCriterion("CURR_PAYROLL_IND is not null");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndEqualTo(BigDecimal value) {
            addCriterion("CURR_PAYROLL_IND =", value, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndNotEqualTo(BigDecimal value) {
            addCriterion("CURR_PAYROLL_IND <>", value, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndGreaterThan(BigDecimal value) {
            addCriterion("CURR_PAYROLL_IND >", value, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CURR_PAYROLL_IND >=", value, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndLessThan(BigDecimal value) {
            addCriterion("CURR_PAYROLL_IND <", value, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CURR_PAYROLL_IND <=", value, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndIn(List<BigDecimal> values) {
            addCriterion("CURR_PAYROLL_IND in", values, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndNotIn(List<BigDecimal> values) {
            addCriterion("CURR_PAYROLL_IND not in", values, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURR_PAYROLL_IND between", value1, value2, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollIndNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURR_PAYROLL_IND not between", value1, value2, "currPayrollInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndIsNull() {
            addCriterion("WAGES_PAY_CUST_IND is null");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndIsNotNull() {
            addCriterion("WAGES_PAY_CUST_IND is not null");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndEqualTo(String value) {
            addCriterion("WAGES_PAY_CUST_IND =", value, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndNotEqualTo(String value) {
            addCriterion("WAGES_PAY_CUST_IND <>", value, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndGreaterThan(String value) {
            addCriterion("WAGES_PAY_CUST_IND >", value, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndGreaterThanOrEqualTo(String value) {
            addCriterion("WAGES_PAY_CUST_IND >=", value, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndLessThan(String value) {
            addCriterion("WAGES_PAY_CUST_IND <", value, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndLessThanOrEqualTo(String value) {
            addCriterion("WAGES_PAY_CUST_IND <=", value, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndLike(String value) {
            addCriterion("WAGES_PAY_CUST_IND like", value, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndNotLike(String value) {
            addCriterion("WAGES_PAY_CUST_IND not like", value, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndIn(List<String> values) {
            addCriterion("WAGES_PAY_CUST_IND in", values, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndNotIn(List<String> values) {
            addCriterion("WAGES_PAY_CUST_IND not in", values, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndBetween(String value1, String value2) {
            addCriterion("WAGES_PAY_CUST_IND between", value1, value2, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andWagesPayCustIndNotBetween(String value1, String value2) {
            addCriterion("WAGES_PAY_CUST_IND not between", value1, value2, "wagesPayCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndIsNull() {
            addCriterion("HISTY_PAYROLL_IND is null");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndIsNotNull() {
            addCriterion("HISTY_PAYROLL_IND is not null");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndEqualTo(String value) {
            addCriterion("HISTY_PAYROLL_IND =", value, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndNotEqualTo(String value) {
            addCriterion("HISTY_PAYROLL_IND <>", value, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndGreaterThan(String value) {
            addCriterion("HISTY_PAYROLL_IND >", value, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndGreaterThanOrEqualTo(String value) {
            addCriterion("HISTY_PAYROLL_IND >=", value, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndLessThan(String value) {
            addCriterion("HISTY_PAYROLL_IND <", value, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndLessThanOrEqualTo(String value) {
            addCriterion("HISTY_PAYROLL_IND <=", value, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndLike(String value) {
            addCriterion("HISTY_PAYROLL_IND like", value, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndNotLike(String value) {
            addCriterion("HISTY_PAYROLL_IND not like", value, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndIn(List<String> values) {
            addCriterion("HISTY_PAYROLL_IND in", values, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndNotIn(List<String> values) {
            addCriterion("HISTY_PAYROLL_IND not in", values, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndBetween(String value1, String value2) {
            addCriterion("HISTY_PAYROLL_IND between", value1, value2, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andHistyPayrollIndNotBetween(String value1, String value2) {
            addCriterion("HISTY_PAYROLL_IND not between", value1, value2, "histyPayrollInd");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtIsNull() {
            addCriterion("CURR_PAYROLL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtIsNotNull() {
            addCriterion("CURR_PAYROLL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtEqualTo(BigDecimal value) {
            addCriterion("CURR_PAYROLL_AMT =", value, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtNotEqualTo(BigDecimal value) {
            addCriterion("CURR_PAYROLL_AMT <>", value, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtGreaterThan(BigDecimal value) {
            addCriterion("CURR_PAYROLL_AMT >", value, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CURR_PAYROLL_AMT >=", value, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtLessThan(BigDecimal value) {
            addCriterion("CURR_PAYROLL_AMT <", value, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CURR_PAYROLL_AMT <=", value, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtIn(List<BigDecimal> values) {
            addCriterion("CURR_PAYROLL_AMT in", values, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtNotIn(List<BigDecimal> values) {
            addCriterion("CURR_PAYROLL_AMT not in", values, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURR_PAYROLL_AMT between", value1, value2, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andCurrPayrollAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURR_PAYROLL_AMT not between", value1, value2, "currPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtIsNull() {
            addCriterion("LAST_SIXMON_AVG_PAYAMT is null");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtIsNotNull() {
            addCriterion("LAST_SIXMON_AVG_PAYAMT is not null");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtEqualTo(BigDecimal value) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT =", value, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtNotEqualTo(BigDecimal value) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT <>", value, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtGreaterThan(BigDecimal value) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT >", value, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT >=", value, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtLessThan(BigDecimal value) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT <", value, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT <=", value, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtIn(List<BigDecimal> values) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT in", values, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtNotIn(List<BigDecimal> values) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT not in", values, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT between", value1, value2, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andLastSixmonAvgPayamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAST_SIXMON_AVG_PAYAMT not between", value1, value2, "lastSixmonAvgPayamt");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndIsNull() {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND is null");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndIsNotNull() {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND is not null");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndEqualTo(String value) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND =", value, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndNotEqualTo(String value) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND <>", value, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndGreaterThan(String value) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND >", value, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND >=", value, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndLessThan(String value) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND <", value, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND <=", value, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndLike(String value) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND like", value, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndNotLike(String value) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND not like", value, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndIn(List<String> values) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND in", values, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndNotIn(List<String> values) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND not in", values, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndBetween(String value1, String value2) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND between", value1, value2, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseMortgLoanCustIndNotBetween(String value1, String value2) {
            addCriterion("HOUSE_MORTG_LOAN_CUST_IND not between", value1, value2, "houseMortgLoanCustInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndIsNull() {
            addCriterion("HOUSELOAN_OVDUE_IND is null");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndIsNotNull() {
            addCriterion("HOUSELOAN_OVDUE_IND is not null");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndEqualTo(String value) {
            addCriterion("HOUSELOAN_OVDUE_IND =", value, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndNotEqualTo(String value) {
            addCriterion("HOUSELOAN_OVDUE_IND <>", value, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndGreaterThan(String value) {
            addCriterion("HOUSELOAN_OVDUE_IND >", value, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSELOAN_OVDUE_IND >=", value, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndLessThan(String value) {
            addCriterion("HOUSELOAN_OVDUE_IND <", value, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndLessThanOrEqualTo(String value) {
            addCriterion("HOUSELOAN_OVDUE_IND <=", value, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndLike(String value) {
            addCriterion("HOUSELOAN_OVDUE_IND like", value, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndNotLike(String value) {
            addCriterion("HOUSELOAN_OVDUE_IND not like", value, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndIn(List<String> values) {
            addCriterion("HOUSELOAN_OVDUE_IND in", values, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndNotIn(List<String> values) {
            addCriterion("HOUSELOAN_OVDUE_IND not in", values, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndBetween(String value1, String value2) {
            addCriterion("HOUSELOAN_OVDUE_IND between", value1, value2, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanOvdueIndNotBetween(String value1, String value2) {
            addCriterion("HOUSELOAN_OVDUE_IND not between", value1, value2, "houseloanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndIsNull() {
            addCriterion("HISTY_HOUSELOAN_CUST_IND is null");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndIsNotNull() {
            addCriterion("HISTY_HOUSELOAN_CUST_IND is not null");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndEqualTo(String value) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND =", value, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndNotEqualTo(String value) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND <>", value, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndGreaterThan(String value) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND >", value, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndGreaterThanOrEqualTo(String value) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND >=", value, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndLessThan(String value) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND <", value, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndLessThanOrEqualTo(String value) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND <=", value, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndLike(String value) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND like", value, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndNotLike(String value) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND not like", value, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndIn(List<String> values) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND in", values, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndNotIn(List<String> values) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND not in", values, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndBetween(String value1, String value2) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND between", value1, value2, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andHistyHouseloanCustIndNotBetween(String value1, String value2) {
            addCriterion("HISTY_HOUSELOAN_CUST_IND not between", value1, value2, "histyHouseloanCustInd");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeIsNull() {
            addCriterion("LEVELCLASSCODE is null");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeIsNotNull() {
            addCriterion("LEVELCLASSCODE is not null");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeEqualTo(String value) {
            addCriterion("LEVELCLASSCODE =", value, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeNotEqualTo(String value) {
            addCriterion("LEVELCLASSCODE <>", value, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeGreaterThan(String value) {
            addCriterion("LEVELCLASSCODE >", value, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeGreaterThanOrEqualTo(String value) {
            addCriterion("LEVELCLASSCODE >=", value, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeLessThan(String value) {
            addCriterion("LEVELCLASSCODE <", value, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeLessThanOrEqualTo(String value) {
            addCriterion("LEVELCLASSCODE <=", value, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeLike(String value) {
            addCriterion("LEVELCLASSCODE like", value, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeNotLike(String value) {
            addCriterion("LEVELCLASSCODE not like", value, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeIn(List<String> values) {
            addCriterion("LEVELCLASSCODE in", values, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeNotIn(List<String> values) {
            addCriterion("LEVELCLASSCODE not in", values, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeBetween(String value1, String value2) {
            addCriterion("LEVELCLASSCODE between", value1, value2, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andLevelclasscodeNotBetween(String value1, String value2) {
            addCriterion("LEVELCLASSCODE not between", value1, value2, "levelclasscode");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndIsNull() {
            addCriterion("NON_HOUSELOAN_IND is null");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndIsNotNull() {
            addCriterion("NON_HOUSELOAN_IND is not null");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndEqualTo(String value) {
            addCriterion("NON_HOUSELOAN_IND =", value, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndNotEqualTo(String value) {
            addCriterion("NON_HOUSELOAN_IND <>", value, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndGreaterThan(String value) {
            addCriterion("NON_HOUSELOAN_IND >", value, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndGreaterThanOrEqualTo(String value) {
            addCriterion("NON_HOUSELOAN_IND >=", value, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndLessThan(String value) {
            addCriterion("NON_HOUSELOAN_IND <", value, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndLessThanOrEqualTo(String value) {
            addCriterion("NON_HOUSELOAN_IND <=", value, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndLike(String value) {
            addCriterion("NON_HOUSELOAN_IND like", value, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndNotLike(String value) {
            addCriterion("NON_HOUSELOAN_IND not like", value, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndIn(List<String> values) {
            addCriterion("NON_HOUSELOAN_IND in", values, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndNotIn(List<String> values) {
            addCriterion("NON_HOUSELOAN_IND not in", values, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndBetween(String value1, String value2) {
            addCriterion("NON_HOUSELOAN_IND between", value1, value2, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andNonHouseloanIndNotBetween(String value1, String value2) {
            addCriterion("NON_HOUSELOAN_IND not between", value1, value2, "nonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndIsNull() {
            addCriterion("HISTY_NON_HOUSELOAN_IND is null");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndIsNotNull() {
            addCriterion("HISTY_NON_HOUSELOAN_IND is not null");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndEqualTo(String value) {
            addCriterion("HISTY_NON_HOUSELOAN_IND =", value, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndNotEqualTo(String value) {
            addCriterion("HISTY_NON_HOUSELOAN_IND <>", value, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndGreaterThan(String value) {
            addCriterion("HISTY_NON_HOUSELOAN_IND >", value, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndGreaterThanOrEqualTo(String value) {
            addCriterion("HISTY_NON_HOUSELOAN_IND >=", value, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndLessThan(String value) {
            addCriterion("HISTY_NON_HOUSELOAN_IND <", value, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndLessThanOrEqualTo(String value) {
            addCriterion("HISTY_NON_HOUSELOAN_IND <=", value, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndLike(String value) {
            addCriterion("HISTY_NON_HOUSELOAN_IND like", value, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndNotLike(String value) {
            addCriterion("HISTY_NON_HOUSELOAN_IND not like", value, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndIn(List<String> values) {
            addCriterion("HISTY_NON_HOUSELOAN_IND in", values, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndNotIn(List<String> values) {
            addCriterion("HISTY_NON_HOUSELOAN_IND not in", values, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndBetween(String value1, String value2) {
            addCriterion("HISTY_NON_HOUSELOAN_IND between", value1, value2, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHistyNonHouseloanIndNotBetween(String value1, String value2) {
            addCriterion("HISTY_NON_HOUSELOAN_IND not between", value1, value2, "histyNonHouseloanInd");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalIsNull() {
            addCriterion("HOUSELOAN_PRIN_BAL is null");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalIsNotNull() {
            addCriterion("HOUSELOAN_PRIN_BAL is not null");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalEqualTo(String value) {
            addCriterion("HOUSELOAN_PRIN_BAL =", value, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalNotEqualTo(String value) {
            addCriterion("HOUSELOAN_PRIN_BAL <>", value, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalGreaterThan(String value) {
            addCriterion("HOUSELOAN_PRIN_BAL >", value, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSELOAN_PRIN_BAL >=", value, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalLessThan(String value) {
            addCriterion("HOUSELOAN_PRIN_BAL <", value, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalLessThanOrEqualTo(String value) {
            addCriterion("HOUSELOAN_PRIN_BAL <=", value, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalLike(String value) {
            addCriterion("HOUSELOAN_PRIN_BAL like", value, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalNotLike(String value) {
            addCriterion("HOUSELOAN_PRIN_BAL not like", value, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalIn(List<String> values) {
            addCriterion("HOUSELOAN_PRIN_BAL in", values, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalNotIn(List<String> values) {
            addCriterion("HOUSELOAN_PRIN_BAL not in", values, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalBetween(String value1, String value2) {
            addCriterion("HOUSELOAN_PRIN_BAL between", value1, value2, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanPrinBalNotBetween(String value1, String value2) {
            addCriterion("HOUSELOAN_PRIN_BAL not between", value1, value2, "houseloanPrinBal");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtIsNull() {
            addCriterion("HOUSELOAN_MON_REPAYAMT is null");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtIsNotNull() {
            addCriterion("HOUSELOAN_MON_REPAYAMT is not null");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtEqualTo(BigDecimal value) {
            addCriterion("HOUSELOAN_MON_REPAYAMT =", value, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtNotEqualTo(BigDecimal value) {
            addCriterion("HOUSELOAN_MON_REPAYAMT <>", value, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtGreaterThan(BigDecimal value) {
            addCriterion("HOUSELOAN_MON_REPAYAMT >", value, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUSELOAN_MON_REPAYAMT >=", value, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtLessThan(BigDecimal value) {
            addCriterion("HOUSELOAN_MON_REPAYAMT <", value, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUSELOAN_MON_REPAYAMT <=", value, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtIn(List<BigDecimal> values) {
            addCriterion("HOUSELOAN_MON_REPAYAMT in", values, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtNotIn(List<BigDecimal> values) {
            addCriterion("HOUSELOAN_MON_REPAYAMT not in", values, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUSELOAN_MON_REPAYAMT between", value1, value2, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanMonRepayamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUSELOAN_MON_REPAYAMT not between", value1, value2, "houseloanMonRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtIsNull() {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT is null");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtIsNotNull() {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT is not null");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtEqualTo(BigDecimal value) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT =", value, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtNotEqualTo(BigDecimal value) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT <>", value, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtGreaterThan(BigDecimal value) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT >", value, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT >=", value, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtLessThan(BigDecimal value) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT <", value, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT <=", value, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtIn(List<BigDecimal> values) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT in", values, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtNotIn(List<BigDecimal> values) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT not in", values, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT between", value1, value2, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andHouseloanNextyearRepayamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUSELOAN_NEXTYEAR_REPAYAMT not between", value1, value2, "houseloanNextyearRepayamt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtIsNull() {
            addCriterion("LAST_ONE_TM_PAYROLL_DT is null");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtIsNotNull() {
            addCriterion("LAST_ONE_TM_PAYROLL_DT is not null");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT =", value, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtNotEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT <>", value, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtGreaterThan(Date value) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT >", value, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT >=", value, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtLessThan(Date value) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT <", value, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT <=", value, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT in", values, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtNotIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT not in", values, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT between", value1, value2, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andLastOneTmPayrollDtNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_ONE_TM_PAYROLL_DT not between", value1, value2, "lastOneTmPayrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtIsNull() {
            addCriterion("PAYROLL_DT is null");
            return (Criteria) this;
        }

        public Criteria andPayrollDtIsNotNull() {
            addCriterion("PAYROLL_DT is not null");
            return (Criteria) this;
        }

        public Criteria andPayrollDtEqualTo(Date value) {
            addCriterionForJDBCDate("PAYROLL_DT =", value, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtNotEqualTo(Date value) {
            addCriterionForJDBCDate("PAYROLL_DT <>", value, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtGreaterThan(Date value) {
            addCriterionForJDBCDate("PAYROLL_DT >", value, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PAYROLL_DT >=", value, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtLessThan(Date value) {
            addCriterionForJDBCDate("PAYROLL_DT <", value, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PAYROLL_DT <=", value, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtIn(List<Date> values) {
            addCriterionForJDBCDate("PAYROLL_DT in", values, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtNotIn(List<Date> values) {
            addCriterionForJDBCDate("PAYROLL_DT not in", values, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PAYROLL_DT between", value1, value2, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andPayrollDtNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PAYROLL_DT not between", value1, value2, "payrollDt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtIsNull() {
            addCriterion("MON_AVG_PAYROLL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtIsNotNull() {
            addCriterion("MON_AVG_PAYROLL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtEqualTo(BigDecimal value) {
            addCriterion("MON_AVG_PAYROLL_AMT =", value, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtNotEqualTo(BigDecimal value) {
            addCriterion("MON_AVG_PAYROLL_AMT <>", value, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtGreaterThan(BigDecimal value) {
            addCriterion("MON_AVG_PAYROLL_AMT >", value, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MON_AVG_PAYROLL_AMT >=", value, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtLessThan(BigDecimal value) {
            addCriterion("MON_AVG_PAYROLL_AMT <", value, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MON_AVG_PAYROLL_AMT <=", value, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtIn(List<BigDecimal> values) {
            addCriterion("MON_AVG_PAYROLL_AMT in", values, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtNotIn(List<BigDecimal> values) {
            addCriterion("MON_AVG_PAYROLL_AMT not in", values, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MON_AVG_PAYROLL_AMT between", value1, value2, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andMonAvgPayrollAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MON_AVG_PAYROLL_AMT not between", value1, value2, "monAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtIsNull() {
            addCriterion("LAST_AVG_PAYROLL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtIsNotNull() {
            addCriterion("LAST_AVG_PAYROLL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtEqualTo(BigDecimal value) {
            addCriterion("LAST_AVG_PAYROLL_AMT =", value, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtNotEqualTo(BigDecimal value) {
            addCriterion("LAST_AVG_PAYROLL_AMT <>", value, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtGreaterThan(BigDecimal value) {
            addCriterion("LAST_AVG_PAYROLL_AMT >", value, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LAST_AVG_PAYROLL_AMT >=", value, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtLessThan(BigDecimal value) {
            addCriterion("LAST_AVG_PAYROLL_AMT <", value, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LAST_AVG_PAYROLL_AMT <=", value, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtIn(List<BigDecimal> values) {
            addCriterion("LAST_AVG_PAYROLL_AMT in", values, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtNotIn(List<BigDecimal> values) {
            addCriterion("LAST_AVG_PAYROLL_AMT not in", values, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAST_AVG_PAYROLL_AMT between", value1, value2, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andLastAvgPayrollAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAST_AVG_PAYROLL_AMT not between", value1, value2, "lastAvgPayrollAmt");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitIsNull() {
            addCriterion("DAY_AVG_DPSIT is null");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitIsNotNull() {
            addCriterion("DAY_AVG_DPSIT is not null");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_DPSIT =", value, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitNotEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_DPSIT <>", value, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitGreaterThan(BigDecimal value) {
            addCriterion("DAY_AVG_DPSIT >", value, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_DPSIT >=", value, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitLessThan(BigDecimal value) {
            addCriterion("DAY_AVG_DPSIT <", value, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_DPSIT <=", value, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitIn(List<BigDecimal> values) {
            addCriterion("DAY_AVG_DPSIT in", values, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitNotIn(List<BigDecimal> values) {
            addCriterion("DAY_AVG_DPSIT not in", values, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_AVG_DPSIT between", value1, value2, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgDpsitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_AVG_DPSIT not between", value1, value2, "dayAvgDpsit");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinIsNull() {
            addCriterion("DAY_AVG_FIN is null");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinIsNotNull() {
            addCriterion("DAY_AVG_FIN is not null");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_FIN =", value, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinNotEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_FIN <>", value, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinGreaterThan(BigDecimal value) {
            addCriterion("DAY_AVG_FIN >", value, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_FIN >=", value, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinLessThan(BigDecimal value) {
            addCriterion("DAY_AVG_FIN <", value, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_FIN <=", value, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinIn(List<BigDecimal> values) {
            addCriterion("DAY_AVG_FIN in", values, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinNotIn(List<BigDecimal> values) {
            addCriterion("DAY_AVG_FIN not in", values, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_AVG_FIN between", value1, value2, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgFinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_AVG_FIN not between", value1, value2, "dayAvgFin");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetIsNull() {
            addCriterion("DAY_AVG_ASSET is null");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetIsNotNull() {
            addCriterion("DAY_AVG_ASSET is not null");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_ASSET =", value, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetNotEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_ASSET <>", value, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetGreaterThan(BigDecimal value) {
            addCriterion("DAY_AVG_ASSET >", value, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_ASSET >=", value, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetLessThan(BigDecimal value) {
            addCriterion("DAY_AVG_ASSET <", value, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_AVG_ASSET <=", value, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetIn(List<BigDecimal> values) {
            addCriterion("DAY_AVG_ASSET in", values, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetNotIn(List<BigDecimal> values) {
            addCriterion("DAY_AVG_ASSET not in", values, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_AVG_ASSET between", value1, value2, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andDayAvgAssetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_AVG_ASSET not between", value1, value2, "dayAvgAsset");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentIsNull() {
            addCriterion("STATUS_NET_LOAN_REPAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentIsNotNull() {
            addCriterion("STATUS_NET_LOAN_REPAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentEqualTo(String value) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT =", value, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentNotEqualTo(String value) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT <>", value, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentGreaterThan(String value) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT >", value, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT >=", value, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentLessThan(String value) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT <", value, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentLessThanOrEqualTo(String value) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT <=", value, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentLike(String value) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT like", value, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentNotLike(String value) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT not like", value, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentIn(List<String> values) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT in", values, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentNotIn(List<String> values) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT not in", values, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentBetween(String value1, String value2) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT between", value1, value2, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andStatusNetLoanRepaymentNotBetween(String value1, String value2) {
            addCriterion("STATUS_NET_LOAN_REPAYMENT not between", value1, value2, "statusNetLoanRepayment");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndIsNull() {
            addCriterion("THIRD_CUSTODY_SIGN_IND is null");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndIsNotNull() {
            addCriterion("THIRD_CUSTODY_SIGN_IND is not null");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndEqualTo(String value) {
            addCriterion("THIRD_CUSTODY_SIGN_IND =", value, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndNotEqualTo(String value) {
            addCriterion("THIRD_CUSTODY_SIGN_IND <>", value, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndGreaterThan(String value) {
            addCriterion("THIRD_CUSTODY_SIGN_IND >", value, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndGreaterThanOrEqualTo(String value) {
            addCriterion("THIRD_CUSTODY_SIGN_IND >=", value, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndLessThan(String value) {
            addCriterion("THIRD_CUSTODY_SIGN_IND <", value, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndLessThanOrEqualTo(String value) {
            addCriterion("THIRD_CUSTODY_SIGN_IND <=", value, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndLike(String value) {
            addCriterion("THIRD_CUSTODY_SIGN_IND like", value, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndNotLike(String value) {
            addCriterion("THIRD_CUSTODY_SIGN_IND not like", value, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndIn(List<String> values) {
            addCriterion("THIRD_CUSTODY_SIGN_IND in", values, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndNotIn(List<String> values) {
            addCriterion("THIRD_CUSTODY_SIGN_IND not in", values, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndBetween(String value1, String value2) {
            addCriterion("THIRD_CUSTODY_SIGN_IND between", value1, value2, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andThirdCustodySignIndNotBetween(String value1, String value2) {
            addCriterion("THIRD_CUSTODY_SIGN_IND not between", value1, value2, "thirdCustodySignInd");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineIsNull() {
            addCriterion("NET_CREDIT_CREDIT_LINE is null");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineIsNotNull() {
            addCriterion("NET_CREDIT_CREDIT_LINE is not null");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineEqualTo(BigDecimal value) {
            addCriterion("NET_CREDIT_CREDIT_LINE =", value, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineNotEqualTo(BigDecimal value) {
            addCriterion("NET_CREDIT_CREDIT_LINE <>", value, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineGreaterThan(BigDecimal value) {
            addCriterion("NET_CREDIT_CREDIT_LINE >", value, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NET_CREDIT_CREDIT_LINE >=", value, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineLessThan(BigDecimal value) {
            addCriterion("NET_CREDIT_CREDIT_LINE <", value, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NET_CREDIT_CREDIT_LINE <=", value, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineIn(List<BigDecimal> values) {
            addCriterion("NET_CREDIT_CREDIT_LINE in", values, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineNotIn(List<BigDecimal> values) {
            addCriterion("NET_CREDIT_CREDIT_LINE not in", values, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NET_CREDIT_CREDIT_LINE between", value1, value2, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditCreditLineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NET_CREDIT_CREDIT_LINE not between", value1, value2, "netCreditCreditLine");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateIsNull() {
            addCriterion("NET_CREDIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateIsNotNull() {
            addCriterion("NET_CREDIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateEqualTo(Date value) {
            addCriterionForJDBCDate("NET_CREDIT_DATE =", value, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("NET_CREDIT_DATE <>", value, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateGreaterThan(Date value) {
            addCriterionForJDBCDate("NET_CREDIT_DATE >", value, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("NET_CREDIT_DATE >=", value, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateLessThan(Date value) {
            addCriterionForJDBCDate("NET_CREDIT_DATE <", value, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("NET_CREDIT_DATE <=", value, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateIn(List<Date> values) {
            addCriterionForJDBCDate("NET_CREDIT_DATE in", values, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("NET_CREDIT_DATE not in", values, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("NET_CREDIT_DATE between", value1, value2, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetCreditDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("NET_CREDIT_DATE not between", value1, value2, "netCreditDate");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountIsNull() {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountIsNotNull() {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountEqualTo(BigDecimal value) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT =", value, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountNotEqualTo(BigDecimal value) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT <>", value, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountGreaterThan(BigDecimal value) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT >", value, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT >=", value, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountLessThan(BigDecimal value) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT <", value, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT <=", value, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountIn(List<BigDecimal> values) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT in", values, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountNotIn(List<BigDecimal> values) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT not in", values, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT between", value1, value2, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andNetLoanPrincipalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NET_LOAN_PRINCIPAL_AMOUNT not between", value1, value2, "netLoanPrincipalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateIsNull() {
            addCriterion("LOAN_RELEASE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateIsNotNull() {
            addCriterion("LOAN_RELEASE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateEqualTo(Date value) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE =", value, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE <>", value, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE >", value, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE >=", value, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateLessThan(Date value) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE <", value, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE <=", value, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateIn(List<Date> values) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE in", values, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE not in", values, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE between", value1, value2, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andLoanReleaseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LOAN_RELEASE_DATE not between", value1, value2, "loanReleaseDate");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeIsNull() {
            addCriterion("TIME_TO_APPLICATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeIsNotNull() {
            addCriterion("TIME_TO_APPLICATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeEqualTo(BigDecimal value) {
            addCriterion("TIME_TO_APPLICATION_TIME =", value, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeNotEqualTo(BigDecimal value) {
            addCriterion("TIME_TO_APPLICATION_TIME <>", value, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeGreaterThan(BigDecimal value) {
            addCriterion("TIME_TO_APPLICATION_TIME >", value, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME_TO_APPLICATION_TIME >=", value, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeLessThan(BigDecimal value) {
            addCriterion("TIME_TO_APPLICATION_TIME <", value, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME_TO_APPLICATION_TIME <=", value, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeIn(List<BigDecimal> values) {
            addCriterion("TIME_TO_APPLICATION_TIME in", values, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeNotIn(List<BigDecimal> values) {
            addCriterion("TIME_TO_APPLICATION_TIME not in", values, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME_TO_APPLICATION_TIME between", value1, value2, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andTimeToApplicationTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME_TO_APPLICATION_TIME not between", value1, value2, "timeToApplicationTime");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysIsNull() {
            addCriterion("CURRENT_OVERDUE_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysIsNotNull() {
            addCriterion("CURRENT_OVERDUE_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysEqualTo(BigDecimal value) {
            addCriterion("CURRENT_OVERDUE_DAYS =", value, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysNotEqualTo(BigDecimal value) {
            addCriterion("CURRENT_OVERDUE_DAYS <>", value, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysGreaterThan(BigDecimal value) {
            addCriterion("CURRENT_OVERDUE_DAYS >", value, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CURRENT_OVERDUE_DAYS >=", value, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysLessThan(BigDecimal value) {
            addCriterion("CURRENT_OVERDUE_DAYS <", value, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CURRENT_OVERDUE_DAYS <=", value, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysIn(List<BigDecimal> values) {
            addCriterion("CURRENT_OVERDUE_DAYS in", values, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysNotIn(List<BigDecimal> values) {
            addCriterion("CURRENT_OVERDUE_DAYS not in", values, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURRENT_OVERDUE_DAYS between", value1, value2, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andCurrentOverdueDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURRENT_OVERDUE_DAYS not between", value1, value2, "currentOverdueDays");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesIsNull() {
            addCriterion("HISTY_OVERDUE_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesIsNotNull() {
            addCriterion("HISTY_OVERDUE_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesEqualTo(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_TIMES =", value, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesNotEqualTo(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_TIMES <>", value, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesGreaterThan(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_TIMES >", value, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_TIMES >=", value, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesLessThan(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_TIMES <", value, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_TIMES <=", value, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesIn(List<BigDecimal> values) {
            addCriterion("HISTY_OVERDUE_TIMES in", values, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesNotIn(List<BigDecimal> values) {
            addCriterion("HISTY_OVERDUE_TIMES not in", values, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTY_OVERDUE_TIMES between", value1, value2, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueTimesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTY_OVERDUE_TIMES not between", value1, value2, "histyOverdueTimes");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberIsNull() {
            addCriterion("HISTY_OVERDUE_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberIsNotNull() {
            addCriterion("HISTY_OVERDUE_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberEqualTo(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_NUMBER =", value, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberNotEqualTo(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_NUMBER <>", value, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberGreaterThan(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_NUMBER >", value, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_NUMBER >=", value, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberLessThan(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_NUMBER <", value, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTY_OVERDUE_NUMBER <=", value, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberIn(List<BigDecimal> values) {
            addCriterion("HISTY_OVERDUE_NUMBER in", values, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberNotIn(List<BigDecimal> values) {
            addCriterion("HISTY_OVERDUE_NUMBER not in", values, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTY_OVERDUE_NUMBER between", value1, value2, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andHistyOverdueNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTY_OVERDUE_NUMBER not between", value1, value2, "histyOverdueNumber");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodIsNull() {
            addCriterion("TOTAL_LOAN_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodIsNotNull() {
            addCriterion("TOTAL_LOAN_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodEqualTo(BigDecimal value) {
            addCriterion("TOTAL_LOAN_PERIOD =", value, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_LOAN_PERIOD <>", value, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_LOAN_PERIOD >", value, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_LOAN_PERIOD >=", value, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodLessThan(BigDecimal value) {
            addCriterion("TOTAL_LOAN_PERIOD <", value, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_LOAN_PERIOD <=", value, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodIn(List<BigDecimal> values) {
            addCriterion("TOTAL_LOAN_PERIOD in", values, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_LOAN_PERIOD not in", values, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_LOAN_PERIOD between", value1, value2, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andTotalLoanPeriodNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_LOAN_PERIOD not between", value1, value2, "totalLoanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodIsNull() {
            addCriterion("LOAN_REPAYMENT_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodIsNotNull() {
            addCriterion("LOAN_REPAYMENT_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodEqualTo(BigDecimal value) {
            addCriterion("LOAN_REPAYMENT_PERIOD =", value, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_REPAYMENT_PERIOD <>", value, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodGreaterThan(BigDecimal value) {
            addCriterion("LOAN_REPAYMENT_PERIOD >", value, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_REPAYMENT_PERIOD >=", value, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodLessThan(BigDecimal value) {
            addCriterion("LOAN_REPAYMENT_PERIOD <", value, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_REPAYMENT_PERIOD <=", value, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodIn(List<BigDecimal> values) {
            addCriterion("LOAN_REPAYMENT_PERIOD in", values, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_REPAYMENT_PERIOD not in", values, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_REPAYMENT_PERIOD between", value1, value2, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanRepaymentPeriodNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_REPAYMENT_PERIOD not between", value1, value2, "loanRepaymentPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreIsNull() {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreIsNotNull() {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreEqualTo(BigDecimal value) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE =", value, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE <>", value, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreGreaterThan(BigDecimal value) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE >", value, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE >=", value, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreLessThan(BigDecimal value) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE <", value, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE <=", value, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreIn(List<BigDecimal> values) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE in", values, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE not in", values, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE between", value1, value2, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andLoanApprovalModelScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_APPROVAL_MODEL_SCORE not between", value1, value2, "loanApprovalModelScore");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndIsNull() {
            addCriterion("DPSIT_CUST_IND is null");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndIsNotNull() {
            addCriterion("DPSIT_CUST_IND is not null");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndEqualTo(String value) {
            addCriterion("DPSIT_CUST_IND =", value, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndNotEqualTo(String value) {
            addCriterion("DPSIT_CUST_IND <>", value, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndGreaterThan(String value) {
            addCriterion("DPSIT_CUST_IND >", value, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndGreaterThanOrEqualTo(String value) {
            addCriterion("DPSIT_CUST_IND >=", value, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndLessThan(String value) {
            addCriterion("DPSIT_CUST_IND <", value, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndLessThanOrEqualTo(String value) {
            addCriterion("DPSIT_CUST_IND <=", value, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndLike(String value) {
            addCriterion("DPSIT_CUST_IND like", value, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndNotLike(String value) {
            addCriterion("DPSIT_CUST_IND not like", value, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndIn(List<String> values) {
            addCriterion("DPSIT_CUST_IND in", values, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndNotIn(List<String> values) {
            addCriterion("DPSIT_CUST_IND not in", values, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndBetween(String value1, String value2) {
            addCriterion("DPSIT_CUST_IND between", value1, value2, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andDpsitCustIndNotBetween(String value1, String value2) {
            addCriterion("DPSIT_CUST_IND not between", value1, value2, "dpsitCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndIsNull() {
            addCriterion("CHREM_CUST_IND is null");
            return (Criteria) this;
        }

        public Criteria andChremCustIndIsNotNull() {
            addCriterion("CHREM_CUST_IND is not null");
            return (Criteria) this;
        }

        public Criteria andChremCustIndEqualTo(String value) {
            addCriterion("CHREM_CUST_IND =", value, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndNotEqualTo(String value) {
            addCriterion("CHREM_CUST_IND <>", value, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndGreaterThan(String value) {
            addCriterion("CHREM_CUST_IND >", value, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndGreaterThanOrEqualTo(String value) {
            addCriterion("CHREM_CUST_IND >=", value, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndLessThan(String value) {
            addCriterion("CHREM_CUST_IND <", value, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndLessThanOrEqualTo(String value) {
            addCriterion("CHREM_CUST_IND <=", value, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndLike(String value) {
            addCriterion("CHREM_CUST_IND like", value, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndNotLike(String value) {
            addCriterion("CHREM_CUST_IND not like", value, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndIn(List<String> values) {
            addCriterion("CHREM_CUST_IND in", values, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndNotIn(List<String> values) {
            addCriterion("CHREM_CUST_IND not in", values, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndBetween(String value1, String value2) {
            addCriterion("CHREM_CUST_IND between", value1, value2, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andChremCustIndNotBetween(String value1, String value2) {
            addCriterion("CHREM_CUST_IND not between", value1, value2, "chremCustInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndIsNull() {
            addCriterion("COLL_REPAY_IND is null");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndIsNotNull() {
            addCriterion("COLL_REPAY_IND is not null");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndEqualTo(String value) {
            addCriterion("COLL_REPAY_IND =", value, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndNotEqualTo(String value) {
            addCriterion("COLL_REPAY_IND <>", value, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndGreaterThan(String value) {
            addCriterion("COLL_REPAY_IND >", value, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndGreaterThanOrEqualTo(String value) {
            addCriterion("COLL_REPAY_IND >=", value, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndLessThan(String value) {
            addCriterion("COLL_REPAY_IND <", value, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndLessThanOrEqualTo(String value) {
            addCriterion("COLL_REPAY_IND <=", value, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndLike(String value) {
            addCriterion("COLL_REPAY_IND like", value, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndNotLike(String value) {
            addCriterion("COLL_REPAY_IND not like", value, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndIn(List<String> values) {
            addCriterion("COLL_REPAY_IND in", values, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndNotIn(List<String> values) {
            addCriterion("COLL_REPAY_IND not in", values, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndBetween(String value1, String value2) {
            addCriterion("COLL_REPAY_IND between", value1, value2, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCollRepayIndNotBetween(String value1, String value2) {
            addCriterion("COLL_REPAY_IND not between", value1, value2, "collRepayInd");
            return (Criteria) this;
        }

        public Criteria andCallComplRateIsNull() {
            addCriterion("CALL_COMPL_RATE is null");
            return (Criteria) this;
        }

        public Criteria andCallComplRateIsNotNull() {
            addCriterion("CALL_COMPL_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andCallComplRateEqualTo(BigDecimal value) {
            addCriterion("CALL_COMPL_RATE =", value, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCallComplRateNotEqualTo(BigDecimal value) {
            addCriterion("CALL_COMPL_RATE <>", value, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCallComplRateGreaterThan(BigDecimal value) {
            addCriterion("CALL_COMPL_RATE >", value, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCallComplRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CALL_COMPL_RATE >=", value, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCallComplRateLessThan(BigDecimal value) {
            addCriterion("CALL_COMPL_RATE <", value, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCallComplRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CALL_COMPL_RATE <=", value, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCallComplRateIn(List<BigDecimal> values) {
            addCriterion("CALL_COMPL_RATE in", values, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCallComplRateNotIn(List<BigDecimal> values) {
            addCriterion("CALL_COMPL_RATE not in", values, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCallComplRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CALL_COMPL_RATE between", value1, value2, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCallComplRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CALL_COMPL_RATE not between", value1, value2, "callComplRate");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraIsNull() {
            addCriterion("COLL_MAX_CALL_DURA is null");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraIsNotNull() {
            addCriterion("COLL_MAX_CALL_DURA is not null");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraEqualTo(String value) {
            addCriterion("COLL_MAX_CALL_DURA =", value, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraNotEqualTo(String value) {
            addCriterion("COLL_MAX_CALL_DURA <>", value, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraGreaterThan(String value) {
            addCriterion("COLL_MAX_CALL_DURA >", value, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraGreaterThanOrEqualTo(String value) {
            addCriterion("COLL_MAX_CALL_DURA >=", value, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraLessThan(String value) {
            addCriterion("COLL_MAX_CALL_DURA <", value, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraLessThanOrEqualTo(String value) {
            addCriterion("COLL_MAX_CALL_DURA <=", value, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraLike(String value) {
            addCriterion("COLL_MAX_CALL_DURA like", value, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraNotLike(String value) {
            addCriterion("COLL_MAX_CALL_DURA not like", value, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraIn(List<String> values) {
            addCriterion("COLL_MAX_CALL_DURA in", values, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraNotIn(List<String> values) {
            addCriterion("COLL_MAX_CALL_DURA not in", values, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraBetween(String value1, String value2) {
            addCriterion("COLL_MAX_CALL_DURA between", value1, value2, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andCollMaxCallDuraNotBetween(String value1, String value2) {
            addCriterion("COLL_MAX_CALL_DURA not between", value1, value2, "collMaxCallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraIsNull() {
            addCriterion("THEMAXTIMETOCALL_DURA is null");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraIsNotNull() {
            addCriterion("THEMAXTIMETOCALL_DURA is not null");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraEqualTo(String value) {
            addCriterion("THEMAXTIMETOCALL_DURA =", value, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraNotEqualTo(String value) {
            addCriterion("THEMAXTIMETOCALL_DURA <>", value, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraGreaterThan(String value) {
            addCriterion("THEMAXTIMETOCALL_DURA >", value, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraGreaterThanOrEqualTo(String value) {
            addCriterion("THEMAXTIMETOCALL_DURA >=", value, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraLessThan(String value) {
            addCriterion("THEMAXTIMETOCALL_DURA <", value, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraLessThanOrEqualTo(String value) {
            addCriterion("THEMAXTIMETOCALL_DURA <=", value, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraLike(String value) {
            addCriterion("THEMAXTIMETOCALL_DURA like", value, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraNotLike(String value) {
            addCriterion("THEMAXTIMETOCALL_DURA not like", value, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraIn(List<String> values) {
            addCriterion("THEMAXTIMETOCALL_DURA in", values, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraNotIn(List<String> values) {
            addCriterion("THEMAXTIMETOCALL_DURA not in", values, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraBetween(String value1, String value2) {
            addCriterion("THEMAXTIMETOCALL_DURA between", value1, value2, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andThemaxtimetocallDuraNotBetween(String value1, String value2) {
            addCriterion("THEMAXTIMETOCALL_DURA not between", value1, value2, "themaxtimetocallDura");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerIsNull() {
            addCriterion("OVERD_DATE_TOTAL_PER is null");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerIsNotNull() {
            addCriterion("OVERD_DATE_TOTAL_PER is not null");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerEqualTo(BigDecimal value) {
            addCriterion("OVERD_DATE_TOTAL_PER =", value, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerNotEqualTo(BigDecimal value) {
            addCriterion("OVERD_DATE_TOTAL_PER <>", value, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerGreaterThan(BigDecimal value) {
            addCriterion("OVERD_DATE_TOTAL_PER >", value, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERD_DATE_TOTAL_PER >=", value, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerLessThan(BigDecimal value) {
            addCriterion("OVERD_DATE_TOTAL_PER <", value, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERD_DATE_TOTAL_PER <=", value, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerIn(List<BigDecimal> values) {
            addCriterion("OVERD_DATE_TOTAL_PER in", values, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerNotIn(List<BigDecimal> values) {
            addCriterion("OVERD_DATE_TOTAL_PER not in", values, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERD_DATE_TOTAL_PER between", value1, value2, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andOverdDateTotalPerNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERD_DATE_TOTAL_PER not between", value1, value2, "overdDateTotalPer");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideIsNull() {
            addCriterion("CURDATE_PAYROLL_PROVIDE is null");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideIsNotNull() {
            addCriterion("CURDATE_PAYROLL_PROVIDE is not null");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideEqualTo(String value) {
            addCriterion("CURDATE_PAYROLL_PROVIDE =", value, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideNotEqualTo(String value) {
            addCriterion("CURDATE_PAYROLL_PROVIDE <>", value, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideGreaterThan(String value) {
            addCriterion("CURDATE_PAYROLL_PROVIDE >", value, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideGreaterThanOrEqualTo(String value) {
            addCriterion("CURDATE_PAYROLL_PROVIDE >=", value, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideLessThan(String value) {
            addCriterion("CURDATE_PAYROLL_PROVIDE <", value, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideLessThanOrEqualTo(String value) {
            addCriterion("CURDATE_PAYROLL_PROVIDE <=", value, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideLike(String value) {
            addCriterion("CURDATE_PAYROLL_PROVIDE like", value, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideNotLike(String value) {
            addCriterion("CURDATE_PAYROLL_PROVIDE not like", value, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideIn(List<String> values) {
            addCriterion("CURDATE_PAYROLL_PROVIDE in", values, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideNotIn(List<String> values) {
            addCriterion("CURDATE_PAYROLL_PROVIDE not in", values, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideBetween(String value1, String value2) {
            addCriterion("CURDATE_PAYROLL_PROVIDE between", value1, value2, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andCurdatePayrollProvideNotBetween(String value1, String value2) {
            addCriterion("CURDATE_PAYROLL_PROVIDE not between", value1, value2, "curdatePayrollProvide");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchIsNull() {
            addCriterion("LOAN_RATIO_MARCH is null");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchIsNotNull() {
            addCriterion("LOAN_RATIO_MARCH is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchEqualTo(BigDecimal value) {
            addCriterion("LOAN_RATIO_MARCH =", value, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_RATIO_MARCH <>", value, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchGreaterThan(BigDecimal value) {
            addCriterion("LOAN_RATIO_MARCH >", value, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_RATIO_MARCH >=", value, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchLessThan(BigDecimal value) {
            addCriterion("LOAN_RATIO_MARCH <", value, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_RATIO_MARCH <=", value, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchIn(List<BigDecimal> values) {
            addCriterion("LOAN_RATIO_MARCH in", values, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_RATIO_MARCH not in", values, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_RATIO_MARCH between", value1, value2, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andLoanRatioMarchNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_RATIO_MARCH not between", value1, value2, "loanRatioMarch");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutIsNull() {
            addCriterion("MONTH_SALARY_PAYOUT is null");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutIsNotNull() {
            addCriterion("MONTH_SALARY_PAYOUT is not null");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutEqualTo(String value) {
            addCriterion("MONTH_SALARY_PAYOUT =", value, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutNotEqualTo(String value) {
            addCriterion("MONTH_SALARY_PAYOUT <>", value, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutGreaterThan(String value) {
            addCriterion("MONTH_SALARY_PAYOUT >", value, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutGreaterThanOrEqualTo(String value) {
            addCriterion("MONTH_SALARY_PAYOUT >=", value, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutLessThan(String value) {
            addCriterion("MONTH_SALARY_PAYOUT <", value, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutLessThanOrEqualTo(String value) {
            addCriterion("MONTH_SALARY_PAYOUT <=", value, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutLike(String value) {
            addCriterion("MONTH_SALARY_PAYOUT like", value, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutNotLike(String value) {
            addCriterion("MONTH_SALARY_PAYOUT not like", value, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutIn(List<String> values) {
            addCriterion("MONTH_SALARY_PAYOUT in", values, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutNotIn(List<String> values) {
            addCriterion("MONTH_SALARY_PAYOUT not in", values, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutBetween(String value1, String value2) {
            addCriterion("MONTH_SALARY_PAYOUT between", value1, value2, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryPayoutNotBetween(String value1, String value2) {
            addCriterion("MONTH_SALARY_PAYOUT not between", value1, value2, "monthSalaryPayout");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioIsNull() {
            addCriterion("LAVG_PAY_APP_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioIsNotNull() {
            addCriterion("LAVG_PAY_APP_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioEqualTo(BigDecimal value) {
            addCriterion("LAVG_PAY_APP_RATIO =", value, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioNotEqualTo(BigDecimal value) {
            addCriterion("LAVG_PAY_APP_RATIO <>", value, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioGreaterThan(BigDecimal value) {
            addCriterion("LAVG_PAY_APP_RATIO >", value, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LAVG_PAY_APP_RATIO >=", value, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioLessThan(BigDecimal value) {
            addCriterion("LAVG_PAY_APP_RATIO <", value, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LAVG_PAY_APP_RATIO <=", value, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioIn(List<BigDecimal> values) {
            addCriterion("LAVG_PAY_APP_RATIO in", values, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioNotIn(List<BigDecimal> values) {
            addCriterion("LAVG_PAY_APP_RATIO not in", values, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAVG_PAY_APP_RATIO between", value1, value2, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andLavgPayAppRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAVG_PAY_APP_RATIO not between", value1, value2, "lavgPayAppRatio");
            return (Criteria) this;
        }

        public Criteria andBaseLineIsNull() {
            addCriterion("BASE_LINE is null");
            return (Criteria) this;
        }

        public Criteria andBaseLineIsNotNull() {
            addCriterion("BASE_LINE is not null");
            return (Criteria) this;
        }

        public Criteria andBaseLineEqualTo(BigDecimal value) {
            addCriterion("BASE_LINE =", value, "baseLine");
            return (Criteria) this;
        }

        public Criteria andBaseLineNotEqualTo(BigDecimal value) {
            addCriterion("BASE_LINE <>", value, "baseLine");
            return (Criteria) this;
        }

        public Criteria andBaseLineGreaterThan(BigDecimal value) {
            addCriterion("BASE_LINE >", value, "baseLine");
            return (Criteria) this;
        }

        public Criteria andBaseLineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_LINE >=", value, "baseLine");
            return (Criteria) this;
        }

        public Criteria andBaseLineLessThan(BigDecimal value) {
            addCriterion("BASE_LINE <", value, "baseLine");
            return (Criteria) this;
        }

        public Criteria andBaseLineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_LINE <=", value, "baseLine");
            return (Criteria) this;
        }

        public Criteria andBaseLineIn(List<BigDecimal> values) {
            addCriterion("BASE_LINE in", values, "baseLine");
            return (Criteria) this;
        }

        public Criteria andBaseLineNotIn(List<BigDecimal> values) {
            addCriterion("BASE_LINE not in", values, "baseLine");
            return (Criteria) this;
        }

        public Criteria andBaseLineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_LINE between", value1, value2, "baseLine");
            return (Criteria) this;
        }

        public Criteria andBaseLineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_LINE not between", value1, value2, "baseLine");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsIsNull() {
            addCriterion("AMOUNT_ASSETS is null");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsIsNotNull() {
            addCriterion("AMOUNT_ASSETS is not null");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_ASSETS =", value, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_ASSETS <>", value, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT_ASSETS >", value, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_ASSETS >=", value, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsLessThan(BigDecimal value) {
            addCriterion("AMOUNT_ASSETS <", value, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT_ASSETS <=", value, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_ASSETS in", values, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT_ASSETS not in", values, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_ASSETS between", value1, value2, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andAmountAssetsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT_ASSETS not between", value1, value2, "amountAssets");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentIsNull() {
            addCriterion("QUOTA_ADJUSTMENT is null");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentIsNotNull() {
            addCriterion("QUOTA_ADJUSTMENT is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentEqualTo(BigDecimal value) {
            addCriterion("QUOTA_ADJUSTMENT =", value, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentNotEqualTo(BigDecimal value) {
            addCriterion("QUOTA_ADJUSTMENT <>", value, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentGreaterThan(BigDecimal value) {
            addCriterion("QUOTA_ADJUSTMENT >", value, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUOTA_ADJUSTMENT >=", value, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentLessThan(BigDecimal value) {
            addCriterion("QUOTA_ADJUSTMENT <", value, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUOTA_ADJUSTMENT <=", value, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentIn(List<BigDecimal> values) {
            addCriterion("QUOTA_ADJUSTMENT in", values, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentNotIn(List<BigDecimal> values) {
            addCriterion("QUOTA_ADJUSTMENT not in", values, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUOTA_ADJUSTMENT between", value1, value2, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andQuotaAdjustmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUOTA_ADJUSTMENT not between", value1, value2, "quotaAdjustment");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountIsNull() {
            addCriterion("SALARY_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountIsNotNull() {
            addCriterion("SALARY_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountEqualTo(BigDecimal value) {
            addCriterion("SALARY_AMOUNT =", value, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountNotEqualTo(BigDecimal value) {
            addCriterion("SALARY_AMOUNT <>", value, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountGreaterThan(BigDecimal value) {
            addCriterion("SALARY_AMOUNT >", value, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALARY_AMOUNT >=", value, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountLessThan(BigDecimal value) {
            addCriterion("SALARY_AMOUNT <", value, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALARY_AMOUNT <=", value, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountIn(List<BigDecimal> values) {
            addCriterion("SALARY_AMOUNT in", values, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountNotIn(List<BigDecimal> values) {
            addCriterion("SALARY_AMOUNT not in", values, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALARY_AMOUNT between", value1, value2, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andSalaryAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALARY_AMOUNT not between", value1, value2, "salaryAmount");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientIsNull() {
            addCriterion("QUOTA_COEFFICIENT is null");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientIsNotNull() {
            addCriterion("QUOTA_COEFFICIENT is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientEqualTo(BigDecimal value) {
            addCriterion("QUOTA_COEFFICIENT =", value, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("QUOTA_COEFFICIENT <>", value, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientGreaterThan(BigDecimal value) {
            addCriterion("QUOTA_COEFFICIENT >", value, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUOTA_COEFFICIENT >=", value, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientLessThan(BigDecimal value) {
            addCriterion("QUOTA_COEFFICIENT <", value, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUOTA_COEFFICIENT <=", value, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientIn(List<BigDecimal> values) {
            addCriterion("QUOTA_COEFFICIENT in", values, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("QUOTA_COEFFICIENT not in", values, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUOTA_COEFFICIENT between", value1, value2, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andQuotaCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUOTA_COEFFICIENT not between", value1, value2, "quotaCoefficient");
            return (Criteria) this;
        }

        public Criteria andCreditLineIsNull() {
            addCriterion("CREDIT_LINE is null");
            return (Criteria) this;
        }

        public Criteria andCreditLineIsNotNull() {
            addCriterion("CREDIT_LINE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditLineEqualTo(BigDecimal value) {
            addCriterion("CREDIT_LINE =", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_LINE <>", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_LINE >", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_LINE >=", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineLessThan(BigDecimal value) {
            addCriterion("CREDIT_LINE <", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_LINE <=", value, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineIn(List<BigDecimal> values) {
            addCriterion("CREDIT_LINE in", values, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_LINE not in", values, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_LINE between", value1, value2, "creditLine");
            return (Criteria) this;
        }

        public Criteria andCreditLineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_LINE not between", value1, value2, "creditLine");
            return (Criteria) this;
        }

        public Criteria andQuotaIsNull() {
            addCriterion("QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andQuotaIsNotNull() {
            addCriterion("QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaEqualTo(BigDecimal value) {
            addCriterion("QUOTA =", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotEqualTo(BigDecimal value) {
            addCriterion("QUOTA <>", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThan(BigDecimal value) {
            addCriterion("QUOTA >", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUOTA >=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThan(BigDecimal value) {
            addCriterion("QUOTA <", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUOTA <=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaIn(List<BigDecimal> values) {
            addCriterion("QUOTA in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotIn(List<BigDecimal> values) {
            addCriterion("QUOTA not in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUOTA between", value1, value2, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUOTA not between", value1, value2, "quota");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustIsNull() {
            addCriterion("RATE_INTERNET_CUST is null");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustIsNotNull() {
            addCriterion("RATE_INTERNET_CUST is not null");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustEqualTo(BigDecimal value) {
            addCriterion("RATE_INTERNET_CUST =", value, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustNotEqualTo(BigDecimal value) {
            addCriterion("RATE_INTERNET_CUST <>", value, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustGreaterThan(BigDecimal value) {
            addCriterion("RATE_INTERNET_CUST >", value, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE_INTERNET_CUST >=", value, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustLessThan(BigDecimal value) {
            addCriterion("RATE_INTERNET_CUST <", value, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE_INTERNET_CUST <=", value, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustIn(List<BigDecimal> values) {
            addCriterion("RATE_INTERNET_CUST in", values, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustNotIn(List<BigDecimal> values) {
            addCriterion("RATE_INTERNET_CUST not in", values, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE_INTERNET_CUST between", value1, value2, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateInternetCustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE_INTERNET_CUST not between", value1, value2, "rateInternetCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustIsNull() {
            addCriterion("RATE_WHITELIST_CUST is null");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustIsNotNull() {
            addCriterion("RATE_WHITELIST_CUST is not null");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustEqualTo(BigDecimal value) {
            addCriterion("RATE_WHITELIST_CUST =", value, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustNotEqualTo(BigDecimal value) {
            addCriterion("RATE_WHITELIST_CUST <>", value, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustGreaterThan(BigDecimal value) {
            addCriterion("RATE_WHITELIST_CUST >", value, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE_WHITELIST_CUST >=", value, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustLessThan(BigDecimal value) {
            addCriterion("RATE_WHITELIST_CUST <", value, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE_WHITELIST_CUST <=", value, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustIn(List<BigDecimal> values) {
            addCriterion("RATE_WHITELIST_CUST in", values, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustNotIn(List<BigDecimal> values) {
            addCriterion("RATE_WHITELIST_CUST not in", values, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE_WHITELIST_CUST between", value1, value2, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andRateWhitelistCustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE_WHITELIST_CUST not between", value1, value2, "rateWhitelistCust");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagIsNull() {
            addCriterion("BLACKLIST_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagIsNotNull() {
            addCriterion("BLACKLIST_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagEqualTo(String value) {
            addCriterion("BLACKLIST_FLAG =", value, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagNotEqualTo(String value) {
            addCriterion("BLACKLIST_FLAG <>", value, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagGreaterThan(String value) {
            addCriterion("BLACKLIST_FLAG >", value, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagGreaterThanOrEqualTo(String value) {
            addCriterion("BLACKLIST_FLAG >=", value, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagLessThan(String value) {
            addCriterion("BLACKLIST_FLAG <", value, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagLessThanOrEqualTo(String value) {
            addCriterion("BLACKLIST_FLAG <=", value, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagLike(String value) {
            addCriterion("BLACKLIST_FLAG like", value, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagNotLike(String value) {
            addCriterion("BLACKLIST_FLAG not like", value, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagIn(List<String> values) {
            addCriterion("BLACKLIST_FLAG in", values, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagNotIn(List<String> values) {
            addCriterion("BLACKLIST_FLAG not in", values, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagBetween(String value1, String value2) {
            addCriterion("BLACKLIST_FLAG between", value1, value2, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andBlacklistFlagNotBetween(String value1, String value2) {
            addCriterion("BLACKLIST_FLAG not between", value1, value2, "blacklistFlag");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioIsNull() {
            addCriterion("DISAMOUNTCREDITLIMITRATIO is null");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioIsNotNull() {
            addCriterion("DISAMOUNTCREDITLIMITRATIO is not null");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioEqualTo(BigDecimal value) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO =", value, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioNotEqualTo(BigDecimal value) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO <>", value, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioGreaterThan(BigDecimal value) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO >", value, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO >=", value, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioLessThan(BigDecimal value) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO <", value, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO <=", value, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioIn(List<BigDecimal> values) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO in", values, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioNotIn(List<BigDecimal> values) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO not in", values, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO between", value1, value2, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDisamountcreditlimitratioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISAMOUNTCREDITLIMITRATIO not between", value1, value2, "disamountcreditlimitratio");
            return (Criteria) this;
        }

        public Criteria andDubilNumberIsNull() {
            addCriterion("DUBIL_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andDubilNumberIsNotNull() {
            addCriterion("DUBIL_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andDubilNumberEqualTo(String value) {
            addCriterion("DUBIL_NUMBER =", value, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberNotEqualTo(String value) {
            addCriterion("DUBIL_NUMBER <>", value, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberGreaterThan(String value) {
            addCriterion("DUBIL_NUMBER >", value, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberGreaterThanOrEqualTo(String value) {
            addCriterion("DUBIL_NUMBER >=", value, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberLessThan(String value) {
            addCriterion("DUBIL_NUMBER <", value, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberLessThanOrEqualTo(String value) {
            addCriterion("DUBIL_NUMBER <=", value, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberLike(String value) {
            addCriterion("DUBIL_NUMBER like", value, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberNotLike(String value) {
            addCriterion("DUBIL_NUMBER not like", value, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberIn(List<String> values) {
            addCriterion("DUBIL_NUMBER in", values, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberNotIn(List<String> values) {
            addCriterion("DUBIL_NUMBER not in", values, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberBetween(String value1, String value2) {
            addCriterion("DUBIL_NUMBER between", value1, value2, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andDubilNumberNotBetween(String value1, String value2) {
            addCriterion("DUBIL_NUMBER not between", value1, value2, "dubilNumber");
            return (Criteria) this;
        }

        public Criteria andInputtimeIsNull() {
            addCriterion("INPUTTIME is null");
            return (Criteria) this;
        }

        public Criteria andInputtimeIsNotNull() {
            addCriterion("INPUTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andInputtimeEqualTo(Date value) {
            addCriterionForJDBCDate("INPUTTIME =", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("INPUTTIME <>", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("INPUTTIME >", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INPUTTIME >=", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeLessThan(Date value) {
            addCriterionForJDBCDate("INPUTTIME <", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INPUTTIME <=", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeIn(List<Date> values) {
            addCriterionForJDBCDate("INPUTTIME in", values, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("INPUTTIME not in", values, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INPUTTIME between", value1, value2, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INPUTTIME not between", value1, value2, "inputtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndIsNull() {
            addCriterion("LOAN_OVDUE_IND is null");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndIsNotNull() {
            addCriterion("LOAN_OVDUE_IND is not null");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndEqualTo(String value) {
            addCriterion("LOAN_OVDUE_IND =", value, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndNotEqualTo(String value) {
            addCriterion("LOAN_OVDUE_IND <>", value, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndGreaterThan(String value) {
            addCriterion("LOAN_OVDUE_IND >", value, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_OVDUE_IND >=", value, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndLessThan(String value) {
            addCriterion("LOAN_OVDUE_IND <", value, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndLessThanOrEqualTo(String value) {
            addCriterion("LOAN_OVDUE_IND <=", value, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndLike(String value) {
            addCriterion("LOAN_OVDUE_IND like", value, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndNotLike(String value) {
            addCriterion("LOAN_OVDUE_IND not like", value, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndIn(List<String> values) {
            addCriterion("LOAN_OVDUE_IND in", values, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndNotIn(List<String> values) {
            addCriterion("LOAN_OVDUE_IND not in", values, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndBetween(String value1, String value2) {
            addCriterion("LOAN_OVDUE_IND between", value1, value2, "loanOvdueInd");
            return (Criteria) this;
        }

        public Criteria andLoanOvdueIndNotBetween(String value1, String value2) {
            addCriterion("LOAN_OVDUE_IND not between", value1, value2, "loanOvdueInd");
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