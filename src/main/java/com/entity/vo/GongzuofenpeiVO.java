package com.entity.vo;

import com.entity.GongzuofenpeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 工作分配
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongzuofenpei")
public class GongzuofenpeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 编号
     */

    @TableField(value = "gongzuofenpei_uuid_number")
    private String gongzuofenpeiUuidNumber;


    /**
     * 工作标题
     */

    @TableField(value = "gongzuofenpei_name")
    private String gongzuofenpeiName;


    /**
     * 工作图片
     */

    @TableField(value = "gongzuofenpei_photo")
    private String gongzuofenpeiPhoto;


    /**
     * 社区人员
     */

    @TableField(value = "shequrenyuan_id")
    private Integer shequrenyuanId;


    /**
     * 工作类型
     */

    @TableField(value = "gongzuofenpei_types")
    private Integer gongzuofenpeiTypes;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "gongzuofenpei_time")
    private Date gongzuofenpeiTime;


    /**
     * 工作分配详情
     */

    @TableField(value = "gongzuofenpei_content")
    private String gongzuofenpeiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "gongzuofenpei_delete")
    private Integer gongzuofenpeiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show2 photoShow
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
	 * 设置：编号
	 */
    public String getGongzuofenpeiUuidNumber() {
        return gongzuofenpeiUuidNumber;
    }


    /**
	 * 获取：编号
	 */

    public void setGongzuofenpeiUuidNumber(String gongzuofenpeiUuidNumber) {
        this.gongzuofenpeiUuidNumber = gongzuofenpeiUuidNumber;
    }
    /**
	 * 设置：工作标题
	 */
    public String getGongzuofenpeiName() {
        return gongzuofenpeiName;
    }


    /**
	 * 获取：工作标题
	 */

    public void setGongzuofenpeiName(String gongzuofenpeiName) {
        this.gongzuofenpeiName = gongzuofenpeiName;
    }
    /**
	 * 设置：工作图片
	 */
    public String getGongzuofenpeiPhoto() {
        return gongzuofenpeiPhoto;
    }


    /**
	 * 获取：工作图片
	 */

    public void setGongzuofenpeiPhoto(String gongzuofenpeiPhoto) {
        this.gongzuofenpeiPhoto = gongzuofenpeiPhoto;
    }
    /**
	 * 设置：社区人员
	 */
    public Integer getShequrenyuanId() {
        return shequrenyuanId;
    }


    /**
	 * 获取：社区人员
	 */

    public void setShequrenyuanId(Integer shequrenyuanId) {
        this.shequrenyuanId = shequrenyuanId;
    }
    /**
	 * 设置：工作类型
	 */
    public Integer getGongzuofenpeiTypes() {
        return gongzuofenpeiTypes;
    }


    /**
	 * 获取：工作类型
	 */

    public void setGongzuofenpeiTypes(Integer gongzuofenpeiTypes) {
        this.gongzuofenpeiTypes = gongzuofenpeiTypes;
    }
    /**
	 * 设置：分配时间
	 */
    public Date getGongzuofenpeiTime() {
        return gongzuofenpeiTime;
    }


    /**
	 * 获取：分配时间
	 */

    public void setGongzuofenpeiTime(Date gongzuofenpeiTime) {
        this.gongzuofenpeiTime = gongzuofenpeiTime;
    }
    /**
	 * 设置：工作分配详情
	 */
    public String getGongzuofenpeiContent() {
        return gongzuofenpeiContent;
    }


    /**
	 * 获取：工作分配详情
	 */

    public void setGongzuofenpeiContent(String gongzuofenpeiContent) {
        this.gongzuofenpeiContent = gongzuofenpeiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getGongzuofenpeiDelete() {
        return gongzuofenpeiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setGongzuofenpeiDelete(Integer gongzuofenpeiDelete) {
        this.gongzuofenpeiDelete = gongzuofenpeiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
