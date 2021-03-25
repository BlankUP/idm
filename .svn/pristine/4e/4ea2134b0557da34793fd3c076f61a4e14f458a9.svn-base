package com.idm.common.util;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.idm.app.system.auth.service.Auth;

public class AuthTagUtil extends TagSupport {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(AuthTagUtil.class);
	
	private String check;
	
    public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	@Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext=pageContext;
    }
    
    @Override
    public int doStartTag() throws JspException {
    	logger.info("权限检查，功能id：" + check);
    	if("root".equals(Auth.getUser())) {
    		return Tag.EVAL_BODY_INCLUDE;
    	}
    	List<String> authList = Auth.getAuthList();
    	if(authList !=null && authList.contains(check)) {
    		return Tag.EVAL_BODY_INCLUDE;
    	}else {
    		return Tag.SKIP_BODY;
    	}
    }
}
