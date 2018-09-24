package org.xujin.halo.domain;


import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 聚合内的实体
 * Entity 包含所有表都有的6个基础字段.
 * This is the parent object of all domain objects
 * @author xujin
 */
public abstract class Entity  {

    protected String id;

	protected Date gmtCreate;

	protected Date gmtModified;

	protected String creator;

	protected String modifier;

	protected String isDeleted;

	/**
	 * bizCode
	 * 业务代码
	 */
	protected String bizCode;

	/**
	 * extValues
	 * 扩展字段
	 */
	protected Map<String, Object> extValues = new ConcurrentHashMap<String, Object>();

    public<T> T getExtField(String key){
        if(extValues != null){
            return (T)extValues.get(key);
        }
        return null;
    }

    public void putExtField(String fieldName, Object value){
        this.extValues.put(fieldName, value);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public Map<String, Object> getExtValues() {
		return extValues;
	}

	public void setExtValues(Map<String, Object> extValues) {
		this.extValues = extValues;
	}
}
