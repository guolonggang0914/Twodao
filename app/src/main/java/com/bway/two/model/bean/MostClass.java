package com.bway.two.model.bean;

import java.util.List;

/**
 * Created by 卢程
 * 2017/8/16.
 */

public class MostClass {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"pageNum":1,"totalSize":20,"totalPage":2,"list":[{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":1,"categoryName":"美食","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502681766582.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":3,"categoryName":"周边游","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682379049.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":2,"categoryName":"酒店","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682342394.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":4,"categoryName":"外卖","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682401380.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":5,"categoryName":"生活服务","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682411950.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":9,"categoryName":"KTV","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682481599.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":6,"categoryName":"丽人","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682431143.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":7,"categoryName":"休闲娱乐","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682453465.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":8,"categoryName":"亲子","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682465921.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":10,"categoryName":"汽车","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682492702.png","type":null,"status":0}]}
     */

    private String code;
    private String descirption;
    private ObjectBean object;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * pageNum : 1
         * totalSize : 20
         * totalPage : 2
         * list : [{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":1,"categoryName":"美食","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502681766582.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":3,"categoryName":"周边游","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682379049.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":2,"categoryName":"酒店","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682342394.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":4,"categoryName":"外卖","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682401380.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":5,"categoryName":"生活服务","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682411950.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":9,"categoryName":"KTV","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682481599.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":6,"categoryName":"丽人","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682431143.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":7,"categoryName":"休闲娱乐","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682453465.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":8,"categoryName":"亲子","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682465921.png","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":10,"categoryName":"汽车","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502682492702.png","type":null,"status":0}]
         */

        private int pageNum;
        private int totalSize;
        private int totalPage;
        private List<ListBean> list;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * beginIndex : 0
             * pageSize : 10
             * sort :
             * order : desc
             * categoryId : 1
             * categoryName : 美食
             * sequence : 0
             * parentId : null
             * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502681766582.png
             * type : null
             * status : 0
             */

            private int beginIndex;
            private int pageSize;
            private String sort;
            private String order;
            private int categoryId;
            private String categoryName;
            private int sequence;
            private Object parentId;
            private String picture;
            private Object type;
            private int status;

            public int getBeginIndex() {
                return beginIndex;
            }

            public void setBeginIndex(int beginIndex) {
                this.beginIndex = beginIndex;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public Object getParentId() {
                return parentId;
            }

            public void setParentId(Object parentId) {
                this.parentId = parentId;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
