package com.example.copy.utli;

import com.example.copy.utli.NetWorkUtli.UtliNetWork;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NetWorkAPI {
    String ApiRootUrl = "https://cdwan.cn/api/";
    @GET()
    Observable<ResponseBody> getData(@Url String url);


























//    String ApiRootUrl = "https://cdwan.cn/api/";
    String LoginUrl = ApiRootUrl + "login/login";//登录接口 {username,password}
    String RegisterUrl = ApiRootUrl + "login/register"; //注册 {username,password}

    String IndexUrl = ApiRootUrl + "index/index";//首页数据接口  get
    String CatalogList = ApiRootUrl + "catalog/index";  //分类目录全部分类数据接口  get
    String CatalogCurrent = ApiRootUrl + "catalog/current";  //分类目录当前分类数据接口  get 参数{id:id(分类数据)}

    String AuthLoginByWeixin = ApiRootUrl + "auth/loginByWeixin"; //微信登录

    String GoodsCount = ApiRootUrl + "goods/count";  //统计商品总数
    String GoodsList = ApiRootUrl + "goods/list";  //获得商品列表   get {categoryId,page,size}
    String GoodsCategory = ApiRootUrl + "goods/category";  //获得分类数据  get 参数{ id:（GoodsList中的id） }  //分类详情页面
    String GoodsDetail = ApiRootUrl + "goods/detail";  //获得商品的详情  get 参数 { id:(商品) }
    String GoodsNew = ApiRootUrl + "goods/new";  //新品
    String GoodsHot = ApiRootUrl + "goods/hot"; //热门  get
    String GoodsRelated = ApiRootUrl + "goods/related";  //商品详情页的关联商品（大家都在看）

    String BrandList = ApiRootUrl + "brand/list";  //品牌列表  get
    String BrandDetail = ApiRootUrl + "brand/detail";  //品牌详情  get 参数{id=1001007(BrandList中的id)}

    String CartList = ApiRootUrl + "cart/index"; //获取购物车的数据 {uid:uid}
    String CartAdd = ApiRootUrl + "cart/add";// 添加商品到购物车 post 参数{uid:uid,goodsId:商品ID,productId:产品ID(prouctList)),number:数量}
    String CartUpdate = ApiRootUrl + "cart/update"; // 更新购物车的商品  post 参数{uid:uid,goodsId:商品ID,productId:产品ID,id:购物车id,number=商品数量}
    String CartDelete = ApiRootUrl + "cart/delete"; // 删除购物车的商品  post 参数{uid:uid,productIds:产品ID数组，用“,”隔开}
    String CartChecked = ApiRootUrl + "cart/checked"; // 选择或取消选择商品  post 参数{uid:uid,productIds:产品ID数组，isChecked:是否选择该商品}
    String CartGoodsCount = ApiRootUrl + "cart/goodscount"; // 获取购物车商品件数 {uid:uid}
    String CartCheckout = ApiRootUrl + "cart/checkout"; // 下单前信息确认  get 参数{uid:uid,addressId:地址ID}

    String AppCartList = ApiRootUrl + "cart/app";

    String OrderSubmit = ApiRootUrl + "order/submit"; // 提交订单 post 参数{addressId}
    String PayPrepayId = ApiRootUrl + "pay/prepay";//获取微信统一下单prepay_id

    String CollectList = ApiRootUrl + "collect/list";  //收藏列表
    String CollectAddOrDelete = ApiRootUrl + "collect/addordelete";  //添加或取消收藏

    String CommentList = ApiRootUrl + "comment/list";  //评论列表
    String CommentCount = ApiRootUrl + "comment/count";  //评论总数
    String CommentPost = ApiRootUrl + "comment/post";   //发表评论

    String TopicList = ApiRootUrl + "topic/list";  //专题列表  get
    String TopicDetail = ApiRootUrl + "topic/detail";  //专题详情 get 参数{id:(TopicList中的id)}
    String TopicRelated = ApiRootUrl + "topic/related";  //相关专题 get 参数{id:(TopicList中的id)}

    String SearchIndex = ApiRootUrl + "search/index"; //搜索页面数据  get
    String SearchResult = ApiRootUrl + "search/result";  //搜索数据
    String SearchHelper = ApiRootUrl + "search/helper";  //搜索帮助  get 参数{keyword: "搜索内容"}
    String SearchClearHistory = ApiRootUrl + "search/clearhistory";  //搜索帮助

    String AddressList = ApiRootUrl + "address/list";  //收货地址列表
    String AddressDetail = ApiRootUrl + "address/detail";  //收货地址详情
    String AddressSave = ApiRootUrl + "address/save"; //保存收货地址  post {id:收货地址id,uid,name:收货人,mobile:手机号,province_id:省份id,city_id:城市id,district_id:区县id,address:详细地址,is_default:是否是默认的地址}
    String AddressDelete = ApiRootUrl + "address/delete";  //保存收货地址

    //app端使用新的地址接口  http://res-pad.oss-cn-shenzhen.aliyuncs.com/jy/province.json
//     String AddressList= ApiRootUrl + "address/listNew";  //收货地址列表  get
//     String  AddressDetail= ApiRootUrl + "address/detailNew";  //收货地址详情  post{uid,id(收货地址id)}
//     String   AddressSave= ApiRootUrl + "address/saveNew"; //保存收货地址  post {id:收货地址id,uid,name:收货人,mobile:手机号,province:省份,city:城市,area:区县,address:详细地址,is_default:是否是默认的地址}
//     String  AddressDelete= ApiRootUrl + "address/delete";  //保存收货地址 post{uid,id(地址id)}


    String RegionList = ApiRootUrl + "region/list";  //获取区域列表 get {parentId:默认1获取省份的数据} 根据获取的省份的数据获取城市的数据

    String OrderList = ApiRootUrl + "order/list";  //订单列表
    String OrderDetail = ApiRootUrl + "order/detail";  //订单详情
    String OrderCancel = ApiRootUrl + "order/cancel";  //取消订单
    String OrderExpress = ApiRootUrl + "order/express";//物流详情

    String FootprintList = ApiRootUrl + "footprint/list"; //足迹列表
    String FootprintDelete = ApiRootUrl + "footprint/delete";  //删除足迹

}
