
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
 * 社区人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shequrenyuan")
public class ShequrenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(ShequrenyuanController.class);

    private static final String TABLE_NAME = "shequrenyuan";

    @Autowired
    private ShequrenyuanService shequrenyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GongzuofenpeiService gongzuofenpeiService;//工作分配
    @Autowired
    private NewsService newsService;//通知公告
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
        params.put("shequrenyuanDeleteStart",1);params.put("shequrenyuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = shequrenyuanService.queryPage(params);

        //字典表数据转换
        List<ShequrenyuanView> list =(List<ShequrenyuanView>)page.getList();
        for(ShequrenyuanView c:list){
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
        ShequrenyuanEntity shequrenyuan = shequrenyuanService.selectById(id);
        if(shequrenyuan !=null){
            //entity转view
            ShequrenyuanView view = new ShequrenyuanView();
            BeanUtils.copyProperties( shequrenyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody ShequrenyuanEntity shequrenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shequrenyuan:{}",this.getClass().getName(),shequrenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShequrenyuanEntity> queryWrapper = new EntityWrapper<ShequrenyuanEntity>()
            .eq("shequrenyuan_name", shequrenyuan.getShequrenyuanName())
            .eq("sex_types", shequrenyuan.getSexTypes())
            .eq("shequrenyuan_phone", shequrenyuan.getShequrenyuanPhone())
            .eq("shequrenyuan_email", shequrenyuan.getShequrenyuanEmail())
            .eq("shequrenyuan_address", shequrenyuan.getShequrenyuanAddress())
            .eq("shequrenyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShequrenyuanEntity shequrenyuanEntity = shequrenyuanService.selectOne(queryWrapper);
        if(shequrenyuanEntity==null){
            shequrenyuan.setShequrenyuanDelete(1);
            shequrenyuan.setCreateTime(new Date());
            shequrenyuanService.insert(shequrenyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShequrenyuanEntity shequrenyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shequrenyuan:{}",this.getClass().getName(),shequrenyuan.toString());
        ShequrenyuanEntity oldShequrenyuanEntity = shequrenyuanService.selectById(shequrenyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(shequrenyuan.getShequrenyuanPhoto()) || "null".equals(shequrenyuan.getShequrenyuanPhoto())){
                shequrenyuan.setShequrenyuanPhoto(null);
        }

            shequrenyuanService.updateById(shequrenyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShequrenyuanEntity> oldShequrenyuanList =shequrenyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ShequrenyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShequrenyuanEntity shequrenyuanEntity = new ShequrenyuanEntity();
            shequrenyuanEntity.setId(id);
            shequrenyuanEntity.setShequrenyuanDelete(2);
            list.add(shequrenyuanEntity);
        }
        if(list != null && list.size() >0){
            shequrenyuanService.updateBatchById(list);
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
            List<ShequrenyuanEntity> shequrenyuanList = new ArrayList<>();//上传的东西
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
                            ShequrenyuanEntity shequrenyuanEntity = new ShequrenyuanEntity();
//                            shequrenyuanEntity.setShequrenyuanName(data.get(0));                    //社区人员名称 要改的
//                            shequrenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            shequrenyuanEntity.setShequrenyuanPhoto("");//详情和图片
//                            shequrenyuanEntity.setShequrenyuanPhone(data.get(0));                    //联系方式 要改的
//                            shequrenyuanEntity.setShequrenyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            shequrenyuanEntity.setShequrenyuanAddress(data.get(0));                    //住址 要改的
//                            shequrenyuanEntity.setShequrenyuanDelete(1);//逻辑删除字段
//                            shequrenyuanEntity.setCreateTime(date);//时间
                            shequrenyuanList.add(shequrenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //联系方式
                                if(seachFields.containsKey("shequrenyuanPhone")){
                                    List<String> shequrenyuanPhone = seachFields.get("shequrenyuanPhone");
                                    shequrenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> shequrenyuanPhone = new ArrayList<>();
                                    shequrenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("shequrenyuanPhone",shequrenyuanPhone);
                                }
                        }

                        //查询是否重复
                         //联系方式
                        List<ShequrenyuanEntity> shequrenyuanEntities_shequrenyuanPhone = shequrenyuanService.selectList(new EntityWrapper<ShequrenyuanEntity>().in("shequrenyuan_phone", seachFields.get("shequrenyuanPhone")).eq("shequrenyuan_delete", 1));
                        if(shequrenyuanEntities_shequrenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShequrenyuanEntity s:shequrenyuanEntities_shequrenyuanPhone){
                                repeatFields.add(s.getShequrenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shequrenyuanService.insertBatch(shequrenyuanList);
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
        PageUtils page = shequrenyuanService.queryPage(params);

        //字典表数据转换
        List<ShequrenyuanView> list =(List<ShequrenyuanView>)page.getList();
        for(ShequrenyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShequrenyuanEntity shequrenyuan = shequrenyuanService.selectById(id);
            if(shequrenyuan !=null){


                //entity转view
                ShequrenyuanView view = new ShequrenyuanView();
                BeanUtils.copyProperties( shequrenyuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody ShequrenyuanEntity shequrenyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shequrenyuan:{}",this.getClass().getName(),shequrenyuan.toString());
        Wrapper<ShequrenyuanEntity> queryWrapper = new EntityWrapper<ShequrenyuanEntity>()
            .eq("shequrenyuan_name", shequrenyuan.getShequrenyuanName())
            .eq("sex_types", shequrenyuan.getSexTypes())
            .eq("shequrenyuan_phone", shequrenyuan.getShequrenyuanPhone())
            .eq("shequrenyuan_email", shequrenyuan.getShequrenyuanEmail())
            .eq("shequrenyuan_address", shequrenyuan.getShequrenyuanAddress())
            .eq("shequrenyuan_delete", shequrenyuan.getShequrenyuanDelete())
//            .notIn("shequrenyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShequrenyuanEntity shequrenyuanEntity = shequrenyuanService.selectOne(queryWrapper);
        if(shequrenyuanEntity==null){
            shequrenyuan.setShequrenyuanDelete(1);
            shequrenyuan.setCreateTime(new Date());
        shequrenyuanService.insert(shequrenyuan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

