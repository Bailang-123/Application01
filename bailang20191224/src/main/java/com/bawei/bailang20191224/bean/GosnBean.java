package com.bawei.bailang20191224.bean;

import java.util.List;

public class GosnBean {

    /**
     * code : 200
     * message : 成功!
     * category : [{"clazz":"1611A","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美8"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美9"}]},{"clazz":"1611B","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小明1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小明2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小明3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小明4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小明5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小明6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小明7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小明8"}]},{"clazz":"1612A","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"张三1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"张三2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"张三3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"张三4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"张三5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"张三6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"张三7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"张三8"}]},{"clazz":"1612B","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"李四1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"李四2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"李四3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"李四4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"李四5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"李四6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"李四7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"李四8"}]},{"clazz":"1613A","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"王五1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"王五2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"王五3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"王五4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"王五5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"王五6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"王五7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"王五8"}]}]
     */

    private int code;
    private String message;
    private List<CategoryBean> category;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public static class CategoryBean {
        /**
         * clazz : 1611A
         * childs : [{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美8"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"小美9"}]
         */

        private String clazz;
        private List<ChildsBean> childs;

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public List<ChildsBean> getChilds() {
            return childs;
        }

        public void setChilds(List<ChildsBean> childs) {
            this.childs = childs;
        }

        public static class ChildsBean {
            /**
             * avatar : http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg
             * name : 小美1
             */

            private String avatar;
            private String name;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
