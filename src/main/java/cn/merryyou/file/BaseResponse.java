package cn.merryyou.file;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public class BaseResponse {

    /**
     * errno : 0
     * guid_info :
     * list : [{"server_filename":"01.VIP课程：互联网工程专题","category":6,"unlist":0,"isdir":1,"dir_empty":0,"oper_id":0,"server_ctime":1529931748,"local_mtime":1529931748,"size":0,"share":0,"server_mtime":1575959804,"path":"/图灵学院java架构师vip课程第二期/01.VIP课程：互联网工程专题","local_ctime":1529931748,"empty":0,"fs_id":1024690564228832},{"server_filename":"02.VIP课程：源码框架专题","category":6,"unlist":0,"isdir":1,"dir_empty":0,"oper_id":0,"server_ctime":1534065972,"local_mtime":1534065972,"size":0,"share":0,"server_mtime":1575959804,"path":"/图灵学院java架构师vip课程第二期/02.VIP课程：源码框架专题","local_ctime":1534065972,"empty":0,"fs_id":285071760809652},{"server_filename":"03.VIP课程：并发编程专题","category":6,"unlist":0,"isdir":1,"dir_empty":0,"oper_id":0,"server_ctime":1536312168,"local_mtime":1536312168,"size":0,"share":0,"server_mtime":1575959804,"path":"/图灵学院java架构师vip课程第二期/03.VIP课程：并发编程专题","local_ctime":1536312168,"empty":0,"fs_id":346375678095473},{"server_filename":"04.VIP课程：性能调优专题","category":6,"unlist":0,"isdir":1,"dir_empty":0,"oper_id":0,"server_ctime":1537968450,"local_mtime":1537968450,"size":0,"share":0,"server_mtime":1575959804,"path":"/图灵学院java架构师vip课程第二期/04.VIP课程：性能调优专题","local_ctime":1537968450,"empty":0,"fs_id":761738034544873},{"server_filename":"05.VIP课程：分布式框架专题","category":6,"unlist":0,"isdir":1,"dir_empty":0,"oper_id":0,"server_ctime":1540200484,"local_mtime":1540200484,"size":0,"share":0,"server_mtime":1575959804,"path":"/图灵学院java架构师vip课程第二期/05.VIP课程：分布式框架专题","local_ctime":1540200484,"empty":0,"fs_id":219763781145709},{"server_filename":"06.VIP课程：项目专题","category":6,"unlist":0,"isdir":1,"dir_empty":0,"oper_id":0,"server_ctime":1548397094,"local_mtime":1548397094,"size":0,"share":0,"server_mtime":1575959804,"path":"/图灵学院java架构师vip课程第二期/06.VIP课程：项目专题","local_ctime":1548397094,"empty":0,"fs_id":879138245709886},{"server_filename":"07.VIP课程：微服务专题","category":6,"unlist":0,"isdir":1,"dir_empty":0,"oper_id":0,"server_ctime":1553869491,"local_mtime":1553869491,"size":0,"share":0,"server_mtime":1575959804,"path":"/图灵学院java架构师vip课程第二期/07.VIP课程：微服务专题","local_ctime":1553869491,"empty":0,"fs_id":649253509776710},{"server_filename":"资料","category":6,"unlist":0,"isdir":1,"dir_empty":0,"oper_id":0,"server_ctime":1564115727,"local_mtime":1564115727,"size":0,"share":0,"server_mtime":1575959804,"path":"/图灵学院java架构师vip课程第二期/资料","local_ctime":1564115727,"empty":0,"fs_id":138764282177958}]
     * request_id : 7969606317089879719
     * guid : 0
     */

    private int errno;
    private String guid_info;
    private long request_id;
    private int guid;
    private List<ListBean> list;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getGuid_info() {
        return guid_info;
    }

    public void setGuid_info(String guid_info) {
        this.guid_info = guid_info;
    }

    public long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(long request_id) {
        this.request_id = request_id;
    }

    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * server_filename : 01.VIP课程：互联网工程专题
         * category : 6
         * unlist : 0
         * isdir : 1
         * dir_empty : 0
         * oper_id : 0
         * server_ctime : 1529931748
         * local_mtime : 1529931748
         * size : 0
         * share : 0
         * server_mtime : 1575959804
         * path : /图灵学院java架构师vip课程第二期/01.VIP课程：互联网工程专题
         * local_ctime : 1529931748
         * empty : 0
         * fs_id : 1024690564228832
         */

        private String server_filename;
        private int category;
        private int unlist;
        private int isdir;
        private int dir_empty;
        private int oper_id;
        private int server_ctime;
        private int local_mtime;
        private long size;
        private int share;
        private int server_mtime;
        private String path;
        private int local_ctime;
        private int empty;
        private long fs_id;

        @Override
        public String toString() {
            return "ListBean{" +
                    "server_filename='" + server_filename + '\'' +
                    ", category=" + category +
                    ", unlist=" + unlist +
                    ", isdir=" + isdir +
                    ", dir_empty=" + dir_empty +
                    ", oper_id=" + oper_id +
                    ", server_ctime=" + server_ctime +
                    ", local_mtime=" + local_mtime +
                    ", size=" + size +
                    ", share=" + share +
                    ", server_mtime=" + server_mtime +
                    ", path='" + path + '\'' +
                    ", local_ctime=" + local_ctime +
                    ", empty=" + empty +
                    ", fs_id=" + fs_id +
                    '}';
        }

        public String getServer_filename() {
            return server_filename;
        }

        public void setServer_filename(String server_filename) {
            this.server_filename = server_filename;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getUnlist() {
            return unlist;
        }

        public void setUnlist(int unlist) {
            this.unlist = unlist;
        }

        public int getIsdir() {
            return isdir;
        }

        public void setIsdir(int isdir) {
            this.isdir = isdir;
        }

        public int getDir_empty() {
            return dir_empty;
        }

        public void setDir_empty(int dir_empty) {
            this.dir_empty = dir_empty;
        }

        public int getOper_id() {
            return oper_id;
        }

        public void setOper_id(int oper_id) {
            this.oper_id = oper_id;
        }

        public int getServer_ctime() {
            return server_ctime;
        }

        public void setServer_ctime(int server_ctime) {
            this.server_ctime = server_ctime;
        }

        public int getLocal_mtime() {
            return local_mtime;
        }

        public void setLocal_mtime(int local_mtime) {
            this.local_mtime = local_mtime;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getServer_mtime() {
            return server_mtime;
        }

        public void setServer_mtime(int server_mtime) {
            this.server_mtime = server_mtime;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getLocal_ctime() {
            return local_ctime;
        }

        public void setLocal_ctime(int local_ctime) {
            this.local_ctime = local_ctime;
        }

        public int getEmpty() {
            return empty;
        }

        public void setEmpty(int empty) {
            this.empty = empty;
        }

        public long getFs_id() {
            return fs_id;
        }

        public void setFs_id(long fs_id) {
            this.fs_id = fs_id;
        }
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "errno=" + errno +
                ", guid_info='" + guid_info + '\'' +
                ", request_id=" + request_id +
                ", guid=" + guid +
                ", list=" + list +
                '}';
    }
}

