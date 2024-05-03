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
 * 社区人员
 *
 * @author 
 * @email
 */
@TableName("shequrenyuan")
public class ShequrenyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShequrenyuanEntity() {

	}

	public ShequrenyuanEntity(T t) {
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
     * 社区人员名称
     */
    @ColumnInfo(comment="社区人员名称",type="varchar(200)")
    @TableField(value = "shequrenyuan_name")

    private String shequrenyuanName;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 人员头像
     */
    @ColumnInfo(comment="人员头像",type="varchar(200)")
    @TableField(value = "shequrenyuan_photo")

    private String shequrenyuanPhoto;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "shequrenyuan_phone")

    private String shequrenyuanPhone;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "shequrenyuan_email")

    private String shequrenyuanEmail;


    /**
     * 住址
     */
    @ColumnInfo(comment="住址",type="varchar(200)")
    @TableField(value = "shequrenyuan_address")

    private String shequrenyuanAddress;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shequrenyuan_delete")

    private Integer shequrenyuanDelete;


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
	 * 获取：社区人员名称
	 */
    public String getShequrenyuanName() {
        return shequrenyuanName;
    }
    /**
	 * 设置：社区人员名称
	 */

    public void setShequrenyuanName(String shequrenyuanName) {
        this.shequrenyuanName = shequrenyuanName;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：人员头像
	 */
    public String getShequrenyuanPhoto() {
        return shequrenyuanPhoto;
    }
    /**
	 * 设置：人员头像
	 */

    public void setShequrenyuanPhoto(String shequrenyuanPhoto) {
        this.shequrenyuanPhoto = shequrenyuanPhoto;
    }
    /**
	 * 获取：联系方式
	 */
    public String getShequrenyuanPhone() {
        return shequrenyuanPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setShequrenyuanPhone(String shequrenyuanPhone) {
        this.shequrenyuanPhone = shequrenyuanPhone;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getShequrenyuanEmail() {
        return shequrenyuanEmail;
    }
    /**
	 * 设置：电子邮箱
	 */

    public void setShequrenyuanEmail(String shequrenyuanEmail) {
        this.shequrenyuanEmail = shequrenyuanEmail;
    }
    /**
	 * 获取：住址
	 */
    public String getShequrenyuanAddress() {
        return shequrenyuanAddress;
    }
    /**
	 * 设置：住址
	 */

    public void setShequrenyuanAddress(String shequrenyuanAddress) {
        this.shequrenyuanAddress = shequrenyuanAddress;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShequrenyuanDelete() {
        return shequrenyuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShequrenyuanDelete(Integer shequrenyuanDelete) {
        this.shequrenyuanDelete = shequrenyuanDelete;
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
        return "Shequrenyuan{" +
            ", id=" + id +
            ", shequrenyuanName=" + shequrenyuanName +
            ", sexTypes=" + sexTypes +
            ", shequrenyuanPhoto=" + shequrenyuanPhoto +
            ", shequrenyuanPhone=" + shequrenyuanPhone +
            ", shequrenyuanEmail=" + shequrenyuanEmail +
            ", shequrenyuanAddress=" + shequrenyuanAddress +
            ", shequrenyuanDelete=" + shequrenyuanDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
