package com.example.weekly.bean;

import java.util.List;

public class GsonBean {
    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/5.jpg","commodityPrice":6,"orderDetailId":22069},{"commentStatus":1,"commodityCount":1,"commodityId":7,"commodityName":"蓝色之恋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/5.jpg,","commodityPrice":29,"orderDetailId":22070}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121411111102513041","orderStatus":1,"orderTime":1576293071000,"payAmount":35,"payMethod":1,"userId":13041},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/5.jpg","commodityPrice":6,"orderDetailId":22067},{"commentStatus":1,"commodityCount":1,"commodityId":7,"commodityName":"蓝色之恋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/5.jpg,","commodityPrice":29,"orderDetailId":22068}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121411110928513041","orderStatus":1,"orderTime":1576293069000,"payAmount":35,"payMethod":1,"userId":13041},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/5.jpg","commodityPrice":6,"orderDetailId":22065},{"commentStatus":1,"commodityCount":1,"commodityId":7,"commodityName":"蓝色之恋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/5.jpg,","commodityPrice":29,"orderDetailId":22066}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121411105415813041","orderStatus":1,"orderTime":1576293054000,"payAmount":35,"payMethod":1,"userId":13041}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

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

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":1,"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/5.jpg","commodityPrice":6,"orderDetailId":22069},{"commentStatus":1,"commodityCount":1,"commodityId":7,"commodityName":"蓝色之恋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/5.jpg,","commodityPrice":29,"orderDetailId":22070}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2019121411111102513041
         * orderStatus : 1
         * orderTime : 1576293071000
         * payAmount : 35
         * payMethod : 1
         * userId : 13041
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 1
             * commodityId : 15
             * commodityName : 玻儿精灵美妆蛋一个
             * commodityPic : http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/5.jpg
             * commodityPrice : 6
             * orderDetailId : 22069
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
            }

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

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
