package com.dao;

import com.entity.GongzuofenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzuofenpeiView;

/**
 * 工作分配 Dao 接口
 *
 * @author 
 */
public interface GongzuofenpeiDao extends BaseMapper<GongzuofenpeiEntity> {

   List<GongzuofenpeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
