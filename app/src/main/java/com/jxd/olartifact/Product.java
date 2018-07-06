package com.jxd.olartifact;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class Product    implements Parcelable
    {
        public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator()
        {
            public Product createFromParcel(Parcel paramAnonymousParcel)
            {
                return new Product(paramAnonymousParcel);
            }

            public Product[] newArray(int paramAnonymousInt)
            {
                return new Product[paramAnonymousInt];
            }
        };
        private String appPrice;
        private String area;
        private String brandCode;
        private int buyMinCount;
        private int catId;
        private String codeImageUrl;
        private int commentCount;
        private List<Comment> comments;
        private String costPrice;
        private String dealAmount;
        private String detail;
        private String detailUrl;
        private int expressFee;
        private String image;
        private List<String> images;
        private int isCollect;
        private boolean isSelected;
        private int isShowScore;
        //private int limitCount;
        //private int listId;
        private String logo;
        private String marketPrice;
        private long memberId;
        //private int minCount;
        private String name;
        private String normal;
        private List<NormalsBean> normals;
        private int num;
        private String percent;
        private int plusCount;
        private String plusPercent;
        private String price;
        private long productId;
        private String productImage;
        private String productName;
        //private double rateFee;
        private String salePrice;
        //private int score;
        private int sellerId;
        private String sellerLogo;
        private String sellerName;
        private int shareScore;
        private int soldCount;
        private int status;
        private int store;
        private String summary;
        private List<String> tags;
        private String time;
        private int type;
        private String unitPrice;
        private int upAndDownStatus;

        public Product() {}

        protected Product(Parcel paramParcel)
        {
            this.memberId = paramParcel.readLong();
            this.productId = paramParcel.readLong();
            this.catId = paramParcel.readInt();
            this.brandCode = paramParcel.readString();
            this.upAndDownStatus = paramParcel.readInt();
            this.type = paramParcel.readInt();
            this.status = paramParcel.readInt();
            this.time = paramParcel.readString();
            this.image = paramParcel.readString();
            this.productName = paramParcel.readString();
            this.salePrice = paramParcel.readString();
            this.appPrice = paramParcel.readString();
            this.marketPrice = paramParcel.readString();
//            this.score = paramParcel.readInt();
//            this.rateFee = paramParcel.readDouble();
            this.expressFee = paramParcel.readInt();
            this.soldCount = paramParcel.readInt();
            this.area = paramParcel.readString();
            this.detail = paramParcel.readString();
            this.detailUrl = paramParcel.readString();
            this.commentCount = paramParcel.readInt();
            this.store = paramParcel.readInt();
            this.isCollect = paramParcel.readInt();
            this.shareScore = paramParcel.readInt();
            this.isShowScore = paramParcel.readInt();
            this.codeImageUrl = paramParcel.readString();
            this.sellerId = paramParcel.readInt();
            this.sellerName = paramParcel.readString();
            this.sellerLogo = paramParcel.readString();
            this.images = paramParcel.createStringArrayList();
            this.tags = paramParcel.createStringArrayList();
            this.comments = paramParcel.createTypedArrayList(Comment.CREATOR);
            this.price = paramParcel.readString();
            //this.limitCount = paramParcel.readInt();
            this.plusCount = paramParcel.readInt();
            this.productImage = paramParcel.readString();
            this.plusPercent = paramParcel.readString();
            this.percent = paramParcel.readString();
            this.summary = paramParcel.readString();
            this.logo = paramParcel.readString();
            this.num = paramParcel.readInt();
            this.normal = paramParcel.readString();
            this.costPrice = paramParcel.readString();
            //this.minCount = paramParcel.readInt();
            this.dealAmount = paramParcel.readString();
            this.buyMinCount = paramParcel.readInt();
            this.name = paramParcel.readString();
            this.unitPrice = paramParcel.readString();
            if (paramParcel.readByte() != 0) {}
            for (boolean bool = true;; bool = false)
            {
                this.isSelected = bool;
                //this.listId = paramParcel.readInt();
                return;
            }
        }

        public int describeContents()
        {
            return 0;
        }

        public String getAppPrice()
        {
            return this.appPrice;
        }

        public String getArea()
        {
            return this.area;
        }

        public String getBrandCode()
        {
            return this.brandCode;
        }

        public int getBuyMinCount()
        {
            return this.buyMinCount;
        }

        public int getCatId()
        {
            return this.catId;
        }

        public String getCodeImageUrl()
        {
            return this.codeImageUrl;
        }

        public int getCommentCount()
        {
            return this.commentCount;
        }

        public List<Comment> getComments()
        {
            return this.comments;
        }

        public String getCostPrice()
        {
            return this.costPrice;
        }

        public String getDealAmount()
        {
            return this.dealAmount;
        }

        public String getDetail()
        {
            return this.detail;
        }

        public String getDetailUrl()
        {
            return this.detailUrl;
        }

        public int getExpressFee()
        {
            return this.expressFee;
        }

        public String getImage()
        {
            return this.image;
        }

        public List<String> getImages()
        {
            return this.images;
        }

        public int getIsCollect()
        {
            return this.isCollect;
        }

        public int getIsShowScore()
        {
            return this.isShowScore;
        }

//        public int getLimitCount()
//        {
//            return this.limitCount;
//        }
//
//        public int getListId()
//        {
//            return this.listId;
//        }

        public String getLogo()
        {
            return this.logo;
        }

        public String getMarketPrice()
        {
            return this.marketPrice;
        }

        public long getMemberId()
        {
            return this.memberId;
        }

//        public int getMinCount()
//        {
//            return this.minCount;
//        }

        public String getName()
        {
            return this.name;
        }

        public String getNormal()
        {
            return this.normal;
        }

        public List<NormalsBean> getNormals()
        {
            return this.normals;
        }

        public int getNum()
        {
            return this.num;
        }

        public String getPercent()
        {
            return this.percent;
        }

        public int getPlusCount()
        {
            return this.plusCount;
        }

        public String getPlusPercent()
        {
            return this.plusPercent;
        }

        public String getPrice()
        {
            return this.price;
        }

        public long getProductId()
        {
            return this.productId;
        }

        public String getProductImage()
        {
            return this.productImage;
        }

        public String getProductName()
        {
            return this.productName;
        }

//        public double getRateFee()
//        {
//            return this.rateFee;
//        }

        public String  getSalePrice()
        {
            return this.salePrice;
        }

//        public int getScore()
//        {
//            return this.score;
//        }

        public int getSellerId()
        {
            return this.sellerId;
        }

        public String getSellerLogo()
        {
            return this.sellerLogo;
        }

        public String getSellerName()
        {
            return this.sellerName;
        }

        public int getShareScore()
        {
            return this.shareScore;
        }

        public int getSoldCount()
        {
            return this.soldCount;
        }

        public int getStatus()
        {
            return this.status;
        }

        public int getStore()
        {
            return this.store;
        }

        public String getSummary()
        {
            return this.summary;
        }

        public List<String> getTags()
        {
            return this.tags;
        }

        public String getTime()
        {
            return this.time;
        }

        public int getType()
        {
            return this.type;
        }

        public String getUnitPrice()
        {
            return this.unitPrice;
        }

        public int getUpAndDownStatus()
        {
            return this.upAndDownStatus;
        }

        public boolean isSelected()
        {
            return this.isSelected;
        }

        public void setAppPrice(String paramDouble)
        {
            this.appPrice = paramDouble;
        }

        public void setArea(String paramString)
        {
            this.area = paramString;
        }

        public void setBrandCode(String paramString)
        {
            this.brandCode = paramString;
        }

        public void setBuyMinCount(int paramInt)
        {
            this.buyMinCount = paramInt;
        }

        public void setCatId(int paramInt)
        {
            this.catId = paramInt;
        }

        public void setCodeImageUrl(String paramString)
        {
            this.codeImageUrl = paramString;
        }

        public void setCommentCount(int paramInt)
        {
            this.commentCount = paramInt;
        }

        public void setComments(List<Comment> paramList)
        {
            this.comments = paramList;
        }

        public void setCostPrice(String paramString)
        {
            this.costPrice = paramString;
        }

        public void setDealAmount(String paramString)
        {
            this.dealAmount = paramString;
        }

        public void setDetail(String paramString)
        {
            this.detail = paramString;
        }

        public void setDetailUrl(String paramString)
        {
            this.detailUrl = paramString;
        }

        public void setExpressFee(int paramInt)
        {
            this.expressFee = paramInt;
        }

        public void setImage(String paramString)
        {
            this.image = paramString;
        }

        public void setImages(List<String> paramList)
        {
            this.images = paramList;
        }

        public void setIsCollect(int paramInt)
        {
            this.isCollect = paramInt;
        }

        public void setIsShowScore(int paramInt)
        {
            this.isShowScore = paramInt;
        }

//        public void setLimitCount(int paramInt)
//        {
//            this.limitCount = paramInt;
//        }
//
//        public void setListId(int paramInt)
//        {
//            this.listId = paramInt;
//        }

        public void setLogo(String paramString)
        {
            this.logo = paramString;
        }

        public void setMarketPrice(String paramDouble)
        {
            this.marketPrice = paramDouble;
        }

        public void setMemberId(long paramLong)
        {
            this.memberId = paramLong;
        }

//        public void setMinCount(int paramInt)
//        {
//            this.minCount = paramInt;
//        }

        public void setName(String paramString)
        {
            this.name = paramString;
        }

        public void setNormal(String paramString)
        {
            this.normal = paramString;
        }

        public void setNormals(List<NormalsBean> paramList)
        {
            this.normals = paramList;
        }

        public void setNum(int paramInt)
        {
            this.num = paramInt;
        }

        public void setPercent(String paramString)
        {
            this.percent = paramString;
        }

        public void setPlusCount(int paramInt)
        {
            this.plusCount = paramInt;
        }

        public void setPlusPercent(String paramString)
        {
            this.plusPercent = paramString;
        }

        public void setPrice(String paramDouble)
        {
            this.price = paramDouble;
        }

        public void setProductId(long paramLong)
        {
            this.productId = paramLong;
        }

        public void setProductImage(String paramString)
        {
            this.productImage = paramString;
        }

        public void setProductName(String paramString)
        {
            this.productName = paramString;
        }

//        public void setRateFee(double paramDouble)
//        {
//            this.rateFee = paramDouble;
//        }

        public void setSalePrice(String paramDouble)
        {
            this.salePrice = paramDouble;
        }

//        public void setScore(int paramInt)
//        {
//            this.score = paramInt;
//        }

        public void setSelected(boolean paramBoolean)
        {
            this.isSelected = paramBoolean;
        }

        public void setSellerId(int paramInt)
        {
            this.sellerId = paramInt;
        }

        public void setSellerLogo(String paramString)
        {
            this.sellerLogo = paramString;
        }

        public void setSellerName(String paramString)
        {
            this.sellerName = paramString;
        }

        public void setShareScore(int paramInt)
        {
            this.shareScore = paramInt;
        }

        public void setSoldCount(int paramInt)
        {
            this.soldCount = paramInt;
        }

        public void setStatus(int paramInt)
        {
            this.status = paramInt;
        }

        public void setStore(int paramInt)
        {
            this.store = paramInt;
        }

        public void setSummary(String paramString)
        {
            this.summary = paramString;
        }

        public void setTags(List<String> paramList)
        {
            this.tags = paramList;
        }

        public void setTime(String paramString)
        {
            this.time = paramString;
        }

        public void setType(int paramInt)
        {
            this.type = paramInt;
        }

        public void setUnitPrice(String paramDouble)
        {
            this.unitPrice = paramDouble;
        }

        public void setUpAndDownStatus(int paramInt)
        {
            this.upAndDownStatus = paramInt;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt)
        {
            paramParcel.writeLong(this.memberId);
            paramParcel.writeLong(this.productId);
            paramParcel.writeInt(this.catId);
            paramParcel.writeString(this.brandCode);
            paramParcel.writeInt(this.upAndDownStatus);
            paramParcel.writeInt(this.type);
            paramParcel.writeInt(this.status);
            paramParcel.writeString(this.time);
            paramParcel.writeString(this.image);
            paramParcel.writeString(this.productName);
            paramParcel.writeString(this.salePrice);
            paramParcel.writeString(this.appPrice);
            paramParcel.writeString(this.marketPrice);
//            paramParcel.writeInt(this.score);
//            paramParcel.writeDouble(this.rateFee);
            paramParcel.writeInt(this.expressFee);
            paramParcel.writeInt(this.soldCount);
            paramParcel.writeString(this.area);
            paramParcel.writeString(this.detail);
            paramParcel.writeString(this.detailUrl);
            paramParcel.writeInt(this.commentCount);
            paramParcel.writeInt(this.store);
            paramParcel.writeInt(this.isCollect);
            paramParcel.writeInt(this.shareScore);
            paramParcel.writeInt(this.isShowScore);
            paramParcel.writeString(this.codeImageUrl);
            paramParcel.writeInt(this.sellerId);
            paramParcel.writeString(this.sellerName);
            paramParcel.writeString(this.sellerLogo);
            paramParcel.writeStringList(this.images);
            paramParcel.writeStringList(this.tags);
            paramParcel.writeTypedList(this.comments);
            paramParcel.writeString(this.price);
           // paramParcel.writeInt(this.limitCount);
            paramParcel.writeInt(this.plusCount);
            paramParcel.writeString(this.productImage);
            paramParcel.writeString(this.plusPercent);
            paramParcel.writeString(this.percent);
            paramParcel.writeString(this.summary);
            paramParcel.writeString(this.logo);
            paramParcel.writeInt(this.num);
            paramParcel.writeString(this.normal);
            paramParcel.writeString(this.costPrice);
           // paramParcel.writeInt(this.minCount);
            paramParcel.writeString(this.dealAmount);
            paramParcel.writeInt(this.buyMinCount);
            paramParcel.writeString(this.name);
            paramParcel.writeString(this.unitPrice);
            if (this.isSelected) {}
            for (paramInt = 1;; paramInt = 0)
            {
                paramParcel.writeByte((byte)paramInt);
                //paramParcel.writeInt(this.listId);
                return;
            }
        }

    }


