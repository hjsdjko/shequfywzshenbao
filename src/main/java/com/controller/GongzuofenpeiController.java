
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 工作分配
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongzuofenpei")
public class GongzuofenpeiController {
    private static final Logger logger = LoggerFactory.getLogger(GongzuofenpeiController.class);

    private static final String TABLE_NAME = "gongzuofenpei";

    @Autowired
    private GongzuofenpeiService gongzuofenpeiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//通知公告
    @Autowired
    private ShequrenyuanService shequrenyuanService;//社区人员
    @Autowired
    private WuziService wuziService;//物资
    @Autowired
    private WuziChuruInoutService wuziChuruInoutService;//出入库
    @Autowired
    private WuziChuruInoutListService wuziChuruInoutListService;//出入库详情
    @Autowired
    private WuziYuyueService wuziYuyueService;//物资申请
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("gongzuofenpeiDeleteStart",1);params.put("gongzuofenpeiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = gongzuofenpeiService.queryPage(params);

        //字典表数据转换
        List<GongzuofenpeiView> list =(List<GongzuofenpeiView>)page.getList();
        for(GongzuofenpeiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongzuofenpeiEntity gongzuofenpei = gongzuofenpeiService.selectById(id);
        if(gongzuofenpei !=null){
            //entity转view
            GongzuofenpeiView view = new GongzuofenpeiView();
            BeanUtils.copyProperties( gongzuofenpei , view );//把实体数据重构到view中
            //级联表 社区人员
            //级联表
            ShequrenyuanEntity shequrenyuan = shequrenyuanService.selectById(gongzuofenpei.getShequrenyuanId());
            if(shequrenyuan != null){
            BeanUtils.copyProperties( shequrenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShequrenyuanId(shequrenyuan.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GongzuofenpeiEntity gongzuofenpei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongzuofenpei:{}",this.getClass().getName(),gongzuofenpei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GongzuofenpeiEntity> queryWrapper = new EntityWrapper<GongzuofenpeiEntity>()
            .eq("gongzuofenpei_name", gongzuofenpei.getGongzuofenpeiName())
            .eq("shequrenyuan_id", gongzuofenpei.getShequrenyuanId())
            .eq("gongzuofenpei_types", gongzuofenpei.getGongzuofenpeiTypes())
            .eq("gongzuofenpei_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongzuofenpeiEntity gongzuofenpeiEntity = gongzuofenpeiService.selectOne(queryWrapper);
        if(gongzuofenpeiEntity==null){
            gongzuofenpei.setGongzuofenpeiDelete(1);
            gongzuofenpei.setInsertTime(new Date());
            gongzuofenpei.setCreateTime(new Date());
            gongzuofenpeiService.insert(gongzuofenpei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongzuofenpeiEntity gongzuofenpei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,gongzuofenpei:{}",this.getClass().getName(),gongzuofenpei.toString());
        GongzuofenpeiEntity oldGongzuofenpeiEntity = gongzuofenpeiService.selectById(gongzuofenpei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(gongzuofenpei.getGongzuofenpeiPhoto()) || "null".equals(gongzuofenpei.getGongzuofenpeiPhoto())){
                gongzuofenpei.setGongzuofenpeiPhoto(null);
        }

            gongzuofenpeiService.updateById(gongzuofenpei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GongzuofenpeiEntity> oldGongzuofenpeiList =gongzuofenpeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<GongzuofenpeiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            GongzuofenpeiEntity gongzuofenpeiEntity = new GongzuofenpeiEntity();
            gongzuofenpeiEntity.setId(id);
            gongzuofenpeiEntity.setGongzuofenpeiDelete(2);
            list.add(gongzuofenpeiEntity);
        }
        if(list != null && list.size() >0){
            gongzuofenpeiService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<GongzuofenpeiEntity> gongzuofenpeiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GongzuofenpeiEntity gongzuofenpeiEntity = new GongzuofenpeiEntity();
//                            gongzuofenpeiEntity.setGongzuofenpeiUuidNumber(data.get(0));                    //编号 要改的
//                            gongzuofenpeiEntity.setGongzuofenpeiName(data.get(0));                    //工作标题 要改的
//                            gongzuofenpeiEntity.setGongzuofenpeiPhoto("");//详情和图片
//                            gongzuofenpeiEntity.setShequrenyuanId(Integer.valueOf(data.get(0)));   //社区人员 要改的
//                            gongzuofenpeiEntity.setGongzuofenpeiTypes(Integer.valueOf(data.get(0)));   //工作类型 要改的
//                            gongzuofenpeiEntity.setGongzuofenpeiTime(sdf.parse(data.get(0)));          //分配时间 要改的
//                            gongzuofenpeiEntity.setGongzuofenpeiContent("");//详情和图片
//                            gongzuofenpeiEntity.setGongzuofenpeiDelete(1);//逻辑删除字段
//                            gongzuofenpeiEntity.setInsertTime(date);//时间
//                            gongzuofenpeiEntity.setCreateTime(date);//时间
                            gongzuofenpeiList.add(gongzuofenpeiEntity);


                            //把要查询是否重复的字段放入map中
                                //编号
                                if(seachFields.containsKey("gongzuofenpeiUuidNumber")){
                                    List<String> gongzuofenpeiUuidNumber = seachFields.get("gongzuofenpeiUuidNumber");
                                    gongzuofenpeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> gongzuofenpeiUuidNumber = new ArrayList<>();
                                    gongzuofenpeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("gongzuofenpeiUuidNumber",gongzuofenpeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //编号
                        List<GongzuofenpeiEntity> gongzuofenpeiEntities_gongzuofenpeiUuidNumber = gongzuofenpeiService.selectList(new EntityWrapper<GongzuofenpeiEntity>().in("gongzuofenpei_uuid_number", seachFields.get("gongzuofenpeiUuidNumber")).eq("gongzuofenpei_delete", 1));
                        if(gongzuofenpeiEntities_gongzuofenpeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongzuofenpeiEntity s:gongzuofenpeiEntities_gongzuofenpeiUuidNumber){
                                repeatFields.add(s.getGongzuofenpeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gongzuofenpeiService.insertBatch(gongzuofenpeiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = gongzuofenpeiService.queryPage(params);

        //字典表数据转换
        List<GongzuofenpeiView> list =(List<GongzuofenpeiView>)page.getList();
        for(GongzuofenpeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongzuofenpeiEntity gongzuofenpei = gongzuofenpeiService.selectById(id);
            if(gongzuofenpei !=null){


                //entity转view
                GongzuofenpeiView view = new GongzuofenpeiView();
                BeanUtils.copyProperties( gongzuofenpei , view );//把实体数据重构到view中

                //级联表
                    ShequrenyuanEntity shequrenyuan = shequrenyuanService.selectById(gongzuofenpei.getShequrenyuanId());
                if(shequrenyuan != null){
                    BeanUtils.copyProperties( shequrenyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShequrenyuanId(shequrenyuan.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody GongzuofenpeiEntity gongzuofenpei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gongzuofenpei:{}",this.getClass().getName(),gongzuofenpei.toString());
        Wrapper<GongzuofenpeiEntity> queryWrapper = new EntityWrapper<GongzuofenpeiEntity>()
            .eq("gongzuofenpei_uuid_number", gongzuofenpei.getGongzuofenpeiUuidNumber())
            .eq("gongzuofenpei_name", gongzuofenpei.getGongzuofenpeiName())
            .eq("shequrenyuan_id", gongzuofenpei.getShequrenyuanId())
            .eq("gongzuofenpei_types", gongzuofenpei.getGongzuofenpeiTypes())
            .eq("gongzuofenpei_delete", gongzuofenpei.getGongzuofenpeiDelete())
//            .notIn("gongzuofenpei_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongzuofenpeiEntity gongzuofenpeiEntity = gongzuofenpeiService.selectOne(queryWrapper);
        if(gongzuofenpeiEntity==null){
            gongzuofenpei.setGongzuofenpeiDelete(1);
            gongzuofenpei.setInsertTime(new Date());
            gongzuofenpei.setCreateTime(new Date());
        gongzuofenpeiService.insert(gongzuofenpei);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

