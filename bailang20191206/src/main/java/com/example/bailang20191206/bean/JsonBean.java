package com.example.bailang20191206.bean;

import java.util.List;

public class JsonBean  {

    /**
     * result : [{"commodityId":95,"commodityName":"秋冬加绒拼接色 不规则套头 假两件休闲短款保暖女装卫衣上衣","masterPic":"http://172.17.8.100/images/small/commodity/nz/wy/3/1.jpg","price":99,"saleNum":0},{"commodityId":92,"commodityName":"冬季新款女款轻薄羽绒服女短款外套女纯色简约百搭保暖女上衣新品女装外套","masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/7/1.jpg","price":229,"saleNum":0},{"commodityId":71,"commodityName":"秋装新款女时尚百搭半高领纯色基础百搭针织衫打底衫毛衣女上衣修身","masterPic":"http://172.17.8.100/images/small/commodity/nz/ddmy/7/1.jpg","price":79,"saleNum":0},{"commodityId":67,"commodityName":"新款简约休闲纯色半高领套头基础款针织衫打底衫女式毛衣上衣","masterPic":"http://172.17.8.100/images/small/commodity/nz/ddmy/3/1.jpg","price":89,"saleNum":0},{"commodityId":66,"commodityName":"秋冬新品韩版女装毛衣纯色时尚简约花边领半高领套头打底上衣长袖针织衫","masterPic":"http://172.17.8.100/images/small/commodity/nz/ddmy/2/1.jpg","price":49,"saleNum":1}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 95
         * commodityName : 秋冬加绒拼接色 不规则套头 假两件休闲短款保暖女装卫衣上衣
         * masterPic : http://172.17.8.100/images/small/commodity/nz/wy/3/1.jpg
         * price : 99
         * saleNum : 0
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
