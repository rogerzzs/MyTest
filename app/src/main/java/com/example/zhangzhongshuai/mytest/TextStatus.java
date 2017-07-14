package com.example.zhangzhongshuai.mytest;


/**
 * Created by zhangzhongshuai on 2017/6/8.
 */

public enum TextStatus{
    START(0,"未开始"),
    PROCESSING(1,"进行中"),
    COMPLETE(2,"已完成");

    int mStatus;
    String mDesc;

    TextStatus(int status,String desc){
        mStatus = status;
        mDesc = desc;
    }

    public static TextStatus getTextStatus(int status){
        for(TextStatus textStatus:values()){
            if(textStatus.mStatus == status ){
                return textStatus;
            }
        }
        return START;
    }
}
