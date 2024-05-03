package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 工作分配
 *
 * @author 
 * @email
 */
@TableName("gongzuofenpei")
public class GongzuofenpeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongzuofenpeiEntity() {

	}

	public GongzuofenpeiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 编号
     */
    @ColumnInfo(comment="编号",type="varchar(200)")
    @TableField(value = "gongzuofenpei_uuid_number")

    private String gongzuofenpeiUuidNumber;


    /**
     * 工作标题
     */
    @ColumnInfo(comment="工作标题",type="varchar(200)")
    @TableField(value = "gongzuofenpei_name")

    private String gongzuofenpeiName;


    /**
     * 工作图片
     */
    @ColumnInfo(comment="工作图片",type="varchar(200)")
    @TableField(value = "gongzuofenpei_photo")

    private String gongzuofenpeiPhoto;


    /**
     * 社区人员
     */
    @ColumnInfo(comment="社区人员",type="int(11)")
    @TableField(value = "shequrenyuan_id")

    private Integer shequrenyuanId;


    /**
     * 工作类型
     */
    @ColumnInfo(comment="工作类型",type="int(11)")
    @TableField(value = "gongzuofenpei_types")

    private Integer gongzuofenpeiTypes;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="分配时间",type="timestamp")
    @TableField(value = "gongzuofenpei_time")

    private Date gongzuofenpeiTime;


    /**
     * 工作分配详情
     */
    @ColumnInfo(comment="工作分配详情",type="text")
    @TableField(value = "gongzuofenpei_content")

    private String gongzuofenpeiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "gongzuofenpei_delete")

    private Integer gongzuofenpeiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：编号
	 */
    public String getGongzuofenpeiUuidNumber() {
        return gongzuofenpeiUuidNumber;
    }
    /**
	 * 设置：编号
	 */

    public void setGongzuofenpeiUuidNumber(String gongzuofenpeiUuidNumber) {
        this.gongzuofenpeiUuidNumber = gongzuofenpeiUuidNumber;
    }
    /**
	 * 获取：工作标题
	 */
    public String getGongzuofenpeiName() {
        return gongzuofenpeiName;
    }
    /**
	 * 设置：工作标题
	 */

    public void setGongzuofenpeiName(String gongzuofenpeiName) {
        this.gongzuofenpeiName = gongzuofenpeiName;
    }
    /**
	 * 获取：工作图片
	 */
    public String getGongzuofenpeiPhoto() {
        return gongzuofenpeiPhoto;
    }
    /**
	 * 设置：工作图片
	 */

    public void setGongzuofenpeiPhoto(String gongzuofenpeiPhoto) {
        this.gongzuofenpeiPhoto = gongzuofenpeiPhoto;
    }
    /**
	 * 获取：社区人员
	 */
    public Integer getShequrenyuanId() {
        return shequrenyuanId;
    }
    /**
	 * 设置：社区人员
	 */

    public void setShequrenyuanId(Integer shequrenyuanId) {
        this.shequrenyuanId = shequrenyuanId;
    }
    /**
	 * 获取：工作类型
	 */
    public Integer getGongzuofenpeiTypes() {
        return gongzuofenpeiTypes;
    }
    /**
	 * 设置：工作类型
	 */

    public void setGongzuofenpeiTypes(Integer gongzuofenpeiTypes) {
        this.gongzuofenpeiTypes = gongzuofenpeiTypes;
    }
    /**
	 * 获取：分配时间
	 */
    public Date getGongzuofenpeiTime() {
        return gongzuofenpeiTime;
    }
    /**
	 * 设置：分配时间
	 */

    public void setGongzuofenpeiTime(Date gongzuofenpeiTime) {
        this.gongzuofenpeiTime = gongzuofenpeiTime;
    }
    /**
	 * 获取：工作分配详情
	 */
    public String getGongzuofenpeiContent() {
        return gongzuofenpeiContent;
    }
    /**
	 * 设置：工作分配详情
	 */

    public void setGongzuofenpeiContent(String gongzuofenpeiContent) {
        this.gongzuofenpeiContent = gongzuofenpeiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getGongzuofenpeiDelete() {
        return gongzuofenpeiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setGongzuofenpeiDelete(Integer gongzuofenpeiDelete) {
        this.gongzuofenpeiDelete = gongzuofenpeiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Gongzuofenpei{" +
            ", id=" + id +
            ", gongzuofenpeiUuidNumber=" + gongzuofenpeiUuidNumber +
            ", gongzuofenpeiName=" + gongzuofenpeiName +
            ", gongzuofenpeiPhoto=" + gongzuofenpeiPhoto +
            ", shequrenyuanId=" + shequrenyuanId +
            ", gongzuofenpeiTypes=" + gongzuofenpeiTypes +
            ", gongzuofenpeiTime=" + DateUtil.convertString(gongzuofenpeiTime,"yyyy-MM-dd") +
            ", gongzuofenpeiContent=" + gongzuofenpeiContent +
            ", gongzuofenpeiDelete=" + gongzuofenpeiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
