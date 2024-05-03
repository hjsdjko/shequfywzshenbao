package com.entity.model;

import com.entity.GongzuofenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 工作分配
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongzuofenpeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 编号
     */
    private String gongzuofenpeiUuidNumber;


    /**
     * 工作标题
     */
    private String gongzuofenpeiName;


    /**
     * 工作图片
     */
    private String gongzuofenpeiPhoto;


    /**
     * 社区人员
     */
    private Integer shequrenyuanId;


    /**
     * 工作类型
     */
    private Integer gongzuofenpeiTypes;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date gongzuofenpeiTime;


    /**
     * 工作分配详情
     */
    private String gongzuofenpeiContent;


    /**
     * 逻辑删除
     */
    private Integer gongzuofenpeiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
