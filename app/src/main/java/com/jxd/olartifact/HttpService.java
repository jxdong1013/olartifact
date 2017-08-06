package com.jxd.olartifact;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by jinxiangdong on 2017/8/6.
 */

    public abstract interface HttpService
    {
        //@FormUrlEncoded
        //@POST("/mobile/memberAccount/accounts")
        //public abstract Call<ResultDO<List<Account>>> accounts(@Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/index/activeProduct")
        public abstract Call<ResultDO> activeProduct(@Field("memberId") long paramLong, @Field("indexDataId") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/address/addAddress")
        public abstract Call<ResultDO<Integer>> addAddress(@Field("addressId") Integer paramInteger, @Field("provinceId") int paramInt1, @Field("cityId") int paramInt2, @Field("districtId") int paramInt3, @Field("address") String paramString1, @Field("name") String paramString2, @Field("mobile") String paramString3, @Field("memberId") long paramLong, @Field("identityNo") String paramString4);

        @FormUrlEncoded
        @POST("/mobile/carItem/addProduct")
        public abstract Call<ResultDO> addToCart(@Field("productId") Long paramLong1, @Field("memberId") Long paramLong2, @Field("normalId") Integer paramInteger, @Field("num") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/member/amountDetail")
//        public abstract Call<ResultDO<List<Amount>>> amountDetail(@Field("memberId") long paramLong1, @Field("type") long paramLong2, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

        @FormUrlEncoded
        @POST("/mobile/order/customerService/apply")
        public abstract Call<ResultDO> apply(@Field("orderId") int paramInt1, @Field("orderItemId") Integer paramInteger, @Field("type") int paramInt2, @Field("reason") String paramString1, @Field("mobile") String paramString2, @Field("desc") String paramString3, @Field("amount") String paramString4);

        @FormUrlEncoded
        @POST("/mobile/hotselect/store/auth")
        public abstract Call<ResultDO> auth(@Field("memberId") long paramLong, @Field("storeLogo") String paramString1, @Field("storeName") String paramString2, @Field("businessNo") String paramString3, @Field("legalPerson") String paramString4, @Field("businessImage") String paramString5, @Field("fieldImage") String paramString6, @Field("doorHeadImage") String paramString7);

        @FormUrlEncoded
        @POST("/mobile/member/boundMobile")
        public abstract Call<ResultDO> boundMobile(@Field("memberId") long paramLong, @Field("oldCode") String paramString1, @Field("mobile") String paramString2, @Field("code") String paramString3);

//        @FormUrlEncoded
//        @POST("/mobile/index/brands")
//        public abstract Call<ResultDO<Brand>> brands(@Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

//        @FormUrlEncoded
//        @POST("/mobile/order/buyNowConfirmOrder")
//        public abstract Call<ResultDO<Order>> buyNowConfirmOrder(@Field("productId") long paramLong1, @Field("num") int paramInt1, @Field("memberId") long paramLong2, @Field("normalId") Integer paramInteger1, @Field("addressId") Integer paramInteger2, @Field("uutype") int paramInt2);

        @FormUrlEncoded
        @POST("/mobile/order/buyNowCreateOrder")
        public abstract Call<ResultDO<PayInfo>> buyNowCreateOrder(@Field("productId") long paramLong1, @Field("num") int paramInt1, @Field("payPassword") String paramString1, @Field("normalId") Integer paramInteger1, @Field("memberId") long paramLong2, @Field("addressId") int paramInt2, @Field("payMethod") int paramInt3, @Field("pledgeMethod") Integer paramInteger2, @Field("memo") String paramString2, @Field("uutype") int paramInt4);

        @FormUrlEncoded
        @POST("/mobile/order/cancelOrder")
        public abstract Call<ResultDO> cancelOrder(@Field("orderId") int paramInt, @Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/withdraw/canleWithdraw")
        public abstract Call<ResultDO> canleWithdraw(@Field("recordId") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/order/carToOrder")
//        public abstract Call<ResultDO<PayInfo>> carToOrder(@Field("carIds") String paramString1, @Field("payPassword") String paramString2, @Field("memberId") long paramLong, @Field("addressId") int paramInt1, @Field("payMethod") int paramInt2, @Field("pledgeMethod") Integer paramInteger, @Field("memos") String paramString3, @Field("uutype") int paramInt3);

//        @FormUrlEncoded
//        @POST("/mobile/order/carToOrderConfirmOrder")
//        public abstract Call<ResultDO<Order>> carToOrderConfirmOrder(@Field("carIds") String paramString, @Field("memberId") long paramLong, @Field("addressId") Integer paramInteger, @Field("uutype") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/appclient/cleanClientId")
        public abstract Call<ResultDO> cleanClientId(@Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/search/cleanSearchRecord")
        public abstract Call<ResultDO> cleanSearchRecord(@Field("memberId") long paramLong);

//        @FormUrlEncoded
//        @POST("/mobile/collect/collects")
//        public abstract Call<ResultDO<List<Collect>>> collects(@Field("memberId") long paramLong, @Field("type") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/order/confirmGet")
        public abstract Call<ResultDO> confirmGet(@Field("orderId") int paramInt, @Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/memberAccount/delete")
        public abstract Call<ResultDO> delete(@Field("memberId") long paramLong, @Field("accountId") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/address/deleteAddress")
        public abstract Call<ResultDO> deleteAddress(@Field("addressId") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/carItem/delete")
        public abstract Call<ResultDO> deleteCart(@Field("carIds") String paramString);

        @FormUrlEncoded
        @POST("/mobile/collect/delete")
        public abstract Call<ResultDO> deleteCollect(@Field("objIds") String paramString, @Field("memberId") long paramLong, @Field("type") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/product/comment/deleteFreeUseComment")
        public abstract Call<ResultDO> deleteFreeUseComment(@Field("commentId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/hotselect/carItem/delete")
        public abstract Call<ResultDO> deleteHotCart(@Field("carIds") String paramString);

        @FormUrlEncoded
        @POST("/mobile/hotselect/member/deleteOftenBuy")
        public abstract Call<ResultDO> deleteOftenBuy(@Field("listId") String paramString);

        @FormUrlEncoded
        @POST("/mobile/order/deleteOrder")
        public abstract Call<ResultDO> deleteOrder(@Field("orderId") int paramInt, @Field("memberId") long paramLong);

//        @FormUrlEncoded
//        @POST("mobile/message/detailMessageCount")
//        public abstract Call<ResultDO<Message>> detailMessageCount(@Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/collect/doCollect")
        public abstract Call<ResultDO> doCollect(@Field("objId") long paramLong1, @Field("memberId") long paramLong2, @Field("type") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/product/comment/doAppComment")
        public abstract Call<ResultDO> doComment(@Field("orderId") int paramInt, @Field("memberId") long paramLong, @Field("productIds") String paramString1, @Field("scores") String paramString2, @Field("title") String paramString3, @Field("contents") String paramString4, @Field("images") String paramString5);

        @FormUrlEncoded
        @POST("/mobile/product/comment/doCommentFreeUseShow")
        public abstract Call<ResultDO> doCommentFreeUseShow(@Field("memberId") long paramLong, @Field("productCommentId") int paramInt, @Field("parentCommentId") Integer paramInteger, @Field("content") String paramString);

        @FormUrlEncoded
        @POST("/mobile/product/comment/doGoodFreeUseShow")
        public abstract Call<ResultDO> doGoodFreeUseShow(@Field("memberId") long paramLong, @Field("productCommentId") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/member/forgetPassword")
        public abstract Call<ResultDO> forgetPassword(@Field("mobile") String paramString1, @Field("code") String paramString2, @Field("password") String paramString3);

//        @FormUrlEncoded
//        @POST("/mobile/product/comment/freeUseDetail")
//        public abstract Call<ResultDO<Comment>> freeUseDetail(@Field("memberId") long paramLong, @Field("commentId") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/product/comment/freeUseShow")
//        public abstract Call<ResultDO<List<Comment>>> freeUseShow(@Field("memberId") long paramLong, @Field("type") int paramInt, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

//        @FormUrlEncoded
//        @POST("/mobile/city/getAllCity")
//        public abstract Call<ResultDO<List<City>>> getAllCity(@Field("memberId") Long paramLong);

        @FormUrlEncoded
        @POST("/mobile/core/apk/getApkInfo")
        public abstract Call<ResultDO> getApkInfo(@Field("versionCode") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/product/category/getBrands")
//        public abstract Call<ResultDO<List<Brand>>> getBrands(@Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

//        @FormUrlEncoded
//        @POST("/mobile/carItem/getMemberCars")
//        public abstract Call<ResultDO<List<Cart>>> getCarts(@Field("memberId") Long paramLong);

//        @FormUrlEncoded
//        @POST("/mobile/product/category/getCategory")
//        public abstract Call<ResultDO<List<Category>>> getCategorys(@Field("memberId") Long paramLong);

//        @FormUrlEncoded
//        @POST("/mobile/specialLocal/getCities")
//        public abstract Call<ResultDO<List<City>>> getCities(@Field("memberId") Long paramLong);

//        @FormUrlEncoded
//        @POST("/mobile/product/comment/getComments")
//        public abstract Call<ResultDO<List<Comment>>> getComments(@Field("productId") long paramLong, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

//        @FormUrlEncoded
//        @POST("/mobile/order/customerService/getCustomerServiceInfo")
//        public abstract Call<ResultDO<Order>> getCustomerServiceInfo(@Field("orderId") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/freeUse/getFreeUseData")
//        public abstract Call<ResultDO<FreeData>> getFreeUseData(@Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2, @Field("isNeedBrand") Integer paramInteger3, @Field("isRecommend") Integer paramInteger4, @Field("timeId") Integer paramInteger5, @Field("isTommorrow") String paramString);
//
//        @FormUrlEncoded
//        @POST("/mobile/freeUse/getFreeUseTimes")
//        public abstract Call<ResultDO<FreeTimes>> getFreeUseTimes(@Field("memberId") String paramString);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/carItem/getMemberCars")
//        public abstract Call<ResultDO<List<Cart>>> getHotCarts(@Field("memberId") Long paramLong);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/product/getCategory")
//        public abstract Call<ResultDO<List<Category>>> getHotCategory(@Field("memberId") String paramString);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/product/getNormal")
//        public abstract Call<ResultDO<ProductNormal>> getHotNormal(@Field("productId") long paramLong, @Field("valueIds") String paramString);
//
//        @FormUrlEncoded
//        @POST("/mobile/lifeHouse/getLifeHouse")
//        public abstract Call<ResultDO<LifeHouse>> getLifeHouse(@Field("latitude") Double paramDouble1, @Field("longitude") Double paramDouble2, @Field("cityId") Integer paramInteger, @Field("uutype") int paramInt);
//
//        @FormUrlEncoded
//        @POST("/mobile/lifeHouse/getLifeHouseProduct")
//        public abstract Call<ResultDO<List<Product>>> getLifeHouseProduct(@Field("lifeHouseId") int paramInt, @Field("isSelection") Integer paramInteger1, @Field("memberId") long paramLong, @Field("catId") Integer paramInteger2, @Field("page") Integer paramInteger3, @Field("rows") Integer paramInteger4);
//
//        @FormUrlEncoded
//        @POST("/mobile/limitBuy/getLimitBuyBrand")
//        public abstract Call<ResultDO<List<Images>>> getLimitBuyBrand(@Field("memberId") String paramString);

//        @FormUrlEncoded
//        @POST("/mobile/limitBuy/getLimitBuyProtuct")
//        public abstract Call<ResultDO<TimeProduct>> getLimitBuyProtuct(@Field("timeId") int paramInt, @Field("startTime") String paramString, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);
//
//        @FormUrlEncoded
//        @POST("/mobile/limitBuy/getLimitBuyTime")
//        public abstract Call<ResultDO<TimeTab>> getLimitBuyTime(@Field("memberId") Long paramLong);
//
//        @FormUrlEncoded
//        @POST("/mobile/member/getMember")
//        public abstract Call<ResultDO<Member>> getMember(@Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/limitBuy/getMillisTime")
        public abstract Call<ResultDO> getMillisTime(@Field("startTime") String paramString1, @Field("endTime") String paramString2);

//        @FormUrlEncoded
//        @POST("/mobile/product/getNormal")
//        public abstract Call<ResultDO<ProductNormal>> getNormal(@Field("productId") long paramLong1, @Field("memberId") long paramLong2, @Field("uutype") int paramInt, @Field("valueIds") String paramString);
//
//        @FormUrlEncoded
//        @POST("/mobile/specialLocal/getOneSpecialLocalCityData")
//        public abstract Call<ResultDO<IndexLand>> getOneSpecialLocalCityData(@Field("cityId") Integer paramInteger);

        @FormUrlEncoded
        @POST("/mobile/member/getShareCodeUrl")
        public abstract Call<ResultDO> getShareCodeUrl(@Field("memberId") long paramLong);

//        @FormUrlEncoded
//        @POST("/mobile/globalShopping/globalShoppingData")
//        public abstract Call<ResultDO<GlobleData>> globalShoppingData(@Field("memberId") Long paramLong);
//
//        @FormUrlEncoded
//        @POST("/mobile/member/growData")
//        public abstract Call<ResultDO<GrowData>> growData(@Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/hotselect/carItem/addProduct")
        public abstract Call<ResultDO> hotAddToCart(@Field("productId") Long paramLong1, @Field("memberId") Long paramLong2, @Field("normalId") Integer paramInteger, @Field("num") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/order/carToOrderConfirmOrder")
//        public abstract Call<ResultDO<Order>> hotCarToOrderConfirmOrder(@Field("carIds") String paramString, @Field("memberId") long paramLong, @Field("addressId") Integer paramInteger);
//
//        @FormUrlEncoded
//        @POST("mobile/hotselect/product/productDetail")
//        public abstract Call<ResultDO<Product>> hotProductDetail(@Field("productId") long paramLong1, @Field("memberId") long paramLong2);

        @FormUrlEncoded
        @POST("/mobile/hotselect/address/addAddress")
        public abstract Call<ResultDO<Integer>> hotaddAddress(@Field("addressId") Integer paramInteger, @Field("provinceId") int paramInt1, @Field("cityId") int paramInt2, @Field("districtId") int paramInt3, @Field("address") String paramString1, @Field("name") String paramString2, @Field("mobile") String paramString3, @Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/hotselect/customerService/apply")
        public abstract Call<ResultDO> hotapply(@Field("orderId") int paramInt1, @Field("orderItemId") Integer paramInteger, @Field("type") int paramInt2, @Field("reason") String paramString1, @Field("mobile") String paramString2, @Field("desc") String paramString3, @Field("amount") String paramString4);

        @FormUrlEncoded
        @POST("/mobile/hotselect/order/cancelOrder")
        public abstract Call<ResultDO> hotcancelOrder(@Field("orderId") int paramInt, @Field("memberId") long paramLong);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/order/carToOrder")
//        public abstract Call<ResultDO<PayInfo>> hotcarToOrder(@Field("carIds") String paramString1, @Field("payPassword") String paramString2, @Field("memberId") long paramLong, @Field("addressId") int paramInt1, @Field("payMethod") int paramInt2, @Field("pledgeMethod") Integer paramInteger1, @Field("memos") String paramString3, @Field("redPacketId") Integer paramInteger2);

        @FormUrlEncoded
        @POST("/mobile/hotselect/order/confirmGet")
        public abstract Call<ResultDO> hotconfirmGet(@Field("orderId") int paramInt, @Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/hotselect/address/deleteAddress")
        public abstract Call<ResultDO> hotdeleteAddress(@Field("addressId") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/hotselect/order/deleteOrder")
        public abstract Call<ResultDO> hotdeleteOrder(@Field("orderId") int paramInt, @Field("memberId") long paramLong);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/customerService/getCustomerServiceInfo")
//        public abstract Call<ResultDO<Order>> hotgetCustomerServiceInfo(@Field("orderId") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/member/info")
//        public abstract Call<ResultDO<Member>> hotgetMember(@Field("memberId") long paramLong);
//
//        @FormUrlEncoded
//        @POST("mobile/hotselect/address/memberAddresses")
//        public abstract Call<ResultDO<List<Address>>> hotmemberAddresses(@Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/hotselect/customerService/memberSend")
        public abstract Call<ResultDO> hotmemberSend(@Field("customerServiceId") int paramInt, @Field("express") String paramString1, @Field("expressNo") String paramString2);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/order/myOrder")
//        public abstract Call<ResultDO<List<Order>>> hotmyOrder(@Field("memberId") long paramLong, @Field("status") Integer paramInteger1, @Field("page") Integer paramInteger2, @Field("rows") Integer paramInteger3);
//
//        @FormUrlEncoded
//        @POST("/mobile/hotselect/order/orderDetail")
//        public abstract Call<ResultDO<Order>> hotorderDetail(@Field("orderId") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/hotselect/address/setDefaultAddress")
        public abstract Call<ResultDO> hotsetDefaultAddress(@Field("memberId") long paramLong, @Field("addressId") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/order/singleOrderPay")
//        public abstract Call<ResultDO<PayInfo>> hotsingleOrderPay(@Field("orderId") long paramLong, @Field("payMethod") Integer paramInteger, @Field("payPassword") String paramString);
//
//        @FormUrlEncoded
//        @POST("/mobile/hotselect/product/indexData")
//        public abstract Call<ResultDO<List<Product>>> indexData(@Field("memberId") long paramLong, @Field("keyword") String paramString, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

//        @FormUrlEncoded
//        @POST("/mobile/index/indexData")
//        public abstract Call<ResultDO<Index>> indexData(@Field("memberId") Long paramLong);
//
//        @FormUrlEncoded
//        @POST("/mobile/address/memberAddresses")
//        public abstract Call<ResultDO<List<Address>>> memberAddresses(@Field("memberId") long paramLong);
//
//        @FormUrlEncoded
//        @POST("/mobile/freeUse/memberFreeUseRecord")
//        public abstract Call<ResultDO<List<FreeRecord>>> memberFreeUseRecord(@Field("memberId") long paramLong, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

        @FormUrlEncoded
        @POST("/mobile/order/customerService/memberSend")
        public abstract Call<ResultDO> memberSend(@Field("customerServiceId") int paramInt, @Field("express") String paramString1, @Field("expressNo") String paramString2);

//        @FormUrlEncoded
//        @POST("mobile/message/messageRecords")
//        public abstract Call<ResultDO<List<Message>>> messageRecords(@Field("memberId") long paramLong, @Field("type") int paramInt1, @Field("isClear") int paramInt2, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);
//
//        @FormUrlEncoded
//        @POST("/mobile/order/myOrder")
//        public abstract Call<ResultDO<List<Order>>> myOrder(@Field("type") int paramInt, @Field("memberId") long paramLong, @Field("status") Integer paramInteger1, @Field("page") Integer paramInteger2, @Field("rows") Integer paramInteger3);
//
//        @FormUrlEncoded
//        @POST("/mobile/hotselect/member/oftenBuy")
//        public abstract Call<ResultDO<List<Product>>> oftenBuy(@Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/member/openPayPassword")
        public abstract Call<ResultDO> openPayPassword(@Field("memberId") long paramLong, @Field("payPassword") String paramString);

//        @FormUrlEncoded
//        @POST("/mobile/order/orderCount")
//        public abstract Call<ResultDO<HashMap<String, Integer>>> orderCount(@Field("memberId") long paramLong);
//
//        @FormUrlEncoded
//        @POST("/mobile/order/orderDetail")
//        public abstract Call<ResultDO<Order>> orderDetail(@Field("orderId") int paramInt);
//
//        @FormUrlEncoded
//        @POST("/mobile/hotselect/order/payExpressFee")
//        public abstract Call<ResultDO<PayInfo>> payExpressFee(@Field("orderId") long paramLong, @Field("payMethod") Integer paramInteger, @Field("payPassword") String paramString);
//
//        @FormUrlEncoded
//        @POST("/mobile/product/productDetail")
//        public abstract Call<ResultDO<Product>> productDetail(@Field("productId") long paramLong1, @Field("memberId") long paramLong2, @Field("uutype") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/hotselect/product/productList")
//        public abstract Call<ResultDO<List<Product>>> productList(@Field("keyword") String paramString, @Field("catId") Integer paramInteger1, @Field("memberId") long paramLong, @Field("sort") Integer paramInteger2, @Field("page") Integer paramInteger3, @Field("rows") Integer paramInteger4);
//
//        @FormUrlEncoded
//        @POST("/mobile/product/productList")
//        public abstract Call<ResultDO<List<Product>>> productList(@Field("keyword") String paramString1, @Field("pcatId") Integer paramInteger1, @Field("catId") Integer paramInteger2, @Field("isNew") Integer paramInteger3, @Field("isVip") Integer paramInteger4, @Field("brandId") Integer paramInteger5, @Field("sellerId") Integer paramInteger6, @Field("memberId") long paramLong, @Field("sort") Integer paramInteger7, @Field("catIds") String paramString2, @Field("brandIds") String paramString3, @Field("sellerCatId") Integer paramInteger8, @Field("page") Integer paramInteger9, @Field("rows") Integer paramInteger10);
//
//        @FormUrlEncoded
//        @POST("/mobile/globalShopping/products")
//        public abstract Call<ResultDO<List<Product>>> products(@Field("catId") int paramInt1, @Field("memberId") long paramLong, @Field("isSelection") int paramInt2, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);
//
//        @FormUrlEncoded
//        @POST("/mobile/coffers/recharge")
//        public abstract Call<ResultDO<PayInfo>> recharge(@Field("memberId") long paramLong, @Field("payMethod") int paramInt1, @Field("amount") int paramInt2);
//
//        @FormUrlEncoded
//        @POST("/mobile/coffers/rechargeRecord")
//        public abstract Call<ResultDO<List<Record>>> rechargeRecord(@Field("memberId") long paramLong, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

        @FormUrlEncoded
        @POST("/mobile/order/refund")
        public abstract Call<ResultDO> refund(@Field("orderId") int paramInt, @Field("memberId") long paramLong, @Field("refundReason") String paramString);

//        @FormUrlEncoded
//        @POST("/mobile/order/refundOrderTime")
//        public abstract Call<ResultDO<TimeTab>> refundOrderTime(@Field("orderId") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/member/reg")
        public abstract Call<ResultDO> reg(@Field("mobile") String paramString1, @Field("code") String paramString2, @Field("password") String paramString3);

        @FormUrlEncoded
        @POST("/mobile/memberAccount/save")
        public abstract Call<ResultDO> save(@Field("memberId") long paramLong, @Field("type") int paramInt, @Field("accountNo") String paramString1, @Field("accountName") String paramString2, @Field("accountBank") String paramString3, @Field("cityName") String paramString4);

        @FormUrlEncoded
        @POST("/mobile/appclient/saveAppClientId")
        public abstract Call<ResultDO> saveAppClientId(@Field("memberId") long paramLong, @Field("type") int paramInt, @Field("clientId") String paramString);

//        @Multipart
//        @POST("/mobile/imageUpload/saveImages")
//        public abstract Call<ResultDO<List<Images>>> saveImages(@Part("images") RequestBody paramRequestBody);
//
//        @FormUrlEncoded
//        @POST("/mobile/search/searchRecords")
//        public abstract Call<ResultDO<Search>> searchRecords(@Field("memberId") long paramLong);
//
//        @FormUrlEncoded
//        @POST("/mobile/sellerShop/sellerShop")
//        public abstract Call<ResultDO<Seller>> sellerShop(@Field("sellerId") long paramLong, @Field("memberId") Long paramLong1);

        @FormUrlEncoded
        @POST("/mobile/code/sendCode")
        public abstract Call<ResultDO> sendCode(@Field("memberId") long paramLong, @Field("mobile") String paramString);

        @FormUrlEncoded
        @POST("/mobile/member/setDefaultAccount")
        public abstract Call<ResultDO> setDefaultAccount(@Field("accountNo") String paramString);

        @FormUrlEncoded
        @POST("/mobile/address/setDefaultAddress")
        public abstract Call<ResultDO> setDefaultAddress(@Field("memberId") long paramLong, @Field("addressId") int paramInt);

//        @FormUrlEncoded
//        @POST("/mobile/order/singleOrderPay")
//        public abstract Call<ResultDO<PayInfo>> singleOrderPay(@Field("orderId") long paramLong, @Field("payMethod") Integer paramInteger);
//
//        @FormUrlEncoded
//        @POST("/mobile/member/tabAcount")
//        public abstract Call<ResultDO<Member>> tabAcount(@Field("accountNo") String paramString, @Field("memberId") long paramLong);
//
//        @FormUrlEncoded
//        @POST("/mobile/member/team")
//        public abstract Call<ResultDO<Team>> team(@Field("memberId") int paramInt, @Field("levelCode") String paramString1, @Field("nickName") String paramString2, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

//        @FormUrlEncoded
//        @POST("/mobile/member/teamTotal")
//        public abstract Call<ResultDO<HashMap<String, String>>> teamTotal(@Field("memberId") long paramLong);
//
//        @FormUrlEncoded
//        @POST("/mobile/member/totalAmount")
//        public abstract Call<ResultDO<HashMap<String, Double>>> totalAmount(@Field("memberId") long paramLong, @Field("type") int paramInt);

        @FormUrlEncoded
        @POST("mobile/message/totalMessageCount")
        public abstract Call<ResultDO> totalMessageCount(@Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/product/totalPages")
        public abstract Call<ResultDO> totalPages(@Field("memberId") long paramLong, @Field("rows") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/carItem/totalSupermarketFee")
        public abstract Call<ResultDO> totalSupermarketFee(@Field("memberId") long paramLong);

        @FormUrlEncoded
        @POST("/mobile/member/update")
        public abstract Call<ResultDO> update(@Field("memberId") long paramLong, @Field("realName") String paramString1, @Field("sex") Integer paramInteger, @Field("identityNo") String paramString2, @Field("birthday") String paramString3);

        @FormUrlEncoded
        @POST("/mobile/hotselect/store/update")
        public abstract Call<ResultDO> update(@Field("storeId") long paramLong, @Field("storeLogo") String paramString1, @Field("storeName") String paramString2);

        @FormUrlEncoded
        @POST("/mobile/carItem/updateNum")
        public abstract Call<ResultDO> updateCartNum(@Field("carId") Long paramLong, @Field("num") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/hotselect/carItem/updateNum")
        public abstract Call<ResultDO> updateHotCartNum(@Field("carId") Long paramLong, @Field("num") int paramInt);

        @FormUrlEncoded
        @POST("/mobile/member/updatePassword")
        public abstract Call<ResultDO> updatePassword(@Field("memberId") Long paramLong, @Field("newPassword") String paramString1, @Field("code") String paramString2);

        @FormUrlEncoded
        @POST("/mobile/member/updatePayPassword")
        public abstract Call<ResultDO> updatePayPassword(@Field("memberId") long paramLong, @Field("payPassword") String paramString1, @Field("code") String paramString2);

//        @Multipart
//        @POST("/mobile/imageUpload/saveImage")
//        public abstract Call<ResultDO<Images>> uploadImage(@Part("image") RequestBody paramRequestBody);

        @FormUrlEncoded
        @POST("/mobile/code/validateCode")
        public abstract Call<ResultDO> validateCode(@Field("mobile") String paramString1, @Field("code") String paramString2);

//        @FormUrlEncoded
//        @POST("/mobile/member/login")
//        public abstract Call<ResultDO<Member>> weixinLogin(@Field("type") int paramInt, @Field("mobile") String paramString1, @Field("password") String paramString2, @Field("code") String paramString3, @Field("unionid") String paramString4, @Field("nickName") String paramString5, @Field("sex") Integer paramInteger, @Field("headimgurl") String paramString6);

        @FormUrlEncoded
        @POST("/mobile/withdraw/withdraw")
        public abstract Call<ResultDO> withdraw(@Field("memberId") long paramLong, @Field("accountId") int paramInt, @Field("amount") double paramDouble, @Field("payPassword") String paramString);

//        @FormUrlEncoded
//        @POST("/mobile/withdraw/withdrawRecords")
//        public abstract Call<ResultDO<List<Record>>> withdrawRecords(@Field("memberId") long paramLong, @Field("page") Integer paramInteger1, @Field("rows") Integer paramInteger2);

}
