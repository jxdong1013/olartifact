package com.jxd.olartifact;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class Comment  implements Parcelable
    {
        public static final Parcelable.Creator<Comment> CREATOR = new Parcelable.Creator()
        {
            public Comment createFromParcel(Parcel paramAnonymousParcel)
            {
                return new Comment(paramAnonymousParcel);
            }

            public Comment[] newArray(int paramAnonymousInt)
            {
                return new Comment[paramAnonymousInt];
            }
        };
        private List<Comment> children;
        private List<Comment> commentCommentDtos;
        private int commentCount;
        private List<Comment> commentGoodDtos;
        private String content;
        private int goodCount;
        private int id;
        private List<String> images;
        private int isGood;
        private int memberId;
        private String memberLevel;
        private String memberLogo;
        private String memberName;
        private int orderId;
        private int parentId;
        private String parentMemberName;
        private int productId;
        private String productImage;
        private String productName;
        private String productPrice;
        private float score;
        private int status;
        private String time;
        private String title;
        private int type;

        public Comment() {}

        protected Comment(Parcel paramParcel)
        {
            this.id = paramParcel.readInt();
            this.type = paramParcel.readInt();
            this.orderId = paramParcel.readInt();
            this.status = paramParcel.readInt();
            this.title = paramParcel.readString();
            this.productId = paramParcel.readInt();
            this.productName = paramParcel.readString();
            this.productImage = paramParcel.readString();
            this.productPrice = paramParcel.readString();
            this.memberName = paramParcel.readString();
            this.memberLevel = paramParcel.readString();
            this.memberId = paramParcel.readInt();
            this.memberLogo = paramParcel.readString();
            this.content = paramParcel.readString();
            this.time = paramParcel.readString();
            this.score = paramParcel.readFloat();
            this.commentCount = paramParcel.readInt();
            this.goodCount = paramParcel.readInt();
            this.isGood = paramParcel.readInt();
            this.commentCommentDtos = paramParcel.createTypedArrayList(CREATOR);
            this.commentGoodDtos = paramParcel.createTypedArrayList(CREATOR);
            this.images = paramParcel.createStringArrayList();
            this.children = paramParcel.createTypedArrayList(CREATOR);
            this.parentMemberName = paramParcel.readString();
            this.parentId = paramParcel.readInt();
        }

        public int describeContents()
        {
            return 0;
        }

        public List<Comment> getChildren()
        {
            return this.children;
        }

        public List<Comment> getCommentCommentDtos()
        {
            return this.commentCommentDtos;
        }

        public int getCommentCount()
        {
            return this.commentCount;
        }

        public List<Comment> getCommentGoodDtos()
        {
            return this.commentGoodDtos;
        }

        public String getContent()
        {
            return this.content;
        }

        public int getGoodCount()
        {
            return this.goodCount;
        }

        public int getId()
        {
            return this.id;
        }

        public List<String> getImages()
        {
            return this.images;
        }

        public int getIsGood()
        {
            return this.isGood;
        }

        public int getMemberId()
        {
            return this.memberId;
        }

        public String getMemberLevel()
        {
            return this.memberLevel;
        }

        public String getMemberLogo()
        {
            return this.memberLogo;
        }

        public String getMemberName()
        {
            return this.memberName;
        }

        public int getOrderId()
        {
            return this.orderId;
        }

        public int getParentId()
        {
            return this.parentId;
        }

        public String getParentMemberName()
        {
            return this.parentMemberName;
        }

        public int getProductId()
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

        public String getProductPrice()
        {
            return this.productPrice;
        }

        public float getScore()
        {
            return this.score;
        }

        public int getStatus()
        {
            return this.status;
        }

        public String getTime()
        {
            return this.time;
        }

        public String getTitle()
        {
            return this.title;
        }

        public int getType()
        {
            return this.type;
        }

        public void setChildren(List<Comment> paramList)
        {
            this.children = paramList;
        }

        public void setCommentCommentDtos(List<Comment> paramList)
        {
            this.commentCommentDtos = paramList;
        }

        public void setCommentCount(int paramInt)
        {
            this.commentCount = paramInt;
        }

        public void setCommentGoodDtos(List<Comment> paramList)
        {
            this.commentGoodDtos = paramList;
        }

        public void setContent(String paramString)
        {
            this.content = paramString;
        }

        public void setGoodCount(int paramInt)
        {
            this.goodCount = paramInt;
        }

        public void setId(int paramInt)
        {
            this.id = paramInt;
        }

        public void setImages(List<String> paramList)
        {
            this.images = paramList;
        }

        public void setIsGood(int paramInt)
        {
            this.isGood = paramInt;
        }

        public void setMemberId(int paramInt)
        {
            this.memberId = paramInt;
        }

        public void setMemberLevel(String paramString)
        {
            this.memberLevel = paramString;
        }

        public void setMemberLogo(String paramString)
        {
            this.memberLogo = paramString;
        }

        public void setMemberName(String paramString)
        {
            this.memberName = paramString;
        }

        public void setOrderId(int paramInt)
        {
            this.orderId = paramInt;
        }

        public void setParentId(int paramInt)
        {
            this.parentId = paramInt;
        }

        public void setParentMemberName(String paramString)
        {
            this.parentMemberName = paramString;
        }

        public void setProductId(int paramInt)
        {
            this.productId = paramInt;
        }

        public void setProductImage(String paramString)
        {
            this.productImage = paramString;
        }

        public void setProductName(String paramString)
        {
            this.productName = paramString;
        }

        public void setProductPrice(String paramString)
        {
            this.productPrice = paramString;
        }

        public void setScore(float paramFloat)
        {
            this.score = paramFloat;
        }

        public void setStatus(int paramInt)
        {
            this.status = paramInt;
        }

        public void setTime(String paramString)
        {
            this.time = paramString;
        }

        public void setTitle(String paramString)
        {
            this.title = paramString;
        }

        public void setType(int paramInt)
        {
            this.type = paramInt;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt)
        {
            paramParcel.writeInt(this.id);
            paramParcel.writeInt(this.type);
            paramParcel.writeInt(this.orderId);
            paramParcel.writeInt(this.status);
            paramParcel.writeString(this.title);
            paramParcel.writeInt(this.productId);
            paramParcel.writeString(this.productName);
            paramParcel.writeString(this.productImage);
            paramParcel.writeString(this.productPrice);
            paramParcel.writeString(this.memberName);
            paramParcel.writeString(this.memberLevel);
            paramParcel.writeInt(this.memberId);
            paramParcel.writeString(this.memberLogo);
            paramParcel.writeString(this.content);
            paramParcel.writeString(this.time);
            paramParcel.writeFloat(this.score);
            paramParcel.writeInt(this.commentCount);
            paramParcel.writeInt(this.goodCount);
            paramParcel.writeInt(this.isGood);
            paramParcel.writeTypedList(this.commentCommentDtos);
            paramParcel.writeTypedList(this.commentGoodDtos);
            paramParcel.writeStringList(this.images);
            paramParcel.writeTypedList(this.children);
            paramParcel.writeString(this.parentMemberName);
            paramParcel.writeInt(this.parentId);
        }

}
