package com.idm.app.ruleengine.modelManage.modelMonitor.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VScoreModelDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VScoreModelDataExample() {
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

        public Criteria andCreditMoneyIsNull() {
            addCriterion("CREDIT_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyIsNotNull() {
            addCriterion("CREDIT_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyEqualTo(BigDecimal value) {
            addCriterion("CREDIT_MONEY =", value, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_MONEY <>", value, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_MONEY >", value, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_MONEY >=", value, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyLessThan(BigDecimal value) {
            addCriterion("CREDIT_MONEY <", value, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_MONEY <=", value, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyIn(List<BigDecimal> values) {
            addCriterion("CREDIT_MONEY in", values, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_MONEY not in", values, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_MONEY between", value1, value2, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andCreditMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_MONEY not between", value1, value2, "creditMoney");
            return (Criteria) this;
        }

        public Criteria andDayRateIsNull() {
            addCriterion("DAY_RATE is null");
            return (Criteria) this;
        }

        public Criteria andDayRateIsNotNull() {
            addCriterion("DAY_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andDayRateEqualTo(BigDecimal value) {
            addCriterion("DAY_RATE =", value, "dayRate");
            return (Criteria) this;
        }

        public Criteria andDayRateNotEqualTo(BigDecimal value) {
            addCriterion("DAY_RATE <>", value, "dayRate");
            return (Criteria) this;
        }

        public Criteria andDayRateGreaterThan(BigDecimal value) {
            addCriterion("DAY_RATE >", value, "dayRate");
            return (Criteria) this;
        }

        public Criteria andDayRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_RATE >=", value, "dayRate");
            return (Criteria) this;
        }

        public Criteria andDayRateLessThan(BigDecimal value) {
            addCriterion("DAY_RATE <", value, "dayRate");
            return (Criteria) this;
        }

        public Criteria andDayRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_RATE <=", value, "dayRate");
            return (Criteria) this;
        }

        public Criteria andDayRateIn(List<BigDecimal> values) {
            addCriterion("DAY_RATE in", values, "dayRate");
            return (Criteria) this;
        }

        public Criteria andDayRateNotIn(List<BigDecimal> values) {
            addCriterion("DAY_RATE not in", values, "dayRate");
            return (Criteria) this;
        }

        public Criteria andDayRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_RATE between", value1, value2, "dayRate");
            return (Criteria) this;
        }

        public Criteria andDayRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_RATE not between", value1, value2, "dayRate");
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

        public Criteria andCreditScoreIsNull() {
            addCriterion("CREDIT_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andCreditScoreIsNotNull() {
            addCriterion("CREDIT_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditScoreEqualTo(Long value) {
            addCriterion("CREDIT_SCORE =", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreNotEqualTo(Long value) {
            addCriterion("CREDIT_SCORE <>", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreGreaterThan(Long value) {
            addCriterion("CREDIT_SCORE >", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("CREDIT_SCORE >=", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreLessThan(Long value) {
            addCriterion("CREDIT_SCORE <", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreLessThanOrEqualTo(Long value) {
            addCriterion("CREDIT_SCORE <=", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreIn(List<Long> values) {
            addCriterion("CREDIT_SCORE in", values, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreNotIn(List<Long> values) {
            addCriterion("CREDIT_SCORE not in", values, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreBetween(Long value1, Long value2) {
            addCriterion("CREDIT_SCORE between", value1, value2, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreNotBetween(Long value1, Long value2) {
            addCriterion("CREDIT_SCORE not between", value1, value2, "creditScore");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNull() {
            addCriterion("DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNotNull() {
            addCriterion("DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDateTimeEqualTo(String value) {
            addCriterion("DATE_TIME =", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotEqualTo(String value) {
            addCriterion("DATE_TIME <>", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThan(String value) {
            addCriterion("DATE_TIME >", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("DATE_TIME >=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThan(String value) {
            addCriterion("DATE_TIME <", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThanOrEqualTo(String value) {
            addCriterion("DATE_TIME <=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLike(String value) {
            addCriterion("DATE_TIME like", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotLike(String value) {
            addCriterion("DATE_TIME not like", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeIn(List<String> values) {
            addCriterion("DATE_TIME in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotIn(List<String> values) {
            addCriterion("DATE_TIME not in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeBetween(String value1, String value2) {
            addCriterion("DATE_TIME between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotBetween(String value1, String value2) {
            addCriterion("DATE_TIME not between", value1, value2, "dateTime");
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