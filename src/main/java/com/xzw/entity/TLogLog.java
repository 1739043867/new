package com.xzw.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 日志表
 * </p>
 *
 * @author xzw
 * @since 2018-05-18
 */
@TableName("t_log_log")
public class TLogLog extends Model<TLogLog> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 标题
     */
	private String title;
    /**
     * 类型
     */
	private String type;
    /**
     * 内容
     */
	private String content;
	private String inserter;
	@TableField("insert_time")
	private Date insertTime;
	private String updater;
	@TableField("update_time")
	private Date updateTime;
    /**
     * 状态
     */
	private String status;
    /**
     * 用户
     */
	private String userId;
    /**
     * 流程id
     */
	private String processInstanceId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInserter() {
		return inserter;
	}

	public void setInserter(String inserter) {
		this.inserter = inserter;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "TLogLog{" +
			"id=" + id +
			", title=" + title +
			", type=" + type +
			", content=" + content +
			", inserter=" + inserter +
			", insertTime=" + insertTime +
			", updater=" + updater +
			", updateTime=" + updateTime +
			", status=" + status +
			", userId=" + userId +
			", processInstanceId=" + processInstanceId +
			"}";
	}
}
