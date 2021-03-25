package com.idm.app.system.login.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IDMUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IDMUserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USERID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USERID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USERID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USERID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USERID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USERID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USERNAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USERNAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USERNAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USERNAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USERNAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("USERPWD is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("USERPWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("USERPWD =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("USERPWD <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("USERPWD >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("USERPWD >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("USERPWD <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("USERPWD <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("USERPWD like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("USERPWD not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("USERPWD in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("USERPWD not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("USERPWD between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("USERPWD not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagIsNull() {
            addCriterion("PWDINITFLAG is null");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagIsNotNull() {
            addCriterion("PWDINITFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagEqualTo(String value) {
            addCriterion("PWDINITFLAG =", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagNotEqualTo(String value) {
            addCriterion("PWDINITFLAG <>", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagGreaterThan(String value) {
            addCriterion("PWDINITFLAG >", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagGreaterThanOrEqualTo(String value) {
            addCriterion("PWDINITFLAG >=", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagLessThan(String value) {
            addCriterion("PWDINITFLAG <", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagLessThanOrEqualTo(String value) {
            addCriterion("PWDINITFLAG <=", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagLike(String value) {
            addCriterion("PWDINITFLAG like", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagNotLike(String value) {
            addCriterion("PWDINITFLAG not like", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagIn(List<String> values) {
            addCriterion("PWDINITFLAG in", values, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagNotIn(List<String> values) {
            addCriterion("PWDINITFLAG not in", values, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagBetween(String value1, String value2) {
            addCriterion("PWDINITFLAG between", value1, value2, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagNotBetween(String value1, String value2) {
            addCriterion("PWDINITFLAG not between", value1, value2, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("USERSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("USERSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(String value) {
            addCriterion("USERSTATUS =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(String value) {
            addCriterion("USERSTATUS <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(String value) {
            addCriterion("USERSTATUS >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(String value) {
            addCriterion("USERSTATUS >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(String value) {
            addCriterion("USERSTATUS <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(String value) {
            addCriterion("USERSTATUS <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLike(String value) {
            addCriterion("USERSTATUS like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotLike(String value) {
            addCriterion("USERSTATUS not like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<String> values) {
            addCriterion("USERSTATUS in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<String> values) {
            addCriterion("USERSTATUS not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(String value1, String value2) {
            addCriterion("USERSTATUS between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(String value1, String value2) {
            addCriterion("USERSTATUS not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andLoginTokenIsNull() {
            addCriterion("LOGINTOKEN is null");
            return (Criteria) this;
        }

        public Criteria andLoginTokenIsNotNull() {
            addCriterion("LOGINTOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTokenEqualTo(String value) {
            addCriterion("LOGINTOKEN =", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotEqualTo(String value) {
            addCriterion("LOGINTOKEN <>", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenGreaterThan(String value) {
            addCriterion("LOGINTOKEN >", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenGreaterThanOrEqualTo(String value) {
            addCriterion("LOGINTOKEN >=", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenLessThan(String value) {
            addCriterion("LOGINTOKEN <", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenLessThanOrEqualTo(String value) {
            addCriterion("LOGINTOKEN <=", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenLike(String value) {
            addCriterion("LOGINTOKEN like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotLike(String value) {
            addCriterion("LOGINTOKEN not like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenIn(List<String> values) {
            addCriterion("LOGINTOKEN in", values, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotIn(List<String> values) {
            addCriterion("LOGINTOKEN not in", values, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenBetween(String value1, String value2) {
            addCriterion("LOGINTOKEN between", value1, value2, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotBetween(String value1, String value2) {
            addCriterion("LOGINTOKEN not between", value1, value2, "loginToken");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeIsNull() {
            addCriterion("TOKENFAILURETIME is null");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeIsNotNull() {
            addCriterion("TOKENFAILURETIME is not null");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeEqualTo(Date value) {
            addCriterionForJDBCDate("TOKENFAILURETIME =", value, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("TOKENFAILURETIME <>", value, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("TOKENFAILURETIME >", value, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TOKENFAILURETIME >=", value, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeLessThan(Date value) {
            addCriterionForJDBCDate("TOKENFAILURETIME <", value, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TOKENFAILURETIME <=", value, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeIn(List<Date> values) {
            addCriterionForJDBCDate("TOKENFAILURETIME in", values, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("TOKENFAILURETIME not in", values, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TOKENFAILURETIME between", value1, value2, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andTokenFailureTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TOKENFAILURETIME not between", value1, value2, "tokenFailureTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATETIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATETIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATEUSER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATEUSER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATEUSER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEUSER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATEUSER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATEUSER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATEUSER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATEUSER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATEUSER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATEUSER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATEUSER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATEUSER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATEUSER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATEUSER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATEUSER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATEUSER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATEUSER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATEUSER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATEUSER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATEUSER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATEUSER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATEUSER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATEUSER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATEUSER not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeIsNull() {
            addCriterion("PWDUPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeIsNotNull() {
            addCriterion("PWDUPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("PWDUPDATETIME =", value, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("PWDUPDATETIME <>", value, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("PWDUPDATETIME >", value, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PWDUPDATETIME >=", value, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("PWDUPDATETIME <", value, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PWDUPDATETIME <=", value, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("PWDUPDATETIME in", values, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("PWDUPDATETIME not in", values, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PWDUPDATETIME between", value1, value2, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPwdUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PWDUPDATETIME not between", value1, value2, "pwdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDepNoIsNull() {
            addCriterion("DEPNO is null");
            return (Criteria) this;
        }

        public Criteria andDepNoIsNotNull() {
            addCriterion("DEPNO is not null");
            return (Criteria) this;
        }

        public Criteria andDepNoEqualTo(String value) {
            addCriterion("DEPNO =", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoNotEqualTo(String value) {
            addCriterion("DEPNO <>", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoGreaterThan(String value) {
            addCriterion("DEPNO >", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoGreaterThanOrEqualTo(String value) {
            addCriterion("DEPNO >=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoLessThan(String value) {
            addCriterion("DEPNO <", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoLessThanOrEqualTo(String value) {
            addCriterion("DEPNO <=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoLike(String value) {
            addCriterion("DEPNO like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoNotLike(String value) {
            addCriterion("DEPNO not like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoIn(List<String> values) {
            addCriterion("DEPNO in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoNotIn(List<String> values) {
            addCriterion("DEPNO not in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoBetween(String value1, String value2) {
            addCriterion("DEPNO between", value1, value2, "orgNo");
            return (Criteria) this;
        }

        public Criteria andDepNoNotBetween(String value1, String value2) {
            addCriterion("DEPNO not between", value1, value2, "orgNo");
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