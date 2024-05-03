package com.entity.vo;

import com.entity.ShequrenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 社区人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shequrenyuan")
public class ShequrenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 社区人员名称
     */

    @TableField(value = "shequrenyuan_name")
    private String shequrenyuanName;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 人员头像
     */

    @TableField(value = "shequrenyuan_photo")
    private String shequrenyuanPhoto;


    /**
     * 联系方式
     */

    @TableField(value = "shequrenyuan_phone")
    private String shequrenyuanPhone;


    /**
     * 电子邮箱
     */

    @TableField(value = "shequrenyuan_email")
    private String shequrenyuanEmail;


    /**
     * 住址
     */

    @TableField(value = "shequrenyuan_address")
    private String shequrenyuanAddress;


    /**
     * 逻辑删除
     */

    @TableField(value = "shequrenyuan_delete")
    private Integer shequrenyuanDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：社区人员名称
	 */
    public String getShequrenyuanName() {
        return shequrenyuanName;
    }


    /**
	 * 获取：社区人员名称
	 */

    public void setShequrenyuanName(String shequrenyuanName) {
        this.shequrenyuanName = shequrenyuanName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：人员头像
	 */
    public String getShequrenyuanPhoto() {
        return shequrenyuanPhoto;
    }


    /**
	 * 获取：人员头像
	 */

    public void setShequrenyuanPhoto(String shequrenyuanPhoto) {
        this.shequrenyuanPhoto = shequrenyuanPhoto;
    }
    /**
	 * 设置：联系方式
	 */
    public String getShequrenyuanPhone() {
        return shequrenyuanPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setShequrenyuanPhone(String shequrenyuanPhone) {
        this.shequrenyuanPhone = shequrenyuanPhone;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getShequrenyuanEmail() {
        return shequrenyuanEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setShequrenyuanEmail(String shequrenyuanEmail) {
        this.shequrenyuanEmail = shequrenyuanEmail;
    }
    /**
	 * 设置：住址
	 */
    public String getShequrenyuanAddress() {
        return shequrenyuanAddress;
    }


    /**
	 * 获取：住址
	 */

    public void setShequrenyuanAddress(String shequrenyuanAddress) {
        this.shequrenyuanAddress = shequrenyuanAddress;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShequrenyuanDelete() {
        return shequrenyuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShequrenyuanDelete(Integer shequrenyuanDelete) {
        this.shequrenyuanDelete = shequrenyuanDelete;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
