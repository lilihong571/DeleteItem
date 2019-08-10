package com.llh.deleterecyclerviewitem;

/**
 * 项目名:    DeleteRecyclerViewItem
 * 包名:      com.llh.deleterecyclerviewitem
 * 文件名:    CheckDelete
 * 创建者:    LLH
 * 创建时间:  2019/8/6 14:46
 * 描述:      TODO
 */
public class CheckDelete {
    //多选框的选中状态
    private Boolean isCheck;
    //文本框的内容
    private String textString;
    //构造函数
    public CheckDelete(Boolean isCheck,String textString){
        this.isCheck = isCheck;
        this.textString = textString;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public String getTextString() {
        return textString;
    }

    public void setTextString(String textString) {
        this.textString = textString;
    }
}
