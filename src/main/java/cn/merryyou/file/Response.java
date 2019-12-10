package cn.merryyou.file;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public class Response {
    private int errno;
    private String guid_info;
    private long request_id;
    private int guid;

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
}
