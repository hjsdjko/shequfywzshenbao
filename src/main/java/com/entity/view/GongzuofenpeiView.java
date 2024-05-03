package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.GongzuofenpeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 工作分配
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("gongzuofenpei")
public class GongzuofenpeiView extends GongzuofenpeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 工作类型的值
	*/
	@ColumnInfo(comment="工作类型的字典表值",type="varchar(200)")
	private String gongzuofenpeiValue;

	//级联表 社区人员
		/**
		* 社区人员名称
		*/

		@ColumnInfo(comment="社区人员名称",type="varchar(200)")
		private String shequrenyuanName;
		/**
		* 性别
		*/
		@ColumnInfo(comment="性别",type="int(11)")
		private Integer sexTypes;
			/**
			* 性别的值
			*/
			@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
			private String sexValue;
		/**
		* 人员头像
		*/

		@ColumnInfo(comment="人员头像",type="varchar(200)")
		private String shequrenyuanPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String shequrenyuanPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String shequrenyuanEmail;
		/**
		* 住址
		*/

		@ColumnInfo(comment="住址",type="varchar(200)")
		private String shequrenyuanAddress;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shequrenyuanDelete;



	public GongzuofenpeiView() {

	}

	public GongzuofenpeiView(GongzuofenpeiEntity gongzuofenpeiEntity) {
		try {
			BeanUtils.copyProperties(this, gongzuofenpeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 工作类型的值
	*/
	public String getGongzuofenpeiValue() {
		return gongzuofenpeiValue;
	}
	/**
	* 设置： 工作类型的值
	*/
	public void setGongzuofenpeiValue(String gongzuofenpeiValue) {
		this.gongzuofenpeiValue = gongzuofenpeiValue;
	}


	//级联表的get和set 社区人员

		/**
		* 获取： 社区人员名称
		*/
		public String getShequrenyuanName() {
			return shequrenyuanName;
		}
		/**
		* 设置： 社区人员名称
		*/
		public void setShequrenyuanName(String shequrenyuanName) {
			this.shequrenyuanName = shequrenyuanName;
		}
		/**
		* 获取： 性别
		*/
		public Integer getSexTypes() {
			return sexTypes;
		}
		/**
		* 设置： 性别
		*/
		public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
		}


			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}

		/**
		* 获取： 人员头像
		*/
		public String getShequrenyuanPhoto() {
			return shequrenyuanPhoto;
		}
		/**
		* 设置： 人员头像
		*/
		public void setShequrenyuanPhoto(String shequrenyuanPhoto) {
			this.shequrenyuanPhoto = shequrenyuanPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getShequrenyuanPhone() {
			return shequrenyuanPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setShequrenyuanPhone(String shequrenyuanPhone) {
			this.shequrenyuanPhone = shequrenyuanPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getShequrenyuanEmail() {
			return shequrenyuanEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setShequrenyuanEmail(String shequrenyuanEmail) {
			this.shequrenyuanEmail = shequrenyuanEmail;
		}

		/**
		* 获取： 住址
		*/
		public String getShequrenyuanAddress() {
			return shequrenyuanAddress;
		}
		/**
		* 设置： 住址
		*/
		public void setShequrenyuanAddress(String shequrenyuanAddress) {
			this.shequrenyuanAddress = shequrenyuanAddress;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShequrenyuanDelete() {
			return shequrenyuanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShequrenyuanDelete(Integer shequrenyuanDelete) {
			this.shequrenyuanDelete = shequrenyuanDelete;
		}


	@Override
	public String toString() {
		return "GongzuofenpeiView{" +
			", gongzuofenpeiValue=" + gongzuofenpeiValue +
			", shequrenyuanName=" + shequrenyuanName +
			", shequrenyuanPhoto=" + shequrenyuanPhoto +
			", shequrenyuanPhone=" + shequrenyuanPhone +
			", shequrenyuanEmail=" + shequrenyuanEmail +
			", shequrenyuanAddress=" + shequrenyuanAddress +
			", shequrenyuanDelete=" + shequrenyuanDelete +
			"} " + super.toString();
	}
}
