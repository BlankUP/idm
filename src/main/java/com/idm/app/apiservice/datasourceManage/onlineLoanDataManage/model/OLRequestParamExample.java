package com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model;

import java.util.ArrayList;
import java.util.List;

public class OLRequestParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OLRequestParamExample() {
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

        public Criteria andServerCodeIsNull() {
            addCriterion("SERVER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andServerCodeIsNotNull() {
            addCriterion("SERVER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andServerCodeEqualTo(String value) {
            addCriterion("SERVER_CODE =", value, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeNotEqualTo(String value) {
            addCriterion("SERVER_CODE <>", value, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeGreaterThan(String value) {
            addCriterion("SERVER_CODE >", value, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_CODE >=", value, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeLessThan(String value) {
            addCriterion("SERVER_CODE <", value, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeLessThanOrEqualTo(String value) {
            addCriterion("SERVER_CODE <=", value, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeLike(String value) {
            addCriterion("SERVER_CODE like", value, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeNotLike(String value) {
            addCriterion("SERVER_CODE not like", value, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeIn(List<String> values) {
            addCriterion("SERVER_CODE in", values, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeNotIn(List<String> values) {
            addCriterion("SERVER_CODE not in", values, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeBetween(String value1, String value2) {
            addCriterion("SERVER_CODE between", value1, value2, "serverCode");
            return (Criteria) this;
        }

        public Criteria andServerCodeNotBetween(String value1, String value2) {
            addCriterion("SERVER_CODE not between", value1, value2, "serverCode");
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

        public Criteria andQuerySystemCodeIsNull() {
            addCriterion("QUERY_SYSTEM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeIsNotNull() {
            addCriterion("QUERY_SYSTEM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeEqualTo(String value) {
            addCriterion("QUERY_SYSTEM_CODE =", value, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeNotEqualTo(String value) {
            addCriterion("QUERY_SYSTEM_CODE <>", value, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeGreaterThan(String value) {
            addCriterion("QUERY_SYSTEM_CODE >", value, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("QUERY_SYSTEM_CODE >=", value, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeLessThan(String value) {
            addCriterion("QUERY_SYSTEM_CODE <", value, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeLessThanOrEqualTo(String value) {
            addCriterion("QUERY_SYSTEM_CODE <=", value, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeLike(String value) {
            addCriterion("QUERY_SYSTEM_CODE like", value, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeNotLike(String value) {
            addCriterion("QUERY_SYSTEM_CODE not like", value, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeIn(List<String> values) {
            addCriterion("QUERY_SYSTEM_CODE in", values, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeNotIn(List<String> values) {
            addCriterion("QUERY_SYSTEM_CODE not in", values, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeBetween(String value1, String value2) {
            addCriterion("QUERY_SYSTEM_CODE between", value1, value2, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andQuerySystemCodeNotBetween(String value1, String value2) {
            addCriterion("QUERY_SYSTEM_CODE not between", value1, value2, "querySystemCode");
            return (Criteria) this;
        }

        public Criteria andCustNoIsNull() {
            addCriterion("CUST_NO is null");
            return (Criteria) this;
        }

        public Criteria andCustNoIsNotNull() {
            addCriterion("CUST_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCustNoEqualTo(String value) {
            addCriterion("CUST_NO =", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotEqualTo(String value) {
            addCriterion("CUST_NO <>", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoGreaterThan(String value) {
            addCriterion("CUST_NO >", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NO >=", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLessThan(String value) {
            addCriterion("CUST_NO <", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLessThanOrEqualTo(String value) {
            addCriterion("CUST_NO <=", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLike(String value) {
            addCriterion("CUST_NO like", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotLike(String value) {
            addCriterion("CUST_NO not like", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoIn(List<String> values) {
            addCriterion("CUST_NO in", values, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotIn(List<String> values) {
            addCriterion("CUST_NO not in", values, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoBetween(String value1, String value2) {
            addCriterion("CUST_NO between", value1, value2, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotBetween(String value1, String value2) {
            addCriterion("CUST_NO not between", value1, value2, "custNo");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNull() {
            addCriterion("ID_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNotNull() {
            addCriterion("ID_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeEqualTo(String value) {
            addCriterion("ID_TYPE =", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotEqualTo(String value) {
            addCriterion("ID_TYPE <>", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThan(String value) {
            addCriterion("ID_TYPE >", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ID_TYPE >=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThan(String value) {
            addCriterion("ID_TYPE <", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThanOrEqualTo(String value) {
            addCriterion("ID_TYPE <=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLike(String value) {
            addCriterion("ID_TYPE like", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotLike(String value) {
            addCriterion("ID_TYPE not like", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeIn(List<String> values) {
            addCriterion("ID_TYPE in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotIn(List<String> values) {
            addCriterion("ID_TYPE not in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeBetween(String value1, String value2) {
            addCriterion("ID_TYPE between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotBetween(String value1, String value2) {
            addCriterion("ID_TYPE not between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("ID_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("ID_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("ID_NUMBER =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("ID_NUMBER <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("ID_NUMBER >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ID_NUMBER >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("ID_NUMBER <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("ID_NUMBER <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("ID_NUMBER like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("ID_NUMBER not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("ID_NUMBER in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("ID_NUMBER not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("ID_NUMBER between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("ID_NUMBER not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIsNull() {
            addCriterion("PHONE_NO is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIsNotNull() {
            addCriterion("PHONE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoEqualTo(String value) {
            addCriterion("PHONE_NO =", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotEqualTo(String value) {
            addCriterion("PHONE_NO <>", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThan(String value) {
            addCriterion("PHONE_NO >", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_NO >=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThan(String value) {
            addCriterion("PHONE_NO <", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThanOrEqualTo(String value) {
            addCriterion("PHONE_NO <=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLike(String value) {
            addCriterion("PHONE_NO like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotLike(String value) {
            addCriterion("PHONE_NO not like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIn(List<String> values) {
            addCriterion("PHONE_NO in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotIn(List<String> values) {
            addCriterion("PHONE_NO not in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoBetween(String value1, String value2) {
            addCriterion("PHONE_NO between", value1, value2, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotBetween(String value1, String value2) {
            addCriterion("PHONE_NO not between", value1, value2, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("PRODUCT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("PRODUCT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("PRODUCT_CODE =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("PRODUCT_CODE <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("PRODUCT_CODE >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("PRODUCT_CODE <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("PRODUCT_CODE like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("PRODUCT_CODE not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("PRODUCT_CODE in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("PRODUCT_CODE not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("PRODUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("PRODUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("PRODUCT_NAME =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("PRODUCT_NAME <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("PRODUCT_NAME >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("PRODUCT_NAME <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("PRODUCT_NAME like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("PRODUCT_NAME not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("PRODUCT_NAME in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("PRODUCT_NAME not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeIsNull() {
            addCriterion("AUTHORIZATION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeIsNotNull() {
            addCriterion("AUTHORIZATION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeEqualTo(String value) {
            addCriterion("AUTHORIZATION_CODE =", value, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeNotEqualTo(String value) {
            addCriterion("AUTHORIZATION_CODE <>", value, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeGreaterThan(String value) {
            addCriterion("AUTHORIZATION_CODE >", value, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORIZATION_CODE >=", value, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeLessThan(String value) {
            addCriterion("AUTHORIZATION_CODE <", value, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeLessThanOrEqualTo(String value) {
            addCriterion("AUTHORIZATION_CODE <=", value, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeLike(String value) {
            addCriterion("AUTHORIZATION_CODE like", value, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeNotLike(String value) {
            addCriterion("AUTHORIZATION_CODE not like", value, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeIn(List<String> values) {
            addCriterion("AUTHORIZATION_CODE in", values, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeNotIn(List<String> values) {
            addCriterion("AUTHORIZATION_CODE not in", values, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeBetween(String value1, String value2) {
            addCriterion("AUTHORIZATION_CODE between", value1, value2, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationCodeNotBetween(String value1, String value2) {
            addCriterion("AUTHORIZATION_CODE not between", value1, value2, "authorizationCode");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoIsNull() {
            addCriterion("LOCAL_SEQ_NO is null");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoIsNotNull() {
            addCriterion("LOCAL_SEQ_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoEqualTo(String value) {
            addCriterion("LOCAL_SEQ_NO =", value, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoNotEqualTo(String value) {
            addCriterion("LOCAL_SEQ_NO <>", value, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoGreaterThan(String value) {
            addCriterion("LOCAL_SEQ_NO >", value, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoGreaterThanOrEqualTo(String value) {
            addCriterion("LOCAL_SEQ_NO >=", value, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoLessThan(String value) {
            addCriterion("LOCAL_SEQ_NO <", value, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoLessThanOrEqualTo(String value) {
            addCriterion("LOCAL_SEQ_NO <=", value, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoLike(String value) {
            addCriterion("LOCAL_SEQ_NO like", value, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoNotLike(String value) {
            addCriterion("LOCAL_SEQ_NO not like", value, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoIn(List<String> values) {
            addCriterion("LOCAL_SEQ_NO in", values, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoNotIn(List<String> values) {
            addCriterion("LOCAL_SEQ_NO not in", values, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoBetween(String value1, String value2) {
            addCriterion("LOCAL_SEQ_NO between", value1, value2, "localSeqNo");
            return (Criteria) this;
        }

        public Criteria andLocalSeqNoNotBetween(String value1, String value2) {
            addCriterion("LOCAL_SEQ_NO not between", value1, value2, "localSeqNo");
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